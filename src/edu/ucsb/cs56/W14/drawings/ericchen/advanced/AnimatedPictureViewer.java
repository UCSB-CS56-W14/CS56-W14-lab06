package edu.ucsb.cs56.w14.drawings.ericchen.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Camera camera = new Camera(100, 100, 150, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

    private int count = 1;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(700,600);
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

          // Draw the Camera
	  Stroke thick = new BasicStroke (4.0f, BasicStroke. CAP_BUTT, BasicStroke.JOIN_BEVEL);
          Camera test = new Camera(x, y, 150, 100);
          Stroke orig = g2.getStroke();
	  Random randomGenerator = new Random();
	  int red = randomGenerator.nextInt(255);
	  int green = randomGenerator.nextInt(255);
	  int blue = randomGenerator.nextInt(255);
	  Color randomColour = new Color(red,green,blue);
	  g2.setStroke(thick);
	  g2.setColor(randomColour);
	  g2.rotate(count * (Math.PI/8), x+75, y+50);
	  g2.draw(test);
	 
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 500) { dx = -5; }
            if (x <= 25) { dx = 5; }
	    if (y >= 550) { dy = -5; }            
	    if (y <= 25) { dy = 5; }

            x += dx;                
	    y += dy;

	    count++;

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
