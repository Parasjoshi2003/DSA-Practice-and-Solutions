package practice.sorting;


public class mergeSort {
    static void merge(int arr[],int left,int mid, int right){
        int n1=mid-left+1;   //size for arrays
        int n2=right-mid;
         int l[]= new int[n1];
         int r[]=new int[n2];
         for (int i=0;i<n1;i++) l[i]=arr[left+i];
         for (int j=0;j<n2;j++) r[j]=arr[mid+1+j];
        int i=0; int j=0;int k=left;
         while (i<n1 && j<n2){
             if (l[i]<=r[j]) arr[k++]=l[i++];
             else arr[k++]=r[j++];
         }
         while (i<n1) arr[k++]=l[i++];
         while (j<n2) arr[k++]=r[j++];
//        for (int ele : arr){
//            System.out.print(ele + " ");
//        }
//        System.out.println();
    }





    static void mergSort(int arr[],int left,int right){
        if (left>=right)return;
        int mid = (left+right)/2;
        mergSort(arr,left,mid);
        mergSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }



    public static void main(String[] args) {
    int arr[]={1,4,2,3,66,4,3,8};
        System.out.println("Before sorting: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    mergSort(arr,0,7);
        System.out.println("after sorting: ");
    for (int i : arr){
        System.out.print(i + " ");
    }
    }
}
