package com.mirdar.dataStructures.Hash;

import java.util.ArrayList;
import java.util.Random;

/*
 * 这种除留余法会产生冲突，未来避免数据经常被hash到同一个位置，所以一般选择合适的除数使得数据被均匀hash到不同位置
 * 除数选择
 * 		1. 避免使用2的幂，这样会使得丢失高位信息
 * 		2. 使用质数，并且最好远离2的幂   （这个为什么？）
 * 		3. 当使用第二个质数尝试的时候，一般使用前一个质数的2倍少一点
 * 
 */

public class ModAdressing {
	int[] hashTable = null;
	ArrayList<Integer>[] hashTable2 = null;
	int divisor = 19;
	
	public static void main(String[] args)
	{
		int[] s = new int[10];
		Random rand = new Random();
		for(int i=0;i<10;i++)
			s[i] = rand.nextInt(1000);
		ModAdressing modAddr = new ModAdressing();
		modAddr.modAdressing(s);
		modAddr.modAdressingWithConflict(s);
		for(int i=0;i<modAddr.hashTable.length;i++)
			System.out.println("i: "+modAddr.hashTable[i]+" ");
		System.out.println();
		for(int i=0;i<modAddr.hashTable2.length;i++)
			for(int j=0;j<modAddr.hashTable2[i].size();j++)
				System.out.println("i: "+modAddr.hashTable2[i]+" ");
	}	
	
	public void modAdressing(int[] s)
	{
		hashTable = new int[2*s.length];
		for(int i=0;i<hashTable.length;i++)
			hashTable[i] = -1;
		for(int i=0;i<10;i++)
		{
			int mod = s[i]%divisor;
			if(hashTable[mod] != -1)
				System.out.println("发生冲突");
			else
				hashTable[mod] = s[i];
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public void modAdressingWithConflict(int[] s)
	{
		hashTable2 = new ArrayList[2*s.length];
		for(int i=0;i<hashTable2.length;i++)
			hashTable2[i] = new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			int mod = s[i]%divisor;
				hashTable2[mod].add(s[i]);
		}
	}
}
