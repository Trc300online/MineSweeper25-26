import java.util.ArrayList;
import java.util.Random;

public class Board {

    private final int boardHeight = Inputs.getHeight();
    private final int boardWidth = Inputs.getWidth();
    private Tile[][] board;

    public void generateBoard() {
        populateBoard();
        placeBombs();
        setTilesValues();
    }

    public void populateBoard() {
        board = new Tile[boardHeight][boardWidth];
    }

    public void placeBombs() {
        int bombs = 0; // = Screen.askBombs();
        if (bombs < 1 || bombs > ((boardHeight * boardWidth)/3)) {
            //set error
        } else {
            int count = 0;
            while (count <= bombs) {
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
        for (int i = 0; i < boardHeight - 1; i++) {
            for (int j = 0; j < boardWidth - 1; j++) {
                if (!board[i][j].getBomb()) {
                    board[i][j].countBombsAround(i, j, board);
                }
            }
        }
    }
}
