package com.mirdar.dataStructures.CollectionAndIterator;

public class VectorQueue {

	Vnode head;
	Vnode current;
	int lenght;
	
	public void add(Vector v)
	{
		if(head == null)
		{
			head = new Vnode(v);
			current = head;
			lenght++;
		}
		else
		{
			current.next = new Vnode(v);
			current = current.next;
			lenght++;
		}
	}
	
	public Vector pop() throws Exception
	{
		if(head == null)
			throw new Exception("����Ϊ��");
		Vnode node = head;
		head = head.next;
		lenght--;
		return node.v;
		
	}
	
	public int lenght()
	{
		return lenght;
	}
}
