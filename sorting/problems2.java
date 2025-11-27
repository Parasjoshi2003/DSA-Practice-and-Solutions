package practice.sorting;

public class problems2 {
    static void swapTwoElementsOnly(int arr[]){
        int pivotIdx=0;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1]) {
                pivotIdx = i;
                break;
            }
        }
//        System.out.println(pivotIdx);
        int smallerElements=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<arr[pivotIdx]) smallerElements++;

        }
//        System.out.println(smallerElements);
        // swap pivt ind with
        int temp = arr[pivotIdx];
        arr[pivotIdx]=arr[smallerElements];
        arr[smallerElements]=temp;
    }

    static void segrigatePosNegNumbers(int arr[]){
        int pivt =0;
        int j=arr.length-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<0) i++;
            if (arr[j]>0) j--;
            if (i>=j) break;
            else{
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
            }
        }
    }

    static  void sortArrayWith123(int arr[]){
        int count[]=new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<3 && arr[i]>=0){
            count[arr[i]]++;
            }
        }

        int idx=0;
        for (int i =0 ;i<3;i++){
            while (count[i]>0){
                arr[idx++]=i;
                count[i]--;
            }
        }

    }

    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void sortArrayWith123AnotherMethod(int arr[]){
        int low=0,mid=0,high=arr.length-1;
        while (mid<=high){
            if (arr[mid]==0){
                swap(arr,mid,low);
                low++;
                mid++;
            }
            else if (arr[mid]==1) mid++;
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }


    public static void main(String[] args) {
        int arr[]={0,1,2,1,2,1,2,0,2};
        sortArrayWith123AnotherMethod(arr);
        for (int val : arr){
            System.out.print(val + " ");
        }
    }
}
