package practice.greedy;

import java.util.*;

public class questions {
    public static int activitySelections(int stTime[], int edTime[]) {
        // code here
        Integer index[] = new Integer[edTime.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> Integer.compare(edTime[i], edTime[j]));
        int endTimeOfLast = edTime[index[0]];
        int activity = 1;
        for (int i = 1; i < edTime.length; i++) {
            if (stTime[index[i]] > endTimeOfLast) {
                activity++;
                endTimeOfLast = edTime[index[i]];
            }
        }
        return activity;
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        double valByweight[] = new double[val.length];
        for (int i = 0; i < valByweight.length; i++) {
            double value = val[i];
            double weight = wt[i];
            valByweight[i] = value / weight;
        }
        Integer index[] = new Integer[valByweight.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> Double.compare(valByweight[i], valByweight[j]));
        double weightPicked = 0;
        double valuePicked = 0;
        int idx = index.length - 1;
        while (weightPicked < capacity && idx >= 0) {
            double curWeight = wt[index[idx]];
            double curValue = val[index[idx]];
//            System.out.println("Current value and weight is: " + curValue + " " + curWeight);
            if (weightPicked + curWeight > capacity) {
                System.out.println("currvalue inside if: " + valuePicked);
                double diff = capacity - weightPicked;
                valuePicked += ((diff) / curWeight) * curValue;
                break;
            }
            weightPicked += curWeight;
            valuePicked += curValue;
//            System.out.println("currvalue : " + valuePicked);
            idx--;
        }
        return valuePicked;
    }

    long findMinSum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > B[i]) {
                sum += A[i] - B[i];
            } else {
                sum += B[i] - A[i];
            }
        }
        return sum;
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int chainLength = 1;
        int prvhigh = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prvhigh) {
                chainLength++;
                prvhigh = pairs[i][1];
            }
        }
        return chainLength;
    }

    public static int coinChange(int[] coins, int amount) {
        int idx = coins.length - 1;
        int valueMade = 0;
        int coinsCount = 0;
        while (valueMade != amount && idx >= 0) {
            int currCoin = coins[idx];
            if (valueMade + currCoin <= amount) {
                valueMade += currCoin;
                coinsCount++;
                System.out.println("coins used:  " + currCoin);
            } else {
                idx--;
            }
        }
        if (valueMade == amount) {
            return coinsCount;
        } else {
            return -1;
        }
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int maxDeadline = 0;
        for (int i = 0; i < deadline.length; i++) {
            if (deadline[i] > maxDeadline) maxDeadline = deadline[i];
        }
        System.out.println("max deadline is " + maxDeadline);
        int ans[] = new int[maxDeadline + 1]; //5
        Arrays.fill(ans, -1);
        // max deadline filled here and array initialised with -1;


        Integer index[] = new Integer[deadline.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> Integer.compare(profit[i], profit[j]));
        //array sorted till here;

        for (int i = index.length-1; i >=0; i--) {
            int idx = index[i];
            int currdL = deadline[idx]; //2
            int currpro = profit[idx]; //20
            for (int j = currdL; j >= 1; j--) {
                if (ans[j] == -1) {
                    ans[j] = idx;
                    break;
                }
//                if (profit[ans[j]] < currpro) {
//                    ans[j] = idx;
//                    break;
//                }
            }
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        int count =0;
        int profits =0;
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]> -1){
                count++;
                profits += profit[ans[i]];
            }
        }
        System.out.println("Count is "+ count + " Profit is "+ profits);
        a.add(count);
        a.add(profits);
        return a;
    }

    public static int minCost(int n, int m, int[] x, int[] y) { //chocola problem
        Arrays.sort(x);
        Arrays.sort(y);
        int vcuts =1 , hcuts = 1;
        int cost=0;
        int i=x.length-1 ,j= y.length-1 ;
        while(i>=0 && j>=0){
            //making a vertical cut ie using x[] array
            if(x[i]>=y[j]){
                cost += x[i]*hcuts; // makes cost by using number of verticle cuts made into current cost;
                vcuts++;
                i--;
            }else{ //making a horizontal cut using y[] array
                cost += y[j]*vcuts; // makes cost by using number of verticle cuts made into current cost;
                hcuts++;
                j--;
            }
            System.out.println(cost);
        }
        // cut using left lines
        while(i>=0){
            cost += x[i]*hcuts;
            vcuts++;
            i--;
        }
        while(j>=0){
            cost += y[j]*vcuts;
            hcuts++;
            j--;
        }
        return cost;
    }


    public static void main(String[] args) {
//        int st[] = { 0,5,8,5,1,3};
//        int st[] = {60, 100, 120};
//        int et[] = { 6,7,9,9,2,4};
//        int et[] = {10, 20, 30};
//        int[] coins ={1,2,5 ,10 ,20, 50,100,500,2000};
//        int deadline[] = {3, 1, 2, 2};
//        int profit[] = {50, 15, 20, 30};
//        jobSequencing(deadline, profit);

//        int n = 4, m = 6;
//        int x[] = {2, 1, 3, 1, 4};
//        int y[] = {4, 1, 2};
//        System.out.println(minCost(n,m,x,y));
            int nums[] = {1,24,5,3};
            int k=8;
//        System.out.println(maxSubarraySum(nums , k));
    }
}
