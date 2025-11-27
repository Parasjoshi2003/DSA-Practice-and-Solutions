package practice.arrays;

import java.util.Scanner;

public class pattern_star {
    public static void main(String[] args) {
//        for (int i=4;i>=1;i--){
//            for (int j=1;j<=i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }


        // Pattern number 2
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        for (int i = 1 ; i<=r; i++){

            for (int j=1;j<=r-i;j++){
                System.out.print(" ");
            }
            for (int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
                System.out.println();

        }
    }
}
