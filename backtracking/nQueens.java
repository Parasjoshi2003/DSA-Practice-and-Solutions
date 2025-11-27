package practice.backtracking;

public class nQueens {
    public static boolean isSafe(String [][] board , int row , int col){
        for (int i = 0 ; i < board.length; i++) {
            if(board[i][col].equals("Q")) return false;
        }
        for (int i = 0 ; i < board.length; i++) {
            if(board[row][i].equals("Q")) return false;
        }
        int i= row , j = col ;
        while(i< board.length && j< board.length && i>=0 && j>=0){
            if(board[i++][j++].equals("Q")) return false;
        }
        i= row ;
        j = col;
        while(i< board.length && j< board.length && i>=0 && j>=0){
            if(board[i--][j++].equals("Q")) return false;
        }
        i= row ;
        j = col;
        while(i< board.length && j< board.length && i>=0 && j>=0){
            if(board[i++][j--].equals("Q")) return false;
        }
        i= row ;
        j = col;
        while(i< board.length && j< board.length && i>=0 && j>=0){
            if(board[i--][j--].equals("Q")) return false;
        }
        return true;
    }
    public static void printArray(String [][] arr){
        for (String[] row : arr) {
            for (String element : row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
    public static void placeNQueens(String [][] board , int row ){
        //Base Case
        if (row == board.length) {
            for (int i = 0; i < board.length*2 -1  ; i++) {
                System.out.print("-");
            }
            System.out.println();
            printArray(board);
            return;
        };
        for (int j = 0; j < board.length ; j++) {
            if(isSafe(board , row , j)){
            board[row][j] = "Q";
            placeNQueens(board , row+1 );
            board[row][j] = "X";
            }
        }
    }
    public static void main(String[] args) {
        int n=6;
        String arr[][]= new String[n][n];
        for(int i =0 ; i< arr.length;i++ ) {
            for (int j =0 ; j< arr.length;j++) {
                arr[i][j]= "X";
            }
        }
        placeNQueens(arr, 0 );
    }
}
