package com.mirdar.dataStructures.Hash;

import java.util.ArrayList;
import java.util.Random;

/*
 * ���ֳ����෨�������ͻ��δ���������ݾ�����hash��ͬһ��λ�ã�����һ��ѡ����ʵĳ���ʹ�����ݱ�����hash����ͬλ��
 * ����ѡ��
 * 		1. ����ʹ��2���ݣ�������ʹ�ö�ʧ��λ��Ϣ
 * 		2. ʹ���������������Զ��2����   �����Ϊʲô����
 * 		3. ��ʹ�õڶ����������Ե�ʱ��һ��ʹ��ǰһ��������2����һ��
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
				System.out.println("������ͻ");
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
