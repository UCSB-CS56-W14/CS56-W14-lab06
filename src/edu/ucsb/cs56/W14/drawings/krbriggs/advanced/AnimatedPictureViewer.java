package edu.ucsb.cs56.w14.drawings.krbriggs.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private SantaWithHat santa = new SantaWithHat(400, 50, 19);
    
    Thread anim;   
    
    private int x = 300;
    private int y = 100;
    
    private int dy = 5;

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

	//random colors
	  int R = (int)(Math.random()*256);
	int G = (int)(Math.random()*256);
	int B= (int)(Math.random()*256);
	Color color = new Color(R, G, B); //random color, but can be bright or dull

	

          // Draw the santa
	//random thickness
	float ra = (float)(Math.random()*10);
	Stroke thick = new BasicStroke (ra, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
          g2.setColor(color);
          SantaWithHat test = new SantaWithHat(x, y, 19);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (y >= 350) { dy = -5; }
            if (y <= 50) { dy = 5; }
            
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
