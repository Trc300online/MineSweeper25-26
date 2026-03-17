//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\uD83D\uDCA5"); //bomba 💥
        System.out.println("\uD83D\uDEA9"); //bandera 🚩
        System.out.println("\u2776"); //❶
        System.out.println("\u2777"); //❷
        System.out.println("\u2778"); //❸
        System.out.println("\u2779"); //❹
        System.out.println("\u277A"); //❺
        System.out.println("\u277B"); //❻
        System.out.println("\u277C"); //❼
        System.out.println("\u277D"); //❽
        System.out.println("\u25CF"); //●


        String[][] ex = {{"NW1 ", "N2 ", "NE3"},
                        {" W ", "C ", "E"},
                        {"SW ", "S ", "SE"}};

        for (int i = 0; i < ex.length; i++) {
            System.out.println();
            for (int j = 0; j < ex[0].length; j++) {
                System.out.print(ex[i][j]);
            }
        }
    }
}