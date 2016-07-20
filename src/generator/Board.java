package generator;

import javax.swing.JPanel;
import java.awt.*;

public class Board extends JPanel {
    private Cell[][] tab;
    private int n;

    public Board(int n, Cell[][] tab) {
        this.tab = tab;
        this.n = n/5;

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(new Dimension(n,n));
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (tab[i][j].getState() == 0) {
                    g.setColor(Color.black);
                }
                if (tab[i][j].getState() == 1) {
                    g.setColor(Color.red);
                }
                if (tab[i][j].getState() == 2) {
                    g.setColor(Color.blue);
                }
                if (tab[i][j].getState() == 3) {
                    g.setColor(Color.yellow);
                }

                g.fill3DRect(j*5, i*5, 5,5, true);
            }
        }
        repaint();

    }
}