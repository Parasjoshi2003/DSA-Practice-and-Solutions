package practice.backtracking;

public class first {
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void changeArr(int arr[] , int idx ,  int value){
        if(idx == arr.length){
            System.out.println("Inserted array before backtracking: ");
            print(arr);
            System.out.println();
            return ;
        }
        arr[idx] = value;
        changeArr(arr , ++idx , ++value );
        arr[idx-1]-= 1;
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr,0,1);
        print(arr);
    }
}
