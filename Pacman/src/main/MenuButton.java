package main;


/**
 * Write a description of class GraphicsDay4Panel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuButton extends JPanel implements ActionListener

{
    private JButton button1;
    private JButton button2;
    private RunnerFrame frame;
private boolean ifPressed;
    public MenuButton()
    {
    	setFocusable(true);
       frame = new RunnerFrame();
        button1 = new JButton("Press To Start Game");
        //detects if the button is clicked
        button1.addActionListener(this);
        add(button1);

        
    
    }
  

    public void actionPerformed(ActionEvent e)
    {
        
        //displays the main game if the button is clicked
       frame.display();
        
      

    }
    

    public void paint(Graphics g)
    {
        super.paint(g);
        //instructions
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Welcome to Pacman!", 100, 100);
         g.setFont(new Font("Arial", Font.BOLD, 15));
        
        System.out.println("reached paint in MenuButton");
             
    }

}
