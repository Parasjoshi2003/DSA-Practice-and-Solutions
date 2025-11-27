package practice.searching;

public class raceTrackChildren {

    static boolean isCompatible(int[] arr, int tchildren, int distance){
        int lastposn=0;
        int count=1;

        for (int i=0;i<arr.length;i++){
            if (arr[i]-arr[lastposn]>=distance){
                count++;
                lastposn=i;
            }
            if (count>=tchildren) return true;
        }
        return false;
    }

    static int possibilityCheck(int[] arr, int tchildren){
        int st=0,end= arr[arr.length-1],ans=0;
        while (st<=end){
            int possAns = st + (end-st)/2;
            if(isCompatible(arr,tchildren,possAns)){
                ans=possAns;
                st=possAns+1;
            }
            else{
                end=possAns-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int tchildren = 3;
        int[] slenght={1,2,4,8,9,14,19,25,29};
        System.out.println(possibilityCheck(slenght,tchildren));

    }
}
