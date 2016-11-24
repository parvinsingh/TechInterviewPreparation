package com.parvin.LinkedLists;

public class LinkedListNode {

	public LinkedListNode next;
	public LinkedListNode prev;
	public int data;
	
	public LinkedListNode(int data){
		this.data = data;
		next = null;
		prev = null;
	}

}
