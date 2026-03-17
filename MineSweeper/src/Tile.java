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
}
