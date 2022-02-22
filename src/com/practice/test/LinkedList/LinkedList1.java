package com.practice.test.LinkedList;

public class LinkedList1 {
     class Node {
        int data;
        Node next= null;
        public Node(int data){
            this.data=data;
        }

    }
    public LinkedList1(int data){
        Node n = new Node(data);
        head= n;
        tail = n;
    }
    Node head;
    Node tail;

    public  void  append(int data){
        Node n=new Node(data);
        this.tail.next= n;
        tail =n;

    }

    public  void  prepend(int data){
        Node n=new Node(data);
       n.next = head;
       head=n;

    }

    public void insert(int index, int value){
        Node temp =head;
        int i=0;

        while (temp != null){
                 if(i==index){
                    Node n = new Node(value);
                    //append the node in front
                    if(index==0) {
                        n.next = temp;
                         head = n;
                    }else{
                         Node temp1= temp.next;
                            n.next= temp1 ;
                            temp.next=n;
                        }

                    }
                        i++;
                        temp=temp.next;
        }

    }

    public Node reverse(){
        Node temp = head;
        tail =head;
        int count=0;
        while(temp != null){
            // loop should run on old linked list
            Node tempNext= temp.next;
            if(count==0){
                temp.next= null;
            }else{
                temp.next= head;
            }
            count+=1;

            head=temp;
           temp= tempNext;
        }

        return head;
// same code
/*Node n =head;

        // Node next = n;
        int count=0;
        while(n!= null){
            Node next= n.next;
            if(count==0){
                n.next= null;
            }else{
                n.next= head;
            }
            count+=1;
            head=n;
            n=next;
        }*/

       // return head;
    }


    public Node reverse1() {

        tail = head;
       if(head.next== null)
           return head;

        Node first = head;
       Node second = head.next;
        while (second!= null) {
            // loop should run on old linked list
            Node tempNext = second.next;

                second.next = first;
                first= second;
                second=tempNext;
            }
        head.next=null;
        return head=first;
        }




public static void main(String s[]){
        LinkedList1 list = new LinkedList1(5);
        list.append(10);
        list.prepend(2);
         list. insert(1,7);
         list.reverse1();
        while(list.head != null){
            System.out.println(list.head.data);
            list.head= list.head.next;
        }
}

}
