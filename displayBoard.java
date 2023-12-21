import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class displayBoard extends JFrame {
    static JPanel[][] panels = new JPanel[8][8]; // Declare a 2D array of panels

    public displayBoard(board board) {
        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final int finalI = i;
                final int finalJ = j;
                panels[i][j] = new JPanel(new GridBagLayout()); // Store panel in the array
                if ((i + j) % 2 == 0) {
                    panels[i][j].setBackground(new Color(87, 36, 3));
                } else {
                    panels[i][j].setBackground(new Color(255, 139, 64));
                }
                JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon(board.getPiece(i, j).getPath());
                label.setIcon(icon);
                panels[i][j].add(label);
                panels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        helpers.clicked(finalI, finalJ, board, displayBoard.this);
                    }
                });
                add(panels[i][j]);
            }
        }
        pack();
        setSize(1600, 1600);
        setVisible(true);
    }

    public Color highlightPanel(int x, int y, Color color) {
        // Get the initial color
        Color initialColor = panels[x][y].getBackground();
    
            if (x >= 0 && x < panels.length && y >= 0 && y < panels[x].length) {
                panels[x][y].setBackground(color);
            }
        return initialColor;
    }
    


    public Boolean update(board board) {
        getContentPane().removeAll(); // Remove all components
                setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final int finalI = i;
                final int finalJ = j;
                panels[i][j] = new JPanel(new GridBagLayout()); // Store panel in the array
                if ((i + j) % 2 == 0) {
                    panels[i][j].setBackground(new Color(87, 36, 3));
                } else {
                    panels[i][j].setBackground(new Color(255, 139, 64));
                }
                JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon(board.getPiece(i, j).getPath());
                label.setIcon(icon);
                panels[i][j].add(label);
                panels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        helpers.clicked(finalI, finalJ, board, displayBoard.this);
                    }
                });
                add(panels[i][j]);
            }
        }
        pack();
        setSize(1600, 1600);
        setVisible(true);
        return true;
    }

    public static void updatePanel(int x, int y, board board) {
        panels[x][y].removeAll(); // Remove all components from the panel
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon(board.getPiece(x, y).getPath());
        label.setIcon(icon);
        panels[x][y].add(label);
        panels[x][y].revalidate();
        panels[x][y].repaint();
    }
    
}