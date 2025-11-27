package practice.searching;

public class findInRowColmSortedArray {
    public static void main(String[] args) {
        int arr[][]={{1,4,5,6},{3,6,9,12},{5,7,10,13}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        int target= 12;
        Boolean ans=false;
        int i=0;
        int j=arr[0].length-1;
        while(i<=arr.length-1 && j>=0){
            if (arr[i][j]==target){
                ans=true;
                break;
            }
            if (target>arr[i][j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println(ans);
    }
}
