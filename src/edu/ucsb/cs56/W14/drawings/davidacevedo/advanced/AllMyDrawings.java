package edu.ucsb.cs56.w14.drawings.davidacevedo.advanced;

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
 * @author David Acevedo
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few donuts 
     */

    public static void drawPicture1(Graphics2D g2) {

	Donut h1 = new Donut(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black Donut that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a Donut that's 4x as big (2x the original)
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
	
	// Draw two Donuts with Sprinkles
	
	SprinkledDonut hw1 = new SprinkledDonut(50,350,40);
	SprinkledDonut hw2 = new SprinkledDonut(200,350,200);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few donuts by David Acevedo", 20,20);
    }


    /** Draw a picture with a few donuts
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some donuts.
	
	SprinkledDonut large = new SprinkledDonut(100,50,225);
	SprinkledDonut smallCC = new SprinkledDonut(20,50,40);
	SprinkledDonut tallSkinny = new SprinkledDonut(20,150,20);
	SprinkledDonut shortFat = new SprinkledDonut(20,250,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Donut h1 = new Donut(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black donut that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a donut that's 4x as big (2x the original)
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
	
	// Draw two donuts with Sprinkles
	
	SprinkledDonut hw1 = new SprinkledDonut(50,350,30);
	SprinkledDonut hw2 = new SprinkledDonut(200,350,50);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second donut 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of donuts by David Acevedo", 20,20);
    }
  
    /** Draw a different picture with a few donuts
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Donuts by David Acevedo", 20,20);

	
	// Draw some donuts.
	
       SprinkledDonut donut1 = new SprinkledDonut(250,200,100);
       SprinkledDonut donut2 = new SprinkledDonut(350,200,100);
	   SprinkledDonut donut3 = new SprinkledDonut(300,300,100);
       
       g2.setColor(Color.RED);     g2.draw(donut1);
       g2.setColor(Color.GREEN);   g2.draw(donut2);
	   g2.setColor(Color.BLUE);    g2.draw(donut3);
	   
	   g2.drawString("A tri-force of donuts by David Acevedo", 20,20);
       
       
    }
    

}
