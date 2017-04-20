package jvm.internals.jsonassist.example;

import java.util.ArrayList;

import com.google.gson.Gson;

import jvm.internals.jsonassist.Jitson;

public class Test {

	public static void main(String[] args) {
		Gson g = new Gson();
		Jitson j = new Jitson();

		Student s = new Student(10,"Witek",3222);
		s.stringList = new ArrayList<String>();
		s.stringList.add("sadasD");
		s.stringList.add("fdgfdhgdh");
		
		System.out.println(g.toJson(s));
		System.out.println(j.toJson(s));
	}

}
