package life;
import java.util.Scanner;

public class Generation {
    private final Universe current;
    private Universe nextCache;
    Generation next;
    private int numOfAlive;


    public Generation(Universe currentState) {
        current = new Universe(currentState.universe);
        nextCache = null;
        countAlive();
        getNextGen();
    }

    public void printGeneration() {
        System.out.printf("Alive: %d\n", numOfAlive);
        current.printUniverse();
        System.out.print('\n');
    }

    public Generation nextGeneration() {
        if (next == null) {
            next = new Generation(nextCache);
        }
        return next;
    }

    public int getNumOfAlive() {
        return numOfAlive;
    }

    private void countAlive() {
        numOfAlive = current.countAlive();
    }

    private void getNextGen() {
        boolean[][] nextState = new boolean[current.size][current.size];

        for (int i = 0; i < current.size; i++) {
            for (int j = 0; j < current.size; j++) {
                nextState[i][j] = willBeAlive(i, j);
            }
        }

        nextCache = new Universe(nextState);
    }

    private boolean willBeAlive(int row, int col) {
        boolean[] neighbour = getNeighbour(row, col);
        int cntLives = 0;
        for (boolean cell : neighbour) {
            if (cell)
                cntLives++;
        }

        if (current.isAlive(row, col)) {
            return cntLives == 2 || cntLives == 3;
        } else {
            // Reborn
            return cntLives == 3;
        }
    }

    private boolean[] getNeighbour(int row, int col) {
        boolean[] neighbour = new boolean[8];
        neighbour[0] = getNW(row, col);
        neighbour[1] = getN(row, col);
        neighbour[2] = getNE(row, col);
        neighbour[3] = getW(row, col);
        neighbour[4] = getE(row, col);
        neighbour[5] = getSW(row, col);
        neighbour[6] = getS(row, col);
        neighbour[7] = getSE(row, col);

        return neighbour;
    }

    private boolean getN(int row, int col) {
        if (row == 0) {
            return current.isAlive(current.size - 1, col);
        } else {
            return current.isAlive(row - 1, col);
        }
    }

    private boolean getNW(int row, int col) {
        if (row == 0 && col == 0) {
            return current.isAlive(current.size - 1, current.size - 1);
        } else if (row == 0) {
            return current.isAlive(current.size - 1, col - 1);
        } else if (col == 0) {
            return current.isAlive(row - 1, current.size - 1);
        } else {
            return current.isAlive(row - 1, col - 1);
        }

    }

    private boolean getNE(int row, int col) {
        if (row == 0 && col == current.size - 1) {
            return current.isAlive(current.size - 1, 0);
        } else if (row == 0) {
            return current.isAlive(current.size - 1, col + 1);
        } else if (col == current.size - 1) {
            return current.isAlive(row - 1, 0);
        } else {
            return current.isAlive(row - 1, col + 1);
        }
    }

    private boolean getW(int row, int col) {
        if (col == 0) {
            return current.isAlive(row, current.size - 1);
        } else {
            return current.isAlive(row, col - 1);
        }
    }

    private boolean getE(int row, int col) {
        if (col == current.size - 1) {
            return current.isAlive(row, 0);
        } else {
            return current.isAlive(row, col + 1);
        }
    }

    private boolean getSW(int row, int col) {
        if (row == current.size - 1 && col == 0) {
            return current.isAlive(0, current.size - 1);
        } else if (row == current.size - 1) {
            return current.isAlive(0, col - 1);
        } else if (col == 0) {
            return current.isAlive(row + 1, current.size - 1);
        } else {
            return current.isAlive(row + 1, col - 1);
        }
    }

    private boolean getS(int row, int col) {
        if (row == current.size - 1) {
            return current.isAlive(0, col);
        } else {
            return current.isAlive(row + 1, col);
        }
    }

    private boolean getSE(int row, int col) {
        if (row == current.size - 1 && col == current.size - 1) {
            return current.isAlive(0, 0);
        } else if (row == current.size - 1) {
            return current.isAlive(0, col + 1);
        } else if (col == current.size - 1) {
            return current.isAlive(row + 1, 0);
        } else {
            return current.isAlive(row + 1, col + 1);
        }

    }


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

//        Generation last = gens[gens.length - 1];
//        last.printGeneration();
        for (int i = 0; i < gens.length; i++) {
            System.out.printf("Generation %d:\n", i + 1);
            gens[i].printGeneration();
        }
    }
}
