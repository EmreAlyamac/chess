import javax.swing.*;
import java.awt.*;



public class clock {

    public JLayeredPane getJLayeredPane(){
        return layeredPane;
    }

    JLayeredPane layeredPane = new JLayeredPane();


    public clock(){
            layeredPane.setPreferredSize(new Dimension(300, 300)); // Set to the size of your largest image
            
            JLabel clock = new JLabel();
            ImageIcon originalIcon = new ImageIcon("clock.png");
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            clock.setIcon(resizedIcon);
            clock.setBounds(0, 0, 300, 300); // Set to the size of the image
            
            JLabel minute = new JLabel();
            ImageIcon originalIcon2 = new ImageIcon("clockMinute.png");
            Image originalImage2 = originalIcon2.getImage();
            Image resizedImage2 = originalImage2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
            minute.setIcon(resizedIcon2);
            minute.setBounds(100, 60, 100, 100); // Set to the size of the image and position it

            ImageIcon originalIcon3 = new ImageIcon("clockSecond.png");
            Image originalImage3 = originalIcon3.getImage();
            Image resizedImage3 = originalImage3.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon3 = new ImageIcon(resizedImage3);
            RotatingImage second = new RotatingImage(resizedIcon3, 45, 45);
            second.setBounds(110, 70, 80, 80); // Set to the size of the image and position it
            second.startRotation(); // Set to the size of the image and position it
            
            layeredPane.add(clock, JLayeredPane.DEFAULT_LAYER);
            layeredPane.add(minute, JLayeredPane.PALETTE_LAYER);
            layeredPane.add(second, JLayeredPane.POPUP_LAYER);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new clock().getJLayeredPane());
        frame.pack();
        frame.setVisible(true);
    }
}
