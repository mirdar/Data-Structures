package com.mirdar.dataStructures.recursive;

import java.util.Scanner;

public class N_Queen {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] board = new N_Queen().calcQueen(n);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i == board[j])
					System.out.print("Q ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
	}
	
	//n�����̴�С��boardΪһ����СΪn�����飬����ÿһ�л���������
	public int[] calcQueen(int n)
	{
		int[] board = new int[n];
		for(int i=0;i<n;i++)
			board[i] = -1;
		nQueen(board,0,n);
		return board;
	}
	
	public boolean nQueen(int[] board,int current,int n)
	{
		if(current == n)
			return true;
		for(int i=0;i<n;i++)
		{
			board[current] = i;
			if(noConflicts(board,current))
			{
				boolean isFound = nQueen(board,current+1,n);
//�����ж��Ƿ��ҵ��ʺ��һ�ְڷŷ�ʽ�����û�оʹӵ�һ���ʺ�ʼ���°ڷţ�������false�Ļ������forѭ�������		
				if(isFound)
					return true;
			}
		}
		return false;
	}
	
	public boolean noConflicts(int[] board, int current)
	{
		for(int i=0;i<current;i++)
		{
			if(board[i] == board[current]) //current��������ǰ������ͬ
				return false;
			if(current-i == Math.abs(board[current]-board[i])) //��ǰ��Ļʺ���ͬһ�Խ���
				return false;
		}
		return true;
	}
}
