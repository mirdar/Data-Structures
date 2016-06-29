package com.mirdar.dataStrctures.Linklist;
/*
 * ��������Ҫ���������࣬һ�������ĵ����������������ڵ�ĵ�������
 * java.util.LinkedListҲ�ǰ�����ģʽʵ�֣�����ʹ�õ���ͷβ˫�ڵ㣨��Ϊnull,��ʼ��Ϊend.pre=start,start.next=end��
 * ʵ����˫����
 */
public class LinkedList<AnyType> {
	
	private ListNode<AnyType> header;

	public LinkedList()
	{
		header = new ListNode<AnyType>(null);
	}
	//Ϊ�������ÿյ�ͷ�ڵ㣬Ϊ�˷�ֹɾ����һ���ڵ���޷����нڵ��ƶ�������Ҳ���ܲ�������������
	public boolean isEmpty()
	{
		return header.next == null;
	}
	
	public void makeEmpty()
	{
		header.next = null;
	}
	//����һ����nullͷ�ڵ�ĵ�������ʹ�õ����ĵ������ô�������ͬʱ���ʲ�ͬλ��
	public LinkedListIterator<AnyType> zeroth()
	{
		return new LinkedListIterator<AnyType>(header);
	}
	//����һ����nullͷ�ڵ�ĵ�����
	public LinkedListIterator<AnyType> first()
	{
		return new LinkedListIterator<AnyType>(header.next);
	}
	//���ض�ӦxԪ�ص�λ��
	public LinkedListIterator<AnyType> find(AnyType x)
	{
		ListNode<AnyType> itr = header.next;
		//��ǰλ�ñȽ�
		while(itr != null && itr.element.equals(x))
			itr = itr.next;
		return new LinkedListIterator<AnyType>(itr);
	}
	
	public void remove(AnyType x)
	{
		LinkedListIterator<AnyType> p = findPrevious(x);
		
		if(p.current.next != null)
			p.current.next = p.current.next.next;
	}
	//���ض�ӦxԪ�ص�ǰһ��λ��
	public LinkedListIterator<AnyType> findPrevious(AnyType x)
	{
		ListNode<AnyType> itr = header;
		//nextλ�ñȽ�
		while(itr.next != null && itr.next.element.equals(x))
			itr = itr.next;
		
		return new LinkedListIterator<AnyType>(itr);
	}
	
	public void insert(AnyType x, LinkedListIterator<AnyType> p)
	{
		if(p != null && p.current != null)
			p.current.next = new ListNode<AnyType>(x, p.current.next);
	}
}
