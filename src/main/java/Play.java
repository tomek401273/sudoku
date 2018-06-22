import java.util.List;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        String numberGrid = "";
        String exit;
        boolean finish = false;
        while (finish == false) {

            FileReader fileReader = new FileReader();
            Scanner sc = new Scanner(System.in);

            ValidateUserChoice validateUserChoice = new ValidateUserChoice();
            numberGrid = validateUserChoice.validate();

            fileReader.readFile();
            List<String> chooseGrid = fileReader.chooseGrid(numberGrid);
            int[][] parsedData = fileReader.parseData(chooseGrid);

            BoardInitialization boardInit = new BoardInitialization();
            Board board = boardInit.init(parsedData);

            System.out.println("--------------------UnSolved Sudoku---------------");
            board.showBoard();
            System.out.println();
            System.out.println("--------------------Solved Sudoku-----------------");
            System.out.println();

            SudokuSolver sudokuSolver = new SudokuSolver();
            sudokuSolver.solve(board);

            board.showBoard();
            System.out.println("Your sudoku was solved if you would like continue and solve another sudoku write c");
            System.out.println("if you would exit write e");
            exit = sc.nextLine();
            if (exit.equals("e")) {
                finish = true;
                System.out.println("Thank you for solving sudoku ");
                System.out.println("I would like to see you again");
            }
        }
    }
}
