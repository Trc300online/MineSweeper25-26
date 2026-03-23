import java.util.Random;

public class Board {

    private final int boardHeight = Inputs.getHeight();
    private final int boardWidth = Inputs.getWidth();
    private static Tile[][] board;

    public void generateBoard() {
        populateBoard();
        placeBombs();
        setTilesValues();
    }

    public void populateBoard() {
        board = new Tile[boardHeight][boardWidth];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Tile();
            }
        }
    }

    public void placeBombs() {
        int bombs = Inputs.getBombInput();
        if (bombs < 1 || bombs > ((boardHeight * boardWidth)/3)) {
            // TODO: set error
            placeBombs();
        } else {
            int count = 0;
            while (count < bombs) {
                int i = new Random().nextInt(boardHeight);
                int j = new Random().nextInt(boardWidth);
                if (!board[i][j].getBomb()) {
                    board[i][j].setBomb();
                    count++;
                }
            }
        }
    }

    public void setTilesValues() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].getBomb()) {
                    board[i][j].countBombsAround(i, j, board);
                }
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }
}
