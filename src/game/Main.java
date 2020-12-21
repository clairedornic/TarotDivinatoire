package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import gameInterface.Window;


import java.io.ObjectOutputStream;


public class Main {

  public static Window game = null;

  public static void main(String[] args) throws Exception {
    int choice;
    String choiceName;
    int choiceId;
    String choiceImgPath;
    String choiceDescription;
    final String[] names = { "Bateleur", "Papesse", "Impératrice", "Empereur", "Pape", "Amoureux", "Chariot", "Justice",
        "Hermite", "Roue de fortune", "Force", "Pendu", "Arcane sans nom", "Tempérance", "Diable", "Maison dieu",
        "Étoile", "Lune", "Soleil", "Jugement", "Monde", "Mat" };
    final int[] theId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
    final String[] descs = { "desc1", "desc2", "desc3", "desc4", "desc5", "desc6", "desc7", "desc8", "desc9", "desc10",
        "desc11", "desc12", "desc13", "desc14", "desc15", "desc16", "desc17", "desc18", "desc19", "desc20", "desc21",
        "desc22" };
    final String[] pathsImg = { "path1", "path2", "path3", "path4", "path5", "path6", "path7", "path8", "path9",
        "path10", "path11", "path12", "path13", "path14", "path15", "path16", "path17", "path18", "path19", "path20",
        "path21", "path22" };

    int choiceIdCard = 0;
    boolean idValid = false;
    boolean nameValid = false;
    int searchChoice = 0;
    Card matchedCard = null;
    Deck deckUser = new Deck();
    Deck oldDeckUser = null;

    game = new Window();
    game.validate();
		game.setVisible(true);

    File file = new File("DeckTest");
    if (file.length() == 0) {
    } else {
      try {
        FileInputStream fileInputStream = new FileInputStream("DeckTest");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        oldDeckUser = (Deck) objectInputStream.readObject();
        oldDeckUser.showDeck();

        fileInputStream.close();
        objectInputStream.close();
        deckUser = oldDeckUser;

      } catch (IOException | ClassNotFoundException e) {
        // e.printStackTrace();
      }
    } 


    // Menu
    System.out.println("Welcome! Want to know what the future holds for you ? It's here");
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("Here are your different options");
      System.out.println("1) Add classics cards to your deck");
      System.out.println("2) Add a new card");
      System.out.println("3) Add a description to a new card");
      System.out.println("4) Read the cards");
      System.out.println("5) Modify a card");
      System.out.println("6) Search into the deck of cards");
      System.out.println("7) Add an image to your card");
      System.out.println("8) Delete a card");
      System.out.println("0) Enter 0 to exit the menu");
      choice = scanner.nextInt();

      if (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
          && choice != 7 && choice != 8) {
        System.out.println(" || You must choose a number in the list");
      } else {
        switch (choice) {
          case 0:
          try {
            FileOutputStream fileOutputStream = new FileOutputStream("DeckTest");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(deckUser);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            break;
          case 1:
            for (int n = 0; n < names.length; n++) {
              String name = names[n];
              int id = theId[n];
              String desc = descs[n];
              String pathImg = pathsImg[n];
              deckUser.addCompleteCardToDeck(name, id, desc, pathImg);
            }
            break;
          case 2:
            System.out.println("Insert the name of your new card");
            choiceName = scanner.next();
            // Create a test for the id and the name;
            System.out.println("Insert the id of your new card");
            choiceId = scanner.nextInt();

            Card newCard = new Card(choiceName, choiceId);

            try {
              deckUser.addCardToDeck(newCard);
              System.out.println("<--- Here is you new deck --->");
              deckUser.showDeck();
            } catch (Exception e) {
              System.out.println(e);
            }

            break;
          case 3:
            // Create a test for the id and the name;
            System.out.println("Insert the name of your new card");
            choiceName = scanner.next();
            System.out.println("Insert the id of your new card");
            choiceId = scanner.nextInt();
            System.out.println("Insert the description of your new card");
            choiceDescription = scanner.next();
            System.out.println("Insert the image path of your new card");
            choiceImgPath = scanner.next();
            Card newCard2 = new Card(choiceName, choiceId, choiceDescription, choiceImgPath);
            try {
              deckUser.addCardToDeck(newCard2);
              System.out.println("<--- Here is you new deck --->");
              deckUser.showDeck();
            } catch (Exception e) {
              System.out.println(e);
            }
            break;
          case 4:
            System.out.println("<-------- Reading the deck -------->");
            try {
              deckUser.showDeck();
            } catch (Exception e) {
              System.out.println(e);
            }
            break;
          case 5:
            do {
              System.out.println("What card do you want to modify in this deck, insert the id of it");
              choiceIdCard = scanner.nextInt();

              // while (idValid == false) {
              for (Card card : deckUser.cardDeck) {
                int idCard = card.setIdCard(card);
                if (idCard == choiceIdCard) {
                  idValid = true;
                  matchedCard = card;
                  update(deckUser, card);
                  break;
                } else {
                  idValid = false;
                }
              }
              if (matchedCard != null) {
              } else {
                System.out.println("Id invalid, please try with an another id present in the list behind");
                deckUser.showDeck();
              }
              // }
            } while (matchedCard == null);

            break;
          case 6:

            do {
              System.out.println("Search card by (choose a number in the list behind) :");
              System.out.println("1) Id of the card");
              System.out.println("2) Name of the card");
              searchChoice = scanner.nextInt();
            } while (searchChoice != 1 && searchChoice != 2);

            if (searchChoice == 1) {
              deckUser.searchById();
            } else {
              deckUser.searchByName();
            }

            break;
          case 7:
            do {
              System.out.println("To what card do you want to add an image, insert its id ?");
              int idchoiceUser = scanner.nextInt();

              for (Card card : deckUser.cardDeck) {
                int idCard = card.setIdCard(card);
                if (idCard == idchoiceUser) {
                  idValid = true;
                  matchedCard = card;
                  matchedCard.addImg();
                  break;
                } else {
                  idValid = false;
                }
              }
              if (matchedCard != null) {
              } else {
                System.out.println("Id invalid, please try with an another id present in the list behind");
                deckUser.showDeck();
              }
            } while (matchedCard == null);

            break;
          case 8:
            System.out.println("Insert the id of the card you want to delete");
            int idchoiceUser = scanner.nextInt();

            deckUser.deleteCard(idchoiceUser);
            break;
        }
      }
    } while (choice != 0);
  }

