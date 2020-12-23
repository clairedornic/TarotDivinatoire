package gameInterface;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import game.Card;
import game.Deck;

public class ModifyCard extends JPanel implements ActionListener {

    private static final long serialVersionUID = 8L;
    Deck userDeck;
    String pathImg;
    ArrayList<Card> userDeckArrayList;
    Card matchedCard = null;

    //JPanels 
    JPanel mainPanel;
    JPanel searchCard;
    JPanel modifyCard;
    JPanel insertIdPanel;
    JPanel selectedCard;
    JPanel selectedCardInfosPanel;
    JPanel selectedCardImgPanel;
    JPanel modifyInfosCardPanel;

    //Search components
    JLabel searchText;
    JTextField id;
    JButton search; 

    //Selected Card components
    JLabel searchOk;
    JButton startModifyInput;

    //Show Card component 
    JLabel nameInfo;
    JLabel nameCard;
    JLabel idInfo;
    JLabel idCard;
    JLabel descInfo;
    JLabel descCard;
    

     //Card img component
    DisplayImage imgDisplay;
    String imgPathCard = "";


    // Modify Card components
    JLabel modifyText;
    JButton modifyCardButton;

    //Mofify infos Card components 
    JLabel modifyName;
    JTextField newName;
    JLabel modifyId;
    JTextField newId;
    JLabel modifyDesc;
    JTextArea newDesc;
    JLabel modifyPathImg;
    JButton modifyImgPath;



    public ModifyCard(Deck deckUser) {
        mainPanel = new JPanel();
        searchCard = new JPanel();
        modifyCard = new JPanel();
        insertIdPanel = new JPanel();
        selectedCard = new JPanel();
        selectedCardInfosPanel = new JPanel();
        selectedCardImgPanel = new JPanel();
        modifyInfosCardPanel = new JPanel();

        this.userDeck = deckUser;
        this.userDeckArrayList = userDeck.getDeckArrayList();

        //Set Layout
        mainPanel.setLayout(new GridLayout(1,2));
        searchCard.setLayout(new BoxLayout(searchCard, BoxLayout.PAGE_AXIS));
        modifyCard.setLayout(new BorderLayout());
        insertIdPanel.setLayout(new BoxLayout(insertIdPanel, BoxLayout.PAGE_AXIS));
        selectedCard.setLayout(new BorderLayout());
        selectedCardInfosPanel.setLayout(new GridBagLayout());
        selectedCardImgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        modifyInfosCardPanel.setLayout(new GridBagLayout());

        //Borders
        searchCard.setBorder(BorderFactory.createEmptyBorder(150,50,150,50));
        modifyCard.setBorder(BorderFactory.createEmptyBorder(150,50,150,50));

        //Create components of each panel
        //InsertId Panel 
        searchText = new JLabel("Insert below the ID of the card you want to modify :");
        id = new JTextField();
        search = new JButton("Search");
        search.addActionListener(this);

        //selectedCardInfosPanel 
        searchOk = new JLabel(""); //Here are the infos of the card you want to modify
        nameInfo = new JLabel("Name : ");
        nameCard = new JLabel("");
        idInfo = new JLabel("ID : ");
        idCard = new JLabel("");
        descInfo = new JLabel("Description : ");
        descCard = new JLabel("");
        startModifyInput = new JButton("Modify this card");
        startModifyInput.addActionListener(this);
  
        // Modify Card Panel
        modifyText = new JLabel("Change here the informations about your card");
        modifyCardButton = new JButton("Save");
        modifyCardButton.addActionListener(this);

        //Mofify infos Card Panel
        modifyName = new JLabel("Name : ");
        newName  = new JTextField();
        modifyId = new JLabel("ID : ");
        newId  = new JTextField();
        modifyDesc = new JLabel("Description : ");
        newDesc  = new JTextArea();
        modifyPathImg = new JLabel("Image : ");
        modifyImgPath = new JButton("New image");
        modifyImgPath.addActionListener(this);
        

        //Add components to each panel
        // Search Panel

        insertIdPanel.add(searchText);
        insertIdPanel.add(id);
        insertIdPanel.add(search);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        selectedCardInfosPanel.add(nameInfo, left);
        selectedCardInfosPanel.add(nameCard, right);
        selectedCardInfosPanel.add(idInfo, left);
        selectedCardInfosPanel.add(idCard, right);
        selectedCardInfosPanel.add(descInfo, left);
        selectedCardInfosPanel.add(descCard, right);
        
        selectedCard.add(searchOk, BorderLayout.PAGE_START);
        selectedCard.add(selectedCardInfosPanel, BorderLayout.LINE_START);
        selectedCard.add(selectedCardImgPanel, BorderLayout.LINE_END);

        searchCard.add(insertIdPanel);
        searchCard.add(selectedCard);

        // Modify Panel
        GridBagConstraints leftBis = new GridBagConstraints();
        leftBis.anchor = GridBagConstraints.EAST;
        GridBagConstraints rightBis = new GridBagConstraints();
        rightBis.weightx = 2.0;
        rightBis.fill = GridBagConstraints.HORIZONTAL;
        rightBis.gridwidth = GridBagConstraints.REMAINDER;
        modifyInfosCardPanel.add(modifyName, leftBis);
        modifyInfosCardPanel.add(newName, rightBis);
        modifyInfosCardPanel.add(modifyId, leftBis);
        modifyInfosCardPanel.add(newId, rightBis);
        modifyInfosCardPanel.add(modifyDesc, leftBis);
        modifyInfosCardPanel.add(newDesc, rightBis);
        modifyInfosCardPanel.add(modifyPathImg, leftBis);
        modifyInfosCardPanel.add(modifyImgPath, rightBis);
    
        modifyCard.add(modifyText, BorderLayout.PAGE_START);
        modifyCard.add(modifyInfosCardPanel, BorderLayout.CENTER);
        modifyCard.add(modifyCardButton, BorderLayout.PAGE_END);

        modifyCard.setVisible(false);
        
        // Add panels to the main panel
        mainPanel.add(searchCard);
        mainPanel.add(modifyCard);
        this.add(mainPanel);
    }
   
