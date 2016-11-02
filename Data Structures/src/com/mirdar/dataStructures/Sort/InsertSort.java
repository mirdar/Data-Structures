package com.mirdar.dataStructures.Sort;

public class InsertSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new InsertSort().insertSort(s);
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}
	//�����������ȶ��ģ�ʵ����һ��ʼû��ֱ��д��
	public void insertSort(int[] s)
	{
		int j;
		for(int i=1;i<s.length;i++)
		{
			int temp = s[i];
			for(j=i;j>0 && temp < s[j-1];j--) //j����λ�þ��Ǵ�����Ԫ�ص�λ��
				s[j] = s[j-1];
			s[j] = temp;
		}
	}
}
