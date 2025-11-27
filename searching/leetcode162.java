package practice.searching;

public class leetcode162 {
    public static int findPeakElement(int[] nums) {
        int st=0;
        int end=nums.length-1;
        int ans=-1;
        while(st<=end){
            int mid= st + (end-st)/2;

            if (nums.length==1) return 0;
            if(nums.length==2) {
                if (nums[0]>nums[1]) return 0;
                else return 1;
            }
            if(nums[mid]<nums[mid+1]){
                st=mid+1;
//                System.out.println();
            }
           if(nums[mid]>nums[mid+1]){
                end=mid;
            }
            if (st==end) return st;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){                    // sari extra condition hatani h to nums[mid]>nums[mid-1] || mid==0 laga do isme
                return mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,3,2,1};
        int ans= findPeakElement(arr);
        System.out.println(ans);
    }
}
