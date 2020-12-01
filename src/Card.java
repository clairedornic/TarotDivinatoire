 
//import java.awt.Image;

public class Card {
    
    private String name;
    private int id;
    private String desc;
    public static String[] names = { "Bateleur", "Papesse", "Impératrice", "Empereur", "Pape", "Amoureux",
            "Chariot", "Justice", "Hermite", "Roue de fortune", "Force", "Pendu", "Arcane sans nom", "Tempérance",
            "Diable", "Maison dieu", "Étoile", "Lune", "Soleil", "Jugement", "Monde", "Mat" };
    public static int[] theId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
    public static String[] descs = { "desc1", "desc2", "desc3", "desc4", "desc5", "desc6", "desc7", "desc8",
            "desc9", "desc10", "desc11", "desc12", "desc13", "desc14", "desc15", "desc16", "desc17", "desc18", "desc19",
            "desc20", "desc21", "desc22"};
    
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

    @Override
    public String toString() {
        return "The " + this.name + this.id + " a comme description " + this.desc;
		
    }

    //Method delete a card
    
    //Method add a card ?

    //Method add an image 



}
