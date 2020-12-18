package gameInterface;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;

import game.Card;
import game.Deck;

public class ReadCardsPanel extends JPanel {

    private static final long serialVersionUID = 6L;
    Deck userDeck;
    String pathImg;
    ArrayList<Card> userDeckArrayList;

    public ReadCardsPanel(Deck deckUser) {
       JPanel showCards = new JPanel();
        this.userDeck = deckUser;
        this.userDeckArrayList = userDeck.getDeckArrayList();
        this.setLayout(new BorderLayout(2,1));

        JScrollPane scroll = new JScrollPane(showCards, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        showCards.setLayout(new FlowLayout());
        showCards.setPreferredSize(new Dimension(1000, 1000));
        scroll.setSize(15, 800);

        for (Card card : userDeckArrayList) {

            String pathOutputImg = "src\\img\\" + card.getNameCard() + ".jpg";
            pathImg = card.getImgCard();
            DisplayImage imgDisplay = new DisplayImage(pathImg, pathOutputImg);
            showCards.add(imgDisplay);
        } 

        JViewport vw = new JViewport();
        vw.add("View", showCards);
        scroll.setViewport(vw);
        scroll.validate();

        // this.add(showCards,BorderLayout.CENTER);
        this.add(scroll);

    }
}
