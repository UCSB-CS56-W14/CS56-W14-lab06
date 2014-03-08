package edu.ucsb.cs56.w14.drawings.sohanshah.advanced;

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
 * @author Sohan Shah 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few 4-step hopscotches 
     */

    public static void drawPicture1(Graphics2D g2) {

   	
	Hopscotch h = new Hopscotch (150, 30, 20);
	g2.setColor(Color.CYAN);g2.draw(h);
	// Make a black hopscotch that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h1 = ShapeTransforms.scaledCopyOfLL(h,0.5,0.5);
	h1 = ShapeTransforms.translatedCopyOf(h1,150,0);
	g2.setColor(Color.BLACK); g2.draw(h1);
	
	// Here's a hopscotch that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h1 = ShapeTransforms.scaledCopyOfLL(h1,4,4);
	h1 = ShapeTransforms.translatedCopyOf(h1,150,250);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h1); 
	
	
	LongerHopscotch lh1 = new LongerHopscotch(70,5,25);
	LongerHopscotch lh2 = new LongerHopscotch(110,130,60);
	
	g2.draw(lh1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(lh2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Translated and transformed hopscotch courts by Sohan Shah", 220,20);
    }


    /** Rotated hopscotch
     */
    public static void drawPicture2(Graphics2D g2) {

	
	Hopscotch h1 = new Hopscotch(100,150,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,50);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,2,2);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	

	// Rotate the second house 45 degrees around its center.
	Shape h3 = ShapeTransforms.rotatedCopyOf(h2, Math.PI/4.0);

	g2.draw(h3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few hopscotch courts with one rotated by Sohan Shah", 20,20);
    }
  
    /** Picture with some longer hopscotch courts
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Let's Play Hopscotch by Sohan Shah", 20,20);

	
	// Draw some long hopscotches
	
       LongerHopscotch large = new LongerHopscotch(270,50,70);
       LongerHopscotch small = new LongerHopscotch(40,50,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