  public static void update(Deck deckUser, Card theCard) {
    String choiceNewName = "";
    int choiceNewId = 0;
    String choiceNewDesc = "";
    boolean nameValid = false;
    boolean idValid = false;
    Card matchedCardName = null;
    Card matchedCardId = null;

    int choiceCharacteristic;

    do {
      Scanner scanner2 = new Scanner(System.in);
      System.out.println("What do you want to modify in this card, choose a number in the list");
      System.out.println("1) The card name");
      System.out.println("2) The card id");
      System.out.println("3) The card description");
      System.out.println("0) Come back to the main menu");
      choiceCharacteristic = scanner2.nextInt();

      if (choiceCharacteristic != 1 && choiceCharacteristic != 2 && choiceCharacteristic != 3
          && choiceCharacteristic != 0) {
        System.out.println(" || You must choose a number in the list");
      } else {
        switch (choiceCharacteristic) {
          case 0:
            break;
          case 1:
            do {
              System.out.println("What name do you want to give to your card ?");
              choiceNewName = scanner2.next();
              for (Card card : deckUser.cardDeck) {
                if (card.getNameCard().equalsIgnoreCase(choiceNewName)) {
                  nameValid = false;
                  matchedCardName = card;
                } else {
                  nameValid = true;
                }
              }
              if (matchedCardName != null) {
                System.out.println("Name already taken, choose an another name, except those from the list behind ");
                deckUser.showDeck();
              } else {
                System.out.println("Name valid");
              }
            } while (matchedCardName != null);

            if (nameValid == true) {
              theCard.changeName(choiceNewName);
            }

            break;
          case 2:
            do {
              System.out.println("What id do you want to give to your card ?");
              choiceNewId = scanner2.nextInt();
              for (Card card : deckUser.cardDeck) {
                if (card.setIdCard(card) == choiceNewId) {
                  idValid = false;
                  matchedCardId = card;
                } else {
                  idValid = true;
                }
              }
              if (matchedCardId != null) {
                System.out.println("Id already taken, choose an another id, except those from the list behind ");
                deckUser.showDeck();
              } else {
                System.out.println("Id valid");
              }
            } while (matchedCardId != null);

            if (idValid == true) {
              theCard.changeId(choiceNewId);
            }
            break;
          case 3:
            System.out.println("What description do you want to give to your card ?");
            choiceNewDesc = scanner2.next();
            theCard.changeDesc(choiceNewDesc);

            break;
        }
      }
    } while (choiceCharacteristic != 0);
  }
}