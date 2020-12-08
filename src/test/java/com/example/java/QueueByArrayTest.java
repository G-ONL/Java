package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueByArrayTest {

  private QueueByArray queueByArray;

  @DisplayName("Queue 초기화")
  @BeforeEach
  void init() {
    queueByArray = new QueueByArray();
  }

  @DisplayName("큐에 요소 더하기")
  void add() {
    queueByArray.add(1);
  }

  @DisplayName("빈 큐 요소 poll 하기")
  @Test
  void pollEmptyQueueTest() {
    assertThat(queueByArray.poll()).isEqualTo(-1);
  }

  @DisplayName("큐 10개 요소 poll 하기")
  @Test
  void pollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queueByArray.add(i);
    }
    for (int i = 0; i < 10; i++) {
      assertThat(queueByArray.poll()).isEqualTo(i);
    }
  }

  @DisplayName("불규칙하게 큐 4개 요소 poll 하기")
  @Test
  void pollRandomFourElementTest() {
    queueByArray.add(1);
    queueByArray.add(2);
    assertThat(queueByArray.poll()).isEqualTo(1);
    queueByArray.add(3);
    queueByArray.add(4);
    assertThat(queueByArray.poll()).isEqualTo(2);
    queueByArray.add(5);
    queueByArray.add(6);
    queueByArray.add(7);
    assertThat(queueByArray.poll()).isEqualTo(3);
    assertThat(queueByArray.poll()).isEqualTo(4);
  }

  @DisplayName("큐 10개 요소 add / poll 하기")
  @Test
  void addAndPollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queueByArray.add(i);
      assertThat(queueByArray.poll()).isEqualTo(i);
    }
  }

}