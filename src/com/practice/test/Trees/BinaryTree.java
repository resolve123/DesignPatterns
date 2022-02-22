package com.practice.test.Trees;

import java.util.Scanner;

public class BinaryTree {
     Scanner scanner = new Scanner(System.in);
     Node root = null;
    private  class Node{
        int data;
       Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }

    }
    public  Node createTree(){
     Node root= null;
           System.out.println("Enter  node");
        int data = scanner.nextInt();
        if (data ==-1) return null;
               root = new Node(data);

        System.out.println("enter left node:"+data);
       root.left=   createTree();


        System.out.println("enter right node:"+data);
        root.right=   createTree();


       return root;
    }

    public  void insert(int value){
        Node n = new Node (value);
        if(root == null){
            root =n;
        }else{
            Node temp= root;
                while (true) {
                    if(temp.data < value){
                        if(temp.right== null){
                            temp.right=n;
                            break;
                        }else{
                            temp= temp.right;
                        }
                    }else {
                        if(temp.left == null) {
                            temp.left = n;
                            break;
                        }
                        else
                            temp = temp.left;
                    }
                }

        }
    }
public Node lookup(int value){
        if(root == null)
            return null;
    Node temp = root;
    while (temp != null) {
        if(temp.data < value){
            if(temp.right== null){
               return null;
            }else{
                temp= temp.right;
            }
        }else if(temp.data > value) {
            if(temp.left == null) {
               return null;
            }
            else
                temp = temp.left;
        }else{
            return temp;
    }

}
return null;
}


    public Node remove(int value){
        if(root == null)
            return null;
        Node temp = root;
        while (temp != null) {
            if(temp.data < value){
                if(temp.right== null){
                    return null;
                }else{
                    temp= temp.right;
                }
            }else if(temp.data > value) {
                if(temp.left == null) {
                    return null;
                }
                else
                    temp = temp.left;
            }else{
                return temp;
            }

        }
        return null;
    }
    public static void inOrderTraversal(Node node){
        if(node != null) {

            inOrderTraversal(node.left);
            System.out.print(node.data );
            inOrderTraversal(node.right);

        }

    }

    public static void preOrderTraversal(Node node){
        if(node != null) {
            System.out.print(node.data );
            inOrderTraversal(node.left);

            inOrderTraversal(node.right);

        }

    }

    public static void postOrderTraversal(Node node){
        if(node != null) {

            inOrderTraversal(node.left);

            inOrderTraversal(node.right);
            System.out.print(node.data );
        }

    }
 public static void main(String s[])   {
     //  Node root=  createTree();

    // inOrderTraversal(root);

     BinaryTree tree = new BinaryTree();
     tree.insert(9);
     tree.insert(4);
     tree.insert(20);
     tree.insert(1);
     tree.insert(6);
     tree.insert(15);
     tree.insert(170);

     inOrderTraversal(tree.root);

    System.out.println("----"+ tree.lookup(20)!= null ?tree.lookup(20).data: null );


 }

}


