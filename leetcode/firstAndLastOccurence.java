package leetcode;

public class firstAndLastOccurence {
    public static String searchRange(int[]nums,int target){
        int i=0,j=nums.length-1;
        while(i<j){
            int mid= (i+j)/2;
            if (nums[mid]==target) return "Found at position "+ mid;
            if (nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return "not found";
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,4,5,6,7,8,9};
        System.out.println(searchRange(arr,0));
    }
}
