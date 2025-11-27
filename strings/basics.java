package practice.Strings;
import java.util.*;
public class basics {
    static void compare(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first string");
        String str= sc.nextLine();
        System.out.println("enter second string");
        String gtr = sc.nextLine();
        System.out.println(str.compareTo(gtr));
        System.out.println("continue y or n");
        char ch =sc.next().charAt(0);
        if (ch=='y') compare();
        else return;

    }
    public static void main(String[] args) {
//        char arr[]= new char[10];
//        String str = "paras";
//        System.out.println(str);
//        Scanner sc= new Scanner(System.in);
//        String input= sc.next();
//        System.out.println(input);
//        String input2= sc.nextLine();
//        System.out.println(input2);

          // theory part of Strings..

//        str.compareTo();
//        str.charAt();
//        str.indexOf();
//        str.contains();
//        str.startsWith();
//        str.endsWith();
//        str.toLowerCase();
//        str=str+1+'c';
//        System.out.println("abc"+10+20); ==abc1020;
//        System.out.println(10+20+"abc"); == 30abc operator precedence is left to right;
//        str.substring(0,1); only 0th index of the string is selected hence
//                substring(i,j)---- i is included and j is exculded;


//        compare();

        }
    }

