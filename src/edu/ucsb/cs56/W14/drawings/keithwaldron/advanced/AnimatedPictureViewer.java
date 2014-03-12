package edu.ucsb.cs56.w14.drawings.keithwaldron.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private Glasses glasses = new Glasses(500, 500, 100);

    Thread anim;

    private int x = 500;
    private int y = 500;
    private int r =0;
    private int dx = 5;
    private int dy = 10;
    private int dr = 25;
    private int roto= 0;

     Random rand = new Random(); 
     private float red = rand.nextFloat();
     private float green = rand.nextFloat();
     private float blue = rand.nextFloat();
     Color randomColor = new Color(red,green,blue);
     

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(1000,1000);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("start");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("stop");
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
          g2.setColor(Color.WHITE);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());
	  
          // Draw glasses 
          g2.setColor(randomColor);
	  g2.rotate(Math.toRadians(roto), 500, 500);//rotate all
          Glasses test = new Glasses(x, y, r);
          g2.draw(test);
	  g2.setColor(randomColor);

       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
         	//move around and rotate and zoom in and out

            if (x >= 300) { dx = -5; }
	    if (y >= 350) dy = -10;
            if (x <= 100) { dx = 5; }
            if (y<=100) dy = 10;            
	    if(r>=200) dr= -25;
	    if(r<=100) dr= 25;
           
            x += dx;                
 	    y += dy;
	    r += dr;
	    roto += 5;//spin speed
	    red = rand.nextInt();
	    green = rand.nextInt(); 
	    blue = rand.nextInt();

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
