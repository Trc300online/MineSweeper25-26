public class Tile {

    private int value = 0;
    private boolean isBomb = false;
    private boolean isRevealed = false;
    private boolean isFlagged = false;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getBomb() {
        return isBomb;
    }

    public void setBomb() {
        this.isBomb = true;
    }

    public boolean getIsReveald() {
        return isRevealed;
    }

    public void setRevealed() {
        this.isRevealed = true;
    }

    public void toggleFlag() {
        isFlagged = !isFlagged;
    }

    public void countBombsAround(int i, int j, Tile[][] board) {
        board[i][j].setValue(checkNeighbours(i, j, board));
    }

    public int checkNeighbours(int i, int j, Tile[][] board) {
        int count = 0;

        if (checkN(i, j, board)) {
            count++;
        }
        if (checkNW(i, j, board)) {
            count++;
        }
        if (checkW(i, j, board)) {
            count++;
        }
        if (checkSW(i, j, board)) {
            count++;
        }
        if (checkS(i, j, board)) {
            count++;
        }
        if (checkSE(i, j, board)) {
            count++;
        }
        if (checkE(i, j, board)) {
            count++;
        }
        if (checkNE(i, j, board)) {
            count++;
        }

        return count;
    }

    public boolean checkN(int i, int j, Tile[][] board) {
        if (i-1 > 0) {
            if (board[i-1][j].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkS(int i, int j, Tile[][] board) {
        if (i+1 < board.length) {
            if (board[i+1][j].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkE(int i, int j, Tile[][] board) {
        if (j+1 < board[0].length) {
            if (board[i][j+1].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkW(int i, int j, Tile[][] board) {
        if (j-1 > 0) {
            if (board[i][j-1].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkNE(int i, int j, Tile[][] board) {
        if (i-1 > 0 && j+1 < board[0].length) {
            if (board[i-1][j+1].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkNW(int i, int j, Tile[][] board) {
        if (i-1 > 0 && j-1 > 0) {
            if (board[i-1][j-1].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSE(int i, int j, Tile[][] board) {
        if (i+1 < board.length && j+1 < board[0].length) {
            if (board[i+1][j+1].getBomb()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSW(int i, int j, Tile[][] board) {
        if (i+1 < board.length && j-1 > 0) {
            if (board[i+1][j-1].getBomb()) {
                return true;
            }
        }

        return false;
    }

}
