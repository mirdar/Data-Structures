package com.mirdar.dataStructures.Hash;

public class HexConversion {

	public static void main(String[] args)
	{
		int i = 10;
		//ʮ����ת��ʮ�����ƣ�
		Integer.toHexString(i);
		//ʮ����ת�ɰ˽���
		Integer.toOctalString(i);
		//ʮ����ת�ɶ�����
		Integer.toBinaryString(i);
//		//ʮ������ת��ʮ����
//		Integer.valueOf("FFFF",16).toString();
//		//�˽���ת��ʮ����
//		Integer.valueOf("876",8).toString();
//		//������תʮ����
//		Integer.valueOf("0101",2).toString();
		
//		System.out.println(Integer.toBinaryString(i));
		
		int[] a = {5554,444,233,776,2342};
		int b = 2;
//		int b = 5;
		//bȡ�����Ļ�ȷʵa�е����ᱻ�ж�ֻ�ܺ��漸λ����bȡ������a��ÿ�����Ĳ���������
		for(int j = 0;j<a.length;j++)
		{
			System.out.print(Integer.toBinaryString(a[j])+" % ");
			System.out.print(Integer.toBinaryString(b)+" = ");
			System.out.print(Integer.toBinaryString(a[j]%b));
			System.out.println();
		}
		
	}
}
