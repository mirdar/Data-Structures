package com.mirdar.data.Strctures.disjointSets;

/*
 * ·��ѹ������find/union�����У�union�������Ѽ��ٸ��Ӷȣ����Դ�find�г���
 * ÿ�β���find(x)��ʹ�丸�ڵ��Ϊ�����ĸ�
 */
public class path_compress {
	public int find(int x)
	{
		if(s[x] < 0)
			return x;
		else
			return s[x] = find(s[x]); //��ѯ��͸�����
	}
	private int[] s;
}
