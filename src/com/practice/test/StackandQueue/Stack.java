package com.practice.test.StackandQueue;

import java.util.EmptyStackException;

public class Stack <T>{
    private static class StackNode<T>{
        T data;
       StackNode<T> next;

        public  StackNode(T item){
            data=item;
        }
    }

   private  StackNode<T> top;

    public void push(T data){
        StackNode<T> node = new StackNode<T>(data);
        node.next= top;
        top = node;
    }

    public T pop (){
        if(top == null) throw new EmptyStackException();
        T data = top.data;
        top= top.next;
        return data;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top== null;
    }
}
