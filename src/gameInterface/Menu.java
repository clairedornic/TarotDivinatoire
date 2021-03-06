package gameInterface;

import game.Deck;
import game.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JMenuBar implements ActionListener {

    private static final long serialVersionUID = 4L;
    JMenu menuBar;
    JMenuItem home, addClassicCards, addCard, readCards, modifyCard, searchCard, deleteCard, exitGame;
    Deck deckUser = new Deck();
    String introText;
    Boolean check;
    
    public Menu(){
        super();
        menuBar = new JMenu("Menu");
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.PAGE_AXIS));
        menuBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        menuElements();
        this.add(menuBar);
        this.setVisible(true);
    }

    /** 
	* Creation of the menu 
	*  
	*/
    private void menuElements() {
        home = new JMenuItem("Back to home page");
        addClassicCards = new JMenuItem("Add classic cards");
        addCard = new JMenuItem("Add cards");
        readCards = new JMenuItem("See my cards");
        modifyCard = new JMenuItem("Modify a card");
        searchCard = new JMenuItem("Search a card");
        deleteCard = new JMenuItem("Delete a card");

        home.addActionListener(this);
        addClassicCards.addActionListener(this);
        addCard.addActionListener(this);
        readCards.addActionListener(this);
        modifyCard.addActionListener(this);
        searchCard.addActionListener(this);
        deleteCard.addActionListener(this);

        this.add(home);
        this.add(addClassicCards);
        this.add(addCard);
        this.add(readCards);
        this.add(modifyCard);
        this.add(searchCard);
        this.add(deleteCard);
    }


    /** 
    * The event displays a new panel according to the button clicked
    *
    * @param e    
	*/
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == home) {
			JPanel panel = new WelcomePanel();
			displayNewPanel(panel);
        } 
        else if(e.getSource() == addClassicCards) {
			JPanel panel = new AddClassicCardsPanel(deckUser);
			displayNewPanel(panel);
		}
        else if(e.getSource() == addCard) {
			JPanel panel = new AddCardPanel(deckUser);
			displayNewPanel(panel);
		}
		else if(e.getSource() == readCards) {
			JPanel panel = new ReadCardsPanel(deckUser);
			displayNewPanel(panel);
		}
		else if(e.getSource() == modifyCard) {
			
			JPanel panel = new ModifyCard(deckUser);
			displayNewPanel(panel);
		}
		else if(e.getSource() == searchCard) {
            introText = "Insert here the name of the card you are looking for in your deck!";
            check = false;
			JPanel panel = new SearchOrDeleteCardPanel(deckUser, introText, check);
			displayNewPanel(panel);
        }
        else if(e.getSource() == deleteCard) {
            introText = "Insert here the name of the card you want to delete!";
            check = true;
			JPanel panel = new SearchOrDeleteCardPanel(deckUser, introText, check);
			displayNewPanel(panel);
        }
        else {
            JPanel panel = new WelcomePanel();
            displayNewPanel(panel);
        }
    }
    
    /** 
	* Simulation of a window refresh to display the new panel
	*  
    * @param panel       
    *
	*/
    private void displayNewPanel(JPanel panel) {
        Main.game.getContentPane().removeAll();
	    Main.game.getContentPane().add(panel);
	    Main.game.getContentPane().invalidate();
	    Main.game.getContentPane().validate();
        Main.game.getContentPane().repaint();
	}
}
