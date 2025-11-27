package practice.searching;

public class tst {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 3, 3, 3, 4, 4, 4, 7, 7, 8, 8};
        int target = 3;
        int low = 0;
        int high = arr.length - 1;
        int firstOccurrence = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                firstOccurrence = mid;
                high = mid - 1; // Move left to find the first occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (firstOccurrence != -1) {
            System.out.printf("First occurrence of %d is at index %d\n", target, firstOccurrence);
        } else {
            System.out.println("Target not found in the array");
        }

    }
}
