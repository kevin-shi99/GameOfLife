package life;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
//        int seed = scanner.nextInt();
        ArrayList<Generation> genList = new ArrayList<>();


        Generation init = new Generation(new Universe(size));
        genList.add(init);
        System.out.printf("Generation: #%d\n", 1);
        genList.get(0).printGeneration();
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(500);
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().
                            start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
//                clearScreen();
            } catch (IOException | InterruptedException e) {}

            genList.add(genList.get(i - 1).nextGeneration());
            System.out.printf("Generation: #%d\n", i + 1);
            genList.get(i).printGeneration();
        }

    }

/*    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }*/
}
