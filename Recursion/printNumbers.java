package practice.Recursion;

import java.util.Scanner;

public class printNumbers {
    void numbers(int num){
        if (num>=0) {
            numbers(num - 1);
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number uptil which you want to print all numbers: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printNumbers obj = new printNumbers();
        obj.numbers(num);
    }
}
