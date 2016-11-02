package com.mirdar.dataStructures.Query;

/*
 * 二叉查找时间复杂O(logn),需要事先对序列排好序
 */

public class BinaryQuery {

	public static void main(String[] args)
	{
		int[] s = {1,3,4,5,6,8,9,10};
		System.out.println(new BinaryQuery().binaryQuery(s, 9)+1);
		System.out.println(new BinaryQuery().binaryQuery(s, 2)+1);
	}
	
	public int binaryQuery(int[] s,int x)
	{
		int l = 0;
		int r = s.length - 1;
		int mid = 0;
		while(l <= r)
		{
			mid = (l+r)/2;
			if(s[mid] < x)
				l = mid + 1;
			else if(s[mid] > x)
				r = mid - 1;
			else
				return mid;
				
		}
		return -2;
	}
}
