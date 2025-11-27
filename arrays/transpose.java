package arrays;

public class transpose {
    static void swap(int arr[][], int i, int j){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }
    static void trans(int arr[][]){
        for (int i=0;i< arr.length;i++){
            for (int j=i;j<arr[i].length;j++){
                swap(arr,i,j);
            }
        }
    }
    static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void swap2(int arr[][],int i, int st, int end){
        int temp=arr[i][st];
        arr[i][st]=arr[i][end];
        arr[i][end]=temp;

    }
    static void colChange(int arr[][]){
        int n=arr.length;
        for (int i = 0; i <n ; i++) {  //colm
            for (int j=0;j<n/2;j++){
                swap2(arr,i,j,n-1-j);
            }

        }
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(matrix);
        System.out.println();
        trans(matrix);
        print(matrix);
        System.out.println();
        colChange(matrix);
        print(matrix);
    }
}
