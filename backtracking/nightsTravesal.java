package practice.backtracking;

public class nightsTravesal {

    public static void printArray(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void initialiseArray(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = -1;
            }
        }
    }
    static int count = 0;

    public static boolean isSafe(int [][]board , int xToCheck , int yToCheck){
        if(xToCheck>=board.length || yToCheck>=board.length || xToCheck <0 || yToCheck<0 ) return false;
        if(board[xToCheck][yToCheck] != -1) return false;
        return true;
    }

    public static boolean findSpots(int[][]board,  int row , int col){
//        System.out.println("row and col and count is; "+ row + " "+ col+" "+ count);

        if(count == board.length* board.length -1 ){
            board[row][col] = ++count;
            return true;
        }
        int[][] moves ={
                {row+2, col-1},
                {row+2 , col+1},
                {row-2 , col+1},
                {row-2, col-1},
                {row+1, col+2},
                {row+1 , col-2},
                {row-1 , col+2},
                {row-1, col-2},
        };
        for (int i = 0; i < moves.length; i++) {
            if(isSafe(board , moves[i][0], moves[i][1])){
                board[row][col] = ++count;
                if(findSpots(board , moves[i][0], moves[i][1] )){
                    return true;
                }
                board[row][col] = -1;
                count--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int board [][] = new int[7][7];
        initialiseArray(board);
        if(findSpots(board, 0 ,0)){
            System.out.println("solution found: ");
            printArray(board);
        }
        else{
            System.out.println("Solution not found");
        }
    }
}
