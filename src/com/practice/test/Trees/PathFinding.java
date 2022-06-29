package com.practice.test.Trees;

import java.util.ArrayList;
import java.util.List;

public class PathFinding {

/*    Given a binary tree where each node's value is an integer, design an algorithm that finds the number of paths which sum to a given value.

    Paths must start at the root node, and end at a leaf node

    For example, given the tree
            1
                    /        \
                    3          2
                    /  \        /    \
                    2    6        5     7
                    / \          / \    / \
                    1  4          1  5  5   10

    Find paths which sum to 10

    lets assume that path can start at any node, end at a leaf node*/

    class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer value;
    }


    //int count=0;
   List list = new ArrayList();
int path=0;
    /// sum = 10
    public void findNumPaths(TreeNode root, int sum) {
        //find paths
        //1, 3, 6
        //1, 3, 2, 4
        //5, 5



        List<Integer> result= traverse(root, 0, sum,list);
        for(int list:result){

        }
    }


    public List<Integer> traverse(TreeNode root, int count, int sum,List<Integer> arrayList){
      /*  if(root.value==sum)
            return 1;*/

        if(root !=null && count !=sum){

            count= count+root.value;
            arrayList.add(count);
            if(count ==sum ){
                path=path+1;

            }
            traverse(root.left,count,sum,arrayList);

            traverse(root.right,count,sum,arrayList);

        }

        return arrayList;
    }
}
