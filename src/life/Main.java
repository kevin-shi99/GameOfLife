package life;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        int numOfGen = scanner.nextInt();

        Generation[] gens = new Generation[numOfGen + 1];
        Generation init = new Generation(new Universe(size, seed));
        gens[0] = init;

        for (int i = 1; i <= numOfGen; i++) {
            gens[i] = gens[i - 1].nextGeneration();
        }

        Generation last = gens[gens.length - 1];
        last.printGeneration();
    }
}
