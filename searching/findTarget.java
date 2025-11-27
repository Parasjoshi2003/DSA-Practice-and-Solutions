package practice.searching;

public class findTarget {
    public static void main(String[] args) {
        int[] arr = {9, 10, 11, 12, 1, 1, 2, 3, 4, 6, 8};
        int trgt = 7;
        int st = 0, ed = arr.length - 1;
        int ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (trgt == arr[mid]) ans = mid;
            if (arr[mid] < arr[ed]) {
                if (trgt >= arr[mid] && trgt <= arr[ed]) {
                    st = mid + 1;
                } else {
                    ed = mid - 1;
                }
            } else {
                if (trgt >= arr[st] && trgt <= arr[mid]) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        System.out.println(ans);
    }
}

