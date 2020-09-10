package life;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameOfLife extends JFrame {

    private final JPanel[][] panels;

    public GameOfLife(int size) {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        root.setLayout(new BorderLayout());

        Font textFont = new Font("Consolas", Font.PLAIN, 16);

        JLabel genLabel = new JLabel();
        genLabel.setName("GenerationLabel");
        genLabel.setFont(textFont);
        genLabel.setText("Generation #");

        JLabel aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setFont(textFont);
        aliveLabel.setText("ALive: ");

        JPanel textPane = new JPanel();
        textPane.setLayout(new BoxLayout(textPane, BoxLayout.PAGE_AXIS));
        textPane.add(genLabel);
        textPane.add(aliveLabel);

        JPanel graphicPane = new JPanel();

        Border graphPaneBoarder =
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 0, 0, 0),
                        BorderFactory.createLoweredBevelBorder());

        graphicPane.setBorder(graphPaneBoarder);
        graphicPane.setLayout(new GridLayout(size, size, 0, 0));

        panels = new JPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JPanel p = new JPanel();
                p.setBackground(Color.GRAY);
                p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                graphicPane.add(p);
                panels[i][j] = p;
            }
        }

        root.add(textPane, BorderLayout.PAGE_START);
        root.add(graphicPane, BorderLayout.CENTER);

        add(root);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GameOfLife(20);
    }
}
