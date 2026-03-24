import java.util.Random;

public class Board {

    private final int boardHeight = Inputs.getHeight();
    private final int boardWidth = Inputs.getWidth();
    private static Tile[][] board;
    int bombs = Inputs.getBombInput();
    int totalTiles = (boardHeight * boardWidth);
    int revelaed = 0;
    private int[][] veinadesRelatives = {{-1,-1},{-1,0},{-1,+1},{0,-1},{0,+1},{1,-1},{1,0},{1,1}};

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
        if (bombs < 1 || bombs > ((boardHeight * boardWidth)/3)) {
            Screen.errorHandler(0);
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

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].getBomb()) {
                    for (int a = 0; a < veinadesRelatives.length; a++) {
                        int x = veinadesRelatives[a][0];
                        int y = veinadesRelatives[a][1];
                        if (esticDinsTauler((i+x), (j+y))) {

                        }
                    }
                }
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void flagTile(int[] position) {
        int x = position[0];
        int y = position[1];

        board[x][y].toggleFlag();
    }

    private boolean esticDinsTauler( int fila , int col ){

        return ( ( fila >= 0 ) && ( fila < board.length ) && ( col >= 0 ) && ( col < board[0].length) );
    }

    public void revealTile(int[] position) {
        int x = position[0];
        int y = position[1];

        int[] newPosition = new int[2];

        if (!board[x][y].getBomb() && !board[x][y].getIsReveald()) {
            revelaed++;
            board[x][y].setRevealed();
            for ( int i = 0; i < veinadesRelatives.length; i++ ) {
                int a = veinadesRelatives[i][0];
                int b = veinadesRelatives[i][1];
                if ( esticDinsTauler((x+a), (y+b))) {
                    if (!board[x+a][y+b].getIsReveald()) {
                        if (board[x+a][y+b].getValue() == 0) {
                            newPosition[0] = x+a;
                            newPosition[1] = y+b;
                            revealTile(newPosition);
                        } else {
                            board[x+a][y+b].setRevealed();
                        }
                    }
                }
            }
        }
    }

    public boolean saveSpot(int[] position) {
        int x = position[0];
        int y = position[1];
        if (board[x][y].getBomb()) {
            Screen.gameOverMsg();
            board[x][y].setRevealed();
            Screen.printBoard(board);
            return false;
        }

        return true;
    }

    public boolean checkWin() {
        return (revelaed + bombs == totalTiles) ;
    }
}
