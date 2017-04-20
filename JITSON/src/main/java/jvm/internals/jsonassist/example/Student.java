package jvm.internals.jsonassist.example;

import java.util.List;

public class Student {
	public int id;
	public String name;
	private Integer iid;
	public List<String> stringList;
	public Student(int id, String name, int iid)
	{
		this.id=id;
		this.name=name;
		this.iid=iid;
	}
	public Integer getIid()
	{
		return this.iid;
	}
	
}