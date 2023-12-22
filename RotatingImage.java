import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RotatingImage extends JLabel {
    private BufferedImage image;
    private double angleInDegrees = 0;
    private int pivotX, pivotY;

    public RotatingImage(ImageIcon icon, int pivotX, int pivotY) {
        this.image = convertToBufferedImage(icon.getImage());
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    private BufferedImage convertToBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform at = new AffineTransform();
        at.translate(pivotX, pivotY);
        at.rotate(Math.toRadians(angleInDegrees));
        at.translate(-pivotX, -pivotY);
        g2.drawImage(image, at, null);
    }

    public void startRotation() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angleInDegrees += 1;
                if (angleInDegrees >= 360) {
                    angleInDegrees = 0;
                }
                repaint();
            }
        });
        timer.start();
    }
}