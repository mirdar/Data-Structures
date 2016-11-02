package com.mirdar.dataStructures.Sort;

import java.util.ArrayList;

public class BucketSort {

	public static void main(String[] args)
	{
		int[] s = {2,4,51,6,44,8,3};
		new BucketSort().bucketSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	
	//桶排序，生成一个list数组，然后将原数据按照该公式   n*(s[i]/(max+1))  映射到每个桶中，
	//对每个桶进行排序，可选择很多排序，这里使用插入排序
	//假设数据分布比较均匀时
	public void bucketSort(int[] s)
	{
		int n = s.length;
		//不能ArrayList<Integer>[] bucketList = new ArrayList<Integer>[n];
		ArrayList<Integer>[] bucketList = new ArrayList[n];
		int max = max(s);
		for(int i=0;i<n;i++)
		{
			int num = n*(s[i]/max);
			if(bucketList[num] == null)
				bucketList[num] = new ArrayList<Integer>();
			bucketList[num].add(s[i]);
		}
		int k = 0;
		for(int i=0;i<n;i++)
		{
			if(bucketList[i] != null)
			{
				insertSort(bucketList[i]);
				for(int j=0;j<bucketList[i].size();j++)
				{
					s[k] = bucketList[i].get(j);
					k++;
				}
			}
		}
	}
	
	public void insertSort(ArrayList<Integer> s)
	{
		int j = -1;
		for(int i=1;i<s.size();i++)
		{
			int temp = s.get(i);
			for(j = i;j>0 && s.get(j-1) > temp;j--)
			{
				s.set(j, s.get(j-1));
			}
			s.set(j, temp);
		}
	}
	
	public int max(int[] s)
	{
		int max = 0;
		for(int i=0;i<s.length;i++)
		{
			if(s[i] > max)
			{
				max = s[i];
			}
		}
		return max+1;
	}
}
