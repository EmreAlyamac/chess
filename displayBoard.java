import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class displayBoard extends JFrame {
    public displayBoard(board board) {
        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final int finalI = i;
                final int finalJ = j;
                JPanel panel = new JPanel(new GridBagLayout()); // Set layout to GridBagLayout
                if ((i + j) % 2 == 0) {
                    panel.setBackground(new Color(87, 36, 3)); // This will set the background to a light red color
                } else {
                    panel.setBackground(new Color(255, 139, 64));
                }
                JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon(board.getPiece(i, j).getPath()); 
                label.setIcon(icon);
                panel.add(label); // Add label to the panel
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Panel " + finalI + " " + finalJ + " clicked");
                    }
                });
                add(panel);
            }
        }
        pack();
        setSize(1600, 1600); // Set the size of the JFrame
        setVisible(true);
    }

        // new displayBoard();
    
}