package edu.ucsb.cs56.w14.drawings.sohanshah.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private LongerHopscotch longerhopscotch = new LongerHopscotch(50,50,50);
    Thread anim;
    
    private int x = 50;
    private int y = 50;
    private int dx = 2;
    private int dy = 2;

    public static void main(String[] args) {
	new AnimatedPictureViewer().go();
    }
   
    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
		    System.out.println("mouse entered");
		    anim = new Animation();
		    anim.start();
		}
		public void mouseExited(MouseEvent e){
		    System.out.println("Mouse exited");
		    //Kill animation thread
		    anim.interrupt();
		    while (anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		}
	    });
	       	
	    }
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    //clear panel
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    //Draw hopscotch
	    g2.setColor(Color.GREEN);
	    LongerHopscotch test = new LongerHopscotch(x, y, 50);
	    g2.draw(test);
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		 while (true) {
            // Bounce off the walls

            if (x >= 560) { 
		dx = -2; 
	    }
            if (x <= 25) { 
		dx = 2;
	    }
	    if (y >=205) {
		dy = -1;
	    }
	    if (y <=0) {
		dy = 1;     
	    }
            
            x += dx;              
	    y += dy;
            panel.repaint();
            Thread.sleep(50);
		 }

	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    //Do nothing - expected on mouseExited
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
}
