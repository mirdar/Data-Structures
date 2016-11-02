package com.mirdar.dataStructures.Sort;

public class QuickSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new QuickSort().quickSort(s, 0, s.length-1);
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}
	//����Ҳ�ǲ��ȶ��ģ���������Ŧ���������� 5 2 6 2 8 7 -> 2 2 5 6 8 7   ��2��5�滻��ʱ����
	public void quickSort(int[] s,int p,int q)
	{
		if(p < q)
		{
			int m = partition(s, p, q);
			quickSort(s, p, m-1);
			quickSort(s, m+1, q);
		}
	}
	public int partition(int[] s,int p,int q)
	{
		int k = p;
		for(int i=p+1;i<=q;i++)
		{
			if(s[i] < s[p]) //��s[p+1->q]����s[p]�ֳ�������
			{
				k++;
				int temp = s[k];
				s[k] = s[i];
				s[i] = temp;
			}
		}
		int temp = s[k];
		s[k] = s[p];
		s[p] = temp;
		
		return k;
	}
}
