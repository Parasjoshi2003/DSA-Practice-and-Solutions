package practice;

import java.util.Scanner;

class soln {
    Scanner sc = new Scanner(System.in);

    double gpa(double credit, double score,double tscore,double tcredit) {
        System.out.println("Enter credit: ");
        credit = sc.nextDouble();
        System.out.println("Enter score: ");
        score = sc.nextDouble();
        tscore=tscore+(credit*score);
        tcredit=tcredit+credit;
        System.out.println("Do you want to continue: y or n");
        String continu = sc.next();
        double answer= tscore/tcredit;
        if (continu.equals("y")) gpa(0,0,tscore,tcredit);
        System.out.println("total score "+ tscore);
        System.out.println("total credit "+ tcredit);
            return answer;


    }
}

public class gpaCalculator {

    public static void main(String[] args) {
        soln obj= new soln();
        double ans = obj.gpa(0,0,261.6,39);
        System.out.println("your gpa is: "+ ans);
    }
}
