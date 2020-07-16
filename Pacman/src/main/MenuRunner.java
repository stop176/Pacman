package main;



import javax.swing.*;
import java.awt.*;

public class MenuRunner extends JFrame
{
    private JFrame frame;
    private MenuButton panel;
    
    public MenuRunner(){
    //the menu screen for starting the game
        frame = new JFrame("menu screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new MenuButton();
        panel.setPreferredSize(new Dimension(448,576));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel);
        
    }
  
    public void display(){
        frame.pack();
        frame.setVisible(true);
    }
}
