package com.jiangfengliu.study;

import java.util.LinkedList;
import java.util.ListIterator;

class MinStack {

    /** initialize your data structure here. */
    private LinkedList<Integer> minStack;
    public MinStack() {
        minStack=new LinkedList<>();
    }
    
    public void push(int x) {
        minStack.push(x);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        Integer min=null;
        ListIterator<Integer> it = minStack.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if (min == null) {
                min = tmp;
            } else if (tmp < min) {
               min=tmp;
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */