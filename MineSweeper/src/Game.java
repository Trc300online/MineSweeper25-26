public class Game {

    Board board = new Board();

    public void playGame() {
        board.generateBoard();
        boolean gameContinue = true;
        while (gameContinue) {
            gameContinue = !board.checkWin();
            Screen.printBoard(board.getBoard());
            gameContinue = playerTurn();
        }

    }

    public boolean playerTurn() {
        char action = Inputs.getAction();
        int[] position;

        switch (action) {
            case 'Q':
                Screen.quitMsg();
                System.exit(0);
                break;
            case 'F':
                position = Inputs.getPosition();
                board.flagTile(position);
                return true;
            case 'R':
                position = Inputs.getPosition();
                board.revealTile(position);
                return board.saveSpot(position);
            default:
                Screen.errorHandler(1);
        }
        return true;
    }
}
