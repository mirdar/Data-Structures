package com.mirdar.dataStructures.Tree.ExpressionTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SuffixToExpressionTree {

	ArrayList<BinaryNode> stack = new ArrayList<BinaryNode>();
	
	public static void main(String[] args)
	{
		SuffixToExpressionTree test = new SuffixToExpressionTree();
		String input = "6523+8*+3+*";
		char[] postfixInput = input.toCharArray();
		for(int i=0;i<postfixInput.length;i++)
			System.out.print(postfixInput[i]+" ");
		System.out.println();
		System.out.println("表达树处理中...");
		BinaryNode root = test.input(postfixInput);
		System.out.println("打印书");
		int width = test.treeWidth(root);
		test.printTree(root, width+5);
	}

	public BinaryNode input(char[] input)
	{
		for(int i=0;i<input.length;i++)
		{
			if(isMathOperation(input[i]))
			{
				BinaryNode node = new BinaryNode(input[i]);
				node.left = stack.get(stack.size()-2);
				node.right = stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
				stack.set(stack.size()-1, node);
			}
			else
			{
				BinaryNode node = new BinaryNode(input[i]);
				stack.add(node);
			}
		}
		
		return stack.get(0);
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
	
	public void printTree(BinaryNode root,int width)
	{
		int level = 0;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		root.setPrintProperty(width, level,0);
		queue.add(root);
		int lastLevel = 0;
		while(!queue.isEmpty())
		{
			BinaryNode node = queue.poll();
			printNode(node,lastLevel);
			lastLevel = node.level;
			if(node.left != null)
			{
				BinaryNode left = node.left;
				left.setPrintProperty(node.width-1, node.level+1,-1);
				queue.add(left);
			}
			if(node.right != null)
			{
				BinaryNode right = node.right;
				right.setPrintProperty(node.width+1, node.level+1,1);
				queue.add(right);
			}
		}
	}
	
	public void printNode(BinaryNode node,int lastLevel)
	{
		if(node.level != lastLevel)
			System.out.println();
		if(node.leftOrRight < 1)
			for(int i=0;i<node.width;i++)
				System.out.print("  ");
		else if(node.leftOrRight == 1)
			System.out.print("    ");
		System.out.print(node.element);
	}
	
	public int treeWidth(BinaryNode root)
	{
		int i=0;
		BinaryNode node = root;
		while(node.left != null)
		{
			i++;
			node = node.left;
		}
		return i;
	}
}
