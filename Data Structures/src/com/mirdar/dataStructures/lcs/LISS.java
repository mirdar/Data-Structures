package com.mirdar.dataStructures.lcs;

import java.util.ArrayList;

/*
 * �����������
 * ���������   1,2,4,2,3,5,4,6
 * 				1. ��̬�滮�� O(n2)��
 * 					���絽����6��β��������Ҫ֪������6֮ǰԪ����ɵ��������������У���ѡ�����һ������
 * 					�����зֲ�Ϊ��1 2 4 2 3 5 4Ϊ��β����������У������Ѿ�����������������������ģ�
 * 					1
 * 					1 2
 * 					1 2 4
 * 					1 2 4 ��2 < 4��
 * 					1 2 3 ��������ʵ����������������ö�̬�滮�õ���Ӧ���������
 * 					1 2 3 5 
 *					1 2 3 4 
 *					Ȼ��6��4�Ƚϣ���4����ֱ�Ӹ�����ȥ��������ǰ����һλ�������Ƚ�
 *
 *				2. ������ת��Ϊ�������������LCS����ʱ�Ƚ�ԭ��������Ȼ����LCS���ɸ��Ӷ��Ը�
 *
 *				3. �õ����г���Ϊi�����������У����ҽ�����β��Ԫ����С��Ԫ�ش���һ���µ�����ĵ�i��λ�ã�ʱ�临�Ӷ�ΪO(nlogn)
 *					�����½�������Ϊlen����len�ĵı仯����Ϊ
 *					1
 *					1 2
 *					1 2 4
 *					1 2���Ѿ��滻�� 4
 *					1 2 3
 *					1 2 3 5
 *					1 2 3 4
 *					1 2 3 4 6
 *					�������ɷ��֣�len�еĵ�i��λ�ô�����Ϊi���Ӵ�������λ�õ�Ԫ�ز��ϵı���С��Ԫ������������Ԫ�ر�ȻҪ����
 *					��i-1��Ԫ�أ�С�ڵ��ڵ�i��Ԫ��
 *					��������˼�룬��ͬ���ȵ����������У���ĩβԪ��ԽСԽ�ã���Ϊ��δ�����и���ļ��ʸ���Ԫ��
 *
 *		��δ�ӡ����
 */

public class LISS {

	public static void main(String[] args)
	{
		LISS liss = new LISS();
		int[] s = {3,2,3,4,1,2,3,4};
		liss.longestIncrementSubSequence(s);
		liss.longestIncrementSubSequence2(s);
		
		//��������Կ��������ַ��ҵ���λ���ǵ�һ��data[i-1]<key��key<=data[i]��iλ��
		double[] a = {1,2,3,4,5,6,7,9,13};
		System.out.println(liss.binarySearch(a, 0, a.length-1, 1.5));
	}
	
	//��̬�滮����
	public void longestIncrementSubSequence(int[] s)
	{
		int[] len = new int[s.length];
		//��һ����������Ľṹ��ӡ�����������
		LISSElement[] lissE = new LISSElement[s.length];
		for(int i=0;i<len.length;i++)
		{
			len[i] = 1;
			lissE[i] = new LISSElement();
		} 
		for(int i=0;i<len.length;i++)
		{
			lissE[i].i = i;
			for(int j = i-1;j>=0;j--)
			{
				//����len[i] < len[j]+1 ��Ϊ���ҵ�iǰ���������������������һ��
				if(s[i] > s[j] && len[i] < len[j]+1)
				{
					len[i] = len[j] + 1;
					lissE[i].pre = lissE[j];
				}
			}
		}
		int longest = 0;
		int k = 0;
		for(int i=0;i<len.length;i++)
		{
			if(len[i] > longest)
			{
				longest = len[i];
				k = i;
			}
		}
		LISSElement temp = lissE[k];
		ArrayList<Integer> printList = new ArrayList<Integer>();
		while(temp != null)
		{
			printList.add(s[temp.i]);
			temp = temp.pre;
		}
		System.out.println("����������г���Ϊ�� "+longest);
		System.out.print("	");
		for(int i=printList.size()-1;i>=0;i--)
			System.out.print(printList.get(i) + " ");
		System.out.println();
	}
	
	//����û�д�ӡ
	public int longestIncrementSubSequence2(int[] s)
	{
		int[] len = new int[s.length];
//		for(int i=0;i<len.length;i++)
//		{
//			len[i] = 0;
//		}
		int length = 1;
		len[0] = s[0];
		for(int i=1;i<s.length;i++)
		{
			if(s[i] > len[length-1])
			{
				len[length] = s[i];
				length++;
				
			}
			else
			{
				//�ҵ���һ����s[i]���Ԫ������λ�ã����滻
				int pos = binarySearch(len, 0, length-1, s[i]);
				len[pos] = s[i];
			}
		}
		System.out.println("length: "+length);
		return length;
	}
	//���ֲ���
	public int binarySearch(double[] data,int low,int high,double key)
	{
		int mid = -1;
		while(low <= high)
		{
//			mid = (low+high)/2;
			mid = low + (high-low)/2; //��ֹ���
			if(data[mid] < key)
				low = mid + 1;
			else if(data[mid] == key)
				return mid;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	public int binarySearch(int[] data,int low,int high,int key)
	{
		int mid = -1;
		while(low <= high)
		{
			mid = (low+high)/2;
			if(data[mid] < key)
				low = mid + 1;
			else if(data[mid] == key)
				return mid;
			else
				high = mid - 1;
		}
		return low;
	}
}
