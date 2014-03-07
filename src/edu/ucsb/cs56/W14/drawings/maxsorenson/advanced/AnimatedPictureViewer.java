package edu.ucsb.cs56.w14.drawings.maxsorenson.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private TelevisionAntenna tv = new TelevisionAntenna(100, 100, 100, 100);
    
    Thread anim;   
    
	private int R, G, B;
	
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

	private int timesHitWall = 0;

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

          // Draw the Television
	      R = (int) (Math.random() * 255);
		  G = (int) (Math.random() * 255);
		  B = (int) (Math.random() * 255);
		  Color randomColor = new Color(R, G, B);
		Stroke thick = new BasicStroke (4.0f, 		BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);  
 	g2.setStroke(thick);
          g2.setColor(randomColor);
          TelevisionAntenna test = new TelevisionAntenna(x, y, 100, 100);
		  
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; dy = -5; timesHitWall++; }
            if (x <= 50) { dx = 5; dy = 5; timesHitWall++; }
            
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
