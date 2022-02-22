package com.practice.test.StringArray;

public class LinkedListAddNumbers {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node= new ListNode();
        ListNode original=node;
        int carry =0;
        while(l1 != null && l2!= null){


            int sum=   l1.val+l2.val+carry;
            carry = getCarry(sum) ;


            ListNode n = new ListNode(sum%10);
            node.next=n;
            node = n;

            l1= l1.next;
            l2= l2.next;
        }

        while(l1 != null){
            ListNode n = new ListNode((l1.val+ carry)%10);
            carry = getCarry(l1.val+ carry) ;
            node.next=n;
            node = n;
            l1 = l1.next;


        }

        while(l2 != null){
            ListNode n = new ListNode((l2.val+ carry)%10);
            carry = getCarry(l2.val+ carry) ;
            node.next=n;
            node = n;
            l2 = l2.next;

        }
        if(carry==1){
            ListNode n = new ListNode(1);
            node.next=n;
            node = n;
        }
        return original.next;
    }

    int getCarry(int sum){
        int carry =0;
        if (sum>=10 )
            carry=1;
        else carry=0;

        return carry;
    }
}
