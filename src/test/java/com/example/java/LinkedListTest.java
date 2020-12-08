package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class LinkedListTest {

  LinkedList list;

  @DisplayName("list init")
  @BeforeEach
  void init() {
    list = new LinkedList();
  }

  @DisplayName("head 만들기 테스트")
  @Test
  void makeHeadTest() {
    ListNode head = new ListNode(1);
    assertThat(head.data).isEqualTo(1);
  }

  @Nested
  @DisplayName("노드 추가하는 테스트")
  class addTest {
    ListNode head;
    ListNode node1;

    @DisplayName("Head에 노드 1개 연결하기")
    @BeforeEach
    void addOneNode() {
      head =  new ListNode(1);
      node1 = new ListNode(2);
    }

    @DisplayName("LinkedList add 테스트")
    @Test
    void addTestInLinkedListTest() {
      assertThat(list.add(head, node1, 1)).isEqualTo(node1);
    }

    @DisplayName("Head에 노드 1개 연결 테스트")
    @Test
    void addOneNodeInExistHeadNodeTest() {
      list.add(head, node1, 1);
      assertThat(head.next).isEqualTo(node1);
    }

    @DisplayName("Head에 노드 1개(Head 자리) 연결 테스트")
    @Test
    void addOneNodeBeforeHeadNodeTest() {
      list.add(head, node1, 0);
      assertThat(node1.next).isEqualTo(head);
    }

    @DisplayName("Head가 존재 + Node 1개 추가하고 중간에 Node 1개 삽입 테스트")
    @Test
    void addOneNodeInTheMiddleExistHeadNodeAndOneNodeTest() {
      list.add(head, node1, 1);
      ListNode node2 = new ListNode(3);
      assertThat(list.add(head, node2, 1)).isEqualTo(node2);
      assertThat(head.next).isEqualTo(node2);
      assertThat(head.next.next).isEqualTo(node2.next);
    }
  }

  @Nested
  @DisplayName("노드 삭제하는 테스트")
  class removeTest {
    ListNode head;
    ListNode node1;

    @DisplayName("Head가 존재한 상태에서 Node 1개 추가하기")
    @BeforeEach
    void addOneNode() {
      head = new ListNode(1);
      node1 = new ListNode(2);
      list.add(head, node1, 1);
    }

    @DisplayName("Head+ 1개 노드 상태에서 뒤에 Node 1개 삭제 테스트")
    @Test
    void removeOneNodeInExistHeadNodeAndOneNodeTest() {
      assertThat(list.remove(head, 1)).isEqualTo(node1);
    }

    @DisplayName("Head+ 2개 노드 상태에서 가운데 Node 1개 삭제 테스트")
    @Test
    void removeMiddleOneNodeInExistHeadNodeAndTwoNodeTest() {
      ListNode node2 = new ListNode(3);
      list.add(head, node2, 2);
      assertThat(list.remove(head, 1)).isEqualTo(node1);
      assertThat(head.next).isEqualTo(node2);
    }

  }

  @Nested
  @DisplayName("노드 포함여부")
  class containTest {
    ListNode head;
    ListNode node1;


    @DisplayName("Head가 존재한 상태에서 Node 1개 추가하기")
    @BeforeEach
    void addOneNode() {
      head = new ListNode(1);
      node1 = new ListNode(2);
      list.add(head, node1, 1);
    }

    @DisplayName("Head + 2개 노드 상태에서 마지막 추가한 노드 찾기 (성공 케이스)")
    @Test
    void successContainInOneHeadAndTwoNodeTest() {
      ListNode node2 = new ListNode(3);
      list.add(head, node2, 1);
      assertThat(list.contains(head, node2)).isEqualTo(true);
    }

    @DisplayName("Head + 2개 노드 상태에서 다른 노드 찾기 (실패 케이스)")
    @Test
    void checkContainInOneHeadAndTwoNodeTest() {
      ListNode node2 = new ListNode(3);
      ListNode node4 = new ListNode(3);
      list.add(head, node2, 1);
      assertThat(list.contains(head, node4)).isEqualTo(false);
    }

  }
}