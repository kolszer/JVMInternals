package mbean;

import java.beans.ConstructorProperties;

public class ServiceStats {

	private int a;
	private int x;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public ServiceStats() {
		super();
	}
	
	@ConstructorProperties({"a", "x"}) 
	public ServiceStats(int a, int x) {
		super();
		this.a = a;
		this.x = x;
	} 

}
