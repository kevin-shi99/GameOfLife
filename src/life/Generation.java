package life;
import java.util.Scanner;

public class Generation {
    private final Universe current;
    private final Universe next;

    public Generation(Universe currentState) {
        current = currentState;
        next = new Universe(currentState.size());
    }

    public Universe current() {
        return current;
    }

    public Universe next() {
        return next;
    }

    public void nextGeneration() {

    }

    public void printCurrentGeneration() {
        current.printUniverse();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
