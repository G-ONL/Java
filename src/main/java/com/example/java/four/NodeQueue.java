package com.example.java.four;

public class NodeQueue implements Queue {

  ListNode head;

  @Override
  public void add(int data) {
    if (head == null) {
      head = new ListNode(data);
      return;
    }
    ListNode node = head;
    while (node.next != null) {
      node = node.next;
    }
    node.next = new ListNode(data);
  }

  @Override
  public int poll() {
    if (head == null) {
      return -1;
    }
    int removeValue = head.data;
    head = head.next;
    return removeValue;
  }
}
