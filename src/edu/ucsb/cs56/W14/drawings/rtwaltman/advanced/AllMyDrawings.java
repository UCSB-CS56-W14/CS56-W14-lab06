package edu.ucsb.cs56.w14.drawings.rtwaltman.advanced;

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
 * @author Richard Waltman 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few bikes and tandem bikes
     */

    public static void drawPicture1(Graphics2D g2) {

	Bike b1 = new Bike(100, 100, 40);
	g2.setColor(Color.BLACK); g2.draw(b1);	

	//Draw a Tandem Bike (2 seats)
	TandemBike tb1 = new TandemBike(25, 225, 15);
	g2.setColor(Color.RED); g2.draw(tb1);
	
	// Make a black bike that's half the size, 
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #008000 is "Ao (English)" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x008000)); 

	//Make a thick stroke Ao tandem bike that's twice the size,
	//and moved over 150 pixels in the x direction
	Shape tb2 = ShapeTransforms.scaledCopyOfLL(tb1,2,2);
	tb2 = ShapeTransforms.translatedCopyOf(tb2,150,0);
	g2.draw(tb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few bikes by Richard Waltman", 20,20);
    }


    /** Draw a picture with a few more bikes and tandem bikes!     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Bike b1 = new Bike(100,50,15);
	Bike b2 = new Bike(200,100,20);
	Bike b3 = new Bike(20,150,25);
	Bike b4 = new Bike(20,250,30);
	
	g2.setColor(Color.RED);     g2.draw(b1);
	g2.setColor(Color.GREEN);   g2.draw(b2);
	g2.setColor(Color.BLUE);    g2.draw(b3);
	g2.setColor(Color.MAGENTA); g2.draw(b4);
		
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	
	// Draw two tandem bikes
	
	TandemBike tb1 = new TandemBike(50,350,40);
	TandemBike tb2 = new TandemBike(300,350,42);
	
	g2.draw(tb1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the tandem bike 90 degrees around its center.
	Shape tb3 = ShapeTransforms.rotatedCopyOf(tb2, Math.PI/2.0);

	g2.draw(tb3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of bikes and tandem bikes by Richard Waltman", 20,20);
    }
  
    /** Draw a different picture with even more bikes!!
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of tandem bikes by Richard Waltman", 20,20);

	
	// Draw some tandem bikes.
	TandemBike tb1 = new TandemBike(350,350,50);

	//rotate tandem bike 120 degrees around it's center
	Shape tb2 = ShapeTransforms.rotatedCopyOf(tb1, Math.PI*2/3);
       
    g2.setColor(Color.BLUE);     g2.draw(tb1);
    g2.setColor(Color.GREEN);      g2.draw(tb2);
   
    }
    

}
