package practice.searching;

public class findTargetInDuplicates {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1,1,3,6,1,1,1};
        int st=0,ed=arr.length-1, trgt =1,ans=-1;

        while (st<=ed){
            int mid = st + (ed-st)/2;
            if (arr[mid]== trgt) ans=mid;
            if (arr[st]==arr[mid] && arr[mid]==arr[ed]){
                st++;
                ed--;
            }
            if (trgt == arr[mid]) ans = mid;
            if (arr[mid] < arr[ed]) {
                if (trgt >= arr[mid] && trgt <= arr[ed]) {
                    st = mid + 1;
                } else {
                    ed = mid - 1;
                }
            } else {
                if (trgt >= arr[st] && trgt <= arr[mid]) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        System.out.println(ans);
    }
}
