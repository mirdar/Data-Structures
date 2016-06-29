package com.mirdar.dataStructures.CollectionAndIterator;

import java.util.Set;

/*
 * HashMap��TreeMapʵ����Map�ӿڣ�����TreeMap�еĹؼ���������ģ�ʵ����һ��SortedMap�ӿڣ�
 * 
 */
public interface Map<KeyType, ValueType> extends java.io.Serializable{

	int size();
	
	boolean isEmpty();
	
	boolean containsKey(KeyType key);
	
	ValueType get(KeyType key);
	
	ValueType put(KeyType key, ValueType value);
	
	ValueType remove(KeyType key);
	
	Set<KeyType> keySet();
	
	Collection<ValueType> values();
	
	/*��/ֵ�Ե���ż����
	 * ����
	 * Set<Map.Entry<KeyType,ValueType>> entryies = map.entrySet();
	 * for(Map.Entry<KeyType,ValueType> thisPair : entries)
	 * {
	 * 		sysout(thisPair.getKey()+thisPair.getValue())
	 * }
	 * 
	 */
	Set< Enrty<KeyType,ValueType>> entrySet();
	
	public interface Enrty<KeyType,ValueType> extends java.io.Serializable
	{
		KeyType getKey();
		
		ValueType getValue();
		
		ValueType setValue(ValueType newValue);
	}
}
