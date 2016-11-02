package com.mirdar.dataStructures.Sort;

public class BubbleSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//冒泡排序,两两相邻的元素比较向后移，冒泡排序是稳定的，因为相等的元素在排序前后相对位置不变，
	public void bubbleSort(int[] s)
	{
		for(int i=1;i<s.length;i++)
		{
			for(int j = 0;j<s.length-i;j++)
			{
				if(s[j] > s[j+1])
				{
					int temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}
}
