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
                    System.out.print("\u25A1");
                }
            }
        }
    }

    public static void quitMsg() {
        System.out.println("Quitting game...");
        System.out.println("Bye!");
    }

    public static void askAction() {
        System.out.println();
        System.out.println("| [R]eveal | [F]lag | [Q]uit |");
    }

    public static void askCoords() {
        System.out.println("Where?");
    }

    public static void gameOverMsg() {
        //System.out.println("You Lose");
        System.out.println("~~~\\  /~|\u203E\u203E|~|  |~~~|   ~|\u203E\u203E|~\u250c\u2500\u2500\u2500~\u250c\u2500\u2500\u2500");
        System.out.println("~~~ \\/ ~|  |~|  |~~~|   ~|  |~\u2514\u2500\u2500\u2510~\u251C\u2500\u2500\u2500");
        System.out.println("~~~ \u2595  ~|  |~|  |~~~|   ~|  |~   |~|");
        System.out.println("~~~ \u2595  ~|__|~|__|~~~\u230A___~|__|~-\u2500\u2500\u2518~\u2514\u2500\u2500\u2500");
    }

    public static void errorHandler(int code) {
        switch (code) {
            case 0:
                System.out.println("The number of bombs has to be between 1 and 1/3 of total tiles");
                break;
            case 1:
                System.out.println("Unknown key pressed, try again");
                break;
            default:
                System.out.println("unexpected error, ending processing....");
                System.exit(0);
        }
    }

    public static void winMsg() {
        //System.out.println("You Win!");
        System.out.println("~~~\\  /~|\u203E\u203E|~|  |~~~\\           /~\u203E\u203E\u203ET\u203E\u203E\u203E~|\\   |~~~");
        System.out.println("~~~ \\/ ~|  |~|  |~~~ \\    X    / ~   |   ~| \\  |~~~");
        System.out.println("~~~ \u2595  ~|  |~|  |~~~  \\  / \\  /  ~   |   ~|  \\ |~~~");
        System.out.println("~~~ \u2595  ~|__|~|__|~~~   \\/   \\/   ~___\u22A5___~|   \\|~~~");
    }
}
