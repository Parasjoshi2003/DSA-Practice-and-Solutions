package practice.backtracking;

public class gridWays {
    public static void printGrid(int[][] arr) {
        for (int[] row : arr) {
            for (int elm : row) {
                System.out.print(elm + " ");
            }
            System.out.println();
        }
    }

    public static void findRoutes(int[][] grid, int row, int col) {
        if (row == grid.length-2 && col == grid[0].length-2) {
            grid[row][col] = 1;
            printGrid(grid);
            System.out.println("-----------");
            return;
        }
        if (row >= grid.length || col >= grid[0].length) {
            return;
        }
            grid[row][col] = 1;
//            System.out.println("checking for row "+ row);
            findRoutes(grid, row + 1, col);
//            System.out.println("checking for col "+ col);
            findRoutes(grid, row, col + 1);
            grid[row][col] = 0;

    }

    public static int countWays(int i , int j , int n , int m ){
        if (i == n-1 && j == m-1){
            return 1;
        } else if (i>=n || j>=m) {
            return 0;
        }
        return countWays(i+1,j,n,m) + countWays(i,j+1,n,m);
    }

    public static int calFactorial(int n){
        if (n==1 ) return 1;
        return n*calFactorial(n-1);
    }
    public static float countWaysLinearTime(int n , int m ){
        return calFactorial(n+m-2)/(calFactorial(n-1)*calFactorial(m-1));
    }
    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        System.out.println(countWaysLinearTime( 4,3));
    }
}
