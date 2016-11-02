package com.mirdar.dataStructures.CollectionAndIterator;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

	//���ȶ�����Ҫ����һ���Ƚ�����<AnyType extends Comparable<? super AnyType>����AnyType�̳���Comparable��
	//ʹ��AnyTypeʵ���˱Ƚ����Ĺ���
	public  static <AnyType extends Comparable<? super AnyType>>
			void dumpPQ(String msg,PriorityQueue<AnyType> pq)
			{
				System.out.println(msg + ":");
				while(!pq.isEmpty())
					System.out.println(pq.remove());
			}
	
	//PriorityQueueһ����add,element,remove����,���ݸ����ıȽ�Ԫ�ؽ����������
	public static void main(String[] args)
	{
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		
		minPQ.add(3);
		minPQ.add(5);
		minPQ.add(6);
		
		dumpPQ("minPQ", minPQ);
	}
}
