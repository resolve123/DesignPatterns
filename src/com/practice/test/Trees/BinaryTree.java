package com.practice.test.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
     Scanner scanner = new Scanner(System.in);
     int totalPath=0;
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

    public int pathNumbers(Node root, int sum,int count){
       if(root != null && count != sum) {
          count += root.data ;
           System.out.println(count);
          if(count ==sum)
              return this.totalPath+=1;
          pathNumbers(root.left,sum,count);
           pathNumbers(root.right,sum,count);

       }
      // System.out.println(totalPath);
       return totalPath;
    }

    public int pathSubNumbers(Node root, int sum, int count, List<Integer> path){
        System.out.println("root-->"+root);
   /*  if(root ==null)
         return ;*/
        if(root != null) {
            System.out.println("root-->"+root.data);
            count += root.data ;
            path.add(root.data);
            if(count ==sum)
                return this.totalPath+=1;
            pathSubNumbers(root.left,sum,count,path);
            pathSubNumbers(root.right,sum,count,path);
          //  if(root.right==null)
              //  System.out.println("right null"+root.data);
            int temp=0;
            for(int i=path.size()-1;i>=0 ; i--){
                System.out.println(path.get(i));
                temp+=path.get(i);
                //  System.out.println(temp);

                    if(temp==sum){
                        totalPath+=1;
                    }

                }


        path.remove(path.size() - 1);


        }

       // list.clear();

        return totalPath;
    }
 public static void main(String s[])   {
     //  Node root=  createTree();

    // inOrderTraversal(root);

  /*        1
             /        \
     3          2
             /  \        /    \
     2    6        5     7
             / \          / \    / \
     1  4          1  5  5   10

        10
     |    \
     8      12
            |  \
    |  \   11   21
    4   9



     */

     BinaryTree tree = new BinaryTree();
     tree.insert(10);
     tree.insert(8);
     tree.insert(12);
     tree.insert(5);
     tree.insert(9);
     tree.insert(11);
     tree.insert(21);

   //  inOrderTraversal(tree.root);
List list = new ArrayList();
     System.out.println(tree.pathSubNumbers(tree.root, 23,0,list));

   // System.out.println("----"+ tree.lookup(20)!= null ?tree.lookup(20).data: null );


 }

}