    /** 
	*  Clicking on the buttons allows you to search for a card and then retrieve the information to modify in it.
	*  
    * @param e 
    *
	*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            String idCardSearch = id.getText(); 
            int idCardSearchInt = Integer.parseInt(idCardSearch);
            boolean idValid = false;

            for (Card card : userDeckArrayList) {
                int idCard = card.getIdCard();
                if (idCard == idCardSearchInt) {
                    idValid = true;
                    matchedCard = card;
                } else {
                    idValid = false;
                }
            }	
            if(matchedCard == null) {
                searchOk.setText("ID invalid, please try to search a card with an another ID!");
            } else {
                searchOk.setText("ID valid, here are all informations about your card");
                nameCard.setText(matchedCard.getNameCard());
                String idString = Integer.toString(matchedCard.getIdCard());
                idCard.setText(idString);
                descCard.setText(matchedCard.getDescCard());
                displayMatchedCardImg(matchedCard);
                selectedCard.add(startModifyInput, BorderLayout.PAGE_END);  
            }
        }else if (e.getSource() == startModifyInput) {
            modifyCard.setVisible(true);

        }else if (e.getSource() == modifyCardButton) {
            int idCardInt = 0;
            String nameCard = newName.getText(); 
            String idCard = newId.getText();
            if(idCard.length() != 0) {
                idCardInt = Integer.parseInt(idCard);  
            }
            String descCard = newDesc.getText();    
            try {
                if(nameCard.length() == 0 && idCard.length() == 0 && descCard.length() == 0 && imgPathCard.length() == 0) {
                    modifyText.setText("You did not modify any field");
                }else{
                    modifyText.setText("Card updated!");
                }
    
                if(nameCard.length() != 0) {
                    matchedCard.setCardName(nameCard);
                }
        
                 if(idCard.length() != 0) {
                     matchedCard.setCardId(idCardInt);
                }
        
                if(descCard.length() != 0) {
                    matchedCard.setCardDesc(descCard);
                }
        
                if(imgPathCard.length() != 0 ) {
                   matchedCard.setCardPathImg(imgPathCard);
                }

            } catch (Exception z) {
            System.out.println(z);
            }


        }else if (e.getSource() == modifyImgPath) {
            JFileChooser choice = new JFileChooser();
            choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
            choice.setMultiSelectionEnabled(false);

            //Setting Up The Filter
            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
            //Attaching Filter to JFileChooser object
            choice.setFileFilter(imageFilter);

            JDialog dialog = new JDialog();  
            int feedback = choice.showOpenDialog(this);
            if(feedback == JFileChooser.APPROVE_OPTION){
                // absolute path of the chosen file
                imgPathCard = choice.getSelectedFile().getAbsolutePath();
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
        selectedCardImgPanel.add(imgDisplay);
    }
}
