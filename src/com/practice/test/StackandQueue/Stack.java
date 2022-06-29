package com.practice.test.StackandQueue;

import java.util.EmptyStackException;

public class Stack {
    private static class StackNode<T>{
        int data;
       StackNode next;

        public StackNode(int item){
            data=item;
        }
    }

   private  StackNode top;

public Stack(int val){
   top = new  StackNode(val);
}
    public  void push(int data){
        StackNode node = new StackNode(data);
        node.next=  top;
        top = node;
    }

    public int pop (){
        if(top == null) throw new EmptyStackException();
        int data = top.data;
        top= top.next;
        return data;
    }

    public int peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top== null;
    }

    public Stack StackNodesortStack(Stack stack1){
        Stack stack2 = new Stack(stack1.pop()) ;
       while(stack1.top != null  ){
           if(stack2.top.data <= stack1.top.data){
               stack2.push(stack1.pop());
           }else if(stack2.top.data > stack1.top.data){
               int temp = stack1.pop();
               while(temp < stack2.top.data){
                   stack1.push(stack2.pop());
               }
               stack2.push(temp);
           }
       }
       return stack2;
    }

    public static void main(String s[]){
    Stack stack1 = new Stack(6);
        stack1.push(4);
        stack1.push(10);
        stack1.push(2);
Stack stack2 = stack1.StackNodesortStack(stack1);
        while(stack2.top !=null){
            System.out.println(stack2.pop());
        }
    }
}
