package com.mirdar.dataStrctures.Linklist;

public class LinkedListIterator<AnyType> {

	ListNode<AnyType> current;
	
	LinkedListIterator(ListNode<AnyType> theNode)
	{
		current = theNode;
	}
	//�Ƿ���Ԫ��
	public boolean isValid()
	{
		return current != null;
	}
	//���ص�ǰԪ��
	public AnyType retrieve()
	{
		return isValid() ? current.element : null;
	}
	//��ǰλ������
	public void advance()
	{
		if(isValid())
			current = current.next;
	}
}
