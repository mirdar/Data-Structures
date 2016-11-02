package com.mirdar.dataStructures.lcs;

import java.util.ArrayList;

/*
 * 最长增长子序列
 * 加入给定串   1,2,4,2,3,5,4,6
 * 				1. 动态规划法 O(n2)）
 * 					假如到达以6结尾，则事先要知道所有6之前元素组成的所有增长子序列，并选择最长的一条附加
 * 					如下列分布为以1 2 4 2 3 5 4为结尾最长增长子序列（这里已经从所有子序列中挑出了最长的）
 * 					1
 * 					1 2
 * 					1 2 4
 * 					1 2 4 （2 < 4）
 * 					1 2 3 （这里其实有两个，但是如果用动态规划得到的应该是这个）
 * 					1 2 3 5 
 *					1 2 3 4 
 *					然后6与4比较，比4大，则直接附加上去，否则向前再推一位，继续比较
 *
 *				2. 将问题转化为求最长公共子序列LCS，此时先将原序列排序，然后求LCS即可复杂度稍高
 *
 *				3. 得到所有长度为i的增长子序列，并且将其中尾部元素最小的元素存在一个新的数组的第i个位置，时间复杂度为O(nlogn)
 *					假设新建的数组为len，则len的的变化过程为
 *					1
 *					1 2
 *					1 2 4
 *					1 2（已经替换） 4
 *					1 2 3
 *					1 2 3 5
 *					1 2 3 4
 *					1 2 3 4 6
 *					从上述可发现，len中的第i个位置代表长度为i的子串，而该位置的元素不断的被更小的元素替代，替代的元素必然要大于
 *					第i-1个元素，小于等于第i个元素
 *					基于这种思想，相同长度的增长子序列，最末尾元素越小越好，因为在未来能有更大的几率附加元素
 *
 *		如何打印？？
 */

public class LISS {

	public static void main(String[] args)
	{
		LISS liss = new LISS();
		int[] s = {3,2,3,4,1,2,3,4};
		liss.longestIncrementSubSequence(s);
		liss.longestIncrementSubSequence2(s);
		
		//从这里可以看出来二分法找到的位置是第一个data[i-1]<key，key<=data[i]的i位置
		double[] a = {1,2,3,4,5,6,7,9,13};
		System.out.println(liss.binarySearch(a, 0, a.length-1, 1.5));
	}
	
	//动态规划化法
	public void longestIncrementSubSequence(int[] s)
	{
		int[] len = new int[s.length];
		//用一个类似链表的结构打印最长增长子序列
		LISSElement[] lissE = new LISSElement[s.length];
		for(int i=0;i<len.length;i++)
		{
			len[i] = 1;
			lissE[i] = new LISSElement();
		} 
		for(int i=0;i<len.length;i++)
		{
			lissE[i].i = i;
			for(int j = i-1;j>=0;j--)
			{
				//这里len[i] < len[j]+1 是为了找到i前面所有增长子序列中最长的一个
				if(s[i] > s[j] && len[i] < len[j]+1)
				{
					len[i] = len[j] + 1;
					lissE[i].pre = lissE[j];
				}
			}
		}
		int longest = 0;
		int k = 0;
		for(int i=0;i<len.length;i++)
		{
			if(len[i] > longest)
			{
				longest = len[i];
				k = i;
			}
		}
		LISSElement temp = lissE[k];
		ArrayList<Integer> printList = new ArrayList<Integer>();
		while(temp != null)
		{
			printList.add(s[temp.i]);
			temp = temp.pre;
		}
		System.out.println("最长增长子序列长度为： "+longest);
		System.out.print("	");
		for(int i=printList.size()-1;i>=0;i--)
			System.out.print(printList.get(i) + " ");
		System.out.println();
	}
	
	//这里没有打印
	public int longestIncrementSubSequence2(int[] s)
	{
		int[] len = new int[s.length];
//		for(int i=0;i<len.length;i++)
//		{
//			len[i] = 0;
//		}
		int length = 1;
		len[0] = s[0];
		for(int i=1;i<s.length;i++)
		{
			if(s[i] > len[length-1])
			{
				len[length] = s[i];
				length++;
				
			}
			else
			{
				//找到第一个比s[i]大的元素所在位置，并替换
				int pos = binarySearch(len, 0, length-1, s[i]);
				len[pos] = s[i];
			}
		}
		System.out.println("length: "+length);
		return length;
	}
	//二分查找
	public int binarySearch(double[] data,int low,int high,double key)
	{
		int mid = -1;
		while(low <= high)
		{
//			mid = (low+high)/2;
			mid = low + (high-low)/2; //防止溢出
			if(data[mid] < key)
				low = mid + 1;
			else if(data[mid] == key)
				return mid;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	public int binarySearch(int[] data,int low,int high,int key)
	{
		int mid = -1;
		while(low <= high)
		{
			mid = (low+high)/2;
			if(data[mid] < key)
				low = mid + 1;
			else if(data[mid] == key)
				return mid;
			else
				high = mid - 1;
		}
		return low;
	}
}
