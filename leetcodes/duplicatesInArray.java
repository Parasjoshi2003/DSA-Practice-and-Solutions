package practice.leetcodes;

import java.util.Arrays;

class Solution {
    int removeDuplicates(int[] nums) {
        int count = 0;
        int j =1;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] == nums[j]) {
                count++;
                nums[i]=1001;
            }
            j++;
        }
        Arrays.sort(nums);
        return (nums.length-count);

    }
}
public class duplicatesInArray {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr={1,1,2,3,4,5,6,6,6,6,7};
        System.out.println(obj.removeDuplicates(arr));
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
