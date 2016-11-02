package com.mirdar.dataStructures.Sort;

public class HeapSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new HeapSort().heapSort(s);
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}
	public void heapSort(int[] s)
	{
		//建树
		for(int i=s.length/2;i>=0;i--)
			percDown(s, i,s.length);
		//排序，并不断减少树的大小（这样就不用用额外的数组存储）
		for(int j=s.length-1;j>0;j--)
		{
			swap(s,0,j);
			percDown(s, 0, j); //这里并没有考虑j以及j往后的元素
		}
	}
	//这里是堆排序最核心的代码，这段代码建立的是最小堆
	public void percDown(int[] s,int i,int n)
	{
		int child = -1;
		int temp;
		for(temp=s[i];leftChild(i)+1<n;i=child)
		{
			child = leftChild(i);
			if(s[child] > s[child+1]) //找到左右子节点较小的
				child++;
			if(temp > s[child]) //如果比temp还行，则替代，否则跳出循环
				s[i] = s[child];
			else
				break;
		}
		s[i] = temp;
	}
	//因为数组下标从0开始，所以这里左子节点为2*i+1
	public int leftChild(int i)
	{
		return 2*i+1;
	}
	
	public void swap(int[] s,int p,int q)
	{
		int temp = s[p];
		s[p] = s[q];
		s[q] = temp;
	}
}
