package binarySearchTree;

import binaryTree.basics;

import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            return new Node(val);
        }
        if(val< root.data){
            root.left = insert(root.left , val);
        }if(val> root.data){
            root.right = insert(root.right , val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static boolean search(Node root , int key){
        if(root == null) return false;
        if(key == root.data) return true;
        if(key < root.data) {
            return search(root.left, key);
        }
        return search(root.right , key);
    }

    public static  Node findInOrderSuccessor(Node root){
        if(root.left == null){
            return root;
        }
        return findInOrderSuccessor(root.left);
    }

    public static Node delete ( Node root , int val){
        if(val< root.data){
            root.left = delete(root.left , val);
        }else if(val> root.data){
                root.right = delete(root.right , val);
        }else{//equals
            //case 1: leaf node
            if( root.left == null  && root.right == null){
                return null;
            }
            //case 2: one child only
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //case 3: two children
            Node successor = findInOrderSuccessor(root.right);
            root.data = successor.data;
            delete(root.right , successor.data);
        }
        return root;
    }

    public static void printInSequence(Node root, int k1, int k2){
        if(root == null ) {
            System.out.println("rturned null");
            return ;

        }
        System.out.println("called " + root.data );
        if(root.data >= k1 && root.data <= k2){
            printInSequence(root.left , k1, k2);
            System.out.println(root.data);
            printInSequence(root.right , k1 , k2);
        }else if(root.data < k1) {
            printInSequence(root.right, k1, k2);
        }else{
            printInSequence(root.left , k1, k2);
        }
    }

    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder str = new StringBuilder();
    public static ArrayList<String> binaryTreePaths(Node root) {
        if (root == null){
             return new ArrayList<>();
        }
        StringBuilder old =  new StringBuilder(str.toString());
        str.append(root.data + "->");
        ArrayList<String> left = binaryTreePaths(root.left);
        ArrayList<String> right = binaryTreePaths(root.right);
        if(left.isEmpty() && right.isEmpty()){
            System.out.println("old string: " + old);
            list.add((old +""+ root.data).toString());
            str = old;
            return list;
        }
        str.replace(0 , str.length() , old.toString());
        return list;
    }
    public static void preorder(Node root){
        if(root == null) {
            System.out.print("N ");
            return ;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = { 8 , 5 , -6 , 3 , 1 , 4 , -10 , 11 , 14};
        Node root = null ;
        for(int i : values){
            root = insert(root, i);
        }
//        boolean ans = search(root , 99);
//        System.out.println(ans);
        preorder(root);
        System.out.println();
        ArrayList<String> ans = binaryTreePaths(root);
        for(String s : ans){
            System.out.println(s);
        }
    }
}
