package edu.ucsb.cs56.w14.drawings.sarahdarwiche.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @author Sarah Darwiche
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few computer monitors 
     */

    public static void drawPicture1(Graphics2D g2) {

	ComputerMonitor h1 = new ComputerMonitor(100,150,75,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black computer monitor that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a computer monitor that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two Computers
	
        Computer c1 = new Computer(50,350,40,75);
        Computer c2 = new Computer(200,350,200,100);
	
	g2.draw(c1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(c2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few computer monitors by Sarah Darwiche", 20,20);
    }


    /** Draw a picture with a few computer monitors and computers
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some computers.
	
        Computer large = new Computer(100,50,225,150);
	Computer smallCC = new Computer(20,50,40,30);
        Computer tallSkinny = new Computer(20,150,20,40);
        Computer shortFat = new Computer(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	ComputerMonitor C1 = new Computer(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(C1);
	
	// Make a Computer monitor that's half the size, 
	// and moved over 150 pixels in x direction
	Shape C2 = ShapeTransforms.scaledCopyOfLL(C1,0.5,0.5);
	C2 = ShapeTransforms.translatedCopyOf(C2,150,0);
	g2.setColor(Color.BLACK); g2.draw(C2);
	
	// Here's a computer monitor that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	C2 = ShapeTransforms.scaledCopyOfLL(C2,4,4);
	C2 = ShapeTransforms.translatedCopyOf(C2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(C2); 
	
	// Draw two Computers
	
        Computer c_1 = new Computer(50,350,40,75);
	Computer c_2 = new Computer(200,350,200,100);
	
	g2.draw(c_1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second computer 45 degrees around its center.
	Shape c_3 = ShapeTransforms.rotatedCopyOf(c_2, Math.PI/4.0);

	g2.draw(c_3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Computers and Computer Monitors by Sarah Darwiche", 20,20);
    }
  
    /** Draw a different picture with a few computers and computer monitors
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Computer Monitors by Sarah Darwiche", 20,20);

	
	// Draw some Computer Monitors.
	
       ComputerMonitor large = new ComputerMonitor(100,50,225,150);
       ComputerMonitor smallCC = new ComputerMonitor(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
