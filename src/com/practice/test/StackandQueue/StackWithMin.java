package com.practice.test.StackandQueue;

import java.util.EmptyStackException;

public class StackWithMin {
    public static class Node{
        int data ;
        Node next;

        public Node(int item){
            data=item;
        }

    }

   private Node min;

    public void pop(int data){
        if(min!= null && min.data== data) {

            min = min.next;
        }
        else  {throw new EmptyStackException();}
    }

    public void push(int n) {
        if (min == null) {
            min.data = n;
        } else if (n <= min.data) {
            Node node = new Node(n);
            node.next = min;
            min = node;
        }
    }
     public int min(){
            return min.data;
        }




}
