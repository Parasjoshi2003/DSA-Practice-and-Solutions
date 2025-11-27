package practice.arrays;
import java.util.Scanner;
import static java.lang.Integer.MIN_VALUE;

class methods
{
    Scanner sc = new Scanner(System.in);

    int[] inputArray() {
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.print("The output array is: {");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "}");
    }


    static void countPairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 7) {
                    count += 1;
                }
            }
        }
        if (count > 0) {
            System.out.println("No of pairs which has sum 7 is: " + count);
        }
        else {
            System.out.println("No pairs found for which sum is 7");
        }
    }

    void countTriplets(int[]arr){
        int count =0;
        System.out.println("Enter target sum: ");
        int sumNo= sc.nextInt();
        for (int i=0;i<arr.length;i++){                         //1st no
            for(int j=i+1;j<arr.length;j++){                       //2nd
                for(int k=i+2;k<arr.length;k++){                        //3rd no
                    if (arr[i]+arr[j]+arr[k]==sumNo){
                        count+=1;
                        System.out.println("the " + count + " triplets is of " + arr[i] +","+ arr[j] +","+ arr[k]);
                    }
                }
            }
        }
        if (count>0){
            System.out.println("The no of triplets which has sum " + sumNo+" is: "+ count);
        }
        else{
            System.out.println("No triplets found for which sum is 10");
        }

    }

    void uniqueNoWithNoDuplicates(int[]arr){
        int count=0,sum=0;
        for (int i =0; i<arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
               if (arr[i]==arr[j]){
                   arr[i]=-1;
                   arr[j]=-1;
               }
            }

        }
        System.out.println("Elements which does not have any duplicate are: ");
        int occurence=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=-1 ){
                System.out.print(arr[i]+", ");
                occurence=1;
            }
        }
        if (occurence==0) {
            System.out.println("All elements have duplicates");

        }
    }

    void secondLargestElement(int[]arr){
        int max = MIN_VALUE ;
        int j=0;
        for (int i=0;i<arr.length;i++){            //1st max element
            if(arr[i]>max){
                max=arr[i];
                j=i;
            }
        }
        //arr[j]= MIN_VALUE;    // this we should do using loop as many max may be present at different location
        for (int i=0;i<arr.length;i++){             //eleminatig 1st max
            if (arr[i]==max){
                arr[i]=MIN_VALUE;
            }
        }
        for (int i =0;i<arr.length;i++){        //find second max
            if (arr[i]>arr[j]){
                arr[j]=arr[i];
            }
        }
        System.out.println("The second largest element is: "+ arr[j]);
    }

    int firstEqualPair(int[]arr){
        int count=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]==arr[j]){
//                    System.out.println("First repeting no in array is: "+ arr[i]);
                    return 1;
                }
            }


        }
      return -1;
    } // return jha pe use kroge method end hojayga wha pe

    int[]  swapVariables(int a,int b){

        a=a+b;
        b=a-b;
        a=a-b;
        int[] arr={a,b};
       return(arr);
    }

    int[] reverseArray(int[] arr){
        int[] arr1= new int[arr.length];
//        for (int i= arr.length-1;i>=0;i--){
//            int j = arr.length-1 - i;     //j++ can be used here
//         arr1[j]=arr[i];

//        }
        int i = arr.length-1, j=0;
        while(i>=0){
            arr1[j++]=arr[i--];
        }
        return arr1;
    }

    static void swapInArray(int[]arr,int i,int j){
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }

    int[] reverseArrayWithoutRef(int[] arr){
        int j=arr.length-1;
    for (int i=0;i<j;i++){
       swapInArray(arr,i,j);
        j--;
    }
    return arr;
    }

    int[] rotateArray(int[]arr,int k){
        int n = arr.length;
        k = k%n;
         int[] ans = new int[arr.length];
         int j=0;

         for (int i=n-k;i<n;i++){
            ans[j++]=arr[i];
         }
         for (int i=0;i<n-k;i++){
             ans[j++]=arr[i];
         }
         return ans;
    }

    void frequencyArrayImple(int[]arr){
        int max = (int) Math.pow(10,5);
        int[] arr1=new int[max];
        for (int i=0;i<arr1.length;i++){
            arr1[i]=0;
        }
        for (int i=0;i<arr.length;i++){
            arr1[arr[i]]++;
        }
        String choice="hello";
        do {
            System.out.println("Enter the value which you want to check:");
            int a = sc.nextInt();
            if (arr1[a]>0){
                System.out.println("Element is present");
            }
            else {
                System.out.println("Element is not present");
            }
            System.out.println("Do you want to proceed: y or n");

            choice =sc.next();
        } while (choice.equals("y")) ;

    }

}


    public class practiceArrays
    {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            methods obj = new methods();
            int[] arr = obj.inputArray();
           obj.frequencyArrayImple(arr);


        }
    }

