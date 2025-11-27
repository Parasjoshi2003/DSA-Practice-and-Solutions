package practice.searching;
class so{
    static boolean isDivisionPossible(int[] a, int m, int mid) {
        int st[] = new int[m];
        int i = 0, j = 0;
        while (i < m && j < a.length) {
            if (st[i]+a[j] <= mid) {
                st[i] += a[j];
                j++;
            } else {
                i++;
            }
        }
        if (i <m && j >= a.length) return true;
        else return false;
    }
}
public class distributeChocolates {

    static int distribute(int a[],int m){
        so obj = new so();

        if (a.length<m) return -1;
        int st=1, ans=0;
        int end=10000;
        while (st<=end){
            int mid = st+ (end-st)/2;
            if (so.isDivisionPossible(a,m,mid)){
                end=mid-1;
                ans=mid;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
     int a[]={5,3,1,4,2};
     int m=3;
        System.out.println(distribute(a,m));
    }
}
