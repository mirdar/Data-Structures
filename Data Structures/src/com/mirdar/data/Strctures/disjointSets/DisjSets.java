package com.mirdar.data.Strctures.disjointSets;

/*
 * ���ཻ���Ļ������ݽṹ����s[i]=i����ʼ���s[i]=-1������i��ʾ������ʼ�����ڲ�ͬ����i��
 * Ӧ�ã������Թ�����
 */
public class DisjSets {

	private int[] s;
	public DisjSets(int numElements) //��ʼ��
	{
		s = new int[numElements];
		for(int i=0;i<s.length;i++)
		{
			s[i] = -1;
		}
	}
	
	public void union(int root1,int root2) //��root2������root1����У�ָ�����ϲ�
	{
		s[root2] = root1;
	}
	
	public int find(int x) //����x���������
	{
		if(s[x] < 0)
			return x;
		else
			return find(s[x]);
	}
}
