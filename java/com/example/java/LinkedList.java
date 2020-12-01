package com.example.java;

import lombok.Getter;

@Getter
public class LinkedList {

  private ListNode head;
  private ListNode tail;
  private int size = 0;
  private final static int START_POSITION = 1;


  public ListNode add(ListNode head, ListNode nodeToAdd, int position){
    ListNode node = head;

    if(node != null && head != nodeToAdd){
      int i = START_POSITION;
      while(node.next != null && position != i){
        node = node.next;
        i++;
      }

      if(node.next != null){//뒤에 더 있을 때(중간 삽입)
        ListNode temp = node.next;
        node.next = nodeToAdd;
        node.next.next = temp;
      }else { // 더 없을 때(뒤에 삽입)
        node.next = nodeToAdd;
        tail = node.next;
      }
      this.size++;
    }
    else if(head == nodeToAdd){
      this.head = head;
      this.tail = nodeToAdd;
      this.size++;
    }
    return node;
  }
  private ListNode remove(ListNode head, int positionToRemove){
    if(head != null){
      int i = START_POSITION;
      while(head.next != null && positionToRemove != i){
        head = head.next;
        i++;
      }

    }
    return null;
  }
  private boolean contains(ListNode head, ListNode nodeToCheck){
    return false;
  }
}

class ListNode{

  Object data;
  ListNode next;

  public ListNode(Object data) {
    this.data = data;
    this.next = null;
  }
}
