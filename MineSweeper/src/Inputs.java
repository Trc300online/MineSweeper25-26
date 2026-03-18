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
}
