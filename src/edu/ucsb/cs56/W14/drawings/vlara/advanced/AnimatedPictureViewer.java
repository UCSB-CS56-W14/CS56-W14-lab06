package edu.ucsb.cs56.w14.drawings.vlara.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private HourglassFull  hourglass = new HourglassFull(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dy = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,600);
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

          // Draw the HourglassFull 
          g2.setColor(Color.BLUE);

                            
         // af.rotate(30.00);

          HourglassFull test = new HourglassFull(x, y, 100, 100);

          g2.draw(test);
                    
          

       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (y >= 400) { dy = -5; }
            if (y <= 50) { dy = 5; }
            
            y += dy;

            AffineTransform af = new AffineTransform();
            af.rotate(30.00, x, y);

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
