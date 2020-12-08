package com.example.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackByArrayByNodeTest {

  private StackByNode stackByNode;

  @DisplayName("init")
  @BeforeEach
  void init() {
    stackByNode = new StackByNode();
  }

  @DisplayName("push Test")
  @Test
  void pushTest() {
    for (int i = 0; i <= 10; i++) {
      stackByNode.push(i);
    }
  }

  @DisplayName("빈 스택 pop Test")
  @Test
  void popEmptyStackTest() {
    assertThat(stackByNode.pop()).isEqualTo(-1);
  }

  @DisplayName("두 개 요소 pop Test")
  @Test
  void popTwoElementTest() {
    for (int i = 0; i <= 1; i++) {
      stackByNode.push(i);
    }
    assertThat(stackByNode.pop()).isEqualTo(1);
    assertThat(stackByNode.pop()).isEqualTo(0);
  }

  @DisplayName("10 개 요소 pop Test")
  @Test
  void popTenElementTest() {
    for (int i = 0; i < 10; i++) {
      stackByNode.push(i);
    }
    for (int i = 9; i >= 0; i--) {
      assertThat(stackByNode.pop()).isEqualTo(i);
    }
  }
}