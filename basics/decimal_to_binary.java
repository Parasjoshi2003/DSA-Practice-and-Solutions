package practice.basics;

import java.util.Scanner;

public class decimal_to_binary {
    public static void main(String[] args) {

            /// Page 1.


        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number to be converted to binary");           // 100 1000 10000 100000
        int ans=0,multiplier=1;
        int no= sc.nextInt();
        for (;no>0;no/=2){           // e,g 18                                                  2nd iteration           last iteration no=1
            int bin_dig = no%2;       //terms = 18%2=0                                            terms=9%2=1             terms=1%2= 1
            ans+=(bin_dig * multiplier );     //ans=0+(1*0)                                               ans=0+(1*10)=10          ans=10+(1*10000)=10010
            multiplier*=10;                // su= 10                                                    su=100
        }                         // 18/2=9   divide ma floor use hota h                        9/2=4
        System.out.println(ans);
    }
}
// Logic --- number ko 2 ka modulo leke multiplier se multiply krke ans ma store kro.