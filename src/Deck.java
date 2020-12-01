import java.util.ArrayList;

//import sun.security.util.Length;

public class Deck {
    ArrayList<Card> cardDeck = new ArrayList<Card>();

    public Deck() {
		for (int n = 0; n < Card.names.length; n++) {
            String name = Card.names[n];
            int id = Card.theId[n];
            String desc = Card.descs[n];
            cardDeck.add(new Card(name, id, desc));   	 
		}
        //System.out.println(cardDeck.toString());  //Vérification
    } 

    public void showDeck() {
        System.out.println("The deck is made up of " + this.cardDeck.size() + " cards :");
        for(int i = 0; i < this.cardDeck.size(); i++) {
            System.out.println(Card.names[i] + " numéro " + Card.theId[i] + " a pour description : " + Card.descs[i]);
        }
    }

    // public void showDeck() {
    //     System.out.println(this.cardDeck.toString());
    // }

    public void addCardToDeck(Card aCard) {
        this.cardDeck.add(aCard);
    }

    public void addCompleteCardToDeck(String name, int id, String desc) {
        this.cardDeck.add(new Card(name, id, desc)); 
    }

   

    @Override 
         public String toString()
         {
            return super.toString();
         }

}
