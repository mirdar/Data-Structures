package com.mirdar.dataStructures.Sort;

public class RadixSort {

	public static void main(String[] args)
	{
		int[] s = {1,6,2,4,5,1,3,22};
		int[] c = new RadixSort().radixSort(s);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
	}
	
	//�ӵ�λ����λ��λһ�����򣬸������������Щ�������ıȽϣ���CountSortΪ����������Ϊÿλȡֵֻ��0-9�����Կ��Դ���
	//CountSort���ܴ���Ĵ���������Ҳ��O(n)������
	//�ȵõ���������Ӷ�֪�����λ������Ȼ��ȡλ��ʱ�� s[j]%Math.pow(10, i)/Math.pow(10, i-1)
	//������temp�ǵù��㣬ÿ��s = c��Ҫnew c����Ȼs,cָ��ͬһ���ڴ棬��������s��c��ֵ��ʱ����������
	public int[] radixSort(int[] s)
	{
		int[] temp = new int[10];
		for(int i=0;i<temp.length;i++)
			temp[i] = 0;
		int max = 0;
		for(int i=0;i<s.length;i++)
		{
			if(max < s[i])
				max= s[i];
		}
		int digit = getDigit(max);
		int[] c = new int[s.length];
		for(int i=1;i<=digit;i++)
		{
			for(int j=0;j<s.length;j++)
			{
				temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]++;
			}
//			for(int j=0;j<temp.length;j++)
//				System.out.print(temp[j]+" ");
//			system2print();
			for(int j=1;j<temp.length;j++)
				temp[j] = temp[j-1]+temp[j];
//			for(int j=0;j<temp.length;j++)
//				System.out.print(temp[j]+" ");
//			system2print();
			for(int j=s.length-1;j>=0;j=j-1)
			{
				c[temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]-1]=s[j];
				temp[(int)(s[j]%Math.pow(10, i)/Math.pow(10, i-1))]--;
			}
			s = c;
			c = new int[s.length]; //c���鲻��sָ��ͬһ���ڴ棬��������
			for(int j=0;j<temp.length;j++) //temp����
				temp[j] = 0;
//			for(int j=0;j<s.length;j++)
//				System.out.print(s[j]+" ");
//			system2print();
		}
		
		return s;
	}
	
	public void system2print()
	{
		System.out.println();
		System.out.println();
	}
	
	public int getDigit(int max)
	{
		int a = 0;
		while(max/10 != 0)
		{
			a++;
			max = max/10;
		}
		if(max % 10 != 0)
			a++;
		return a;
	}
}
