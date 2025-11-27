package practice.twoDarrays;

import java.util.Scanner;
 class one{
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
    int[][] transposeArray(int[][] arr, int row, int col) {
        int ans[][] = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = arr[i][j];
            }
        }
        return ans;
    }
    void swap(int[][]arr,int i,int j){
      arr[i][j]=arr[i][j]+arr[j][i];
      arr[j][i]=arr[i][j]-arr[j][i];
      arr[i][j]=arr[i][j]-arr[j][i];
    }

    void transposeWithoutAnotherArray(int[][]arr,int row, int col){
        for (int i=0;i<col;i++){
            for (int j=i+1;j<row;j++){
                swap(arr,i,j);
            }
        }
    }
    static void rotate(int arr[][],int n){
        int ans[][]= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    ans[j][i] = arr[i][j];

            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<((n-1)/2);j++){
                ans[i][j]=ans[i][j]+ans[i][n-j-1];
                ans[i][n-j-1]=ans[i][j]-ans[i][n-j-1];
                ans[i][j]=ans[i][j]-ans[i][n-j-1];
            }
        }
        printArray(ans);

    }
    void pascalTriangle(){
        System.out.print("Enter the row till which you want to display pascals triangle: ");
        int a = sc.nextInt();
        int arr[][]=new int[a][];
                for (int i = 0; i < a; i++) {
                    arr[i]= new int[i+1];
                    for (int j = 0; j <= i; j++) {
                        if (i == j || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                        }
                    }
                }
        System.out.println("The pascal triangle is: ");
        printArray(arr);
    }

    static void spiralMatrix(int[][]arr){
        int n = arr.length;
        int c= arr[0].length;
        int topRow=0,rightCol=c-1,leftCol=0,bottomRow=n-1;
        int num=0;
        while(num<=(n*c)){
            //toprow print
            for (int j=leftCol;j<rightCol;j++){
                System.out.print(arr[topRow][j]+" ");
                num++;
                if(num==(n*c)){
                    return;
                }
            }
            //rightcol
            for (int i=topRow;i<bottomRow;i++){
                System.out.print(arr[i][rightCol]+ " ");
                num++;
                if(num==(n*c)){
                    return;
                }
            }
            //bottomrow
            for (int j=rightCol;j>leftCol;j--){
                System.out.print(arr[bottomRow][j]+ " ");
                num++;
                if(num==(n*c)){
                    return;
                }
            }
            //leftcol
            for (int i=bottomRow;i>topRow;i--){
                System.out.print(arr[i][leftCol]+ " ");
                num++;
                if(num==(n*c)){
                    return;
                }
            }
            topRow++;
            bottomRow--;
            leftCol++;
            rightCol--;

        }
    }


    int[][] spiralMatrixGenerator(int a){
       int arr [][]=new int[a][a];
         int topRow=0,rightCol=a-1,leftCol=0,bottomRow=a-1;
            int num =1;
         while(num<=(a*a)){
             //topRow print
             for (int j=leftCol;j<=rightCol && num<=(a*a);j++){
                 arr[topRow][j]=num++;
//                 if(num==(a*a)){
//                     return arr;
//                 }
             }
             topRow++;
             //rightCol
             for (int i=topRow;i<=bottomRow && num<=(a*a);i++){
                 arr[i][rightCol]=num++;
//                 if(num==(a*a)){
//                     return arr;
//                 }
             }
             rightCol--;
             //bottomRow
             for (int j=rightCol;j>=leftCol  && num<=(a*a);j--){
                 arr[bottomRow][j]=num++;
//                 if(num==(a*a)){
//                     return arr;
//                 }
             }
             bottomRow--;
             //leftCol
             for (int i=bottomRow;i>=topRow && num<=(a*a);i--){
                 arr[i][leftCol]=num++;
//                 if(num==(a*a)){
//                     return arr;
//                 }
             }
             leftCol++;
         }
         return arr;
     }
 }

public class practiceTwoDArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        one obj = new one();
        System.out.println("Enter the size for spiral matrix: ");
        int a=sc.nextInt();
        int arr[][]=obj.spiralMatrixGenerator(a);
        obj.printArray(arr);


    }
}
