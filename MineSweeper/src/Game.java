public class Game {

    static Board board = new Board();

    public void playGame() {
        board.generateBoard();
        boolean gameContinue = true;
        while (gameContinue) {
            Screen.printBoard(board.getBoard());
            gameContinue = playerTurn();
            if (!gameContinue) {
                break;
            }
            gameContinue = !board.checkWin();
            if (!gameContinue) {
                break;
            }
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
                position = Inputs.getPosition(board.getBoardHeight(), board.getBoardWidth());
                board.flagTile(position);
                return true;
            case 'R':
                position = Inputs.getPosition(board.getBoardHeight(), board.getBoardWidth());
                board.revealTile(position);
                return board.saveSpot(position);
            default:
                Screen.errorHandler(1);
                playerTurn();
        }
        return true;
    }
}
