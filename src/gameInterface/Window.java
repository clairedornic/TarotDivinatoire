package gameInterface;

import java.awt.Dimension;

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
        this.setPreferredSize(new Dimension(1100, 700));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLocationRelativeTo(null); 
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
}
