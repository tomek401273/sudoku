public class BoardInitialization {
    public Board init(int[][] parsedData) {
        Board board = new Board();
        board.initBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board.setValueInBoard(i, j, parsedData[i][j]);
            }
        }
        return board;
    }
}
