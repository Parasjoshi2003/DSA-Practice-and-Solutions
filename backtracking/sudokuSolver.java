package practice.backtracking;

import java.net.InetSocketAddress;

public class sudokuSolver {
    public static boolean isSafe(int [][] sudoku, int row , int col, int digit){
        //row and col check
        for (int i = 0; i <= 8 ; i++) {
            if(sudoku[i][col] == digit) return false;
            if(sudoku[row][i] == digit) return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr+3 ; i++) {
            for (int j = sc; j < sc+3 ; j++) {
                if(sudoku[i][j] == digit) return false;
            }
        }
        return true;
    }
    static  int count = 0 ;
    public static boolean solver( int[][] sudoku , int row, int col){
        count++;
        //base case
        if(row ==9) return true;
        //recursion
        int nextRow = row , nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col]!=0){
            return solver(sudoku, nextRow , nextCol);
        }
        for(int digit = 1; digit < 10 ; digit++){
            if(isSafe(sudoku, row, col , digit)){
//                System.out.println("the cell is "+ row + " " +col +" and digit is "+ digit);
                sudoku[row][col] = digit;
                if(solver(sudoku, nextRow , nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void printArray(int arr[][]){
        for (int i = 0; i < arr.length ; i++) {
            for (int j =0; j < arr.length ; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        int sudoku[][] =  {
//                {5,3,0, 0,7,0, 0,0,0},
//                {6,0,0, 1,9,5, 0,0,0},
//                {0,9,8, 0,0,0, 0,6,0},
//
//                {8,0,0, 0,6,0, 0,0,3},
//                {4,0,0, 8,0,3, 0,0,1},
//                {7,0,0, 0,2,0, 0,0,6},
//
//                {0,6,0, 0,0,0, 2,8,0},
//                {0,0,0, 4,1,9, 0,0,5},
//                {0,0,0, 0,8,0, 0,7,9}
//        };
        int[][] sudoku = {
                {0,0,0, 2,6,0, 7,0,1},
                {6,8,0, 0,7,0, 0,9,0},
                {1,9,0, 0,0,4, 5,0,0},

                {8,2,0, 1,0,0, 0,4,0},
                {0,0,4, 6,0,2, 9,0,9},
                {0,5,0, 0,0,3, 0,2,8},

                {0,0,9, 3,0,0, 0,7,4},
                {0,4,0, 0,5,0, 0,3,6},
                {7,0,3, 0,1,8, 0,0,0}
        };
        if(solver(sudoku , 0 , 0)){
            System.out.println("solution found and no of calls is "+ count);
            printArray(sudoku);
        }
        else{
            System.out.println("solution found and no of calls is "+ count);
            System.out.println("soltuion not found");
        }
    }
}
