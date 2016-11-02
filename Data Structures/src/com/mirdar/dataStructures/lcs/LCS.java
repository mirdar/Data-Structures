package com.mirdar.dataStructures.lcs;

/*
 * 最长公共子序列	 	动态规划求解
 * 最长公共子串 	 	动态规划 or 循环
 * 
 * 最长公共子串在dp解释与最长公共子序列有区别
 * 最长公共子序列，直接返回mat[n,m]即可，因为求解过程从mat[n,m]分解出去的
 * 而最长公共子串，则返回mat中的最大数(计算公式不一样)，因为求解过程是找到所有可能的共同连续子串，
 * 									而不是某一个分解出去的，也即相当于找到mat中最长的对角线
 */
public class LCS {

	public static void main(String[] args)
	{
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		LCS lcs = new LCS();
		System.out.println(lcs.commonSequenceLength(s1, s2));
		System.out.println(lcs.commonSubStringdp(s1, s2));
		System.out.println(lcs.commonSubString(s1, s2));
	}
	//这里只打印了公共子序列的长度，没有打印子序列本身，修改可以打印子序列
	//if(i == j) c[i,j] = c[i-1,j-1]+1
	//else c[i,j] = max( c[i-1,j],c[i,j-1] )
	public int commonSequenceLength(String s1,String s2)
	{
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int m1 = c1.length+1;
		int m2 = c2.length+1;
		
		int[][] mat = new int[m1][m2];
		for(int i=0;i<m1;i++)
			for(int j=0;j<m2;j++)
				mat[i][j] = 0;
		for(int i=1;i<m1;i++)
			for(int j=1;j<m2;j++)
			{
				if(c1[i-1] == c2[j-1])
					mat[i][j] = mat[i-1][j-1] + 1;
				else if(mat[i-1][j] > mat[i][j-1])
					mat[i][j] = mat[i-1][j];
				else
					mat[i][j] = mat[i][j-1];
			}
		//打印子序列，只能打印一个
		int i = m1-1;
		int j = m2-1;
		int k = 0;
		int[] path = new int[m1];
		while(mat[i][j] != 0)
		{
			if(mat[i][j] == mat[i-1][j])
				i--;
			else if(mat[i][j] == mat[i][j-1])
				j--;
			else
			{
				path[k++] = i-1;
				i--;
				j--;
			}
		}
		for(int k1=k-1;k1 >= 0;k1--)
			System.out.print(c1[path[k1]]+" ");
		System.out.println();
		Element e = new Element();
		printLCS(mat, c1, e,m1-1,m2-1,c2);
		System.out.println(e.i);
		preOrderTraversal(e, 0);
		System.out.println("从右往左获得公共子序列！");
		return mat[m1-1][m2-1];
	}
	//以树的形式将所有的最长公共子序列打印
	public void printLCS(int[][] mat,char[] c1,Element root,int m1,int m2,char[] c2)
	{
		int i = m1;
		int j = m2;
		while(mat[i][j] != 0 && i >0 && j > 0)
		{
			if(c1[i-1] == c2[j-1])
			{
				root.i.add(c1[i-1]);
				i--;
				j--;
			}
			else
			{
				if(mat[i-1][j] > mat[i][j-1])
					i--;
				else if(mat[i-1][j] < mat[i][j-1])
					j--;
				else
				{
					root.left = new Element();
					root.right = new Element();
					printLCS(mat, c1, root.left,i-1,j,c2);
					printLCS(mat, c1, root.right,i,j-1,c2);
					return;
				}
			}
		}
	}
	
	public void preOrderTraversal(Element e,int depth)
	{
		if(e != null)
		{
			for(int i=0;i<depth;i++)
			{
				System.out.print("	");
			}
			for(int i=0;i<e.i.size();i++)
				System.out.print(e.i.get(i));
			System.out.println();
			preOrderTraversal(e.left, depth+1);
			preOrderTraversal(e.right, depth+1);
		}
	}
	
	public void arrayCopy(int[][] a,int[][] b,int nrow,int ncol)
	{
		for(int i=0;i<nrow;i++)
		{
			for(int j=0;j<ncol;j++)
			{
				a[i][j] = b[i][j];
			}
		}
		System.out.println("---------");
	}
	
	//最长公共子串动态规划版 ，注意LCS与LCSS的矩阵中保存的元素含义不同，LCS中a[m,n]中元素必然最大，而LCSS不一定
	//if(i == j) c[i,j] = c[i-1,j-1]+1
	//else c[i,j] = 0
		public int commonSubStringdp(String s1,String s2)
		{
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			int m1 = c1.length+1;
			int m2 = c2.length+1;
			int max = 0;
			int[][] mat = new int[m1][m2];
			for(int i=0;i<m1;i++)
				for(int j=0;j<m2;j++)
					mat[i][j] = 0;
			for(int i=1;i<m1;i++)
				for(int j=1;j<m2;j++)
				{
					if(c1[i-1] == c2[j-1])
						mat[i][j] = mat[i-1][j-1] + 1;
					else
						mat[i][j] = 0;
					if(mat[i][j] > max)
						max = mat[i][j];
				}
			return max;
		}
		
	
	//最长公共子串，连续的，循环版的
	//规定一个串，依次让第i个位置作为子串的起始位置
	//相比dp，减少了空间复杂度
	public int commonSubString(String s1,String s2)
	{
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int maxSubString  = 0;
		int temp =0;
		for(int i=0;i<c1.length;i++)
		{
			
			int k = i;
			for(int j=0;j<c2.length;j++)
			{
				if(c1[k] == c2[j])
				{
					k++;
					//这里是为了防止数组越界
					if(k == c1.length)
					{
						if(temp + 1 > maxSubString)
							maxSubString = temp + 1;
						//用来跳出当前循环
						j = c2.length;
						temp = 0;
					}
					else 
					{
						temp++;
					}
				}
				else if(c1[k] != c2[j])
				{
					if(temp > maxSubString)
						maxSubString = temp;
					temp = 0;
					k = i;
				}
			}
		}
		
		return maxSubString;
	}
}
