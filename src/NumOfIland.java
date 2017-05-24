import java.util.Scanner;

/**
 * Created by byuwa on 2017/5/7.
 */
public class NumOfIland {
    public static int numIslands(char[][] grid) {

        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = grid[0].length;
        if (col == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1'){
                    setGrid(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public static void setGrid(char[][] grid, int row, int col){

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return ;
        if (grid[row][col] == '1'){
            grid[row][col] = '0';
            setGrid(grid, row - 1, col);
            setGrid(grid, row + 1, col);
            setGrid(grid, row, col + 1);
            setGrid(grid, row, col - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  m = sc.nextInt();
        char[][] grid=new char[n][m];
        String[] temp=new String[n+1];
        for(int i = 0; i < n+1; i++){
            temp[i]=sc.nextLine();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<temp[i+1].length();j++){
                grid[i][j]=temp[i+1].charAt(j);
            }
        }
        int result =numIslands(grid);
        System.out.println(result);
    }
}
