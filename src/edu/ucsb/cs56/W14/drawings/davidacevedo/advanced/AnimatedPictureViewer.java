package edu.ucsb.cs56.w14.drawings.davidacevedo.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Donut donut;
	private Donut donut2;
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
	private int x2 = 100;
	private int y2 = 340;
    
    private int dx;
	private int dx2;

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
          g2.setColor(Color.black);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Donut
          g2.setColor(Color.RED);
          donut = new Donut(x, y, 100);
          g2.draw(donut);
		  donut2 = new Donut(x2, y2, 100);
		  g2.draw(donut2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls and race each other

            if (x >= 520) { dx = -5;}
            if (x <= 100) { dx = 5; }
            if (x2 >= 520) { dx2 = -10;}
            if (x2 <= 100) { dx2 = 10; }

            
            x += dx;
			x2 += dx2;
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
