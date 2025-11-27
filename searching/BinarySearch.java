package practice.searching;

public class BinarySearch {
    static void binarySearch(int arr[],int low,int high,int target){
        int mid=Math.floorDiv((low+high),2);
//        System.out.println(mid);
        if (target<arr[low] || target >arr[high]) {
            System.out.println("Not present in array");
            return;
        }
        if (target==arr[mid]) {
            System.out.println("Target present in idx: "+ mid);
            return;
        }
        if (target >arr[mid]) binarySearch(arr,mid+1,high,target);
        if (target<arr[mid]) binarySearch(arr,low,mid-1,target);

    }

    public static void main(String[] args) {
    int arr[]={0,2,3,6,8,9,12,15};
//    binarySearch(arr,0,arr.length-1,10);
    int target = 19;
    int high= arr.length-1;
    int low=0;

    // binary search iteratively
        for (int mid=(low+high) /2;arr[low]<arr[high];){
            mid=(low+high) /2;
            if (target<arr[low] || target >arr[high]) {
                System.out.println("Not present in array");
                break;
            }
            if (target==arr[mid]) {
                System.out.println("Target present in idx: "+ mid);
                break;
            }
            if (target >arr[mid]){
                low=mid+1;
            }

            if (target<arr[mid]){
                high=mid-1;
            }
        }

    }
}
