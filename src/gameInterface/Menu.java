package gameInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Menu extends JPanel {

    private static final long serialVersionUID = 3L;
    JLabel label = new JLabel("Welcome, let's play to Mystic Tarot");
    JLabel space = new JLabel("                                              ");
    JLabel choice1 = new JLabel("First, what do you want to do ?");
    JButton classicCards  = new JButton("Add classics cards to your deck");
    JButton addCard  = new JButton("Add a card");
    JPanel menuPanel = new JPanel();

    public Menu(){
        menuPanel.setSize(1300, 700);
        menuPanel.setLayout(new GridLayout(4,2));
        menuPanel.add(label);
        menuPanel.add(space);
        menuPanel.add(choice1);
        menuPanel.add(classicCards);
        menuPanel.add(addCard);
    }
}
