package com.mirdar.dataStructures.Sort;

public class SelectSort {

	public static void main(String[] args)
	{
		int[] s = {1,4,3,7,6,8,-1,3,-2};
		new SelectSort().selectSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//选择排序是不稳定的，每次选择最小的元素放到数组前面位置， 例如 3 3 2 此时排序后变成 2 3 3，第一个3在第二个3后面了(2,3)间隔交换了
	public void selectSort(int[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			for(int j=i+1;j<s.length;j++)
			{
				if(s[j] < s[i])
				{
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	}
}
