package com.stackAndQueue;

import java.util.Stack;

public class StackMin {

	public static void main(String[] args){
		StackWithMin myStack = new StackWithMin();
		/**
		 * You can create sequence of switch case statements to go through
		 * series of operations on this stack.
		 */
	}
}

class StackWithMin extends Stack<Integer>{
	/**
	 * 
	 */
	
	Stack<Integer> minStack;
	public StackWithMin(){
		minStack = new Stack<Integer>();
	}
	
	public void push(int value){
		if(value <=min()){
			minStack.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public int min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return minStack.peek();
		}
		
	}
}