package com.mirdar.dataStructures.Tree;

public class BinaryNode {

	Object element;
	BinaryNode left;
	BinaryNode right;
	
	
	//下面三个属性是为了打印方便
	int width; //前面填充多少空格
	int level; //所在层次
	int leftOrRight; //-1表示左节点
	public void setPrintProperty(int width,int level,int leftOrRight)
	{
		this.width = width;
		this.level = level;
		this.leftOrRight = leftOrRight;
	}
	
	public BinaryNode(Object element)
	{
		this.element = element;
	}
}
