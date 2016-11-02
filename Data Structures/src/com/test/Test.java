package com.test;

public class Test {

	double a = 0.7;
	public static void main(String[] args)
	{
		Test test = new Test();
		System.out.println(test.f(50,0));
		System.out.println(test.f(50,2));
		System.out.println(test.f(30,1));
		System.out.println(test.f(40,2));
		System.out.println(test.f(45,1));
		System.out.println(test.f(60,0.5));
		System.out.println(test.f(55,0.5));
		System.out.println(test.f(55,1));
		System.out.println(test.f(25,5));
	}
	
	public double f(double income,double diffT)
	{
		return (1-a)*income+a*Math.exp(diffT);
	}
}
