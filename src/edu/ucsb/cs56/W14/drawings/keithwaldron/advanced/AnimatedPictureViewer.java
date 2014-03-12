package edu.ucsb.cs56.w14.drawings.keithwaldron.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
import java.util.Random;

/** An animated viewer class to see a simple picture of Glasses I drew with 
 *  just two simple Java graphics objects Line2D.Double and Ellipse2D.Double
 *  The glasses change in size, color and position while rotating over time when mouse enters panel
 *
 * @author Keith Waldron
 * @version for UCSB CS56, W14, 03/10/2014
 */

public class AnimatedPictureViewer {

	private DrawPanel panel = new DrawPanel();
	private Glasses glasses = new Glasses(500, 500, 100);

	Thread anim;

	private int x = 500;//x position
	private int y = 500;//y position
	private int r = 0;//radius size
	private int dx = 5;//x change
	private int dy = 10;//y change
	private int dr = 25;//radius change
	private int roto = 0;//rotation 

	//generate random color
	Random rand = new Random(); 
	private int red = (int)(rand.nextFloat()*256);
	private int green = (int)(rand.nextFloat()*256);
	private int blue = (int)(rand.nextFloat()*256);
	Color randomColor = new Color(red,green,blue);
     

	public static void main (String[] args) {
		//instantiate and start drawing
		new AnimatedPictureViewer().go();
	}//end main
    
	/** constructs a JFrame with an animated picture inside
        */
	public void go() {
		JFrame frame = new JFrame();
		//to close window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.setTitle("Keith Waldron's crazy glasses animation!");
      
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				System.out.println("start");
				//Get a new animation thread and start the animation on it.
				anim = new Animation();
				anim.start();
        		}//end mouse enter

			public void mouseExited(MouseEvent e){        
				System.out.println("stop");
  				// stop animation thread
				anim.interrupt();
				while (anim.isAlive()){}
				anim = null;         
				panel.repaint();        
        		}//end mouse exit
      		});
      
	} // go()

	/*class to override paint component and draw Glasses
	*/
	class DrawPanel extends JPanel {
		public void paintComponent(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
	
			// Clears panel for updated image to be drawn
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,this.getWidth(), this.getHeight());
	  
			// Draw glasses 
			g2.setColor(randomColor);
			g2.rotate(Math.toRadians(roto), 500, 500);//rotate
			Glasses test = new Glasses(x, y, r);
			g2.draw(test);
		}//end paintCompoenent
	}//end drawPanel
    
	class Animation extends Thread {
		public void run() {//begin run method
			try {
				while (true) {
					//The following code will continue to
					// loop until the animation thread is
					// interrupted by the mouseExited method. 
         
					//set barriers
					if (x >= 300) dx = -5; 
					if (y >= 350) dy = -10;
					if (x <= 100) dx = 5; 
					if (y<=100) dy = 10;            
					if(r>=200) dr= -15;
					if(r<=100) dr= 15;
           
					x += dx; //horizantal movement             
					y += dy;//vertical movement
					r += dr;//size change
					roto += 5;//spin
	 
					//change to random color
					red = (int)(rand.nextFloat()*256);
					green = (int)(rand.nextFloat()*256); 
					blue = (int)(rand.nextFloat()*256);
					randomColor = new Color(red, green, blue);		 	

					panel.repaint();//update animation
					Thread.sleep(50);//delay
				}//end while
			} catch(Exception ex) {
				if (ex instanceof InterruptedException) {
					// Do nothing - expected on mouseExited
				} else {
					ex.printStackTrace();
					System.exit(1);
				}//end else
			}//end catch
		}//end run
	}//end animation class
}//end Animated Picture Viewer
