package com.mirdar.dataStructures.CollectionAndIterator;

/*
 * ArrayList��LinkListʵ����List�ӿڣ�����ArrayList��Ҫ�������ң����ҿ����Զ���ֵ�ռ�ӱ�
 * LinkList��Ҫ����������ɾ������
 * 
 */

public interface List<AnyType> extends Collection<AnyType>{

	AnyType get(int idx);
	
	AnyType set(int idx,AnyType newVal);
	
	//ListIterator�Ǹ�˫�������
//	ListIterator<AnyType> listIterator(int pos);
}
