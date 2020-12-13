package com.example.java.four;

public class NodeStack implements Stack {

  private ListNode head;

  @Override
  public void push(int data) {
    if (head == null) {
      head = new ListNode(data);
    }
    ListNode node = head;
    while (node.next != null) {
      node = node.next;
    }
    node.next = new ListNode(data);
  }

  @Override
  public int pop() {
    if (head == null) {
      return -1;
    }
    ListNode node = head;
    if (head.next == null) {
      head = null;
      return node.data;
    }

    while (node.next.next != null) {
      node = node.next;
    }

    int pushValue = node.next.data;
    node.next = null;

    return pushValue;
  }
}
