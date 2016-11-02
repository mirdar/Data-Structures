package com.mirdar.dataStructures.Sort;

public class HeapSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,-1,3,-2};
		new HeapSort().heapSort(s);
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}
	public void heapSort(int[] s)
	{
		//����
		for(int i=s.length/2;i>=0;i--)
			percDown(s, i,s.length);
		//���򣬲����ϼ������Ĵ�С�������Ͳ����ö��������洢��
		for(int j=s.length-1;j>0;j--)
		{
			swap(s,0,j);
			percDown(s, 0, j); //���ﲢû�п���j�Լ�j�����Ԫ��
		}
	}
	//�����Ƕ���������ĵĴ��룬��δ��뽨��������С��
	public void percDown(int[] s,int i,int n)
	{
		int child = -1;
		int temp;
		for(temp=s[i];leftChild(i)+1<n;i=child)
		{
			child = leftChild(i);
			if(s[child] > s[child+1]) //�ҵ������ӽڵ��С��
				child++;
			if(temp > s[child]) //�����temp���У����������������ѭ��
				s[i] = s[child];
			else
				break;
		}
		s[i] = temp;
	}
	//��Ϊ�����±��0��ʼ�������������ӽڵ�Ϊ2*i+1
	public int leftChild(int i)
	{
		return 2*i+1;
	}
	
	public void swap(int[] s,int p,int q)
	{
		int temp = s[p];
		s[p] = s[q];
		s[q] = temp;
	}
}
