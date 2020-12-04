package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class LinkedListTest {
  ListNode head;
  LinkedList list;

  @DisplayName("head노드 만들기")
  @BeforeEach
  void head(){
    list = new LinkedList();
    head = new ListNode(1);
    list.add(head, head, 1);
  }

  @DisplayName("head 노드 추가 테스트")
  @Test
  void addHeadTest(){
    assertThat(list.getHead()).isEqualTo(head);
  }

  @Nested
  @DisplayName("노드 추가하는 테스트")
  class addTest{
    ListNode node1;

    @DisplayName("Head가 존재한 상태에서 Node 1개 추가하기")
    @BeforeEach
    void addOneNode() {
      node1 = new ListNode(2);
      list.add(head, node1, 2);
    }

    @DisplayName("Head가 존재한 상태에서 Node 1개 추가한 테스트")
    @Test
    void addOneNodeInExistHeadNode(){
      assertThat(list.getSize()).isEqualTo(2);
      assertThat(list.getTail()).isEqualTo(node1);
      assertThat(list.getHead()).isEqualTo(head);
    }

    @DisplayName("Head가 존재 + Node 1개 추가하고 중간에 Node 1개 삽입 테스트")
    @Test
    void addOneNodeInTheMiddleExistHeadNodeAndOneNode(){
      ListNode node2 = new ListNode(3);
      assertThat(list.add(head,node2,2).data).isEqualTo(node2.data);
      assertThat(list.getSize()).isEqualTo(3);
      assertThat(list.getTail()).isEqualTo(node1);
      assertThat(list.getHead()).isEqualTo(head);

    }
  }



}