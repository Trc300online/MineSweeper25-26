import java.util.Scanner;

public class Inputs {

    public static int getHeight() {
        int height;

        Scanner input = new Scanner(System.in);
        Screen.askHeight();
        height = input.nextInt();

        return height;
    }

    public static int getWidth() {
        int width;

        Scanner input = new Scanner(System.in);
        Screen.askWidth();
        width = input.nextInt();

        return width;
    }

    public static int getBombInput() {
        int bombs;

        Scanner input = new Scanner(System.in);
        Screen.askBombs();
        bombs = input.nextInt();
        return bombs;
    }

    public static char getAction() {
        char action;

        Scanner input = new Scanner(System.in);
        Screen.askAction();
        action = input.next().toUpperCase().charAt(0);

        return action;
    }

    public static int[] getPosition(int height, int width) {
        int[] coords = new int[2];
        do {
            Scanner x = new Scanner(System.in);
            Scanner y = new Scanner(System.in);
            Screen.askCoords();
            coords[0] = x.nextInt() - 1;
            coords[1] = y.nextInt() - 1;

        } while (coords[0] < 0 || coords[0] >= height || coords[1] < 0 || coords[1] >= width);
        return coords;
    }
}
