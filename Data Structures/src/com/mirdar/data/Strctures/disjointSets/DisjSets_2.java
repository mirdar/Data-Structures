package com.mirdar.data.Strctures.disjointSets;

/*
 * �������㷨
 */
public class DisjSets_2 {

	private int[] s;
	public DisjSets_2(int numElements) //��ʼ��
	{
		s = new int[numElements];
		for(int i=0;i<s.length;i++)
		{
			s[i] = -1;
		}
	}
	//���߶Ⱥϲ�����ǳ�ĺϲ�������У������logN������s[i]��ʾ��Ӧ���ĸ߶ȵĸ�ֵ-1
	public void union(int root1,int root2) //��root2������root1����У�ָ�����ϲ�
	{
		if(s[root2]<s[root1])
		{
			s[root1] = root2;
		}
		else
		{
			if(s[root2] == s[root1])
			{
				s[root1]--; //ֻ�������ϲ�����ͬ���ߵ�ʱ��Ż�ʹ�ø߶�����
			}
			s[root2] = root1;
		}
	}
	//����С�ϲ�����С�ĺϲ��������ȥ�������logN��s[i]��ʾ��Ӧ���Ĵ�С-2
	public void union_by_size(int root1,int root2) //��root2������root1����У�ָ�����ϲ�
	{
		if(s[root2]<=s[root1])
		{
			s[root1]+=s[root2]+2; //�ȸ������Ĵ�С
			s[root2] = root1;
		}
		else
		{
			s[root2]+=s[root1]+2;
			s[root1] = root2;
		}
	}
	
	public int find(int x) //����x���������
	{
		if(s[x] < 0)
			return x;
		else
			return find(s[x]);
	}
}
