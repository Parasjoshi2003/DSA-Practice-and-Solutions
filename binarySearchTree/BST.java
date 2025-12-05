package binarySearchTree;

import binaryTree.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Integer.max(lh , rh ) + 1;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static void levelOrder(Node root , int height){
        int totalSpaces = ( (int) Math.pow(2, height) ) - 1;
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        for (int i = 0; i < totalSpaces / 2  ; i++) {
            System.out.print(" ");
        }
        int currLevel = 2 ;
        while(!q.isEmpty()){
            if(q.peek()== null){
                System.out.println();
                currLevel*=2;
                int newLead = (int) Math.max(1, Math.floor((double) totalSpaces / currLevel));
                for (int i = 0; i < newLead ; i++) {
                    System.out.print(" ");
                }
                q.remove();
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);

                }
//                    continue;
            }
            System.out.print(q.peek().data);
            int gap = (int) Math.max(1, Math.floor((double)(2 * totalSpaces) / currLevel));
            for (int i = 0; i <gap ; i++) {
                System.out.print(" ");
            }
            Node temp = q.remove();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
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

    public static boolean helper(Node root, Double min , Double max){
        if(root == null ) return true;
        boolean left = helper(root.left , min , (double) root.data);
        boolean right = helper(root.right , (double) root.data , max );
        if(root.data > min && root.data < max && left == true && right == true){
            return true;
        }
        return false;
    }

    public static boolean isValidBST(Node root) {
        return helper(root, Double.MIN_VALUE , Double.MAX_VALUE);
    }

    public static Node sortedArrayToBST(int arr[] , int low , int high){
        int mid = low + (high - low)/2;
        if(low > high) return null;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToBST(arr , low , mid-1);
        root.right = sortedArrayToBST(arr , mid+1 , high);
        return root;
    }

    static class data{
        boolean isBST;
        int size;
        int min;
        int max;

    }
    public static data large(Node root){
        if(root == null ) {
            data a =new data();
            a.size = 0;
            a.isBST = true;
            a.min = Integer.MAX_VALUE;
            a.max = Integer.MIN_VALUE;
            return a;
        }
        data left = large(root.left );
        data right = large(root.right );

        if(root.data > left.max && root.data < right.min && left.isBST && right.isBST ){
            data ans = new data();
            ans.isBST = true;
            ans.size = left.size + right.size + 1 ;
            ans.min = Math.min(left.min, root.data);
            ans.max = Math.max(right.max, root.data);
            return ans;
        }

        data ans  = new data();
        ans.isBST = false;
        ans.size = Math.max(left.size , right.size);
        ans.min = 0;
        ans.max = 0;
        return ans;
    }
    static int largestBst(Node root) {
        // Write your code here
        data ans = large(root);
        return ans.size;
    }

    public static void main(String[] args) {
//        int values[] = { 8 , 5 , -6 , 3 , 1 , 4 , -10 , 11 , 14};
//        Node root = null ;
//        for(int i : values){
//            root = insert(root, i);
//        }
//        boolean ans = search(root , 99);
//        System.out.println(ans);
//        preorder(root);
//        System.out.println();
//        ArrayList<String> ans = binaryTreePaths(root);
//        for(String s : ans){
//            System.out.println(s);
//        }
//        System.out.println(isValidBST(root));
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14 ,15,16,17,18};
        Node root = sortedArrayToBST(arr , 0 , arr.length-1);
        int height = height(root);
        levelOrder(root , height);
        System.out.println(isValidBST(root));
    }

}