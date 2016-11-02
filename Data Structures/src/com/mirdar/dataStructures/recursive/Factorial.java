package com.mirdar.dataStructures.recursive;

import java.util.Scanner;

/*
 * ½×³ËµÝ¹é
 */

public class Factorial {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(new Factorial().factorial(n));
	}
	
	public int factorial(int n)
	{
		if(n <= 1)
			return 1;
		return n*factorial(n-1);
	}
	
}
