package com.mirdar.dataStructures.Tree.printDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/*
 * 遍历文件目录
 */

public class DirectoryPrint {

	public static void main(String[] args)
	{
		DirectoryPrint directPrint = new DirectoryPrint();
		File file = new File("F:\\ML\\byteCup/");
//		directPrint.printDirectoryPreOrder(0, file);
		directPrint.printDirectorypostOrder(0,file);
	}
	//先序遍历，打印文件目录等级
	public void printDirectoryPreOrder(int depth,File file)
	{
		if(depth == 0 && !file.exists())
			System.out.println("该文件目录不存在");
		printName(depth, file.getName());
		if(file.isDirectory())
			for(File f : file.listFiles())
				printDirectoryPreOrder(depth+1, f);
	}
	//后续遍历，打印文件大小比较复杂，还需要计算文件的大小
	public double printDirectorypostOrder(int depth,File file)
	{
		//file.length()返回的是bytes字节型， -> kB -> M -> G
		double totalSize = file.length()/(1000.0);
		//下面两中计算文件大小的方法都只能计算文件的大小，无法计算目录的大小
		/*double totalSize = 0;
		FileChannel fc = null;
		FileInputStream fis = null;
		try
		{
			fis= new FileInputStream(file); 
			totalSize = fis.available()/(1000.0); //fis.available返回的是int型，能正确计算的文件大小大概为1.99G
			fc = fis.getChannel();
			totalSize = fc.size()/(1000.0); //流式方式读取文件大小
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
			System.out.println("目录或文件不存在");
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
