//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[][] ex = new String[3][3];

        for (int i = 0; i < ex.length; i++) {
            System.out.println();
            for (int j = 0; j < ex[0].length; j++) {
                System.out.print(i + "" + j + " ");
            }
        }
    }
}