package gameInterface;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;

public class DisplayImage extends JPanel {

    private static final long serialVersionUID = 16L;
    private BufferedImage img;

    public DisplayImage(String pathImg) {
        this.setPreferredSize(new Dimension(150, 200));
        try {
            img = ImageIO.read(new File(pathImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}