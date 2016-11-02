package com.mirdar.dataStructures.Hash;
/*
 * 直接寻址，当关键字范围较小时，可以将关键字k的元素放到直接寻址表中的槽k中
 */
public class DirectAddressing {
	int[] directTable;
	
	public static void main(String[] args)
	{
		//这里直接将关键字与元素相同了，一般的像数据库一样，都是用一个ID作为关键字，然后将记录hash到表中
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
