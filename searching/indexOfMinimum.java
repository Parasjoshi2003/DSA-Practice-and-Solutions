package practice.searching;

public class indexOfMinimum {
  static  int indxMin(int arr[],int start , int end){
      int mid = start + (end-start)/2;
      if (arr[start] <= arr[end]) return start;
        else if (arr[start]>arr[end] && arr[mid]>arr[end] ){
            if (mid==start) mid=end;
            return indxMin(arr,mid,end);
        }
        else {
            return indxMin(arr,start,mid);
        }
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,1,2,3};
        System.out.println(indxMin(arr,0,arr.length-1));
    }
}
