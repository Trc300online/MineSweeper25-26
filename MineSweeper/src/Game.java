public class Game {

    Board board = new Board();

    public void playGame() {
        board.generateBoard();
        Screen.printBoard(board.getBoard());
        playerTurn();

    }

    public void playerTurn() {
        char action = Inputs.getAction();
        int[] position;

        switch (action) {
            case 'Q': //Screen.quitMsg()
                Screen.quitMsg();
                System.exit(0);
                break;
            case 'F':
                position = Inputs.getPosition();
                board.flagTile(position);
                break;
            case 'R':
                position = Inputs.getPosition();
                board.revealTile(position);
                break;
        }
    }
}
