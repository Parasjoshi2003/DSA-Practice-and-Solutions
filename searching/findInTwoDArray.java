package practice.searching;

public class findInTwoDArray {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        int target= 2;
        Boolean ans=false;                             //  this is one approach
//
//        for (int i=0;i<arr.length;i++){
//            int st=0;
//            int end=arr[i].length-1;
//            while(st<=end){
//                int mid=st+(end-st)/2;
//                if (arr[i][mid]==target){
//                    ans=true;
//                    break;
//                }
//                if (arr[i][mid]>target){
//                    end=mid-1;
//                }
//                else{
//                    st=mid+1;
//                }
//            }
//            if (ans==true) break;
//        }
//
//        System.out.println("the ans is "+ ans);


        // time efficient approach

        int start=0;
        int end=arr.length*arr[0].length-1;
        int col=arr.length;
        while(start<=end){
            int mid= start + (end-start)/2;
            if (arr[mid/col][mid%col]==target){
                ans = true;
                break;
            }
            if (arr[mid/col][mid%col]>target){
                end=mid-1;
            }
            else{
                start= mid+1;
            }
        }
        System.out.println("the element is present or not: " + ans);
    }
}
