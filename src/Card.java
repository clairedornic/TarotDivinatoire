import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Card {

    private String name;
    private int id;
    private String desc;
    String imagePath = "";

    public Card() {
        this.name = "";
        this.id = 0;
        this.desc = "";
        this.imagePath = "";
    }

    public Card(String desc) {
        this.desc = desc;
    }

    public Card(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Card(String name, int id, String desc, String imgPath) {
        this.name = name;
        this.id = id;
        this.desc = desc;
        this.imagePath = imgPath;
    }

    public int getIdCard(Card aCard) {
        return this.id = aCard.id;
    }

    public String getNameCard() {
        return name;
    }

    public String getDescCard() {
        return desc;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeId(int id) {
        this.id = id;
    }

    public void changeDesc(String desc) {
        this.desc = desc;
    }

    public void addImg() {
        boolean errorImg = false;
        String pathImg ="";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Insert the path of your image");
            pathImg = scanner.next();
            try {
                BufferedImage myPicture = ImageIO.read(new File(pathImg));
                break;
            } catch (IOException e) {
                e.printStackTrace();
                errorImg = true;
                continue;
            }
        }
        if(imagePath.length()!=0) {
            imagePath = "";
            this.imagePath = pathImg;
        } else {
            this.imagePath = pathImg;
        }
        
    }

    @Override
    public String toString() {
        return "The " + this.name + " " + this.id + " has as description " + this.desc + " " + this.imagePath;
		
    }
}
