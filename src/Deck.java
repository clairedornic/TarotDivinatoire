import java.util.ArrayList;

//import sun.security.util.Length;

public class Deck {
    ArrayList<Card> cardDeck;

    public Deck() {
        cardDeck = new ArrayList<Card>();
    } 

    public void showDeck() {
        for (Card card : cardDeck) {
            System.out.println(card.toString());
	    }
    }

    public void addCardToDeck(Card aCard) {
        this.cardDeck.add(aCard);
    }

    public void addCompleteCardToDeck(String name, int id, String desc) {
        this.cardDeck.add(new Card(name, id, desc)); 
    }

    public boolean deleteCard(int id) {
        for (Card card : cardDeck) {
            if (card.getIdCard(card) == id) 
            return cardDeck.remove(card);
        }		
        return false;
    }
    
    @Override 
         public String toString()
         {
            return super.toString();
         }

}
