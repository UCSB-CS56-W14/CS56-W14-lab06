package edu.ucsb.cs56.w14.drawings.cantor.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   A viewer class that animated warningsigns moving around

   @author Antonio Cantor
   @version for UCSB CS56, W14, 03/10/2014
*/

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private WarningSign warningsign = new WarningSign(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 0;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the warningsign
          g2.setColor(Color.GREEN);
          WarningSign ws = new WarningSign(x, y, x, y);
          g2.draw(ws);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400){ 
				dx = -5; 
				dy = -5;}
			else if (y>= 400){
				dx = -5;
				dy = -5;}
            if (x <= 50){ 
				dx = 5; 
				dy = 0;}
			else if (y<=50){
				dx = 0;
				dy = 5;}     
            x += dx;    
			y += dy;            
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
