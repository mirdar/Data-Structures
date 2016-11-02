package com.mirdar.dataStructures.Sort;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new MergeSort().mergeSort(s);
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}
	
	public void mergeSort(int[] s)
	{
		int[] tempArray = new int[s.length]; //这里开辟空间就不用每次merge的时候重新开辟了
		mergeSort(s,tempArray, 0, s.length-1);
	}
	
	public void mergeSort(int[] s,int[] tempArray,int p,int q)
	{
		if(p < q)
		{
			int center = (p+q)/2;
			mergeSort(s,tempArray, p, center);
			mergeSort(s,tempArray,center+1,q);
			merge(s,tempArray,p,center+1,q);
		}
	}
	public void merge(int[] s,int[] tempArray,int p,int mid,int q)
	{
		int i=p;
		int j=mid;
		int k = p;
		while(i < mid && j <= q)
		{
			if(s[i] > s[j]) //这里就保证了稳定性
			{
				tempArray[k++] = s[j++];
			}
			else
			{
				tempArray[k++] = s[i++];
			}
		}
		if(i >= mid)
		{
			while(j <= q)
				tempArray[k++] = s[j++];
		}
		else
		{
			while(i < mid)
				tempArray[k++] = s[i++];
		}
		for(int m=p;m<=q;m++)
		{
			s[m] = tempArray[m];
		}
	}
}
