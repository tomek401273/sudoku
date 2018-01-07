import java.util.ArrayList;
import java.util.List;

public class Board {
    List<SudokuRow> board = new ArrayList<>();

    public Board() {
    }

    public void initBoard() {
        for (int i = 0; i < 9; i++) {
            SudokuRow rowZero = new SudokuRow();
            rowZero.initRow();
            board.add(rowZero);
        }
    }

    public void showBoard() {
        System.out.print("   ");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println("");
        System.out.println("----------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 + "| ");
            List<SudokuElement> row = board.get(i).getSudokuRow();
            for (int j = 0; j < 9; j++) {
                SudokuElement element = row.get(j);
                System.out.print(element.getValue() + "|");
            }
            System.out.println();
        }
    }

    public void setValueInBoard(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {

            List<SudokuElement> Row = board.get(i).getSudokuRow();
            for (int j = 0; j < 9; j++) {
                if (i == row && j == col) {
                    board.get(i).getSudokuRow().get(j).setValue(val);
                }
            }
        }
    }

    public int getValueInBoard(int row, int col) {
        int val = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == row && j == col) {
                    val = board.get(i).getSudokuRow().get(j).getValue();
                }
            }
        }
        return val;
    }

    public boolean checkRow(int row, int possible) {
        for (int i = 0; i < 9; i++) {
            if (getValueInBoard(row, i) == possible) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(int col, int possible) {
        for (int i = 0; i < 9; i++) {
            if (getValueInBoard(i, col) == possible) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBox(int ro, int col, int possible) {
        int row = (ro / 3) * 3;
        int column = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getValueInBoard(row + i, column + j) == possible)
                    return true;
            }
        }
        return false;
    }
}
