package edu.ucsb.cs56.w14.drawings.jovo123.advanced;

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
 * @author Josephine Vo
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few rodents
     */

    public static void drawPicture1(Graphics2D g2) {

	Rodent r1 = new Rodent(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(r1);
	
	// Make a black rodent that's half the size, 
	// and moved over 150 pixels in x direction

	Shape r2 = ShapeTransforms.scaledCopyOfLL(r1,0.5,0.5);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	g2.setColor(Color.BLACK); g2.draw(r2);
	
	// Here's a rodent that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	r2 = ShapeTransforms.scaledCopyOfLL(r2,4,4);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(r2); 
	
	// Draw two Rabbits
	
	Rabbit ra1 = new Rabbit(50,350,40);
	Rabbit ra2 = new Rabbit(200,350,200);
	
	g2.draw(ra1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ra2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few rabbits by Josephine Vo", 20,20);
    }


    /** Draw a picture with a few rodents
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Rodent large = new Rodent(100,50,225);
	Rodent smallCC = new Rodent(20,50,40);
	Rodent tallSkinny = new Rodent(20,150,20);
	Rodent shortFat = new Rodent(20,250,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Rodent r1 = new Rodent(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(r1);
	
	// Make a black rodent that's half the size, 
	// and moved over 150 pixels in x direction
	Shape r2 = ShapeTransforms.scaledCopyOfLL(r1,0.5,0.5);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	g2.setColor(Color.BLACK); g2.draw(r2);
	
	// Here's a rodent that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	r2 = ShapeTransforms.scaledCopyOfLL(r2,4,4);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(r2); 
	
	// Draw two rabbits
	
	Rabbit ra1 = new Rabbit(50,350,40);
	Rabbit ra2 = new Rabbit(200,350,200);
	
	g2.draw(ra1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second rabbit 45 degrees around its center.
	Shape ra3 = ShapeTransforms.rotatedCopyOf(ra2, Math.PI/4.0);

	g2.draw(ra3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Rodents and a few Rabbits by Josephine", 20,20);
    }
  
    /** Draw a different picture with a rabbits and rodents
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Rodents by Josephine Vo", 20,20);

	
	// Draw some Rodents.
	
       Rodent large = new Rodent(100,50,225);
       Rodent smallCC = new Rodent(20,50,40);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
