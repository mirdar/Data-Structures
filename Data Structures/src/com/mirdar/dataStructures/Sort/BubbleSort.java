package com.mirdar.dataStructures.Sort;

public class BubbleSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(s);
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+" ");
		}
	}
	//ð������,�������ڵ�Ԫ�رȽ�����ƣ�ð���������ȶ��ģ���Ϊ��ȵ�Ԫ��������ǰ�����λ�ò��䣬
	public void bubbleSort(int[] s)
	{
		for(int i=1;i<s.length;i++)
		{
			for(int j = 0;j<s.length-i;j++)
			{
				if(s[j] > s[j+1])
				{
					int temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}
}
