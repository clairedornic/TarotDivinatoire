package game;

import gameInterface.Window;

public class Main {

  public static Window game = null;

  public static void main(String[] args) throws Exception {

    //Create the window to start the game
    game = new Window();
    game.validate();
    game.setVisible(true);


    //Deserialisation

    // File file = new File("DeckTest");
    // if (file.length() == 0) {
    // } else {
    //   try {
    //     FileInputStream fileInputStream = new FileInputStream("DeckTest");
    //     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    //     oldDeckUser = (Deck) objectInputStream.readObject();
    //     oldDeckUser.showDeck();

    //     fileInputStream.close();
    //     objectInputStream.close();
    //     deckUser = oldDeckUser;

    //   } catch (IOException | ClassNotFoundException e) {
    //   }
    // } 

    //Serialisation 
    
    // try {
    //   FileOutputStream fileOutputStream = new FileOutputStream("DeckTest");
    //   ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    //   objectOutputStream.writeObject(deckUser);

    //   fileOutputStream.close();
    //   objectOutputStream.close();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }    
  }
}