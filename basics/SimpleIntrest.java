package practice.basics;
import java.util.Scanner;
public class SimpleIntrest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float p  , t ;
        float r = 8.60f ;
        System.out.println("Enter the amount to be invested");
        p = sc.nextFloat();
        System.out.println("Enter the time period of investemnt");
        t= sc.nextFloat();
        System.out.println("The rate of increament is 8.60% per annum. \n" +
                "So the intrest in your deposit becomes \n"
                + "= ("+ p +"*"+ r +"*" +t +")" +"/" +"100");
        float a = (p*r*t)/100;
        System.out.println("= " +a);

    }
}
