package com.mirdar.dataStructures.Tree.ExpressionTree;

import java.util.ArrayList;

public class ComputeInPostFix {

	ArrayList<Integer> stack = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
		String input = "6523+8*+3+*";
		char[] postfixInput = input.toCharArray();
		for(int i=0;i<postfixInput.length;i++)
			System.out.print(postfixInput[i]+" ");
		System.out.println();
		System.out.println("result: ");
		int result = new ComputeInPostFix().computeByPostFix(postfixInput);
		System.out.println(result);
	}
	
	public int computeByPostFix(char[] input)
	{
		for(int i=0;i<input.length;i++)
		{
			if(isMathOperation(input[i]))
			{
				int temp = compute(stack.get(stack.size()-1),stack.get(stack.size()-2),input[i]);
				stack.remove(stack.size()-1);
				stack.set(stack.size()-1,temp);
			}
			else
			{
				//这里直接用int强制转的时候会得到相应的Ascii值
//				System.out.println(input[i]+" "+(int)input[i]+" "+Integer.parseInt(String.valueOf(input[i])));
				stack.add( Integer.parseInt(String.valueOf(input[i])));
			}
		}
		System.out.println(stack.size());
		return stack.get(0);
	}
	
	public int compute(int a,int b,char operation)
	{
		if(operation == '+')
			return b+a;
		else if(operation == '-')
			return b-a;
		else if(operation == '*')
			return b*a;
		else
			return b/a;
	}
	
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
}
