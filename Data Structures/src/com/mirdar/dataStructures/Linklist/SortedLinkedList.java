package com.mirdar.dataStructures.Linklist;
/*
 * 有序链表，让AnyType继承了Comparable
 * 
 */
public class SortedLinkedList<AnyType extends Comparable<? super AnyType>> extends LinkedList<AnyType> {

	public void insert(AnyType x, LinkedListIterator<AnyType> p)
	{
		insert(x);
	}
	//这是降序
	public void insert(AnyType x)
	{
		LinkedListIterator<AnyType> prev = zeroth();
		LinkedListIterator<AnyType> curr = first();
		
		while(curr.isValid() && x.compareTo(curr.retrieve()) > 0)
		{
			prev.advance();
			curr.advance();
		}
		super.insert(x, prev);
	}
}
