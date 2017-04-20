package jvm.internals.jsonassist;

import java.lang.reflect.Method;

import jvm.internals.jsonassist.example.Student;

public class asd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(10,"Witek",222);
		System.out.println(toJSON(s));
		asdasd(s);
	}
	public static String toJSON(Student o)
	{
		Integer a = o.getIid();
		return a.toString();
	}
	public static String asdasd(Student o)
	{
		
		Method[] methods = o.getClass().getMethods();

		for(Method method : methods){
			if(method.getName().startsWith("get") && method.getName()!="getClass")
				System.out.println("method = " + method.getName());
		}
		return null;
	}

}
