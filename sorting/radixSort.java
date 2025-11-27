package practice.sorting;

public class radixSort {
    static void counSort(int arr[],int place){
        //fill count array or frequency array
        int count []= new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i]/place)%10]++;
        }


//fill ans array which is stable mthd
        for (int i = 1; i < count.length; i++) {
            // make prefix sum here
            count[i]=count[i]+count[i-1];
        }
        //ans array banao with same size as that of input array
        int ans[]= new int[arr.length];
        //input array ko traverse kro last se, prefix count array se currnt value ki shi position find kro or use fill kro,
        for (int i = arr.length-1; i >=0 ; i--) {
            int currVal = (arr[i]/place)%10;
            ans[count[currVal]-1]=arr[i];
            // fill krne ke bad prefix array ki value kam kro taki alge bar shi position bata paye
            count[currVal]--;
        }
        for (int i = 0; i < ans.length; i++) {
            arr[i]=ans[i];

        }

    }
    static void display(int arr[]){
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]+" ");
        }
    }
    static  void radSort(int arr[]){
     int max= Integer.MIN_VALUE;
     //find the max value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max=arr[i];

        }

     for (int place=1;max/place>0;place*=10){
         counSort(arr,place);
     }



    }


    public static void main(String[] args) {
    int arr[]={102,003,405,302};
    radSort(arr);
    display(arr);
    }
}
