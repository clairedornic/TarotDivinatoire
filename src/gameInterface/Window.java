package gameInterface;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    private static final long serialVersionUID = 3L;
    WelcomePanel welcome;

    public Window() {
        super();
        windowProperties();
        windowComponents();
    }

    private void windowProperties() {
        this.setSize(1300, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setAlwaysOnTop(true);
    }

    private void windowComponents() {
        welcome = new WelcomePanel();
        this.add(welcome);
        Menu menuBar = new Menu();                
        setJMenuBar(menuBar);            
        pack();
        setVisible(true);
    }

    public java.awt.Container getCurrentContainer() {
        return this.getContentPane();
      }
}
