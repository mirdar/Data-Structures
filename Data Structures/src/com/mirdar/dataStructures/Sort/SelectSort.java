package com.mirdar.dataStructures.Sort;

public class SelectSort {

	public static void main(String[] args)
	{
		int[] s = {1,4,3,7,6,8,-1,3,-2};
		new SelectSort().selectSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//ѡ�������ǲ��ȶ��ģ�ÿ��ѡ����С��Ԫ�طŵ�����ǰ��λ�ã� ���� 3 3 2 ��ʱ������� 2 3 3����һ��3�ڵڶ���3������(2,3)���������
	public void selectSort(int[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			for(int j=i+1;j<s.length;j++)
			{
				if(s[j] < s[i])
				{
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	}
}
