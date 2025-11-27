package practice.leetcodes;

public class solutionsForProblems {
    //This is not the optimal solution but done as n square TC. can be done in O(n) with Kadanes algo
    public static long maxSubarraySum(int[] nums, int k) {
        long length = k;
        long maxSum = Long.MIN_VALUE;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        //Made prefix array
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int i = 0; i <= nums.length - length; i++) {
            for(int j=i ; j< i+k ; j++){
                if (i == 0) {
                    if (prefix[j] > maxSum) {
                        maxSum = prefix[j];
                    }
                    continue;
                }
                long sum = prefix[j] - prefix[i - 1];
                if (sum > maxSum)
                    maxSum = sum;
            }

        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
