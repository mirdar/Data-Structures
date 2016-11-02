package com.mirdar.dataStructures.recursive;

public class ReverseString {

	public static void main(String[] args)
	{
		String s = "abcd";
		System.out.println(s.substring(0,s.length()));
		System.out.println(new ReverseString().reverse(s));
	}
	
	public String reverse(String s)
	{
		if(s.equals(""))
			return s;
		String subString = s.substring(1,s.length());
//		System.out.println(subString);
		String subSolution = reverse(subString);
		return subSolution + s.substring(0,1);
	}
}
