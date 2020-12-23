package gameInterface;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import game.Card;
import game.Deck;

public class SearchOrDeleteCardPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 18L;
    Deck userDeck;
    String pathImg;
    ArrayList<Card> userDeckArrayList;
    Card matchedCard = null;

    //JPanels 
    JPanel showCard;
    JPanel searchCard;
    JPanel infosCard;
    JPanel imgCard;

   //Search components
    JLabel searchText;
    JTextField name;
    JButton search; 

    //Show Card component 
    JLabel searchOk;

    //Card info components
    JLabel nameInfo;
    JLabel nameCard;
    JLabel idInfo;
    JLabel idCard;
    JLabel descInfo;
    JLabel descCard;

    //Card img component
    DisplayImage imgDisplay;
    
    // Delete the card
    JButton deleteCard;
    JLabel checkDelete;
    Boolean booleanCheck;

    public SearchOrDeleteCardPanel(Deck deckUser, String introText, Boolean check) {
        booleanCheck = check;

        showCard = new JPanel();
        searchCard = new JPanel();
        infosCard = new JPanel();
        imgCard = new JPanel();

        this.userDeck = deckUser;
        this.userDeckArrayList = userDeck.getDeckArrayList();
        this.setLayout(new GridLayout(1,2)); //Main Panel

        searchCard.setLayout(new BoxLayout(searchCard, BoxLayout.PAGE_AXIS));
        showCard.setLayout(new BorderLayout());
        infosCard.setLayout(new GridBagLayout());
        imgCard.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        searchCard.setBorder(BorderFactory.createEmptyBorder(300,50,300,50));
        showCard.setBorder(BorderFactory.createEmptyBorder(150,50,150,50));

        //Create search panel components 
        searchText = new JLabel(introText);
        name = new JTextField();
        search = new JButton("Search");
        search.addActionListener(this);

        searchCard.add(searchText);
        searchCard.add(name);
        searchCard.add(search);

        //Create infos Card panel components 
        searchOk = new JLabel("");
        nameInfo = new JLabel("Name : ");
        nameCard = new JLabel("");
        idInfo = new JLabel("ID : ");
        idCard = new JLabel("");
        descInfo = new JLabel("Description : ");
        descCard = new JLabel("");
        deleteCard = new JButton("Delete this card");
        deleteCard.addActionListener(this);

        //Layout of the panel 
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        infosCard.add(nameInfo, left);
        infosCard.add(nameCard, right);
        infosCard.add(idInfo, left);
        infosCard.add(idCard, right);
        infosCard.add(descInfo, left);
        infosCard.add(descCard, right);

        //Add components to the panel which display the found card
        showCard.add(searchOk, BorderLayout.PAGE_START);
        showCard.add(infosCard, BorderLayout.LINE_START);
        showCard.add(imgCard, BorderLayout.LINE_END);
        
         //Add panels to the main panels
        this.add(searchCard);
        this.add(showCard);
    }

    /** 
	*  Clicking on the buttons allows you to search for a card and then delete it.
	*  
    * @param e 
    *
	*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            String nameCardSearch = name.getText(); 
            boolean nameValid = false;

            for (Card card : userDeckArrayList) {
                String nameCard = card.getNameCard();
                if (nameCard.equalsIgnoreCase(nameCardSearch)) {
                    nameValid = true;
                    matchedCard = card;
                } else {
                    nameValid = false;
                }
            }	
            if(matchedCard == null) {
                searchOk.setText("Name invalid, please try to search a card with an another name!");
            } else {
                searchOk.setText("Name valid, here are all informations about your card");
                nameCard.setText(matchedCard.getNameCard());
                String idString = Integer.toString(matchedCard.getIdCard());
                idCard.setText(idString);
                descCard.setText(matchedCard.getDescCard());
                displayMatchedCardImg(matchedCard);
                if(booleanCheck == true) {
                    showCard.add(deleteCard, BorderLayout.PAGE_END);
                }
                
            }
        }else if (e.getSource() == deleteCard) {
            try {
                userDeck.deleteCard(matchedCard.getIdCard());
                searchOk.setText("Card deleted");
            } catch (Exception x) {
                System.out.println(x);
            }   
        }
    }

     /** 
	* Retrieve the image path then call the function to display the image and finally add the image to the selected card
	*  
    * @param card       
    *
	*/
    public void displayMatchedCardImg(Card card) { 
        String imgPath = card.getImgCard();
        String pathOutputImg = "src\\img\\" + card.getNameCard() + ".jpg";
        imgDisplay = new DisplayImage(imgPath, pathOutputImg);
        imgCard.add(imgDisplay);
    }
}
