package com.mirdar.dataStructures.Sort;

/*
 * 1. ϣ���������ڲ�������Ļ�����,����һ�������������з�Ϊ������У�
 * 2.		Ȼ����ÿ�������Ͻ��в�������
 * 3.		���𽥼��ٲ������ظ�1,2
 * ϣ������Խ������������Խ����
 * ����ϣ������Ҳ����������������С������������������У�
 * ϣ������������ڲ�����ѡ��
 */

public class ShellSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new ShellSort().shellSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//ϣ�������ǻ��ڲ�������ģ����ڼ����������Ԫ��λ�ã�����Ҳ�ǲ��ȶ���
	public void shellSort(int[] s)
	{
		int gap = s.length/2;
		while(gap >= 1)
		{
			shellInsertSort(s, gap);
			gap = gap/2;
		}
	}
	
	public void shellInsertSort(int[] s,int gap)
	{
		int j = -1;
		for(int i=1;i<s.length;i++)
		{
			int temp= s[i];
			for(j=i;j>0 && j-gap>=0 && temp<s[j-gap];j=j-gap)
			{
				s[j] = s[j-gap];
			}
			s[j] = temp;
		}
	}
}
