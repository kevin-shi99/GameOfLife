package life;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universe universe = new Universe(scanner.nextInt(), scanner.nextInt());

        universe.printUniverse();
    }
}
