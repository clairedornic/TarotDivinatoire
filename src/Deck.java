import java.util.ArrayList;
import java.util.Scanner;

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

    public void addCompleteCardToDeck(String name, int id, String desc, String imgPath) {
        this.cardDeck.add(new Card(name, id, desc, imgPath)); 
    }

    public boolean deleteCard(int id) {
        for (Card card : cardDeck) {
            if (card.getIdCard(card) == id) 
            return cardDeck.remove(card);
        }		
        return false;
    }

    public Card searchById() {
        boolean idValid = false;
        Card matchedCard = null;
        Scanner scanner = new Scanner(System.in);

        do {   
            System.out.println("Insert the id of the card you are looking for :");
            int searchIdChoice = scanner.nextInt();

              for (Card card : this.cardDeck) {
                int idCard = card.getIdCard(card);
                if (idCard == searchIdChoice) {
                  idValid = true;
                  matchedCard = card;
                } else {
                  idValid = false;
                }
              }	
              if(matchedCard == null) {
                System.out.println("Id invalid, please try to search a card with an another id present in the list behind");
                this.showDeck();
              } else {
              }
          } while (matchedCard == null);
          System.out.println("Voici la carte que vous recherchiez : " + matchedCard);
          return matchedCard;
    }

    public Card searchByName() {
        boolean nameValid = false;
        Card matchedCard = null;
        Scanner scanner2 = new Scanner(System.in);

        do {   
            System.out.println("Insert the name of the card you are looking for :");
            String searchNameChoice = scanner2.next();
            
            // while (idValid == false) {
              for (Card card : this.cardDeck) {
                String nameCard = card.getNameCard();
                if (nameCard.equalsIgnoreCase(searchNameChoice)) {
                    nameValid = true;
                  matchedCard = card;
                } else {
                    nameValid = false;
                }
              }	
              if(matchedCard == null) {
                System.out.println("Name invalid, please try to search a card with an another name present in the list behind");
                this.showDeck();
              } else {
              }
            // }
          } while (matchedCard == null);
          System.out.println("Here is the card you were looking for : " + matchedCard);
          return matchedCard;
    }
    
    @Override 
         public String toString()
         {
            return super.toString();
         }

}
