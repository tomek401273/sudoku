import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuRow = new ArrayList<>();

    public SudokuRow() {
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }

    public void initRow() {
        for (int i = 0; i < 9; i++) {
            SudokuElement elementZero = new SudokuElement(0);
            sudokuRow.add(elementZero);
        }
    }

}
