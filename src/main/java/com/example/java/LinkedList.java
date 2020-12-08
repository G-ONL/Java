package com.example.java;

import lombok.Getter;

@Getter
public class LinkedList {

  public ListNode add(ListNode head, ListNode nodeToAdd, int position){
    if(head == null || nodeToAdd == null) return null;

    if(position == 0){
        nodeToAdd.next = head;
        return nodeToAdd;
    }

    int size = 0;

    while(position != size + 1){
      head = head.next;
      size++;
    }

    ListNode prev = head;
    nodeToAdd.next = prev.next;
    prev.next = nodeToAdd;

    return nodeToAdd;
  }

  public ListNode remove(ListNode head, int positionToRemove){

    if(positionToRemove == 0){
      head.next = null;
      return head;
    }

    int size = 0;

    while(positionToRemove != size + 1){
      head = head.next;
      size++;
    }
    ListNode prev = head;
    ListNode removeNode = prev.next;
    prev.next = removeNode.next;

    return removeNode;
  }
  private boolean contains(ListNode head, ListNode nodeToCheck){
    ListNode compareNode = head;
    while(compareNode.next != null && compareNode != nodeToCheck){
      compareNode = compareNode.next;
    }
    return compareNode.data.equals(nodeToCheck.data)  ? true : false;
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
