package com.mirdar.dataStructures.Hash;
/*
 * ֱ��Ѱַ�����ؼ��ַ�Χ��Сʱ�����Խ��ؼ���k��Ԫ�طŵ�ֱ��Ѱַ���еĲ�k��
 */
public class DirectAddressing {
	int[] directTable;
	
	public static void main(String[] args)
	{
		//����ֱ�ӽ��ؼ�����Ԫ����ͬ�ˣ�һ��������ݿ�һ����������һ��ID��Ϊ�ؼ��֣�Ȼ�󽫼�¼hash������
		int[] s = {1,0,5,3,8,6,9,44};
		DirectAddressing direct = new DirectAddressing();
		direct.directAddre(s);
		System.out.println(direct.find(1));
		System.out.println(direct.find(10));
		
		
	}
	public void directAddre(int[] s)
	{
		int len = max(s);
		directTable = new int[len+1];
		for(int i=0;i<directTable.length;i++)
			directTable[i] = -1;
		for(int i=0;i<s.length;i++)
		{
			directTable[s[i]] = s[i];
		}
	}
	public boolean find(int x)
	{
		if(directTable[x] != -1)
			return true;
		else
			return false;
	}
	public int max(int[] s)
	{
		int max = 0;
		for(int i=0;i<s.length;i++)
		{
			if(max < s[i])
				max = s[i];
		}
		return max;
	}
}
