package gameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

import game.Card;

public class AddCardPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 11L;
    JButton save; 
    JTextField name;
    JLabel nameLabel;
    JTextField id;
    JLabel idLabel;
    JTextArea desc;
    JLabel descLabel;
    JScrollPane scrollArea;

	public AddCardPanel() {
        panelElements();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(150,200,150,150));
        this.setVisible(true);

    }

    private void panelElements() {

        // System.out.println("Insert the name of your new card");
        // choiceName = scanner.next();
        // // Create a test for the id and the name;
        // System.out.println("Insert the id of your new card");
        // choiceId = scanner.nextInt();


        nameLabel = new JLabel("Name");
        name = new JTextField(30);
        nameLabel.setBounds(65, 31, 0, 0);
        name.setBounds(50,100, 200,30); 

        idLabel = new JLabel("Id");
        id = new JTextField(30);
        id.setBounds(50,100, 200,30);

        descLabel = new JLabel("Description");
        desc = new JTextArea(5, 25);
        scrollArea = new JScrollPane(desc);

        save = new JButton("Save your card");
        save.addActionListener(this);


        this.add(nameLabel);
        this.add(name);
        this.add(idLabel);
        this.add(id);
        this.add(descLabel);
        this.add(scrollArea);
        this.add(save);
    }

    @Override
	public void actionPerformed(ActionEvent e) {

        String nameCard = name.getText(); 
        String idCard = id.getText();
        int idCardInt = Integer.parseInt(idCard);  
        String descCard = desc.getText();   
        Card newCard = new Card(nameCard, idCardInt, descCard);
    }
}
