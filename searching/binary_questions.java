package practice.searching;

public class binary_questions {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 3, 3, 3, 4, 4, 4, 7, 7, 8, 8};
        int target=3;
        int low=0;
        int high=arr.length-1;
        int occ=-1;
        int check=1;


        for (int mid=low+(high-low)/2;low<=high;mid=low+(high-low)/2){
//            System.out.println(check++);-
            if (target<arr[0] || target>arr[arr.length-1]) return;
            if (arr[mid]==target){
                occ=mid;
                high=mid-1;
            }
           else if (arr[mid]<target)low=mid+1 ;
            else if (arr[mid]>target) high=mid-1;


            }

        System.out.printf("First occurence is %d ", occ);
        }


    }
