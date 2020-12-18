package gameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
// import javax.swing.border.EmptyBorder;

import game.Card;
import game.Deck;

public class AddCardPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 11L;
    JButton save; 
    JTextField name;
    JLabel nameLabel;
    JTextField id;
    JLabel idLabel;
    JButton img;
    JLabel imgLabel;
    JLabel imgLabel2;
    JTextArea desc;
    JLabel descLabel;
    JScrollPane scrollArea;
    Deck userDeck;
    JLabel addedCard;
    String pathImgchoix;

	public AddCardPanel(Deck deckUser) {
        panelElements();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(150,200,150,150));
        this.setVisible(true);
        this.userDeck = deckUser;
    }

    private void panelElements() {

        nameLabel = new JLabel("Name");
        name = new JTextField(5);
        // name.setBorder(new EmptyBorder(2, 10, 10, 10));

        idLabel = new JLabel("Id");
        id = new JTextField();

        imgLabel = new JLabel("Click here to choose the card image :");
        imgLabel2 = new JLabel("");
        img = new JButton("Pick an image on your computer");
        img.addActionListener(this);

        descLabel = new JLabel("Description");
        desc = new JTextArea(5, 10);
        scrollArea = new JScrollPane(desc);

        save = new JButton("Save your card");
        save.addActionListener(this);

        addedCard = new JLabel("");

        this.add(nameLabel);
        this.add(name);
        this.add(idLabel);
        this.add(id);
        this.add(imgLabel);
        this.add(imgLabel2);
        this.add(img);
        this.add(descLabel);
        this.add(scrollArea);
        this.add(save);
        this.add(addedCard);

    }

    @Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            String nameCard = name.getText(); 
            String idCard = id.getText();
            int idCardInt = Integer.parseInt(idCard);  
            String descCard = desc.getText();   
            Card newCard = new Card(nameCard, idCardInt, descCard, pathImgchoix);
    
            try {
                userDeck.addCardToDeck(newCard);
                addedCard.setText("Card has been added to the deck!");
              } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == img){
            System.out.println("YES");
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
                 // nom du fichier  choisi 
                imgLabel2.setText(choice.getSelectedFile().getName());
                // absolute path of the chosen file
                pathImgchoix = choice.getSelectedFile().getAbsolutePath();
            }else {
                System.out.println("NOP");
            } 
        }
    }
}




