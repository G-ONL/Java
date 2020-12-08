package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {

  private Queue queue;

  @DisplayName("Queue 초기화")
  @BeforeEach
  void init() {
    queue = new Queue();
  }

  @DisplayName("큐에 요소 더하기")
  void add() {
    queue.add(1);
  }

  @DisplayName("빈 큐 요소 poll 하기")
  @Test
  void pollEmptyQueueTest() {
    assertThat(queue.poll()).isEqualTo(-1);
  }

  @DisplayName("큐 10개 요소 poll 하기")
  @Test
  void pollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queue.add(i);
    }
    for (int i = 0; i < 10; i++) {
      assertThat(queue.poll()).isEqualTo(i);
    }
  }

  @DisplayName("불규칙하게 큐 4개 요소 poll 하기")
  @Test
  void pollRandomFourElementTest() {
    queue.add(1);
    queue.add(2);
    assertThat(queue.poll()).isEqualTo(1);
    queue.add(3);
    queue.add(4);
    assertThat(queue.poll()).isEqualTo(2);
    queue.add(5);
    queue.add(6);
    queue.add(7);
    assertThat(queue.poll()).isEqualTo(3);
    assertThat(queue.poll()).isEqualTo(4);
  }

  @DisplayName("큐 10개 요소 add / poll 하기")
  @Test
  void addAndPollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queue.add(i);
      assertThat(queue.poll()).isEqualTo(i);
    }
  }

}