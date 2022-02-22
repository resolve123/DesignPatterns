package com.practice.test.StringArray;

import java.util.EmptyStackException;

public class ValidParentheses {

    private static class Node {
        char c;
        Node next;

        Node(char item) {
           c=item;
        }

        Node() {

        }

        void push(char c) {
            Node n = new Node(c);
            n.next = top;
            top = n;
        }

        char pop() {
            if (top == null) throw new EmptyStackException();
            char ch = top.c;
            top = top.next;
            return ch;
        }
    }

    static Node top;

    public static boolean isvalid(String s) {
        char c[] = s.toCharArray();
        Node stack = new Node();

        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
                stack.push(c[i]);
            }

            if (c[i] == '}' || c[i] == ']' || c[i] == ')') {
                if(top == null) return false;
                char temp = stack.pop();
                if (temp == '{' && c[i] != '}' || (temp == '[' && c[i] != ']') || (temp == '(' && c[i] != ')')) {
                    return false;
                }

            }

        }
        if(top != null) return false;
        return true;
    }


    public static void main(String s[]){
       System.out.println(isvalid("}"));
    }
}
