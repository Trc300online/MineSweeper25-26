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

        if (i-1 > 0) {
            if (board[i-1][j].getBomb()) {
                count++;
            }
        }
        if (i-1 > 0 && j-1 > 0) {
            if (board[i-1][j-1].getBomb()) {
                count++;
            }
        }
        if (j-1 > 0) {
            if (board[i][j-1].getBomb()) {
                count++;
            }
        }

        return count;
    }
}
