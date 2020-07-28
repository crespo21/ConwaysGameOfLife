public class GameOfLife{
    public static void isState(int[][] grid,int columns, int rows){
      // The next board
        int[][] next = new int[columns][rows];
        //[full] Looping but skipping the edge cells
        for (int x = 1; x < columns-1; x++) {
            for (int y = 1; y < rows-1; y++) {
                // Add up all the neighbor states to
                // calculate the number of live neighbors.
                int neighbors = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        neighbors += grid[x+i][y+j];
                // Correct by subtracting the cell state itself.
                neighbors -= grid[x][y];
                //[full] <b>The rules of life!</b>
                if ((grid[x][y] == 1) && (neighbors <  2)) next[x][y] = 0;
                else if ((grid[x][y] == 1) && (neighbors == 2 || neighbors == 3 )) next[x][y] = 1;
                else if ((grid[x][y] == 1) && (neighbors >  3)) next[x][y] = 0;
                else if ((grid[x][y] == 0) && (neighbors == 3)) next[x][y] = 1;
                else next[x][y] = grid[x][y];
            }
        }
        //[end]
        // The 2D array “next” is now the current board.
        System.out.println("\n"+" nextGeneration ");
        for(int i = 0; i <columns;i++) {
            for (int j = 0; j < rows; j++) {
                if (next[i][j] == 0){
                    System.out.print("+");
                }
                else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
 // The current generation;
        int columns=10;
        int rows =10;
        // Note that this 2DArray has 10 elements
        // horizontally(Columns) and vertically(Rows), thus form a grid
        int[][] grid = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,1,1,1,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };
        System.out.println("\n"+" currentGeneration  ");
       for(int i = 0; i <rows;i++) {
           for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0){
                    System.out.print("+");
                }
                else {
                    System.out.print("#");
                }
           }
           System.out.println();
       }
        isState(grid,columns,rows);
    }
}