public class Screen {

    public static void askHeight() {
        System.out.println("Input the Height for your board:");
    }

    public static void askWidth() {
        System.out.println("Input the Width for your board:");
    }

    public static void askBombs() {
        System.out.println("Input how many bombs do you want to play with:");
    }

    public static void printBoard(Tile[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getFlagged()) {
                    System.out.print("P");
                } else if (board[i][j].getIsReveald() && board[i][j].getBomb()) {
                    System.out.print("B");
                }
                else if (board[i][j].getIsReveald()) {
                    System.out.print(board[i][j].getValue());
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
