package practice.sorting;

class Sol {
    static void swap(int arr[], int i, int j) {
        if (i!=j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
        }
    }

    int partition(int arr[], int st, int ed) {
        int count = 0;
        for (int i = st + 1; i <=ed; i++) {
            if (arr[i] < arr[st]) count++;
        }
        int pivtIdx = count + st;


        swap(arr, st, pivtIdx); // swap pivt with its right place



        int j = ed;
        int i=st;
        while(i<pivtIdx && j>pivtIdx) {                             // this loop places elemnts in left or right
            while (arr[i] < arr[pivtIdx] && i<pivtIdx) i++;
            while (arr[j] > arr[pivtIdx] && j>pivtIdx) j--;
            if (i < pivtIdx && j > pivtIdx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivtIdx;
    }

}

public class quickSort {

    static void quikSort(int arr[], int st, int ed) {
    Sol obj = new Sol();
        if (st >= ed) return; //base case
        int pvtIdx = obj.partition(arr, st, ed); // self work is to find pivtIdx and place left and right elements
        quikSort(arr, st, pvtIdx - 1);
        quikSort(arr, pvtIdx + 1, ed);
    }


    public static void main(String[] args) {

        int arr[] = {4, 2, 1, 9, 6};
        System.out.println("Before swapping the array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        quikSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter swapping array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}