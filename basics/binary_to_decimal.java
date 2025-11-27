package practice.basics;

import java.util.Scanner;

public class binary_to_decimal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int binary_num= sc.nextInt();
        int pw=1,ans=0;
        for (;binary_num>0;){
            int unit_digit= binary_num % 10;
            ans += (unit_digit * pw);
            binary_num/=10;
            pw*=2;
        }
        System.out.println(ans);
    }
}
