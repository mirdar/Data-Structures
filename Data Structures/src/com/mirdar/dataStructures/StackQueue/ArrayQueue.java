package com.mirdar.dataStructures.StackQueue;

/*
 * ����ʵ�ֶ��У�������βָ�룬һ��currentSize��Ҳ��ʵ�ּӱ���չ��ʵ��Stack��һ��
 * 
 */
public class ArrayQueue<AnyType> {

	private AnyType[] theArray;
	private int currentSize;
	private int front;
	private int back;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public int increment(int x)
	{
		if(++x == theArray.length) //�����ʵ����ѭ������
			x = 0;
		return x;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue()
	{
		theArray = (AnyType []) new Object[DEFAULT_CAPACITY];
		makeEmpty();
	}
	
	public void enqueue(AnyType x)
	{
		if(currentSize == theArray.length)
			doubleQueue();
		back=increment(back);
		theArray[back] = x;
		currentSize++;
	}
	
	@SuppressWarnings("unchecked")
	private void doubleQueue()
	{
		AnyType[] newArray;
		newArray = (AnyType[]) new Object[theArray.length*2];
		
		//��Ϊdequeue������ʹ��front������,ʹ�ö���������д�С�ı�
		for(int i=0;i<currentSize;i++,front = increment(front))
			newArray[i] = theArray[front];
		theArray = newArray;
		front = 0;
		back = currentSize-1;
	}
	
	public AnyType dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("ArrayStack top");
		currentSize--;
		
		AnyType returnValue = theArray[front];
		front = increment(front);
		return returnValue;
	}
	
	public AnyType getFront() throws Exception
	{
		if(isEmpty())
			throw new Exception("ArrayStack top");
		return theArray[front];
	}
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}
	
	public void makeEmpty()
	{
		currentSize = 0;
		front = 0;
		back = -1;
	}
}
