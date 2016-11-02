package com.mirdar.dataStructures.Sort;

public class RadixSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,1,3,22};
		int[] c = new RadixSort().radixSort(s);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
	}
	
	//从低位到高位按位一次排序，该排序是针对那些大整数的比较，以CountSort为基方法，因为每位取值只有0-9，所以可以处理
	//CountSort不能处理的大整数排序，也是O(n)的排序
	//先得到最大数，从而知道最高位数，当然在取位的时候 s[j]%Math.pow(10, i)/Math.pow(10, i-1)
	//过程中temp记得归零，每次s = c后，要new c，不然s,c指向同一块内存，导致在用s给c赋值的时候会产生混乱
	public int[] radixSort(int[] s)
	{
		int[] temp = new int[10];
		for(int i=0;i<temp.length;i++)
			temp[i] = 0;
		int max = 0;
		for(int i=0;i<s.length;i++)
		{
			if(max < s[i])
				max= s[i];
		}
		int digit = getDigit(max);
		int[] c = new int[s.length];
		for(int i=1;i<=digit;i++)
		{
			for(int j=0;j<s.length;j++)
			{
				temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]++;
			}
//			for(int j=0;j<temp.length;j++)
//				System.out.print(temp[j]+" ");
//			system2print();
			for(int j=1;j<temp.length;j++)
				temp[j] = temp[j-1]+temp[j];
//			for(int j=0;j<temp.length;j++)
//				System.out.print(temp[j]+" ");
//			system2print();
			for(int j=s.length-1;j>=0;j=j-1)
			{
				c[temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]-1]=s[j];
				temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]--;
			}
			s = c;
			c = new int[s.length]; //c数组不能s指向同一块内存，否则会混乱
			for(int j=0;j<temp.length;j++) //temp归零
				temp[j] = 0;
//			for(int j=0;j<s.length;j++)
//				System.out.print(s[j]+" ");
//			system2print();
		}
		
		return s;
	}
	
	public void system2print()
	{
		System.out.println();
		System.out.println();
	}
	
	public int getDigit(int max)
	{
		int a = 0;
		while(max/10 != 0)
		{
			a++;
			max = max/10;
		}
		if(max % 10 != 0)
			a++;
		return a;
	}
}
