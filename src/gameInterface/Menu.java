package gameInterface;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import  java.awt.event.*;

public class Menu extends JPanel {

    private static final long serialVersionUID = 3L;
    JLabel label;
    JLabel space;
    JLabel choice1;
    JLabel space2;
    JButton classicCards;
    JLabel space3;
    JButton addCard;

    public Menu(){
        super();
        this.menuElements();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
        this.setVisible(true);
    }

    private void menuElements() {
        
        label = new JLabel("Welcome, let's play to Mystic Tarot");
        space = new JLabel("                                              ");
        choice1 = new JLabel("First, what do you want to do ?");
        space2 = new JLabel("                                              ");
        classicCards = new JButton("Add classics cards to your deck");
        space3 = new JLabel("                                              ");
        addCard = new JButton("Add a card");

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        space.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        space.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        choice1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        choice1.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        classicCards.setAlignmentX(JButton.CENTER_ALIGNMENT);
        classicCards.setAlignmentY(JButton.CENTER_ALIGNMENT);
        addCard.setAlignmentX(JButton.CENTER_ALIGNMENT);
        addCard.setAlignmentY(JButton.CENTER_ALIGNMENT);

        this.add(label);
        this.add(space);
        this.add(choice1);
        this.add(space2);
        this.add(classicCards);
        this.add(space3);
        this.add(addCard);

        classicCards.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
            }
        });
    }
}
