package com.xu.data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 参见java.util.Stack<>和Queue<>
 */
public class Stack_Queue {
    java.util.Stack<Integer> stack;
    Queue<Integer> queue;
    LinkedList<Integer> linkedList;
    ArrayList<Integer> arrayList;

    public int top;
    public int[] s;
    public Stack_Queue(int[] s){
        top = 0;
        this.s = s;
    }

    public boolean stack_empty(Stack_Queue s){
        if(s.top==0)return true;return false;
    }

    public boolean stack_empty(){
        if(this.top==0)return true;return false;
    }

    void push(int x){
        this.top++;
        this.s[this.top] = x;
    }
}
