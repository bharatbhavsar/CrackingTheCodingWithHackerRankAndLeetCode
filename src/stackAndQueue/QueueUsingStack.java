package stackAndQueue;

import java.util.Stack;

public class QueueUsingStack {
	static Stack<Integer> pushStack = new Stack<Integer>(), popStack = new Stack<Integer>();
	
	public static void main(String[] args){
		
		
	}
	
	public int myStackSize(){
		return pushStack.size() + popStack.size();
	}
	
	public void add(int value){
		pushStack.push(value);
	}
	
	public int remove(){
		shiftStack();
		return popStack.pop();
	}
	
	public int peek(){
		shiftStack();
		return popStack.peek();
	}
	
	private void shiftStack(){
		if(popStack.isEmpty()){
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
	}
}
