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
	
	//n是棋盘大小，board为一个大小为n的数组，保存每一列换行所在行
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
//这里判断是否找到皇后的一种摆放方式，如果没有就从第一个皇后开始重新摆放，即这里false的话，外层for循环会继续		
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
			if(board[i] == board[current]) //current所在行与前面列相同
				return false;
			if(current-i == Math.abs(board[current]-board[i])) //与前面的皇后在同一对角线
				return false;
		}
		return true;
	}
}
