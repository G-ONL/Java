package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

  private Queue arrayQueue;

  @DisplayName("Queue 초기화")
  @BeforeEach
  void init() {
    arrayQueue = new ArrayQueue();
  }

  @DisplayName("빈 큐 요소 poll 하기")
  @Test
  void pollEmptyQueueTest() {
    assertThat(arrayQueue.poll()).isEqualTo(-1);
  }

  @DisplayName("큐 10개 요소 poll 하기")
  @Test
  void pollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      arrayQueue.add(i);
    }
    for (int i = 0; i < 10; i++) {
      assertThat(arrayQueue.poll()).isEqualTo(i);
    }
  }

  @DisplayName("불규칙하게 큐 4개 요소 poll 하기")
  @Test
  void pollRandomFourElementTest() {
    arrayQueue.add(1);
    arrayQueue.add(2);
    assertThat(arrayQueue.poll()).isEqualTo(1);
    arrayQueue.add(3);
    arrayQueue.add(4);
    assertThat(arrayQueue.poll()).isEqualTo(2);
    arrayQueue.add(5);
    arrayQueue.add(6);
    arrayQueue.add(7);
    assertThat(arrayQueue.poll()).isEqualTo(3);
    assertThat(arrayQueue.poll()).isEqualTo(4);
  }

  @DisplayName("큐 10개 요소 add / poll 하기")
  @Test
  void addAndPollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      arrayQueue.add(i);
      assertThat(arrayQueue.poll()).isEqualTo(i);
    }
  }

}