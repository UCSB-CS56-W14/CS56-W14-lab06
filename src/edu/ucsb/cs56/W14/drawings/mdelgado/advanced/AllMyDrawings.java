package edu.ucsb.cs56.w14.drawings.mdelgado.advanced;

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
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture of a flag 
     */

    public static void drawPicture1(Graphics2D g2) {

	Flag f1 = new Flag(100,250,75,50);
	g2.setColor(Color.BLACK); g2.draw(f1);
	
	// Make a black flag that's half the size, 
	// and moved over 150 pixels in x direction

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.setColor(Color.BLACK); g2.draw(f2);
	
	// Here's a flag that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.draw(f2);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(f1); 
	
	// Draw two Japanese flags
	
	JapaneseFlag jp1 = new JapaneseFlag(200,100,100,50);
	JapaneseFlag jp2 = new JapaneseFlag(200,350,200,100);
	
	g2.draw(jp1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(jp2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few flags by Miggy D", 20,20);
    }


    /** Draw a picture with a few flags
     */
    public static void drawPicture2(Graphics2D g2) {

	
	Flag f1 = new Flag(100,250,50,25);
	g2.setColor(Color.CYAN); g2.draw(f1);
	
	// Make a black flag that's half the size, 
	// and moved over 150 pixels in x direction
	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.setColor(Color.BLACK); g2.draw(f2);
	
	// Here's a flag that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(f2); 
	
	// Draw two houses with Windows
	
	JapaneseFlag jp1 = new JapaneseFlag(50,350,75,40);
	JapaneseFlag jp2 = new JapaneseFlag(10,10,300,150);
	
	g2.draw(jp1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second flag  45 degrees around its center.
	Shape jp3 = ShapeTransforms.rotatedCopyOf(jp2, Math.PI/4.0);

	g2.draw(jp3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of flags by Miggy D", 20,20);
    }
  
    /** Draw a different picture with a few flags
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	JapaneseFlag jp1 = new JapaneseFlag(100, 100, 400, 200);
	
	Shape jp2 = ShapeTransforms.rotatedCopyOf(jp1,Math.PI/2);
	
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	g2.setColor(Color.RED);
	g2.drawString("A bunch of RED flags by Miggy D", 20,20);	 
        g2.draw(jp2);
    }
    

}
