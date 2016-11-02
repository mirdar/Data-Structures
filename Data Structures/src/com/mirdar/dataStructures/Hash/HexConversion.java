package com.mirdar.dataStructures.Hash;

public class HexConversion {

	public static void main(String[] args)
	{
		int i = 10;
		//十进制转成十六进制：
		Integer.toHexString(i);
		//十进制转成八进制
		Integer.toOctalString(i);
		//十进制转成二进制
		Integer.toBinaryString(i);
//		//十六进制转成十进制
//		Integer.valueOf("FFFF",16).toString();
//		//八进制转成十进制
//		Integer.valueOf("876",8).toString();
//		//二进制转十进制
//		Integer.valueOf("0101",2).toString();
		
//		System.out.println(Integer.toBinaryString(i));
		
		int[] a = {5554,444,233,776,2342};
		int b = 2;
//		int b = 5;
		//b取合数的话确实a中的数会被切断只能后面几位，而b取奇数则a中每个数的参与运算了
		for(int j = 0;j<a.length;j++)
		{
			System.out.print(Integer.toBinaryString(a[j])+" % ");
			System.out.print(Integer.toBinaryString(b)+" = ");
			System.out.print(Integer.toBinaryString(a[j]%b));
			System.out.println();
		}
		
	}
}
