package com.example.java;

import java.util.Arrays;

public class Queue {

  private int count;
  private int[] numbers;
  private static final int INIT_SIZE = 5;

  Queue() {
    this.numbers = new int[INIT_SIZE];
    this.count = 0;
  }


  public void add(int i) {
    if (count == numbers.length || numbers.length < INIT_SIZE) {
      numbers = Arrays.copyOf(numbers, numbers.length * 2);
    }
    numbers[count++] = i;
  }

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
