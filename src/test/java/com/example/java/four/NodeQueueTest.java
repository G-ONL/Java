package com.example.java.four;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.java.four.NodeQueue;
import com.example.java.four.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeQueueTest {

  private Queue queue;

  @DisplayName("큐 초기화")
  @BeforeEach
  void init() {
    queue = new NodeQueue();
  }

  @DisplayName("빈 큐 poll 테스트")
  @Test
  void pollEmptyQueueTest() {
    assertThat(queue.poll()).isEqualTo(-1);
  }

  @DisplayName("1개의 element add 후 poll 테스트")
  @Test
  void pollOneElementTest() {
    queue.add(1);
    assertThat(queue.poll()).isEqualTo(1);
  }

  @DisplayName("10개의 element add 후 poll 테스트")
  @Test
  void pollTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queue.add(i);
    }
    for (int i = 0; i < 10; i++) {
      assertThat(queue.poll()).isEqualTo(i);
    }

  }

  @DisplayName("10개의 element add 후 poll 테스트")
  @Test
  void pollImmediatelyTenElementTest() {
    for (int i = 0; i < 10; i++) {
      queue.add(i);
      assertThat(queue.poll()).isEqualTo(i);
    }
  }

  @DisplayName("4개의 element 랜덤하게 poll 테스트")
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
    assertThat(queue.poll()).isEqualTo(3);
  }

}