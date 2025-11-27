package practice.basics;
import java.util.Scanner;
public class series_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n till which you want the sum");
        int n= sc.nextInt(),a=0,b=0;
        for(int i=1;i<=n;i++){
            if (i%2==0){
                a=a+i;
                System.out.println("a= " +  a);
            }
            else {
                b=b+i;
                System.out.println("b= " + b);
            }
        }
        System.out.println(a-b);    }
}
