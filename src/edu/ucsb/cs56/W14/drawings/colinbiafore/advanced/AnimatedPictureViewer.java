package edu.ucsb.cs56.w14.drawings.colinbiafore.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private Tree tree;
    private Tree tree2;
    private ChristmasTree ct1;

    Thread anim;

    private int x = 100;
    private int y = 100;
    private int w = 150;
    private int z = 200;
    private int a = 250;
    private int b = 150;

    private int dx = 5;
    private int dz = 10;
    private int da = 3;
    private int db = 3;

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
		public void mouseEntered(MouseEvent e) {
		    anim = new Animation();
		    anim.start();
		}
		
		public void mouseExited(MouseEvent e) {
		    //kill animation thread
		    anim.interrupt();
		    while(anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		}
	    });
    }

	class DrawPanel extends JPanel {
	    public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Clear panel
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,this.getWidth(), this.getHeight());

		// Draw the Tree
		g2.setColor(Color.RED);
		tree = new Tree(x,y,100);
		
		tree2 = new Tree(w,z,100);

		ct1 = new ChristmasTree(a,b,200);
		g2.draw(tree);
		g2.setColor(Color.GREEN);
		g2.draw(tree2);
		g2.setColor(Color.BLUE);
		g2.draw(ct1);
	    }
	}

	class Animation extends Thread {

	    public void run() {
		try {
		    while(true) {
			if(x >= 600) { dx = -5; }
			if(x <= 30) {dx = 5; }
			if(z >= 360) {dz = -10; }
			if(z <= 0) {dz = 10; }
			if(a >= 550) { da = -3; }
			if(a <= 70) { da = 3; }
			if(b >= 240) { db = -3; }
			if(b <= 0) { db = 3; }

			x += dx;
			z += dz;
			a += da;
			b += db;
			panel.repaint();
			Thread.sleep(50);
		    }
		} catch(Exception ex) {
		    if( ex instanceof InterruptedException) {
			//Do nothing - expected on mouseExited
		    } else {
			ex.printStackTrace();
			System.exit(1);
		    }
		}
	    }
	}
}
		    
		    
	    
