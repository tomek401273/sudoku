import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Board {
    List<SudokuRow> board = new ArrayList<>();

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
        board.get(row).getSudokuRow().get(col).setValue(val);
    }

    public int getValueInBoard(int row, int col) {
        return board.get(row).getSudokuRow().get(col).getValue();
    }


    public boolean checkRow(int row, int possible) {
//        for (int i = 0; i < 9; i++) {
//            if (getValueInBoard(row, i) == possible) {
//                return true;
//            }
//        }
       return checkRowOrColumn(i ->getValueInBoard(row, i) == possible  );

    }

    public boolean checkColumn(int col, int possible) {
//        for (int i = 0; i < 9; i++) {
//            if (getValueInBoard(i, col) == possible) {
//                return true;
//            }
//        }
        return checkRowOrColumn(i-> getValueInBoard(i, col)==possible);
    }

    public boolean checkRowOrColumn(Predicate<Integer> valueChecker) {
        for (int i = 0; i < 9; i++) {
            if (valueChecker.test(i)) {
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
