package com.mirdar.dataStructures.lcs;

import java.util.ArrayList;

/*
 * 最大子序列和   
 * 			1. 递归 (O(nlogn))
 * 			2. 直接循环 （只需要O(n)）
 * 
 */

public class LSSS {

	public static void main(String[] args)
	{
		int[] s = {1,-2,3,4,-1,2};
		LSSS lsss = new LSSS();
		System.out.println(lsss.largestSubSequenceSum(s, 0, s.length-1));
		System.out.println(lsss.largestSubSequenceSumSimple(s));
	}
	//类似归并排序算法逻辑，每次从左，中右选出最大的子序列和
	public int largestSubSequenceSum(int[] s,int left,int right)
	{
		//递归出口
		if(left == right)
			if(s[left] > 0)
				return s[left];
			else
				return 0;
		
		int mid = (left+right)/2;
		int maxLeftSum = largestSubSequenceSum(s,left,mid);
		int maxRightSum = largestSubSequenceSum(s, mid+1, right);
		int maxLeftBoradSum = 0, leftBoradSum = 0;
		for(int i=mid;i>=left;i--)
		{
			leftBoradSum += s[i];
			if(leftBoradSum > maxLeftBoradSum) 
				maxLeftBoradSum = leftBoradSum;
		}
		int maxRightBoradSum = 0, RightBoradSum = 0;
		for(int i=mid+1;i<=right;i++)
		{
			RightBoradSum += s[i];
			if(RightBoradSum > maxRightBoradSum)
				maxRightBoradSum = RightBoradSum;
		}
		
		return max(maxLeftSum,maxRightSum,maxLeftBoradSum+maxRightBoradSum);
	}
	
	public int max(int a1,int a2,int a3)
	{
		if(a1 > a2)
			if(a1 > a3)
				return a1;
			else
				return a3;
		else
			if(a2 > a3)
				return a2;
			else 
				return a3;
	}
	
	//最简单的方式求最大子序列和
	public int largestSubSequenceSumSimple(int[] s)
	{
		int max = 0,curMax = 0;
		//用两个ArrayList得到最大子序列和的序列，打印
		ArrayList<Integer> subSequence = new ArrayList<Integer>();
		ArrayList<Integer> maxSequence = new ArrayList<Integer>();
		for(int i=0;i<s.length;i++)
		{
			curMax += s[i];
			System.out.print(s[i]+" ");
			subSequence.add(s[i]);
			if(curMax < 0)
			{
				System.out.println();
				subSequence = new ArrayList<Integer>();
				curMax = 0;
			}
			if(curMax > max)
			{
				maxSequence = new ArrayList<Integer>();
				for(int j=0;j<subSequence.size();j++)
					maxSequence.add(subSequence.get(j));
				max = curMax;
			}
		}
		System.out.println();
		System.out.println("最大子序列和序列为： ");
		System.out.print("		");
		for(int j=0;j<maxSequence.size();j++)
			System.out.print(maxSequence.get(j)+" ");
		System.out.println();
		return max;
	}
}
