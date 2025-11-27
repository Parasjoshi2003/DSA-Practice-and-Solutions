package practice.sorting;

public class moveZerosToLast {

    public static void main(String[] args) {
        int arr[]={1,0,2,0,0,4,5};

        for (int i=1;i<arr.length;i++){
                for (int j=i;j>=1;j--){
                    if (arr[j]!=0 && arr[j-1]==0) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i : arr ){
            System.out.print(i + " ");
        }



        //This is spaceous method;
//        int ans[]= new int[arr.length];
//        int j= arr.length-1;
//        int a=0;
//
//        for (int i=0;i<arr.length;i++){
//            if (arr[i]==0) {
//                ans[j]=arr[i];
//                j--;
//            }
//            else{
//                ans[a]=arr[i];
//                a++;
//            }
//        }
//        for (int i=0;i<ans.length;i++){
//            System.out.print(ans[i]+" ");
//        }

    }
}
