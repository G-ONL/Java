package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LinkedListTest {

  @DisplayName("head노드 만들기 테스트")
  @Test
  void head(){
    LinkedList list = new LinkedList();
    ListNode head = new ListNode(1);
    assertThat(list.add(head, head, 1)).isEqualTo(head);
    assertThat(list.getHead()).isNotNull();
    assertThat(list.getHead().data).isEqualTo(1);
  }

}