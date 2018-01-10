public class SudokuSolver {
    public SudokuSolver() {
    }

    public  boolean solve(Board board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getValueInBoard(i, j) != 0) {
                    continue;
                }
                solveCell(board,i,j);

            }
        }
        return true;
    }

    public boolean solveCell(Board board, int i, int j){
        for (int n = 1; n < 10; n++) {
            if (isPosibleValueInRowColBox(board, i, j, n)) {
                board.setValueInBoard(i, j, n);
                if (solve(board))
                    return true;

                else {
                    board.setValueInBoard(i, j, 0);
                }
            }
        }
        return false;
    }

    public boolean isPosibleValueInRowColBox(Board board, int row, int col, int possible) {
        return board.checkRow(row, possible) || board.checkColumn(col, possible) || board.checkBox(row, col, possible);
    }

}
