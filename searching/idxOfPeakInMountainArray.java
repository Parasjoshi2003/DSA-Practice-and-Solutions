package practice.searching;

public class idxOfPeakInMountainArray {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,0};
        int st=0;
        int end=arr.length-1;
        int ans=-1;
        int mid=st + (end-st)/2;
        while (st<=mid && end>=mid ){
            mid=st + (end-st)/2;
            if(arr.length==1) ans= arr[0];
            if (arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                ans = mid;
                break;
            }
            if (arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
                st=mid;
            }
            else{
                end=mid;
            }
        }
        System.out.println(ans);
    }
}
