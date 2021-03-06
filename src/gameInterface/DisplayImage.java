package gameInterface;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DisplayImage extends JPanel {

    private static final long serialVersionUID = 16L;
    private BufferedImage img;

    public DisplayImage(String pathImg, String pathOutputImg) {
        this.setPreferredSize(new Dimension(195, 245));
        try {

            int scaledWidth = 140;
            int scaledHeight = 225;
            // reads input image
            img = ImageIO.read(new File(pathImg));

            // creates output image
            BufferedImage outputImage = new BufferedImage(scaledWidth,
            scaledHeight, img.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(img, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            // extracts extension of output file
            String formatName = pathOutputImg.substring(pathOutputImg
                    .lastIndexOf(".") + 1);
     
            // writes to output file
            ImageIO.write(outputImage, formatName, new File(pathOutputImg));
            img = ImageIO.read(new File(pathOutputImg));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 
 	* Create new image
    * @param g       
	*/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}