package com.mirdar.dataStructures.Sort;

public class CountSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,1,3,22};
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
		System.out.println();
		int[] c = new CountSort().countSort(s);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
	}
	
	//计数排序是针对于小正整数的排序，整数的范围不能太大，否则太耗内存，当然对于该特殊排序，只需要O(n)
	//当序列为0,1，99999999999999，则该排序不适合，而且不适合于小数
	//对于有负整数的序列，可以排序前序列加上最小负数的绝对值，排序后再减去即可
	public int[] countSort(int[] s)
	{
		int length = 0;
		for(int i=0;i<s.length;i++)
		{
			if(length < s[i])
			{
				length = s[i];
			}
		}
		int[] temp = new int[length+1];
		for(int i=0;i<temp.length;i++)
		{
			temp[i] = 0;
		}
		for(int i=0;i<s.length;i++)
		{
			temp[s[i]]++;
		}
		System.out.println();
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
		System.out.println();
		for(int i=1;i<temp.length;i++)
		{
			temp[i] = temp[i-1]+temp[i];
		}
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
		System.out.println();
		int[] c = new int[s.length];
		for(int i=0;i<s.length;i++)
		{
			c[temp[s[i]]-1] = s[i];
			temp[s[i]]--;
		}
		
		return c;
	}
}
