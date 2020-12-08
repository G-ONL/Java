package com.example.java;

import java.util.Arrays;

public class Stack {

  private int count;
  private int[] numbers;
  private static final int INIT_SIZE = 5;

  public Stack() {
    this.numbers = new int[INIT_SIZE];
    this.count = 0;
  }

  public Stack(int size) {
    numbers = new int[size];
    this.count = 0;
  }

  public void push(int data) {
    if (count == numbers.length) {
      numbers = Arrays.copyOf(numbers, numbers.length * 2);
    }
    numbers[count++] = data;
  }

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
