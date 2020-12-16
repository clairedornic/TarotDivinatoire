package gameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Deck;
import game.Main;

public class addClassicCardsPanel extends JPanel {

    private static final long serialVersionUID = 11L;
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
    JLabel test;

    public addClassicCardsPanel() {
        for (int n = 0; n < names.length; n++) {
            String name = names[n];
            int id = theId[n];
            String desc = descs[n];
            String pathImg = pathsImg[n];
            Main.deckUser.addCompleteCardToDeck(name, id, desc, pathImg);
          }
          panelElements();
    }

    private void panelElements() {
        JLabel empty;
        JLabel noEmpty;
        if (deckUser.isEmpty() == true)  {
            empty = new JLabel("Classic cards have not been added to the deck.");
            this.add(empty);
        } else {
            noEmpty = new JLabel("Classic cards have been added to your deck!");
            this.add(noEmpty);
        }
    }

}
