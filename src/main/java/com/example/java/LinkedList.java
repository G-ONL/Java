package com.example.java;

public class LinkedList {

  private static final int HEAD_POSITION = 0;

  public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
    if (head == null || nodeToAdd == null) {
      return null;
    }

    if (position == HEAD_POSITION) {
      nodeToAdd.next = head;
      return nodeToAdd;
    }

    for (int size = 1; size < position; size++) {
      head = head.next;
    }

    ListNode prev = head;
    nodeToAdd.next = prev.next;
    prev.next = nodeToAdd;

    return nodeToAdd;
  }

  public ListNode remove(ListNode head, int positionToRemove) {

    if (positionToRemove == HEAD_POSITION) {
      head.next = null;
      return head;
    }

    for (int size = 1; size < positionToRemove; size++) {
      head = head.next;
    }

    ListNode prev = head;
    ListNode removeNode = prev.next;
    prev.next = removeNode.next;

    return removeNode;
  }

  public boolean contains(ListNode head, ListNode nodeToCheck) {
    ListNode compareNode = head;

    while (compareNode.next != null && compareNode != nodeToCheck) {
      compareNode = compareNode.next;
    }

    return compareNode.equals(nodeToCheck) ? true : false;
  }
}
