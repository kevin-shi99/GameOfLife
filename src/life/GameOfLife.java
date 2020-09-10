package life;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameOfLife extends JFrame {

    private JPanel[][] panels;
    private int cntGeneration = 0;
    private final JPanel root = new JPanel();
    private final JLabel genLabel = new JLabel();
    private final JLabel aliveLabel = new JLabel();
    private final JPanel textPane = new JPanel();
    private final JPanel graphicPane = new JPanel();

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 460);
        setLocationRelativeTo(null);

        cntGeneration = 0;

        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        root.setLayout(new BorderLayout());

        Font textFont = new Font("Consolas", Font.PLAIN, 16);

        JLabel genText = new JLabel("Generation #");
        genText.setFont(textFont);
        JLabel aliveText = new JLabel("Alive: ");
        aliveText.setFont(textFont);

        genLabel.setName("GenerationLabel");
        genLabel.setFont(textFont);
        genLabel.setText("1");

        aliveLabel.setName("AliveLabel");
        aliveLabel.setFont(textFont);
        aliveLabel.setText("400");

        JPanel genPane = new JPanel();
        JPanel alivePane = new JPanel();

        genPane.setLayout(new FlowLayout());
        alivePane.setLayout(new FlowLayout());

        genPane.add(genText);
        genPane.add(genLabel);

        alivePane.add(aliveText);
        alivePane.add(aliveLabel);

        textPane.setLayout(new BoxLayout(textPane, BoxLayout.Y_AXIS));
        textPane.add(genPane);
        textPane.add(alivePane);



        Border graphPaneBoarder =
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 0, 0, 0),
                        BorderFactory.createLoweredBevelBorder());

        graphicPane.setBorder(graphPaneBoarder);

        root.add(textPane, BorderLayout.PAGE_START);
        root.add(graphicPane, BorderLayout.CENTER);

        add(root);

        setVisible(true);
    }

    public void setGrid(int size) {
        panels = new JPanel[size][size];
        graphicPane.setLayout(new GridLayout(size, size, 0, 0));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JPanel p = new JPanel();
                p.setBackground(Color.LIGHT_GRAY);
                p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                graphicPane.add(p);
                panels[i][j] = p;
            }
        }
        graphicPane.repaint();
    }

    public void setGrid(Generation cur) {
        Universe curUni = cur.getCurrent();
        boolean[][] curArray = curUni.universe;
        for (int i = 0; i < curUni.size; i++) {
            for (int j = 0; j < curUni.size; j++) {
                if (curArray[i][j]) {
                    panels[i][j].setBackground(Color.BLACK);
                } else {
                    panels[i][j].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        graphicPane.repaint();
    }

    public void setGenLabel(int genNum) {
        genLabel.setText(Integer.toString(genNum));
        genLabel.repaint();
    }

    public void setAliveLabel(int numOfAlive) {
        aliveLabel.setText(Integer.toString(numOfAlive));
        aliveLabel.repaint();
    }

    public void update(Generation cur) {
        setGenLabel(++cntGeneration);
        setAliveLabel(cur.getNumOfAlive());
        setGrid(cur);
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        game.setGrid(20);
        game.setGenLabel(1);
        game.setAliveLabel(400);
    }
}
