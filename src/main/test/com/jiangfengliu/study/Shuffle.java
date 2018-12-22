package com.jiangfengliu.study;

import java.util.Random;

public class Shuffle {
  int []origin;
  int []nums;

  public Shuffle(int[] nums) {
    this.origin=nums;
    if(nums!=null){
      this.nums=new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        this.nums[i]=nums[i];
      }
    }
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return origin;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    Random random=new Random();
    for (int i = 0; i < this.nums.length; i++) {
      int dest=random.nextInt(i+1);
      swap(this.nums,i,dest);
    }
    return this.nums;
  }

  private void swap(int[] a, int origin, int dest) {
    int tmp=a[origin];
    a[origin]=a[dest];
    a[dest]=tmp;
  }
}
