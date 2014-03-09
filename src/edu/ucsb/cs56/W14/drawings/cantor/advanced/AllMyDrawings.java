package edu.ucsb.cs56.w14.drawings.cantor.advanced;

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
 * @author Antonio Cantor
 * @version for CS56, lab06, Spring 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few triangles 
     */

    public static void drawPicture1(Graphics2D g2) {

	Triangle h1 = new Triangle(150,150,150,150);
	g2.setColor(Color.GREEN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLUE); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
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
	

	
	WarningSign ws1 = new WarningSign(150,150,150,150);
	WarningSign ws2 = new WarningSign(100,100,100,100);
	
	g2.draw(ws1);
	g2.setColor(new Color(0x8F00FF)); //g2.draw(ws2);
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few signs by Antonio Cantor", 20,20);
    }


    /** Draw a picture with a few warning signs
     */
    public static void drawPicture2(Graphics2D g2) {


	
	WarningSign ws1 = new WarningSign(50,50,50,50);

	WarningSign ws4 = new WarningSign(200,200,200,200);
	
	g2.setColor(Color.RED);     g2.draw(ws1);
	g2.setColor(Color.MAGENTA); g2.draw(ws4);
	
	Triangle h1 = new Triangle(200,200,200,200);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
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
	

	
	WarningSign ws5 = new WarningSign(150,150,150,150);
	WarningSign ws6 = new WarningSign(100,100,100,100);
	
	g2.draw(ws5);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape ws7 = ShapeTransforms.rotatedCopyOf(ws6, Math.PI/4.0);

	g2.draw(ws7);
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of warning signs and triangles by Antonio Cantor", 20,20);
    }
  
    /** Draw a different picture with a few triangles
     */

    public static void drawPicture3(Graphics2D g2) {
	

	
	g2.drawString("A bunch of triangles by Antonio Cantor", 20,20);

	
	
       Triangle t1 = new Triangle(75,75,75,75);
       WarningSign ws1 = new WarningSign(100,100,100,100);
       
       g2.setColor(Color.RED);     g2.draw(t1);
       g2.setColor(Color.GREEN);   g2.draw(ws1);
       
       
    }
    

}
