package jvm.internals.jsonassist;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class Jitson {

	private ClassPool pool;
	private Map<Class<?>, JsonConverter> cache;

	public Jitson() {
		pool = ClassPool.getDefault();
		cache = new HashMap<>();
	}

	/**
	 * Converts given object to JSON. Supports only public fields. No support
	 * for nested conversions (toString is used for value).
	 * 
	 * @param o
	 *            Object to be converted.
	 * @return JSON in a String
	 * @throws Exception
	 */
	public String toJson(Object o) {
		try {
			synchronized(o){
				if (!cache.containsKey(o.getClass())) {
					cache.put(o.getClass(), getConverter(o.getClass()));
				}
				return cache.get(o.getClass()).toJson(o);
			}
		} catch (Exception e) {
			return "";
		}
	}

	private JsonConverter getConverter(Class<?> cls)
			throws CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException {

		// new class with a random name, as this name is not needed in any way
		CtClass converterClass = pool.makeClass(UUID.randomUUID().toString());

		converterClass.addMethod(CtNewMethod.make(getConverterMethodBody(cls), converterClass));
		converterClass.addMethod(CtNewMethod
				.make("public String toJson(Object o){return toJson((" + cls.getName() + ")o);}", converterClass));
		converterClass.setInterfaces(new CtClass[] { pool.get("jvm.internals.jsonassist.JsonConverter") });

		JsonConverter result = (JsonConverter) pool.toClass(converterClass).newInstance();
		
		// this allows us to save memory
		converterClass.detach();
		return result;
	}

	// actual JSON producing code is written here!
	private String getConverterMethodBody(Class<?> cls) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder("public String toJson(" + cls.getName() + " o) { ");

		sb.append("String res=\"\";");
		sb.append("res+=\"{\";");
		Method[] mtd = cls.getMethods();
		for (Method mtds : mtd) {
			if(mtds.getName().startsWith("get") && mtds.getName()!="getClass")
			{
				sb.append("res+=\""+mtds.getName().substring(3)+":\";");
				sb.append("res+=o."+mtds.getName()+"().toString()+\",\";");
			}
		}
		
		sb.append("res+="+Arrays.stream(cls.getFields()).map(fld -> fld.getName()).map(f -> "\"\\\"" + f + "\\\":\"+o." + f)
				.collect(Collectors.joining("+\",\"+"))+";");

		sb.append("res+=\"}\";");
		sb.append("return res; }");
		return sb.toString();
	}

}
