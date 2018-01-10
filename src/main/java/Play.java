import java.util.List;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        String numberGrid = "";
        String exit;
        boolean finish = false;
        int gridI = 0;
        while (finish == false) {

            FileReader fileReader = new FileReader();
            Scanner sc = new Scanner(System.in);

            System.out.println("Which grid would You like to solve. Write number since 01 to 50");

            while (gridI <= 0) {
                try {
                    numberGrid = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Somenthing go wrong. Can you write again your choice number since 1 to 50");
                }
                try {
                    gridI = Integer.parseInt(numberGrid);
                    if (gridI < 10 && gridI > 0) {
                        numberGrid = "0" + numberGrid;
                    }
                    if (gridI <= 0 || gridI > 50) {
                        gridI = 0;
                        System.out.println("Somenthing go wrong. Can you write again your choice number since 01 to 50");

                    }
                } catch (Exception e) {
                    System.out.println("Something go wrong, Can you write again your choice since 01 to 50");
                }
            }

            System.out.println("You choice grid number: " + numberGrid);

            fileReader.readFile();
            List<String> choosenGrid = fileReader.chooseGrid(numberGrid);
            int[][] parsedData = fileReader.parseData(choosenGrid);

            Board board = new Board();
            board.initBoard();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board.setValueInBoard(i, j, parsedData[i][j]);
                }
            }

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
            if (exit.equals("c")) {
                gridI = 0;
            }
        }
    }
}
