package practice.sorting;

public class countSort {
    static void sort(int arr[]){
        //find max element
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max=arr[i];
        }

//        //fill count array
//        int count []= new int[max+1];
//        int j=0;
//        while (j<=max){
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i]==j) count[j]=count[j]+1;
//            }
//            j++;
//        }


        //fill count array or frequency array
        int count []= new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //fill ans array unstable mthd
//        int cIdx =0;
//        int aIdx=0;
//        while (cIdx<=max){
//            if (count[cIdx]==0) cIdx++;
//            else{
//                for (int i=0;i<count[cIdx];i++){
//                    arr[aIdx]= cIdx;
////                    System.out.println(arr[aIdx]);
//                    aIdx++;
//                }
//                cIdx++;
//            }
//        }


//fill ans array which is stable mthd
        for (int i = 1; i < count.length; i++) {
            // make prefix sum here
            count[i]=count[i]+count[i-1];
        }
        //ans array banao with same size as that of input array
        int ans[]= new int[arr.length];
        //input array ko traverse kro last se, prefix count array se currnt value ki shi position find kro or use fill kro,
        for (int i = arr.length-1; i >=0 ; i--) {
            int currVal = arr[i];
            ans[count[currVal]-1]=currVal;
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

    public static void main(String[] args) {
        int arr[]={1,3,5,2,3,1,6};
        display(arr);
        System.out.println("array after sorting");
        sort(arr);
        display(arr);
    }
}
