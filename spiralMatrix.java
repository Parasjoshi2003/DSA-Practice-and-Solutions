package practice;
import java.util.List;
import java.util.ArrayList;

public class spiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        int t=0,l=0;
        int b= matrix.length-1;
        int r=matrix[0].length-1;
        while(t <= b && l <= r){
            for (int i = l; i <=r ; i++) {
                li.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <=b ; i++) {
                li.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >=l ; i--) {
                li.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i>=t ; i--) {
                li.add(matrix[i][l]);
            }
            l++;
//
        }

        return li;

    }

    public static void main(String[] args) {
        int arr[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(arr);
        System.out.println(spiralOrder(arr));
    }
}
