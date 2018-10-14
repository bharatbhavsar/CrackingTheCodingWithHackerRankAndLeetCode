package com.treesAndGraphs;

import java.util.LinkedList;

import com.treesAndGraphs.RouteBetweenNodes.State;

public class RouteBetweenNodes {

	enum State { Unvisited, 
				Visited, 
				Visiting;}
	
	public static void main(String[] args){
		/**
		 * you need to write a piece of code to generate a graph
		 * and pick 2 Nodes out of it and pass these as argument to search method
		 */
	}
	
	public boolean search(Graph g, Node start, Node end){
		if(start == end){
			return true;
		}
		
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		Node u;
		
		while(!q.isEmpty()){
			u = q.removeFirst();
			if(u != null){
				for(Node v : u.getAdjecent()){
					if(v.state == State.Unvisited){
						if (v == end){
							return true;
						}else{
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
}

class Node{
	public State state;
	public String name;
	public Node[] children;
	
	Node[] getAdjecent(){
		return children;
	}
}

class Graph{
	public Node[] nodes;
	
	Node[] getNodes(){
		return nodes;
	}
}
