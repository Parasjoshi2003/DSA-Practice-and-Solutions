
package practice.basics;
import java.util.Scanner;
public class reverse_no {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the number");
        int num= scan.nextInt();
        int ans=0;
        for (;num>0;num/=10){
            ans =(ans*10) + (num%10);
        }
        System.out.println(ans);
    }
    }
