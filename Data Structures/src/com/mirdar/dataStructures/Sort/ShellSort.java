package com.mirdar.dataStructures.Sort;

/*
 * 1. 希尔排序是在插入排序的基础上,设置一个步长，将序列分为多个序列，
 * 2.		然后在每个序列上进行插入排序，
 * 3.		再逐渐减少步长，重复1,2
 * 希尔排序越往后，整个序列越有序
 * 所以希尔排序也叫缩减增量排序（缩小步长，增长排序的序列）
 * 希尔排序很依赖于步长的选择
 */

public class ShellSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new ShellSort().shellSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//希尔排序是基于插入排序的，存在间隔调换两个元素位置，所以也是不稳定的
	public void shellSort(int[] s)
	{
		int gap = s.length/2;
		while(gap >= 1)
		{
			shellInsertSort(s, gap);
			gap = gap/2;
		}
	}
	
	public void shellInsertSort(int[] s,int gap)
	{
		int j = -1;
		for(int i=1;i<s.length;i++)
		{
			int temp= s[i];
			for(j=i;j>0 && j-gap>=0 && temp<s[j-gap];j=j-gap)
			{
				s[j] = s[j-gap];
			}
			s[j] = temp;
		}
	}
}
