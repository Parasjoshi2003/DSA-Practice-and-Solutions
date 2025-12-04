package binaryTree;

import java.util.ArrayList;

public class binaryTreeProblems {
    public static void kthLevel(basics.Node root ,int k , int level){
        if(root == null ) return;
        if(level == k){
            System.out.print(root.data + " ");
            return ;
        }
        kthLevel(root.left, k , level + 1);
        kthLevel(root.right, k , level + 1);
    }
    basics.Node ans = new basics.Node(-1);
    public boolean preorder (basics.Node root ,basics.Node p, basics.Node q) {
        if(root == null) return false;
        if(root == p || root == q ) {
            ans = root;
            return true ;
        }

        boolean left = preorder(root.left , p , q);
        boolean right = preorder(root.right , p , q);
        if(right == true && left == true ){
            ans = root;
            return true;
        }
        return left || right ;
    }
    public basics.Node lowestCommonAncestor(basics.Node root, basics.Node p, basics.Node q) {
        preorder(root , p , q);
        return ans;
    }

    public static boolean getPath(basics.Node root, basics.Node target , ArrayList<basics.Node> list){
        if (root == null){
            return false;
        }
        list.add(root);
        if(list.get(list.size()-1) == target ) return true;

        if (getPath(root.left , target , list)) return true;

        if( getPath(root.right , target , list)) return true;

        list.remove(list.size() - 1);

        return false;
        /*
Structure of Node class is:

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/




    }

    static int d  = -1;
    public static int find(basics.Node root, int k, int node){
        if(root == null ){
            return -1;
        }
        if(root.data == node){
            return 0;
        }

        int left = find(root.left , k , node);
        int right = find(root.right , k , node);
        if(left == -1 && right == -1) {
            return -1;
        }
        int max = Math.max(left , right) + 1;
        if(max == k  ){
            d = root.data;
        }
        return max;
    }
    public static int kthAncestor(basics.Node root, int k, int node) {
        // Write your code here
        find(root , k , node);
        if(d == -1){
            return -1;
        }else{
            return d;
        }
    }

    public static int helper(basics.Node root){
        if( root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int old = root.data;
        root.data = l+r ;
        return  root.data + old ;
    }
    public static void toSumTree(basics.Node root) {
        // add code here.
        helper(root);
    }

    public static void main(String[] args) {
        basics.BinaryTree b = new basics.BinaryTree();
        basics.Node root =  b.buildTree(new int[] {1,-1,-1});
        root.left = new basics.Node(2);
        root.left.left = new basics.Node(4);
        root.left.right = new basics.Node(5);
        root.right = new basics.Node(3);
        root.right.left = new basics.Node(6);
        root.right.right = new basics.Node(7);
//                  1
//                 /  \
//                2    3
//               / \  / \
//              4   5 6  7
//        ArrayList<basics.Node> a = new ArrayList<>();
//        boolean ans = getPath(root, root.left.right, a);
//        for (basics.Node n : a){
//            System.out.println(n.data);
//        }
        toSumTree(root);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
//        System.out.println(root.right.right.data);
    }
}
