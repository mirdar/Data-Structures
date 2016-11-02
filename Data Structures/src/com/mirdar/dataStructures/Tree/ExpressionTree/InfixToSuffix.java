package com.mirdar.dataStructures.Tree.ExpressionTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * suffix postfix���к�׺
 * ��ջ�ķ�ʽ��ǰ׺���ʽת�ɺ�׺����ʽ
 */

public class InfixToSuffix {

	ArrayList<Character> output = new ArrayList<Character>();
	ArrayList<Character> stack = new ArrayList<Character>();
	Map<Character,Integer> priorityMap = new HashMap<Character, Integer>(); //�������+,-,*,/�����ȼ�
	
	public static void main(String[] args)
	{
		String expression = "a+b*c+(d*e+f)*g";
		char[] expre = expression.toCharArray();
		for(int i=0;i<expre.length;i++)
			System.out.print(expre[i]+" ");
		System.out.println();
		System.out.println("InfixToSuffix-------->");
		System.out.println();
		InfixToSuffix iTs = new InfixToSuffix();
		iTs.setPriority();
		iTs.input(expre);
		for(int i=0;i<iTs.output.size();i++)
			System.out.print(iTs.output.get(i)+" ");
	}
	
	public void input(char[] expre)
	{
		for(int i=0;i<expre.length;i++)
		{
			if(!isMathOperation(expre[i])) //���������
			{
				output.add(expre[i]);
			}
			else
			{
				if(stack.size() == 0)
					stack.add(expre[i]);
				else
				{
					if(expre[i] == ')') //�������е����ݵ��������Ų����뵽output��
					{
						while(stack.get(stack.size()-1) != '(')
						{
							output.add(stack.get(stack.size()-1));
							stack.remove(stack.size()-1);
						}
						stack.remove(stack.size()-1);
					}
					else
					{
						//��ջ����Ԫ���ҵ�ǰԪ�����ȼ�С�ڵ���ջ��Ԫ��ʱ������ջ��Ԫ��
						while(stack.size() > 0 && needPop(expre[i], stack.get(stack.size()-1)))
						{
							output.add(stack.get(stack.size()-1));
							stack.remove(stack.size()-1);
						}
						stack.add(expre[i]);
					}
				}
			}
			if(i == expre.length-1) //���ʽ��ȡ��ϣ�ȫ�����
			{
				while(stack.size() > 0)
				{
					output.add(stack.get(stack.size()-1));
					stack.remove(stack.size()-1);
				}
			}
		}
	}
	//�ж��Ƿ���һ����ѧ�����
	public boolean isMathOperation(char a)
	{
		char[] mathOperation = {'(',')','*','/','+','-'};
		for(int i=0;i<mathOperation.length;i++)
		{
			if(a == mathOperation[i])
				return true;
		}
		return false;
	}
	public void setPriority()
	{
		char[] mathOperation = {'(','*','/','+','-'};
		for(int i=0;i<mathOperation.length;i++)
			if(i == 0)
				priorityMap.put(mathOperation[i],0);
			else if(i < 2)
				priorityMap.put(mathOperation[i],1);
			else
				priorityMap.put(mathOperation[i],2);
	}
	
	public boolean needPop(char up,char down)
	{
		if(down == '(')
			return false;
		if(priorityMap.get(up) < priorityMap.get(down)) //up���ȼ��ߵ�ʱ�򲻵���
			return false;
		else
			return true;
	}
}
