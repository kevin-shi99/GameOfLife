package life;
import java.util.Random;
import java.util.Scanner;

public class Universe {
    private final boolean[][] universe;
    private final int size;

    public Universe(int size, int seed) {
        this.size = size;
        universe = new boolean[size][size];
        Random rand = new Random(seed);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = rand.nextBoolean();
            }
        }
    }

    public Universe(int size) {
        this.size = size;
        universe = new boolean[size][size];
    }

    public void printUniverse() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (universe[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public int size() {
        return size;
    }

    public boolean[][] getUniverse() {
        return universe;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universe universe = new Universe(scanner.nextInt(), scanner.nextInt());

        universe.printUniverse();
    }
}
