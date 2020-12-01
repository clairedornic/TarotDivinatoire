import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    int choice;
    String choiceName;
    int choiceId;
    String choiceDescription;
    Deck deckUser = new Deck();

    //Menu
    System.out.println("Welcome! Want to know what the future holds for you ? It's here");
    Scanner scanner = new Scanner(System.in);

    do {
        System.out.println("Here are your different options");
        System.out.println("1) Read the cards");
        System.out.println("2) Add a new card");
        System.out.println("3) Add a description to a new card");
        System.out.println("4) Add a new card with its name, its id and its description");
        System.out.println("5) Modify a card");
        System.out.println("6) Search in to a deck of cards");
        System.out.println("0) Enter 0 to exit the menu");
        choice = scanner.nextInt();

        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
          System.out.println(" || You must choose a number in the list");
        } else {
          switch (choice) {
            case 0:
                break;
            case 1:
                System.out.println("<-------- Reading the deck -------->");
                try {
                  deckUser.showDeck();
                } catch (Exception e) {
                  System.out.println(e);
                } 
              break;
            case 2:
              Card aNewCard = new Card();
              try {
                deckUser.addCardToDeck(aNewCard);
                deckUser.showDeck();
              } catch (Exception e) {
                System.out.println(e);
              }
              
              break;
            case 3:
                System.out.println("Insert the description of your new card");
                choiceDescription = scanner.next();
                Card aNewCard2 = new Card(choiceDescription);
                deckUser.addCardToDeck(aNewCard2);
              break;
            case 4:
                System.out.println("Insert the name of your new card");
                choiceName = scanner.next();
                System.out.println("Insert the id of your new card");
                choiceId = scanner.nextInt();
                System.out.println("Insert the description of your new card");
                choiceDescription = scanner.next();
                // Card aNewCard3 = new Card(choiceName, choiceId, choiceDescription);
                deckUser.addCompleteCardToDeck(choiceName, choiceId, choiceDescription);
              break;
            case 5: //Not working 
          }
        }
      } while (choice != 0); 

        // String name = "Test";
        // int id = 23;
        // String desc = "Desc23";
        // Card testCard = new Card(name, id, desc); 
        // System.out.println(testCard.toString());
        
    }
}
