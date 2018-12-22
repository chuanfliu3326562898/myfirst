package com.jiangfengliu.study;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> tmp=new HashMap();
    int result[]=new int[2];
    for(int i=0;i<nums.length;i++){
      if(tmp.containsKey(target-nums[i])){
        result[0]=tmp.get(target-nums[i]);
        result[1]=i;
        return result;
      }
      tmp.put(nums[i],i);
    }
    return null;
  }

  public static boolean isInterleave(String s1, String s2, String s3) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] flags1 = new int[s1.length()];
    int[] flags2 = new int[s2.length()];
    while (k < s3.length()) {
      if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
        flags1[i++] = 1;
        k++;
      } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
        flags2[j++] = 1;
        k++;
      } else {
        return false;
      }
    }
    for (int tmp : flags1) {
      if (tmp == 0) {
        return false;
      }
    }
    for (int tmp : flags2) {
      if (tmp == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isInterleave2(String s1, String s2, String s3) {
    int[] counts = new int[1024];
    for (int i = 0; i < s1.length(); i++) {
        counts[s1.charAt(i)]+=1;
    }
    for (int i = 0; i < s2.length(); i++) {
      counts[s2.charAt(i)]+=1;
    }

    for (int i = 0; i < s3.length(); i++) {
      counts[s2.charAt(i)]-=1;
    }

    for(int tmp:counts){
      if(tmp!=0){
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    TreeSet<Object> test=new TreeSet<>();
    test.add(new Object());
    test.add(new Object());

    System.out.println(9/.75);
    String s1="aabcc";
    String s2="dbbca";
    String s3="aadbbcbcac";
    isInterleave(s1,s2,s3);

    ListNode[] results = new ListNode[3];
    results[0] = new ListNode(1);
    results[0].next = new ListNode(4);
    results[0].next.next = new ListNode(5);
    results[1] = new ListNode(1);
    results[1].next = new ListNode(3);
    results[1].next.next = new ListNode(4);
    results[2] = new ListNode(2);
    results[2].next = new ListNode(6);
    mergeKLists(results);

    System.out.println(Math.sqrt(23.33)%1);
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    ListNode[] results = sortedArray(lists);
    quickSort(results, 0, results.length - 1);
    for (int i = 0; i < results.length - 1; i++) {
      results[i].next = results[i + 1];
    }
    return results[0];
  }

  private static ListNode[] sortedArray(ListNode[] lists) {
    int nodesNum = 0;
    for (int i = 0; i < lists.length; i++) {
      int listNo = 0;
      ListNode tmp = lists[i];
      while (tmp != null) {
        listNo++;
        tmp = tmp.next;
      }
      nodesNum += listNo;
    }
    ListNode[] results = new ListNode[nodesNum];
    int count = 0;
    for (int i = 0; i < lists.length; i++) {
      ListNode tmp = lists[i];
      while (tmp != null) {
        results[count++] = tmp;
        tmp = tmp.next;
      }
    }
    return results;
  }

  private static void quickSort(ListNode[] results, int low, int high) {
    if (low < high) {
      int mid = partion(results, low, high);
      quickSort(results, low, mid);
      quickSort(results, mid + 1, high);
    }
  }

  private static int partion(ListNode[] results, int low, int high) {
    if (high <= low) {
      return low;
    }
    ListNode tmp = results[low];
    while (low < high) {
      if (results[high].val >= tmp.val) {
        high--;
      }
      if (low <= high) {
        results[low] = results[high];
      }
      if (results[low].val < tmp.val) {
        low++;
      }
      if (low <= high) {
        results[high] = results[low];
      }
    }
    results[low] = tmp;
    return low;
  }
}