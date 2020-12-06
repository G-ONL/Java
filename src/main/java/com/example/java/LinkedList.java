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

      if(position== i || node.next != null){//뒤에 더 있을 때(중간 삽입)
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
    return nodeToAdd;
  }

  public ListNode remove(ListNode head, int positionToRemove){
    ListNode node = head;
    ListNode prev = null;
    ///1 head + 1 노드인 상태에서 1개를 지우면
    ///
    if(node != null){
      int i = START_POSITION;
      while(node != null && positionToRemove != i){
        prev = node;
        node = node.next;
        i++;
      }
      if(i == positionToRemove){
        ListNode removeNode = node;
        if(positionToRemove == 1){
         this.head = node.next;
          if(this.tail ==this.head) this.tail = this.head;
        }else {
          prev.next = node.next;
        }
        this.size--;
        return removeNode;
      }else{
        return null;
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
