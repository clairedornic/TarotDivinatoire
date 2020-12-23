package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Deck implements Serializable {

  private static final long serialVersionUID = 1L;
  ArrayList<Card> cardDeck;

    public Deck() {
      cardDeck = new ArrayList<Card>();
    } 
       
	 /** 
	  * Display all the cards or the deck
	  *
	  */
    public void showDeck() {
        for (Card card : cardDeck) {
            System.out.println(card.toString());
	    }
    }

    
	 /** 
	  * Add the card pass as a parameter in the deck
	  *  
	  * @param aCard
	  *
	  */
    public void addCardToDeck(Card aCard) {
        this.cardDeck.add(aCard);
    }

    
	 /** 
	  * Create a card with all the informations  
	  *  
    * @param name     Name of the card
    * @param id       Id of the card
    * @param desc     Description of the image
    * @param imgPath  Path to the image of the card
	  *
	  */
    public void addCompleteCardToDeck(String name, int id, String desc, String imgPath) {
        this.cardDeck.add(new Card(name, id, desc, imgPath)); 
    }

    /** 
	  * Delete the card corresponding to the ID passed in parameter
	  *  
    * @param id       Id of the card
    * @return boolean 
    *
	  */
    public boolean deleteCard(int id) {
        for (Card card : cardDeck) {
            if (card.setIdCard(card) == id) 
            return cardDeck.remove(card);
        }		
        return false;
    }

    /** 
	  * Search a card by ID in the deck and return it
	  *  
    * @return Card 
    *
	  */
    public Card searchById() {
        boolean idValid = false;
        Card matchedCard = null;
        Scanner scanner = new Scanner(System.in);

        do {   
            System.out.println("Insert the id of the card you are looking for :");
            int searchIdChoice = scanner.nextInt();

              for (Card card : this.cardDeck) {
                int idCard = card.setIdCard(card);
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

    /** 
	  * Search a card by Name in the deck and return it
	  *  
    * @return Card 
    *
	  */
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

    /** 
	  * Check if the current deck is empty 
	  *  
    * @return boolean 
    *
	  */
    public boolean isEmpty() {

      if(this.cardDeck.size() > 0) {
        return false;
      } else {
        return true;
      }
    }

    /** 
	  * Return the current ArrayList of Card
	  *  
    * @return ArrayList<Card> 
    *
	  */
    public ArrayList<Card> getDeckArrayList() {
      return cardDeck;
    }
    
    /** 
	  *  
    * @return String 
    *
	  */
    @Override 
         public String toString()
         {
            return super.toString();
         }

}
