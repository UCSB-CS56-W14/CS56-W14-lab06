package edu.ucsb.cs56.w14.drawings.alecharrell.advanced;

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
 * @author Alec Harrell
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few dogs 
     */

    public static void drawPicture1(Graphics2D g2) {
	Dog d1 = new Dog(100,100,100,100);
	g2.setColor(Color.CYAN);
	g2.draw(d1);
			
	// Make a black dog that's half the size, 
	// and moved over 150 pixels in x direction

	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	
	// Here's a dog that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw two partyDogs
	
	partyDog pd1 = new partyDog(50,350,50,50);
	partyDog pd2 = new partyDog(200,350,75,75);
	
	g2.draw(pd1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(pd2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few dogs by Alec Harrell", 20,20);

    }


    /** Draw a picture with some dogs and party dogs
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some dogs.
	
	Dog large = new Dog(100,50,200,200);
	Dog small = new Dog(20,50,40,40);
	
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	
	
	partyDog pD = new partyDog(100,250,50,50);
	g2.setColor(Color.CYAN); g2.draw(pD);
	
	

	// Rotate the partyDog 45 degrees around its center.
	Shape pD2 = ShapeTransforms.rotatedCopyOf(pD, Math.PI/4.0);
	pD2 = ShapeTransforms.translatedCopyOf(pD2,150,0);
	g2.draw(pD2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of dogs by Alec Harrell", 20,20);
    }
  
    /** Draw a different picture with dogs
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Dogs by Alec Harrell", 20,20);

	
	// Draw some dogs.
	
       Dog large = new Dog(100,50,225,225);
       partyDog small = new partyDog(20,50,30,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
