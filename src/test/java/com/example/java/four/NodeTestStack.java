package com.example.java.four;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.java.four.NodeStack;
import com.example.java.four.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTestStack {

  private Stack nodeStack;

  @DisplayName("init")
  @BeforeEach
  void init() {
    nodeStack = new NodeStack();
  }

  @DisplayName("push Test")
  @Test
  void pushTest() {
    for (int i = 0; i <= 10; i++) {
      nodeStack.push(i);
    }
  }

  @DisplayName("빈 스택 pop Test")
  @Test
  void popEmptyStackTest() {
    assertThat(nodeStack.pop()).isEqualTo(-1);
  }

  @DisplayName("두 개 요소 pop Test")
  @Test
  void popTwoElementTest() {
    for (int i = 0; i <= 1; i++) {
      nodeStack.push(i);
    }
    assertThat(nodeStack.pop()).isEqualTo(1);
    assertThat(nodeStack.pop()).isEqualTo(0);
  }

  @DisplayName("10 개 요소 pop Test")
  @Test
  void popTenElementTest() {
    for (int i = 0; i < 10; i++) {
      nodeStack.push(i);
    }
    for (int i = 9; i >= 0; i--) {
      assertThat(nodeStack.pop()).isEqualTo(i);
    }
  }
}