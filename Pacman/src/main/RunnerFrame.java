package main;


import javax.swing.*;
import java.awt.*;

public class RunnerFrame extends JFrame
{

    private JFrame frame;
    private GraphicsDay2Panel panel;
  
    public RunnerFrame()
    {
        //title of the game
        frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//creates an instance of a panel
        panel = new GraphicsDay2Panel();
        //panel size
        panel.setPreferredSize(new Dimension(448,576));
        frame.getContentPane().add(panel);
        
        
      
    
   
    }

    public void display()
    {
        //puts the panel into the dimensions
        frame.pack();
        //displays the panel
        frame.setVisible(true);

    }

    public static void main(String[]args)
    {
        RunnerFrame game = new RunnerFrame();
        //displays the frame for the panel
        game.display();

    }
}