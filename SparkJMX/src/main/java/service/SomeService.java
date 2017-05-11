package service;

public class SomeService {

	private int a = 1;
	private int x = 1;

	public double result() {
		return Math.pow(a,x);
	}

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
	
}
