package edu.ucsb.cs56.w14.drawings.blakezimmerman.advanced;

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
 * @author Blake Zimmerman
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few tires and tire swings 
     */

    public static void drawPicture1(Graphics2D g2) {
	
	Tire t1 = new Tire(100,250,20,20);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black tire that's half the size, 
	// and moved over 150 pixels in x direction

       	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a tire that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two tire swings
	
	TireSwing ts1 = new TireSwing(100,200,20,20);
	TireSwing ts2 = new TireSwing(200,250,50,50);
	
	g2.draw(ts1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ts2);
	
	// sign and label the drawing
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few tires and tire swings by Blake Zimmerman", 20,20);
	
    }


    /** Draw a picture with a few tires and tire swings
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some tires.
	
	Tire large = new Tire(200,200,100,100);
	Tire small = new Tire(50,100,20,20);
	Tire skinny = new Tire(150,200,50,10);
	Tire fat = new Tire(200,250,10,50);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(skinny);
	g2.setColor(Color.MAGENTA); g2.draw(fat);
	
	Tire t1 = new Tire(100,250,25,25);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black tire that's half the size, 
	// and moved over 150 pixels in x direction
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a tire that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two tire swings
	
	TireSwing ts1 = new TireSwing(50,350,10,20);
	TireSwing ts2 = new TireSwing(200,300,30,30);
	
	g2.draw(ts1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second tire swing 45 degrees around its center.
	Shape ts3 = ShapeTransforms.rotatedCopyOf(ts2, Math.PI/4.0);

	g2.draw(ts3);
	
	// sign and label the drawing
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of tires and tire swings by Blake Zimmerman", 20,20);
    }
  
    /** Draw a different picture with a few tires and tire swings
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of tires by Blake Zimmerman", 20,20);

	
	// Draw some tires.
	
       Tire large = new Tire(300,300,150,150);
       Tire small = new Tire(150,150,40,40);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
