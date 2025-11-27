package practice.twoDarrays;

import java.util.Scanner;

public class practice {
    Scanner sc = new Scanner(System.in);
    int[] returnSize(){
        System.out.print("Enter no of rows: ");
        int size[]=new int[2];
        size[0]=sc.nextInt();
        System.out.print("Enter no of colms: ");
        size[1]=sc.nextInt();
        return size;
    }
    int [][] inputArray(int a,int b){
        int array[][]=new int[a][b];
        System.out.println("Enter the value of elements: ");
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                array[i][j]=sc.nextInt();
            }
        }
        return array;
    }
    static void printArray(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    int areaOfRectangle(int arr[][], int r1,int c1,int r2, int c2){
    int area=0;
     for (int i=r1;i<=r2;i++){
         for (int j=c1;j<=c2;j++){
             area+=arr[i][j];
         }
     }
        return area;
    }
    int [] inputRowCol(){
        int rowsColms[]=new int[4];
        System.out.println("Enter the value of r1:");
        rowsColms[0]= sc.nextInt();
        System.out.println("Enter the value of c1:");
        rowsColms[1]= sc.nextInt();
        System.out.println("Enter the value of r1:");
        rowsColms[2]= sc.nextInt();
        System.out.println("Enter the value of c2:");
        rowsColms[3]= sc.nextInt();
        return rowsColms;
    }
    static void prefixArray(int []arr){
        for (int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
    }
    int areaForMoreQueries(int arr[][],int r1,int c1,int r2,int c2){
        int area=0;
        for (int i=0;i<arr.length;i++){
            prefixArray(arr[i]);
        }
        for (int i=r1;i<=r2;i++) {
            area = arr[i][c2] - arr[i][c1];
        }
        return area;
    }


    public static void main(String[] args) {
        practice obj = new practice();
        int []size= obj.returnSize();
        int arr[][]= obj.inputArray(size[0],size[1]);
        System.out.println("The input array is: ");
        printArray(arr);
        int[]rowsColms=obj.inputRowCol();
        int area= obj.areaForMoreQueries(arr,rowsColms[0],rowsColms[1],rowsColms[2],rowsColms[3]);
        System.out.println("The area is: "+ area );
    }
}
