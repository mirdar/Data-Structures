package com.mirdar.dataStructures.Tree;

public class BinaryNode {

	Object element;
	BinaryNode left;
	BinaryNode right;
	
	
	//��������������Ϊ�˴�ӡ����
	int width; //ǰ�������ٿո�
	int level; //���ڲ��
	int leftOrRight; //-1��ʾ��ڵ�
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
