package com.stackAndQueue;

import java.util.EmptyStackException;
import java.util.Scanner;

public class ThreeStackUsingArray {

	public static void main(String[] args){
		System.out.println("Enter stack size for each stack: ");
		Scanner in = new Scanner(System.in);
		int stackSize = in.nextInt();
		in.close();
		FixedMultiStack myStack = new FixedMultiStack(stackSize);
		
		/**
		 *  you can use following class and its methods to manipulate
		 *  the created stack entries.
		 */
	}
}

class FixedMultiStack{
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize){
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	//push values into stack
	public void push(int stackNum, int value){
		if(isFull(stackNum)){
			System.out.println("Stack is Full");;
		}
		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	//pop values from stack
	public int pop(int stackNum) throws EmptyStackException{
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	//return top element
	public int peek(int stackNum){
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		
		return values[indexOfTop(stackNum)];
	}
	
	//check if stack is empty
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}
	
	//check if stack is full
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackCapacity;
	}
	
	private int indexOfTop(int stackNum){
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	
}


