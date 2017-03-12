import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class JSONConverter {
	private static boolean isPri(Object o)
	{
		String[] types = {"Byte","Short","Int","Long","Float","Double","Character","Boolean","Integer"};
		for(int i=0;i<types.length;i++)
			if(o.getClass().getSimpleName().equals(types[i]))
				return true;
		return false;
	}
	private static String listToJSON(Object o) throws IllegalArgumentException, IllegalAccessException
	{
		StringBuilder res = new StringBuilder();
		if (o.getClass().getName()=="java.util.ArrayList" || o.getClass().getName()=="java.util.LinkedList")
			for(Object i : (List)o)
				res.append(objToJSON(i)+",");
		else if (o.getClass().isArray())
			for(int i=0;i<Array.getLength(o);i++)
				res.append(objToJSON(Array.get(o, i))+",");
		res.setLength(res.length() - 1);
		return res.toString();
	}

	public static String objToJSON(Object o) throws IllegalArgumentException, IllegalAccessException
	{		
		if(o == null)
			return "null";
		else if(o.getClass().getName()=="java.lang.String" || o.getClass().isEnum())
			return "\""+o.toString()+"\"";
		else if(isPri(o))
			return o.toString();
		else if(o.getClass().getName()=="java.util.ArrayList" || o.getClass().getName()=="java.util.LinkedList" || o.getClass().isArray())
			return "["+listToJSON(o)+"]";
		
		StringBuilder res = new StringBuilder();
		res.append("{");
		for(Field fld : o.getClass().getDeclaredFields())
		{
			fld.setAccessible(true);
			res.append("\""+fld.getName()+"\":"+objToJSON(fld.get(o))+",");
		}
		res.setLength(res.length() - 1);
		res.append("}");
		
		return res.toString();
	}
}