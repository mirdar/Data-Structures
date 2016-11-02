package com.mirdar.dataStructures.lcs;

/*
 * �����������	 	��̬�滮���
 * ������Ӵ� 	 	��̬�滮 or ѭ��
 * 
 * ������Ӵ���dp�����������������������
 * ����������У�ֱ�ӷ���mat[n,m]���ɣ���Ϊ�����̴�mat[n,m]�ֽ��ȥ��
 * ��������Ӵ����򷵻�mat�е������(���㹫ʽ��һ��)����Ϊ���������ҵ����п��ܵĹ�ͬ�����Ӵ���
 * 									������ĳһ���ֽ��ȥ�ģ�Ҳ���൱���ҵ�mat����ĶԽ���
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
	//����ֻ��ӡ�˹��������еĳ��ȣ�û�д�ӡ�����б����޸Ŀ��Դ�ӡ������
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
		//��ӡ�����У�ֻ�ܴ�ӡһ��
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
		System.out.println("���������ù��������У�");
		return mat[m1-1][m2-1];
	}
	//��������ʽ�����е�����������д�ӡ
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
	
	//������Ӵ���̬�滮�� ��ע��LCS��LCSS�ľ����б����Ԫ�غ��岻ͬ��LCS��a[m,n]��Ԫ�ر�Ȼ��󣬶�LCSS��һ��
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
		
	
	//������Ӵ��������ģ�ѭ�����
	//�涨һ�����������õ�i��λ����Ϊ�Ӵ�����ʼλ��
	//���dp�������˿ռ临�Ӷ�
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
					//������Ϊ�˷�ֹ����Խ��
					if(k == c1.length)
					{
						if(temp + 1 > maxSubString)
							maxSubString = temp + 1;
						//����������ǰѭ��
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
