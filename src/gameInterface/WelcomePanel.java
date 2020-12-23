package gameInterface;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
    private static final long serialVersionUID = 3L;
    JLabel label;
    JLabel space;
    JLabel rules;
    JLabel choice1;
    JLabel space2;

    public WelcomePanel(){
        super();
        this.welcomeElements();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
        this.setVisible(true);
    }

     /** 
	* Add components to the Main panel
	*  
    *
	*/
    private void welcomeElements() {
        
        label = new JLabel("Welcome, let's play to Mystic Tarot");
        space = new JLabel("                                              ");
        choice1 = new JLabel("To begin you should add cards to your deck. You can do that in the menu above");
        space2 = new JLabel("                                              ");
        rules = new JLabel("Click on the menu item and then choose what do you want to do!");

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        space.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        space.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        choice1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        choice1.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        space2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        space2.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        rules.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        rules.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        this.add(label);
        this.add(space);
        this.add(choice1);
        this.add(space2);
        this.add(rules);
    }
}
