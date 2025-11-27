package practice.Recursion;

import com.sun.source.tree.BinaryTree;

class check{
    static void change(int a, int b ){
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+" b= "+b);
        System.out.println();
    }
}
public class test {

    public static void main(String[] args) {
        Integer a= 2;
        Integer b=3;
        check.change(a,b);
        System.out.println(a+" b= "+b);
    }
}
