package com.practice.test.StackandQueue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;
      public QueueNode(T item)  {
          data=item;
      }

    }
    QueueNode<T> first;
    QueueNode<T> last;

    public void add(T item){
        QueueNode<T> node = new QueueNode(item);
        if(last == null) {
            first=node;
            last= node;
        }else{
            last.next=node;
            last= node;
        }

    }

    public T remove (){

        if(first== null) throw new NoSuchElementException();
        T item = first.data;
        first= first.next;
        if(first == null)
            last=first;
        return item;
    }

    public T peek(){
        if(first== null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return (first== null) ;

    }
}
