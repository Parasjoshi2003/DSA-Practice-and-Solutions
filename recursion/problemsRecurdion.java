package practice.Recursion;

import java.util.Scanner;

class soln{
    int fact(int a){
        if (a==0){
            return 1;
        }
      a*=fact(a-1);
        return a;
    }

    int fibon(int length){
        if (length ==1 || length==2) {
            return length-1;
        }
        return (fibon(length-1)+fibon(length-2))  ;

    }

    int sumOfDigits(int num){
      if (num<10 && num>=0) return num; // base case
      return sumOfDigits(num/10)+(num%10); // calling fn and adding the value of last digit.
    }


    int countDigits(int n ){
        if (n<10 && n>=0) return 1;
        return countDigits(n/10) + 1;
    }

    int powerOfNumber(int p , int q){
        if (q<=0) return 1;
        return powerOfNumber(p , q-1)*p;
    }

    int powerCostEffective(int p ,int q){
        if (q==0) return 1;
        int smallPow = powerCostEffective(p,q/2);
        if (q%2==0){
            return smallPow*smallPow;
        }

        return p*smallPow*smallPow;
    }

    void printMultiples(int n ,int k){
        if (k==1) {
            System.out.print(n + " ");
            return;
        }
        printMultiples(n,k-1);
        System.out.print(n*k + " ");
    }

    int sumAlternateSigns(int n) {//The method calculates sum upto n with alternate signs
        if (n==1) return 1;       // for eg n=5; 1-2+3-4+5 = 3 in ans;
        if (n%2==0){
            return -n + sumAlternateSigns(n-1);
        }
        return n+sumAlternateSigns(n-1);
    }


    boolean isPowerOfTwo(int n) {

        if (n==1) return true;
        for (;n>2;n=n/2) {
            if (n % 2 != 0) return false;

        }
     return true;
    }

    int gcd(int x,int y){                                                // this is first solution which came into my mind about the gcd problem;
        int[] arr = new int[x];       // two arrays for storing divisors
        int[] arr2 = new int[y];
        int i=0, ans=0;
        for (int a=1;a<=x;a++){        // store divisors of x in array
            if ((x%a)==0){
                arr[i]=a;
                i++;
            }
        }
        int j=0;
        for (int a=1;a<=y;a++){        // store divisors in array for y
            if ((y%a)==0){
                arr2[j]=a;
                j++;
            }
        }
        for (int p=0;p<=x-1;p++){      //for vacant slots of array make value -1
            if (arr[p]==0){
                arr[p]=-1;
            }
        }
        for (int p=0;p<=x-1;p++){      //for vacant slots of array 2 make value -2
            if (arr2[p]==0){            // we do this because the vacant slots will have value 0 hence in our comparision this will make problem as 0==0
                arr2[p]=-2;
            }
        }
        for (int p=x-1;p>=0;p--){                         // Now compare the values of two arrays from backwards and return the gcd;
            for (int q=y-1;q>=0;q--){
//                System.out.println(arr[p]+" 2nd array "+arr2[q]);
                if (arr[p]==arr2[q]) return arr[p];
            }

        }
//        System.out.println("this is last line");
        return ans;
    }


    int gcdEfficientUsingLoops(int x,int y){                 // this method uses long division//
        if (x<y){                      //we were changing values her but it is not recommended because modulo will swap values //                       // See copy for info//
            x=x+y;
            y=x-y;
            x=x-y;
        }
        while (x%y!=0){
            int rem= x%y;
            x=y;
            y=rem;
        }
        return y;
    }


    int gcdEuclidsRecursion(int x,int y){
        if (y==0) return x;
        return gcdEuclidsRecursion(y,x%y);
    }



}





public class problemsRecurdion {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Enter the second number: ");
        int b = scan.nextInt();
        soln obj = new soln();
        System.out.println();
        System.out.println(obj.gcdEuclidsRecursion(a,b));
    }
}
