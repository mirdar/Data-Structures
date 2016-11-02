package com.mirdar.dataStructures.Tree.printDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/*
 * �����ļ�Ŀ¼
 */

public class DirectoryPrint {

	public static void main(String[] args)
	{
		DirectoryPrint directPrint = new DirectoryPrint();
		File file = new File("F:\\ML\\byteCup/");
//		directPrint.printDirectoryPreOrder(0, file);
		directPrint.printDirectorypostOrder(0,file);
	}
	//�����������ӡ�ļ�Ŀ¼�ȼ�
	public void printDirectoryPreOrder(int depth,File file)
	{
		if(depth == 0 && !file.exists())
			System.out.println("���ļ�Ŀ¼������");
		printName(depth, file.getName());
		if(file.isDirectory())
			for(File f : file.listFiles())
				printDirectoryPreOrder(depth+1, f);
	}
	//������������ӡ�ļ���С�Ƚϸ��ӣ�����Ҫ�����ļ��Ĵ�С
	public double printDirectorypostOrder(int depth,File file)
	{
		//file.length()���ص���bytes�ֽ��ͣ� -> kB -> M -> G
		double totalSize = file.length()/(1000.0);
		//�������м����ļ���С�ķ�����ֻ�ܼ����ļ��Ĵ�С���޷�����Ŀ¼�Ĵ�С
		/*double totalSize = 0;
		FileChannel fc = null;
		FileInputStream fis = null;
		try
		{
			fis= new FileInputStream(file); 
			totalSize = fis.available()/(1000.0); //fis.available���ص���int�ͣ�����ȷ������ļ���С���Ϊ1.99G
			fc = fis.getChannel();
			totalSize = fc.size()/(1000.0); //��ʽ��ʽ��ȡ�ļ���С
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */
		if(file.isDirectory())
		{
			for(File f: file.listFiles())
			{
				totalSize+= printDirectorypostOrder(depth+1, f);
			}
			printName(depth,file.getName(),totalSize);
		}
		else if(file.exists())
		{
			printName(depth,file.getName(),totalSize);
		}
		else
			System.out.println("Ŀ¼���ļ�������");
		return totalSize;
	}
	
	public void printName(int depth,String name,double size)
	{
		for(int i=0;i<depth;i++)
			System.out.print("	");
		System.out.println(name+" "+size);
	}
	
	public void printName(int depth,String name)
	{
		for(int i=0;i<depth;i++)
			System.out.print("	");
		System.out.println(name);
	}
}
