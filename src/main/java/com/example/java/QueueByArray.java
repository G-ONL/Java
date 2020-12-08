package com.example.java;

import java.util.Arrays;

public class QueueByArray implements Queue {

  private int count;
  private int[] numbers;
  private static final int INIT_SIZE = 5;

  QueueByArray() {
    this.numbers = new int[INIT_SIZE];
    this.count = 0;
  }

  @Override
  public void add(int data) {
    if (count == numbers.length || numbers.length < INIT_SIZE) {
      numbers = Arrays.copyOf(numbers, numbers.length * 2);
    }
    numbers[count++] = data;
  }

  @Override
  public int poll() {
    if (count == 0) {
      return -1;
    }
    int pollValue = this.numbers[0];
    numbers = Arrays.copyOfRange(numbers, 1, numbers.length);
    count--;
    return pollValue;
  }

}
