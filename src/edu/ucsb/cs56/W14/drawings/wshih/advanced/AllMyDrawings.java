package edu.ucsb.cs56.w14.drawings.wshih.advanced;

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
 * @author George Shih
 * @version for CS56, lab06, Winter 2014
 */

public class AllMyDrawings {

    /**
       Draw a picture (1) with a few Circles and Squares
    */     

    public static void drawPicture1(Graphics2D g2) {

	Circles c1 = new Circles(150,150,40,20);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make some black circles that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's some circles that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two CirclesWithSquares
	
	CirclesWithSquares cws1 = new CirclesWithSquares(100,350,40,20);
	CirclesWithSquares cws2 = new CirclesWithSquares(500,350,40,20);
	
	g2.draw(cws1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cws2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few circles by George Shih", 20,20);

    }



    /** Draw a picture (2) with a few Circles and Squares
     */

    public static void drawPicture2(Graphics2D g2) {	

	Circles c1 = new Circles(100,250,40,20);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);

	// Here's a Circle that's 6x as big (3x the original)
	// and moved over 75 more pixels down and 125 pixels to the right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,6,6);
	c2 = ShapeTransforms.translatedCopyOf(c2,-75,125);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// CirclesWithSquares
	
	CirclesWithSquares cws2 = new CirclesWithSquares(335,220,40,20);
	
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape cws3 = ShapeTransforms.rotatedCopyOf(cws2, Math.PI/4.0);
	Shape cws4 = ShapeTransforms.rotatedCopyOf(cws2, -Math.PI/4.0);
	Shape cws5 = ShapeTransforms.rotatedCopyOf(cws2, -2*Math.PI/4.0);
	Shape cws6 = ShapeTransforms.rotatedCopyOf(cws2, -3*Math.PI/4.0);
	Shape cws7 = ShapeTransforms.rotatedCopyOf(cws2, -4*Math.PI/4.0);
	Shape cws8 = ShapeTransforms.rotatedCopyOf(cws2, -5*Math.PI/4.0);
	Shape cws9 = ShapeTransforms.rotatedCopyOf(cws2, -6*Math.PI/4.0);

	// Draw 8 CirclesWithSquares

	g2.draw(cws2);
	g2.draw(cws3);
	g2.draw(cws4);
	g2.draw(cws5);
	g2.draw(cws6);
	g2.draw(cws7);
	g2.draw(cws8);
	g2.draw(cws9);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of circles and squares by George Shih", 20,20);

    }
  


    /** Draw a different picture (3) with a few Circles and Squares
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// Label the drawing
	
	g2.drawString("A bunch of circles and squares by George Shih", 20,20);
	
	// Draw some symmetric design with different colors

	CirclesWithSquares cws1 = new CirclesWithSquares(200,100,60,30);
	
	Shape cws2 = ShapeTransforms.translatedCopyOf(cws1,250,0);
	cws2 = ShapeTransforms.rotatedCopyOf(cws2, 2*Math.PI/4.0);
	Shape cws3 = ShapeTransforms.translatedCopyOf(cws1,250,250);
	cws3 = ShapeTransforms.rotatedCopyOf(cws3, 4*Math.PI/4.0);
	Shape cws4 = ShapeTransforms.translatedCopyOf(cws1,0,250);
	cws4 = ShapeTransforms.rotatedCopyOf(cws4, 6*Math.PI/4.0);

	g2.setColor(Color.RED);     g2.draw(cws1);
	g2.setColor(Color.GREEN);   g2.draw(cws2);
	g2.setColor(Color.BLUE);    g2.draw(cws3);
	g2.setColor(Color.BLACK);   g2.draw(cws4);
       
    }
    

}
