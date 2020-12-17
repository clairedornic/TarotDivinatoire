package gameInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Deck;

public class addClassicCardsPanel extends JPanel {

    private static final long serialVersionUID = 11L;
    final String[] names = { "Bateleur", "Papesse", "Impératrice", "Empereur", "Pape", "Amoureux", "Chariot", "Justice",
        "Hermite", "Roue de fortune", "Force", "Pendu", "Mort", "Tempérance", "Diable", "Maison dieu",
        "Étoile", "Lune", "Soleil", "Jugement", "Monde", "Mat" };
    final int[] theId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
    final String[] descs = { "desc1", "desc2", "desc3", "desc4", "desc5", "desc6", "desc7", "desc8", "desc9", "desc10",
        "desc11", "desc12", "desc13", "desc14", "desc15", "desc16", "desc17", "desc18", "desc19", "desc20", "desc21",
        "desc22" };
    final String[] pathsImg = { "src\\img\\1-bateleur.jpg", "src\\img\\2-papesse.jpg", "src\\img\\3-imperatrice.jpg", "src\\img\\4-empereur.jpg", "src\\img\\5-pape.jpg", "src\\img\\6-amoureux.jpg", "src\\img\\7-chariot.jpg", "src\\img\\8-justice.jpg", "src\\img\\9-hermite.jpg",
        "src\\img\\10-roue-fortune.jpg", "src\\img\\11-force.jpg", "src\\img\\12-pendu.jpg", "src\\img\\13-mort.jpg", "src\\img\\14-temperance.jpg", "src\\img\\15-diable.jpg", "src\\img\\16-maison-dieu.jpg", "src\\img\\17-etoile.jpg", "src\\img\\18-lune.jpg", "src\\img\\19-soleil.jpg", "src\\img\\20-jugement.jpg",
        "src\\img\\21-monde.jpg", "src\\img\\22-mat.jpg" };
    JLabel test;
    Deck userDeck;
    
    public addClassicCardsPanel(Deck deckUser) {
        this.userDeck = deckUser;
        for (int n = 0; n < names.length; n++) {
            String name = names[n];
            int id = theId[n];
            String desc = descs[n];
            String pathImg = pathsImg[n];
            userDeck.addCompleteCardToDeck(name, id, desc, pathImg);
          }
          panelElements();
    }

    private void panelElements() {
        JLabel empty;
        JLabel noEmpty;
        if (userDeck.isEmpty() == true)  {
            empty = new JLabel("Classic cards have not been added to the deck.");
            this.add(empty);
        } else {
            noEmpty = new JLabel("Classic cards have been added to your deck!");
            this.add(noEmpty);
        }
    }

}
