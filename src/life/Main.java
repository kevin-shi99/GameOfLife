package life;

public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        game.setGrid(20);
        game.setGenLabel(1);
        game.setAliveLabel(400);

        Generation init = new Generation(new Universe(20));
        game.update(init);

        Generation cur = init;
        Generation next;

        while (true) {
            next = cur.nextGeneration();
            game.update(next);
            cur = next;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }
    }
}
