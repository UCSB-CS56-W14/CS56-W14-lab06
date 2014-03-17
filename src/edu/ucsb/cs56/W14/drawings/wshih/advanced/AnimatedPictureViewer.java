package edu.ucsb.cs56.w14.drawings.wshih.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
   
    Thread anim;   
    
    private int x1 = 100;
    private int y1 = 100;
    private int x2 = 400;
    private int y2 = 200;    
    private int x3 = 300;
    private int y3 = 300; 
    private int x4 = 500;
    private int y4 = 350; 
    
    private int dx1 = 7;
    private int dy1 = 7;
    private int dx2 = 10;
    private int dy2 = 10;
    private int dx3 = -5;
    private int dy3 = -5;
    private int dx4 = -6;
    private int dy4 = -8;

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

          // Draw the Circles
          CirclesWithSquares test1 = new CirclesWithSquares(x1, y1, 40, 20);
	  CirclesWithSquares test2 = new CirclesWithSquares(x2, y2, 40, 20);
	  CirclesWithSquares test3 = new CirclesWithSquares(x3, y3, 40, 20);
	  CirclesWithSquares test4 = new CirclesWithSquares(x4, y4, 40, 20);
          g2.setColor(Color.RED);
	  g2.draw(test1);
	  g2.setColor(Color.BLUE);
	  g2.draw(test2);
	  g2.setColor(Color.GREEN);
	  g2.draw(test3);
	  g2.setColor(Color.WHITE);
	  g2.draw(test4);

       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x1 >= 550) { dx1 = -7; }
            if (x1 <= 80) { dx1 = 7; }
	    if (y1 >= 360) { dy1 = -7; }
	    if (y1 <= 80) { dy1 = 7; }
            x1 += dx1;
	    y1 += dy1;

            if (x2 >= 550) { dx2 = -10; }
            if (x2 <= 80) { dx2 = 10; }
	    if (y2 >= 360) { dy2 = -10; }
	    if (y2 <= 80) { dy2 = 10; }
            x2 += dx2;
	    y2 += dy2;

            if (x3 >= 550) { dx3 = -5; }
            if (x3 <= 80) { dx3 = 5; }
	    if (y3 >= 360) { dy3 = -5; }
	    if (y3 <= 80) { dy3 = 5; }
            x3 += dx3;
	    y3 += dy3;

            if (x4 >= 550) { dx4 = -6; }
            if (x4 <= 80) { dx4 = 6; }
	    if (y4 >= 360) { dy4 = -8; }
	    if (y4 <= 80) { dy4 = 8; }
            x4 += dx4;
	    y4 += dy4;

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
