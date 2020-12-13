package com.example.java.four;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.java.four.ArrayStack;
import com.example.java.four.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

  //  int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
  //  void push(int data)를 구현하세요.
  //  int pop()을 구현하세요.

  private Stack arrayStack;

  @DisplayName("스택 init")
  @BeforeEach
  void init() {
    arrayStack = new ArrayStack();
  }

  @DisplayName("11개 stack push (Stack 늘리기 테스트)")
  @Test
  void pushTestElevenElementInEmptyStack() {
    for (int i = 0; i <= 10; i++) {
      arrayStack.push(i);
    }
  }

  @DisplayName("11개 pop 테스트")
  @Test
  void popTestElevenElementInEmptyStack() {
    for (int i = 0; i <= 10; i++) {
      arrayStack.push(i);
    }
    for (int i = 10; i >= 0; i--) {
      assertThat(arrayStack.pop()).isEqualTo(i);
    }
  }

  @DisplayName("11개 push + pop 번갈아가는 테스트")
  @Test
  void pushAndPopTestElevenElementInEmptyStack() {
    for (int i = 0; i <= 10; i++) {
      arrayStack.push(i);
      assertThat(arrayStack.pop()).isEqualTo(i);
    }
  }


  @DisplayName("11개 push 11개 pop * 3 회 반복 테스트")
  @Test
  void pushAndPopTestForThreeLoopElevenElementInEmptyStack() {
    for (int k = 0; k < 3; k++) {
      for (int i = 0; i <= 10; i++) {
        arrayStack.push(i);
      }
      for (int i = 10; i >= 0; i--) {
        assertThat(arrayStack.pop()).isEqualTo(i);
      }
    }
  }

  @DisplayName("빈 스택 Pop 테스트")
  @Test
  void popTestInEmptyStack() {
    assertThat(arrayStack.pop()).isEqualTo(-1);
  }
}