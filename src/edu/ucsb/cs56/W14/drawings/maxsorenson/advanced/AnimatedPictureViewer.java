package edu.ucsb.cs56.w14.drawings.maxsorenson.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private TelevisionAntenna tv = new TelevisionAntenna(100, 100, 100, 100);
    
    Thread anim;   
    
    private int R, G, B;
	
    private int x = 100;
    private int y = 100;
    private int x2 = x;
    private int y2 = y;
    
    private int dx = 5;
    private int dy = 5;
    
    private float sThick=4.0f;
    private int counter = 0;
    private double scale = 0.5;
    private boolean hitWall = false;

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
	  //randomize stroke color
	  R = (int) (Math.random() * 255);
	  G = (int) (Math.random() * 255);
	  B = (int) (Math.random() * 255);
	  Color randomColor = new Color(R, G, B);
	  //stroke thickness
	  if((counter%3) == 0) sThick = 10.0f;
	  else sThick = 4.0f;
	  Stroke thick = new BasicStroke (sThick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);  
	  g2.setStroke(thick);
          g2.setColor(randomColor);
          TelevisionAntenna test = new TelevisionAntenna(x, y, 100, 100);
	  Television second = new Television(x2+300, y2+300, 100, 100);
	  Shape test2 = ShapeTransforms.scaledCopyOf(test,scale,scale); 
          if((counter%2) == 0) {g2.draw(test2); g2.draw(second);}
	  else {g2.draw(test); g2.draw(second);} 
	  int i = 0;
	  while(hitWall == true) {
	      g2.setFont(new Font("default", Font.BOLD, 50));
	      g2.drawString("You hit a wall!", 100,300);
	      hitWall=false;
	  }
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      if (x >= 400) { dx = -5; dy = -5; hitWall=true; counter++; }
	      if (x <= 50) { dx = 5; dy = 5; hitWall=true;counter++; }
            x += dx;
	    y += dy;
	    x2 -= dx;
	    y2 -= dy;
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
