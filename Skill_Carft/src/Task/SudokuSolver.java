package Task;

public class SudokuSolver {

    public static final int GRID_SIZE=9;
    public static void main(String[] args) {
        int[][]board ={
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        if(solveBoard(board)) {
            System.out.println("Solved Sudoku board:");
            printBoard(board);
        } else{
            System.out.println("Unsolvable board");
        }
    }
    public static boolean solveBoard(int[][]board) {
        for(int row=0; row< GRID_SIZE;row++) {
            for(int col=0;col<GRID_SIZE;col++) {
                if(board[row][col]==0) {
                    for(int num=1;num<=GRID_SIZE;num++) {
                        if(isValidPlacement(board,num,row,col)) {
                            board[row][col]=num;

                            if(solveBoard(board)) {
                                return true;
                            } else{
                                board[row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidPlacement(int[][]board,int number,int row,int col) {
        for(int i=0;i< GRID_SIZE;i++) {
            if(board[row][i]==number) {
                return false;
            }
        }
        for(int i=0;i<GRID_SIZE;i++) {
            if(board[i][col]==number) {
                return false;
            }
        }
        int boxRow=row-row%3;
        int boxCol=col-col%3;
        for(int i=boxRow;i<boxRow+3;i++) {
            for(int j = boxCol;j< boxCol+3;j++) {
                if(board[i][j]==number) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][]board) {
        for(int row=0;row<GRID_SIZE;row++) {
            if (row%3==0&&row!=0) {
                System.out.println("----**----");
            }
            for(int col=0;col<GRID_SIZE;col++) {
                if(col%3==0&&col!=0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]==0?".":board[row][col]);
            }
            System.out.println();
        }
    }
}