package com.mirdar.dataStructures.Query;

/*
 * 顺序查找时间复杂度为O(n),序列不需要事先排序
 * 
 */

public class SequentialQuery {

	public static void main(String[] args)
	{
		int[] s = {2,4,6,7,9,11};
		System.out.println(new SequentialQuery().findX(s, 6)+1);
		System.out.println(new SequentialQuery().findX(s, 5)+1);
	}
	
	public int findX(int [] s,int x)
	{
		for(int i=0;i<s.length;i++)
			if(x == s[i])
				return i;
		return -1;
	}
}
