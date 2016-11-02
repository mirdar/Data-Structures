package com.mirdar.dataStructures.Tree.ExpressionTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * suffix postfix都叫后缀
 * 用栈的方式将前缀表达式转成后缀的形式
 */

public class InfixToSuffix {

	ArrayList<Character> output = new ArrayList<Character>();
	ArrayList<Character> stack = new ArrayList<Character>();
	Map<Character,Integer> priorityMap = new HashMap<Character, Integer>(); //用来存放+,-,*,/的优先级
	
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
			if(!isMathOperation(expre[i])) //不是运算符
			{
				output.add(expre[i]);
			}
			else
			{
				if(stack.size() == 0)
					stack.add(expre[i]);
				else
				{
					if(expre[i] == ')') //将括号中的内容弹出，括号不加入到output中
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
						//当栈中有元素且当前元素优先级小于等于栈顶元素时，弹出栈顶元素
						while(stack.size() > 0 && needPop(expre[i], stack.get(stack.size()-1)))
						{
							output.add(stack.get(stack.size()-1));
							stack.remove(stack.size()-1);
						}
						stack.add(expre[i]);
					}
				}
			}
			if(i == expre.length-1) //表达式读取完毕，全部输出
			{
				while(stack.size() > 0)
				{
					output.add(stack.get(stack.size()-1));
					stack.remove(stack.size()-1);
				}
			}
		}
	}
	//判断是否是一个数学运算符
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
		if(priorityMap.get(up) < priorityMap.get(down)) //up优先及高的时候不弹出
			return false;
		else
			return true;
	}
}
