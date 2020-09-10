package life;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Universe {
    final boolean[][] universe;
    final int size;

    /**
     * Construct a new random Universe state
     * @param size the size of the Universe (n * n)
     * @param seed the seed use to generate random pattern
     */
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

    /**
     * Construct an empty Universe without specifying seed
     * @param size the size of the Universe (n * n)
     */
    public Universe(int size) {
        this.size = size;
        universe = new boolean[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = rand.nextBoolean();
            }
        }
    }

    /**
     * Construct a new Universe using an existing 2-D boolean array
     * <p>This method use a shallow copy of the given array argument</p>
     * @param array an existing 2-D boolean array where the size of the two dimensions
     *              need to be the same
     */
    public Universe(boolean[][] array) {
        if (array.length != array[0].length) {
            throw new IllegalArgumentException("The given array has different size " +
                    "along its two dimensions!");
        }
        size = array.length;
        universe = Arrays.copyOf(array, size);
    }

    /**
     * Print this Universe.
     */
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

    public boolean isAlive(int row, int col) {
        return universe[row][col];
    }


    public int countAlive() {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isAlive(i, j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universe universe = new Universe(scanner.nextInt(), scanner.nextInt());

        universe.printUniverse();
    }
}
