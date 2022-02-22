package com.practice.test.LinkedList;

public class Node {
    Node next = null;
    int data;
    public Node(int d){
        this.data=d;
    }

    void appendToTail(int d){
        Node newNode = new Node(d);
        Node n = this;
        while(n.next != null){
            n= n.next;

        }
        n.next=newNode;
    }

    Node deleteNode(Node head , int d){
        Node temp = head;
       //  Node deleteNode = null;
         if(temp.data ==d )
             return temp.next;
        while (temp.next != null ){

            if(temp.next.data == d){
               //deleteNode = temp.next;
               temp.next = temp.next.next;
               return head;

            }
            temp = temp.next;
        }
        return head;
    }

    Node removeDuplicate(Node head){
        Node temp = head;
        Node temp1 = head.next;
        while(temp.next != null){
            while(temp1 != null) {
                if (temp.data == temp1.data) {
                    if(temp1.next != null)
                    temp1.next = temp1.next.next;
                    else temp1= null;

                }else {
                    temp1 = temp1.next;
                }
            }
            temp= temp.next;
        }
        return head;
    }

int KthNode(Node head, int k){
        if(head==null)
            return 0;

        int index = KthNode(head.next,k)+1;
        if(index==k)
            System.out.println(head.data);
        return index;
}

    /**
     * Needed to so that each iterator have object correctr vaule as primitive not going to work
     */
    static class Counter{
        int count =0;
}

    Node K1thNode(Node head, int k,Counter counter){
        if(head==null)
            return null;

        Node node = K1thNode(head.next,k,counter);
        counter.count = counter.count+1;
        if(counter.count==k)
            return head;
       return node;
    }

    Node partition(Node n, int num) {
        Node temp = n;
        Node temp1 = n;
        Node temp2 = n;
        Node temp3 = null;
        int count = 0;
        int count1 = 0;

        while (temp != null) {
            if (temp.data >= num) {
                if (count == 0) {

                    temp3=temp;
                    count += 1;

                }
                temp1 = temp;
                temp = temp.next;
            } else {
                if (count1 == 0) {
                    temp2 = temp;
                    count = 0;
                    count1+=1;
                    temp = temp.next;
                } else {
                    if (count > 0) {
                        temp1.next = temp.next;
                        temp.next = temp3;
                        temp2.next = temp;
                        temp2= temp2.next;
                        temp = temp.next;
                       count=0;
                        System.out.println("@@@@@@@@@@2"+temp.data);
                    }

                }



            }
Node x= n;
            while (x!= null){
                System.out.println(x.data);
               x = x.next;
            }
System.out.println("----------------------------------------------");
        }
        return n;
    }


    Node partition1(Node n , int d){
        Node head = n;
        Node tail = n;

        while (n != null){
            Node next = n.next;
            if(n.data <d){
                System.out.println("+++"+head.data);
                System.out.println("----"+n.data);
                System.out.println("-----------------------------");
                 n.next=head;
                    head= n;



            }else{
                tail.next= n;
                tail=n;
            }
        n= next;
        }
     tail.next= null;

        return  head;
    }


    Node reverseLinkedList(Node n){

        Node head = n;
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
        }
        Node temp =head;
        while (temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        return head;
    }


    Node sumLinkedList(Node n1,Node n2){

        Node sortedL1= n1;

        Node sortedL2=n2
                ;
        int carry =0;
        int first=0;
        int sec=0;
        Node sumNode= null;
       // Node sumNode= new Node();
        while(sortedL1 != null || sortedL2!= null){

            if(sortedL1 != null){
                first= sortedL1.data;
                sortedL1= sortedL1.next;
            }else{
                first=0;
            }
            if(sortedL2 != null){
                sec= sortedL2.data;
                sortedL2= sortedL2.next;
            }else{
                sec=0;
            }
           int result= first+sec+carry;
            int quot= result %10;
            carry=result/10;
            if(sumNode==null) {
                sumNode = new Node(quot);
                sumNode.next=null;
            }else{
               Node temp = new Node(quot);
               temp.next=sumNode;
               sumNode=temp;
            }


        }
        if(carry != 0) {
            Node temp2=new Node(carry);
            temp2.next=sumNode;
            return temp2;
        }
        return sumNode;
    }
    public static void main(String s[]){
        Node n1 = new Node(7);
        n1.appendToTail(1);
        n1.appendToTail(6);
        Node n2 = new Node(5);
        n2.appendToTail(9);
        n2.appendToTail(2);


       /*Node n1= n.removeDuplicate(n);
       while (n1.next!= null){
           System.out.println(n1.data);
           n1 = n1.next;
       }
*/

       // n.KthNode(n,3);
      // Node temp= n.K1thNode(n,9,new Counter());

     /*Node n1=  n.partition1(n,5);
        while (n1!= null){
            System.out.println(n1.data);
            n1 = n1.next;
        }*/

    /*   Node n1=  n.reverseLinkedList(n);
        while (n1!= null){
            System.out.println(n1.data);
            n1 = n1.next;
        }

    }*/

    Node n3=  n1.sumLinkedList(n1,n2);
        while (n3!= null){
        System.out.println(n3.data);
        n3 = n3.next;
    }

}
}
