package edu.ucsb.cs56.w14.drawings.bhammel.advanced;

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
	A class with static methods for drawing various pictures
	@author Phill Conrad
	@author Brandon Hammel
	@version for CS56, lab06, Winter 2014
 */

public class AllMyDrawings
{
    /** Draw a picture with a few snare drums
     */

    public static void drawPicture1(Graphics2D g2) {

	SnareDrum sd1 = new SnareDrum(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(sd1);
	
	// Make a black snare drum that's half the size, 
	// and moved over 150 pixels in x direction
	Shape sd2 = ShapeTransforms.scaledCopyOfLL(sd1,0.5,0.5);
	sd2 = ShapeTransforms.translatedCopyOf(sd2,150,0);
	g2.setColor(Color.BLACK); g2.draw(sd2);
	
	// Here's a snare drum that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	sd2 = ShapeTransforms.scaledCopyOfLL(sd2,4,4);
	sd2 = ShapeTransforms.translatedCopyOf(sd2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(sd2); 
	
	// Draw two snare drum with a stand
	
	SnareDrumWithStand sds1 = new SnareDrumWithStand(50,350,40,75);
	SnareDrumWithStand sds2 = new SnareDrumWithStand(200,350,200,100);
	
	g2.draw(sds1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sds2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Snare Drums by Brandon Hammel", 20, 20);
    }


    /** Draw a picture with a snare drums
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some snare drums
	
	SnareDrum large = new SnareDrum(100,50,225,150);
	SnareDrum smallCC = new SnareDrum(20,50,40,30);
	SnareDrum tallSkinny = new SnareDrum(20,150,20,40);
	SnareDrum shortFat = new SnareDrum(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	SnareDrum sd1 = new SnareDrum(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(sd1);
	
	// Make a black snare drum that's half the size, 
	// and moved over 150 pixels in x direction
	Shape sd2 = ShapeTransforms.scaledCopyOfLL(sd1,0.5,0.5);
	sd2 = ShapeTransforms.translatedCopyOf(sd2,150,0);
	g2.setColor(Color.BLACK); g2.draw(sd2);
	
	// Here's a snare drum that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	sd2 = ShapeTransforms.scaledCopyOfLL(sd2,4,4);
	sd2 = ShapeTransforms.translatedCopyOf(sd2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(sd2); 
	
	// Draw two snare drums with stands
	
	SnareDrumWithStand sds1 = new SnareDrumWithStand(50,350,40,75);
	SnareDrumWithStand sds2 = new SnareDrumWithStand(200,350,200,100);
	
	g2.draw(sds1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second snare drum 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(sds2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("A bunch of Snare Drums by Brandon Hammel", 20,20);
    }
  
    /** Draw a different picture with a few snare drums
     */

    public static void drawPicture3(Graphics2D g2) {

	   // Draw some snare drums
    	
       SnareDrum large = new SnareDrum(100,50,225,150);
       SnareDrum smallCC = new SnareDrum(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);

       // label the drawing
	   g2.setColor(Color.BLACK);
	   g2.drawString("A bunch of Snare Drums by Brandon Hammel", 20,20);
    }
}
