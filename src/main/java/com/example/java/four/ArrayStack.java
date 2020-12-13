package com.example.java.four;

import java.util.Arrays;

public class ArrayStack implements Stack {

  private int count;
  private int[] numbers;
  private static final int INIT_SIZE = 5;

  public ArrayStack() {
    this.numbers = new int[INIT_SIZE];
    this.count = 0;
  }

  @Override
  public void push(int data) {
    if (count == numbers.length) {
      numbers = Arrays.copyOf(numbers, numbers.length * 2);
    }
    numbers[count++] = data;
  }

  @Override
  public int pop() {
    if (count == 0) {
      return -1;
    }
    int popNumber = numbers[--count];
    if (numbers.length / 3 > count) {
      numbers = Arrays.copyOfRange(numbers, 0, count + INIT_SIZE);
    }
    return popNumber;
  }
}
