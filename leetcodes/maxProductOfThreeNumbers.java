package practice.leetcodes;


import java.util.Arrays;

class Solutions {
     int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length -1 ;
        if (nums.length >= 3 && nums.length <= 10000) {
            if (nums[n]<=1000 && nums[0]>=-1000){
                int a= nums[0]*nums[1]*nums[n];
                int b= nums[n]*nums[n-1]*nums[n-2];
                int c = nums[0]*nums[1]*nums[2];
                return Math.max(a,Math.max(b,c));
            }
             else {
                System.out.println("dimesions incorrect");
            }

        }
        else {
            System.out.println("Dimensions of array out of range.");
        }
        return -10000000;
    }
}
public class maxProductOfThreeNumbers{
    public static void main(String[] args) {
        Solutions obj =new Solutions();
        int arr[] = {-990,-99,-1,1,2,3};
        int ans = obj.maximumProduct(arr);
        System.out.println(ans);
    }
}

// alternative mthd
//class Solution {
//    public int maximumProduct(int[] nums) {
//        int max1 = Integer.MIN_VALUE;
//        int max2 = Integer.MIN_VALUE;
//        int max3 = Integer.MIN_VALUE;
//        int min1 = Integer.MAX_VALUE;
//        int min2 = Integer.MAX_VALUE;
//
//        for (int num : nums) {
//            if (num > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = num;
//            } else if (num > max2) {
//                max3 = max2;
//                max2 = num;
//            } else if (num > max3) {
//                max3 = num;
//            }
//
//            if (num < min1) {
//                min2 = min1;
//                min1 = num;
//            } else if (num < min2) {
//                min2 = num;
//            }
//        }
//
//        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
//    }
//}

