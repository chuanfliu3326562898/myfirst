package com.jiangfengliu.study;

import com.google.common.collect.Maps;

import java.util.*;

public class GetMinPathSum {
  public int minPathSum(int[][] grid) {
    if (grid == null) {
      return 0;
    }
    if (grid.length == 1) {
      int sum = 0;
      for (int tmp : grid[0]) {
        sum += tmp;
      }
      return sum;
    }
    if (grid[0].length == 1) {
      int sum = 0;
      for (int tmp : grid[0]) {
        sum += tmp;
      }
      return sum;
    }

    for (int i = 0; i < grid.length; i++) {

    }
    return 0;
  }

  public int minPathSum2(int[][] grid) {
    if (grid == null) {
      return 0;
    }
    if (grid.length == 1) {
      int sum = 0;
      for (int tmp : grid[0]) {
        sum += tmp;
      }
      return sum;
    }
    if (grid[0].length == 1) {
      int sum = 0;
      for (int tmp : grid[0]) {
        sum += tmp;
      }
      return sum;
    }
    return 0;
  }

  public static void main(String[] args) {
    //Queue
    //Deque
    //ArrayDeque
    allocateElements(5);

    System.out.println(-4&15);

    Map hashMap= Maps.newHashMap();

    Random random=new Random();
    for(int i=0;i<5;i++){
      System.out.println(random.nextInt(i+1));
    }
  }

  private static final int MIN_INITIAL_CAPACITY = 8;
  private static void allocateElements(int numElements) {
    int initialCapacity = MIN_INITIAL_CAPACITY;
    // Find the best power of two to hold elements.
    // Tests "<=" because arrays aren't kept full.
    if (numElements >= initialCapacity) {
      initialCapacity = numElements;
      initialCapacity |= (initialCapacity >>>  1);
      initialCapacity |= (initialCapacity >>>  2);
      initialCapacity |= (initialCapacity >>>  4);
      initialCapacity |= (initialCapacity >>>  8);
      initialCapacity |= (initialCapacity >>> 16);
      initialCapacity++;

      if (initialCapacity < 0)   // Too many elements, must back off
        initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
    }
    System.out.println(initialCapacity);
  }
}
