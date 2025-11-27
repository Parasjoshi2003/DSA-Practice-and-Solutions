package practice.sorting;

class soln {

    static void bubbleSort(int[] arr, int idx, int itrNo) {               // uses more space O(n)
        if (itrNo == arr.length - 1) return;              //almost n-1 iterations ma array sort ho jayega
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1] + arr[i];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
            }
        }
        itrNo++;
        bubbleSort(arr, 0, itrNo);

    }

    static void bubbleSortIterative(int[] arr) {
        int n = arr.length;
        for (int j = 0; j < n - 1; j++) {
            boolean check = true;
            for (int i = 0; i < n - i - 1; i++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j] + arr[i];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
//                    System.out.println(j);
                    check = false;
                }
            }
            if (check == true) return;
        }
    }

    static void selectionSort(int arr[]){
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    static void insertionSort(int arr[]){
//        int c=0;
        for (int j=1;j<arr.length-1;j++) {             // unsorted array traverse ke liye
//            int curr =j;
            for (int i = j; i >= 0; i--) {//sorted array traverse krne ke liye i.e right position find krne ke liye
//                System.out.println(++c);
                if (arr[i+1] < arr[i]) {
                   int temp=arr[i];
                   arr[i]=arr[i+1];
                   arr[i+1]=temp;
//                   j--;
//                    curr--;
                }
            }
        }
    }

}

public class bubbleInsertionSelection {
    public static void main(String[] args) {
        soln obj = new soln();

        int arr[] = {5, 2, 4, 6, 1, 3};
        obj.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
