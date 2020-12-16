package gameInterface;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    private static final long serialVersionUID = 3L;
    Menu menu;

    public Window() {
        super();
        windowProperties();
    }

    private void windowProperties() {
        this.setSize(1300, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setAlwaysOnTop(true);
        menu = new Menu();
        this.add(menu);
    }
}
