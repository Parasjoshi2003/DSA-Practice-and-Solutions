package practice.arrays;

import java.util.Scanner;


  class methods2{
      Scanner sc = new Scanner(System.in);
    int[] sortArray(int arr[]){
        int zeros=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0){
                zeros++;
            }
        }

        for (int i =0;i<zeros;i++){
            arr[i]=0;
        }
        for (int i=zeros;i<arr.length;i++){
            arr[i]=1;
        }
        return arr;
    }

    void swapVariablesInArray(int arr[],int i, int j){
       int temp = arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
    }


    int [] sortByParity(int arr[]){
        int i=0,j=arr.length-1;

        do{
            if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                swapVariablesInArray(arr,i,j);
                i++;
                j--;
            }
            if (arr[i]%2==0){
                i++;
            }
            if (arr[j]%2!=0){
                j--;
            }
        }
        while (i<j);
        return arr;
    }

    int [] squareOfNumberInArray(int arr[]){
        int []array= new int[arr.length];
     for (int i=0;i<arr.length;i++){
      array[i]=arr[i]*arr[i];

     }
        System.out.println("Squared Array is");
     return array;


    }

    int[] prefixSum(int[] arr) {
        int [] prefixSum= new int[arr.length];
        prefixSum[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];

        }
        return prefixSum;
    }

    int[] suffixSum(int arr []) {
        for (int i=arr.length-2;i>=0;i--){
            arr[i]=arr[i]+arr[i+1];
        }
        return arr;
    }

 // 0 1 3 5 6 8 7 8
      // 0 1 4 9 15 23 30 38
      // 38 38 37 34 29 2

    int queries(int arr[]){
        System.out.println("Enter the value of l:");
        int l = sc.nextInt();
        l=l-1;
        System.out.println("Enter the value of m:");
        int m=sc.nextInt();
        m=m-1;
        int sum=0;
//        int []prefix= prefixSum(arr);
        for (int i=l;i<=m;i++){
            sum=sum+arr[i];
        }


        return sum;
    } //this is bruteforce method

    int queriesUsingPrefixSum(int [] arr){
        int prefix[]=prefixSum(arr);
        System.out.println("Enter the value of l:");
        int l = sc.nextInt();
        System.out.println("Enter the value of m:");
        int m=sc.nextInt();
        int sum = prefix[m]-prefix[l-1];
        return sum;
    }

   static Boolean checkingPartition(int[]arr){
        methods2 obj2 = new methods2() ;
        int prefix[]=obj2.prefixSum(arr);
       int[] suffix=obj2.suffixSum(arr);
       Boolean ans=true;
       for (int i=0;i<prefix.length-2;i++){
           System.out.println("prefix"+ prefix[i]);
           System.out.println("suffix"+ suffix[i+1]);

           if (prefix[i]==suffix[i+1]){
               ans =false;
           }
       }
      return ans;
   }

  }



public class twoPointer__and__prefixSum__Imp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        methods obj = new methods();
        methods2 obj2 = new methods2();
        int []arr= obj.inputArray();
        int prefix[]=obj2.prefixSum(arr);
        int suffix[]=obj2.suffixSum(arr);
        System.out.println("The prefix sum array is: ");
        obj.printArray(prefix);
        System.out.println();
        System.out.println("The suffix sum array is: ");
        obj.printArray(suffix);
        System.out.println();

        System.out.println("The ans is:"+ obj2.checkingPartition(arr));







    }
}