import java.util.ArrayList;
import java.util.Random;

public class Board {

    private int boardHeight;
    private int boardWidth;
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
        int bombs = Screen.askBombs();
        if (bombs < 1 || bombs > ((boardWidth * boardWidth)/3)) {
            //set error
        } else {
            int count = 0;
            while (count <= bombs) {
                int i = new Random().nextInt(boardHeight);
                int j = new Random().nextInt(boardWidth);
                if (!board[i][j].getBomb()) {
                    board[i][j].setBomb();
                }
            }
        }
    }

    public void setTilesValues() {

    }
}
