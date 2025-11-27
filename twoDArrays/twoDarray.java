package practice.twoDarrays;
import java.util.Scanner;
class methods{
    Scanner sc = new Scanner(System.in);
    static void printArray(int [][]arr){
        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    int [] returnSize(){
        int[]size=new int[2];
        System.out.print("Enter number of rows: i=");
        size[0]= sc.nextInt();
        System.out.print("Enter number of columns: j=");
        size[1]= sc.nextInt();
        return size;
    }
    int [][] inputArray(int a,int b){
        int array[][]=new int[a][b];
        System.out.print("Enter the value of elements: ");
        for (int i=0;i<a;i++){
                System.out.print("Enter row "+i+": ");
            for (int j=0;j<b;j++){
                array[i][j]=sc.nextInt();
            }
        }
        return array;
    }
    int[][] addMatrices(int[][]a,int i,int j,int[][]b,int m, int n){
         if (i!=m || j!=n){
            System.out.println("Dimension mismatch! Hence addition not possible.");
        }
          else{
            int [][]ans= new int[i][j];
              for (int s=0;s<i;s++){

                for (int t=0;t<j;t++){
                    ans[s][t]=a[s][t]+b[s][t];
                }

              }
            return ans;
          }
        return null;
    }
    static void multiplyMatrices(int[][]a,int r1,int c1,int[][]b,int r2,int c2){
        int mul[][]= new int[r1][c2];
        if (c1!=r2){
            System.out.println("Invalid dimensions hence multiplication not possible:");
            return ;
        }
        for (int i=0;i<r1;i++){
            for (int j=0;j<c2;j++){
                for (int k=0;k<c1;k++){
                    mul[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        System.out.println("Matrix one is: ");
        printArray(a);
        System.out.println("Matrix two is: ");
        printArray(b);
        System.out.println("Multiplaction of these matrix is: ");
        printArray(mul);
    }

}
public class twoDarray {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        methods obj = new methods();
        int size1[]= obj.returnSize();
        int [][]array1=obj.inputArray(size1[0],size1[1]);
        int size2[]= obj.returnSize();
        int [][]array2=obj.inputArray(size2[0],size2[1]);
        obj.multiplyMatrices(array1,size1[0],size1[1],array2,size2[0],size2[1]);

    }
}

