package leetcode;
import java.net.Inet4Address;
import java.util.*;

public class greedy {
    public static boolean checkValidString(String s) {
        Deque<Character> q = new LinkedList<>();
        int star = 0;
        int l = 0, r = 0, st = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                q.addLast(ch);
                l++;
            }
            if (ch == '*') {
                star++;
                st++;
            }
            if (ch == ')') {
                r++;
                if (q.isEmpty()) {
                    if (star == 0) {
                        return false;
                    }
                    star--;
                } else {
                    q.removeLast();
                }

            }
        }
        System.out.println(" left is " + l + " right is " + r + " star is " + st);
        while (!q.isEmpty() && star > 0) {
            q.removeLast();
            star--;
        }
        return star >= 0 && q.isEmpty();

    }

    public static void candy(int[] ratings) {
        int arr[] = new int[ratings.length];
        arr[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            arr[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("________________");
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                if (arr[i] >= arr[i - 1]) {
                    arr[i - 1] = arr[i] + 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length == 0 ) return intervals;
        if (intervals.length == 0 ){
            int ne[][] = new int[1][];
            ne[0] = newInterval;
            return ne;
        }
        int fCol [] = new int[intervals.length+1];
        int sCol [] = new int[intervals.length+1];
        int f = 0 , s = 0;
        // This returns two arrays with filled in sorted values
        for(int i=0;i<intervals.length;i++){
            int col1 = intervals[i][0];
            int col2 = intervals[i][1];
            if(col1 < newInterval[0]){
                fCol[f++] = col1;
            }else{
                fCol[f++] = newInterval[0];
                newInterval[0] = Integer.MAX_VALUE;
                fCol[f++] = col1;
            }
            if(col2 < newInterval[1]){
                sCol[s++] = col2;
            }else{
                sCol[s++] = newInterval[1];
                newInterval[1] = Integer.MAX_VALUE;
                sCol[s++] = col2;
            }
        }
        // Now problem is to make non overlapping sets from two arrays
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0 , j = 0 , idx = 0 ;
        while(i< fCol.length){
            int temp[] = new int[2];
            temp[0] = fCol[i];
            while(j+1<fCol.length && (sCol[j] >= fCol[j+1] || sCol[j] <= fCol[i])){
                j++;
            }
            temp[1] = sCol[j];
            intervals[idx++] = temp;
            i = j+1 ;
            j++;
            System.out.println("pair "+ temp[0]+" "+ temp[1]);
            map.put(temp[0] , temp[1]);
        }
        int [][] ans = new int[map.size()][];
        int ansIdx =0 ;
        for (Integer key : map.keySet()) {
            int a[] = new int[2];
            a[0] = key;
            a[1] = map.get(key);
            ans[ansIdx++] = a;
        }
        return ans;
    } // wrong code

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int  n = intervals.length;
        int i = 0 , j = 0;
        while(i < n ) {
            int fIndex = intervals[i][0];
            while (j + 1 < n && (intervals[j][1] <= fIndex || intervals[j][1] >= intervals[j + 1][0]))
                j++;
            int sIndex = intervals[j][1];
//            System.out.println(fIndex + " " + sIndex);
            int[] ans = {fIndex, sIndex};
            list.add(ans);
            j++;
            i =  j;
        }

        return  list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int arr[] = {2,7};
//        [[1,3],[2,6],[8,10],[15,18]]
        int intervals[][] = { {1,4}, {4,5}};
        int ans[][] =  merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
