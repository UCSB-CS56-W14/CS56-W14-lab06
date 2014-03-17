package edu.ucsb.cs56.w14.drawings.aepalyan.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private LollipopWithSwirls lollipop = new LollipopWithSwirls(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;

    private int xText = 150;
    private int yText = 250;

    private int dx = 5;
    private int dy = 5;
    private int textDelay;

    private int rc,bc,gc;
    private double rotate = .05;
    private double dr = .01;
    private int delay = 75;
    private int dDelay = 5;

    private int charCount;

    Color randColor;
    

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setLocationRelativeTo(null); // center the frame
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

    /** return random Color
     */
    public Color randColor() {
	rc = (int)(Math.random()*255);
        gc = (int)(Math.random()*255);
        bc = (int)(Math.random()*255);
        randColor = new Color(rc, gc, bc);

	return randColor;
    }

    /** draw lollipop with random color
     * @param g2 use to manipulate and draw objects to screen
     * @param pop object to draw
     */
    public void drawLollipop(Graphics2D g2, LollipopWithSwirls pop) {
	g2.setColor(randColor());
	g2.draw(pop);
    }

    /** draw text to screen
     * @param g use to manipulate and draw objects to screen
     **/
    public void drawText(Graphics g) {
	
	String text = "Animation";


	// replace single character in string with random color (wave effect)
	g.setColor(randColor());
	g.setFont(new Font("TimesRoman", Font.PLAIN, 50));

	switch(charCount) {

	case 0:
	    g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
	    break;
	case 1:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
	case 2:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
	case 3:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
        case 4:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
        case 5:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
        case 6:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
        case 7:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;
	case 8:
            g.drawString(Character.toString(text.charAt(charCount)), xText, yText);
            break;

	default:
	    charCount = 0;
	    xText = 150;
	    break;
	 
	}
	textDelay++;
	if (textDelay > 5) {
	    charCount++;
	    xText+=25;
	    textDelay = 0;
	}
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;


         // Clear the panel first	
	g2.setColor(Color.BLACK);
	g2.fillRect(0,0,this.getWidth(), this.getHeight());
	
	// draw text to screen
	drawText(g);

	// draw the lollipops
	LollipopWithSwirls pop1 = new LollipopWithSwirls(x, y, 100, 100);
	LollipopWithSwirls pop2 = new LollipopWithSwirls(-x, -y, 100, 100);
	LollipopWithSwirls pop3 = new LollipopWithSwirls(x*2, y*2, 100, 100);
	LollipopWithSwirls pop4 = new LollipopWithSwirls(-x*2, -y*2, 100, 100);

	g2.rotate(rotate);
	drawLollipop(g2,pop1);
	drawLollipop(g2,pop2);
	drawLollipop(g2,pop3);
	drawLollipop(g2,pop4);

       }
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Delay
		    if (delay >= 75) dDelay = -1;
		    if (delay <= 15) dDelay = 1;
		    
		    // Bounce off the walls
		    if (x >= 640) dx = -5; 
		    if (x <= 0) dx = 5;
		    
		    if (y >= 480) dy = -5; 
		    if (y <= 0) dy = 5;

		    // rotate
		    if (rotate > 1) dr = -.01;
		    if (rotate <= 0) dr = .01;
		    
		    delay += dDelay;
		    x += dx;
		    y += dy;
		    rotate += dr;

		    panel.repaint();
		    Thread.sleep(delay);
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
