 
//import java.awt.Image;

public class Card {
    
    private String name;
    private int id;
    private String desc;
    
    // private Image cardImg;

    
    public Card() {
        this.name = "";
        this.id = 0;
        this.desc = "";
    }

    public Card(String desc) {
        this.desc = desc;
    }

    public Card(String name, int id) {
        this.name = name;
        this.id = id; 
    }

    public Card(String name, int id, String desc) {
        this.name = name;
        this.id = id;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "The " + this.name + " " + this.id + " a comme description " + this.desc;
		
    }
}
