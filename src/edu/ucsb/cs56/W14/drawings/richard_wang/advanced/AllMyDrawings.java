package edu.ucsb.cs56.w14.drawings.richard_wang.advanced;

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
 * @author Richard Wang
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Cubes and Legos
     */

    public static void drawPicture1(Graphics2D g2) {

	Cube c1 = new Cube(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black cube that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a cube that's 4x as big (2x the original)
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
	
	//Draw two Legos with Nubs
	Lego l1 = new Lego(50, 350, 50);
	Lego l2 = new Lego(200, 350, 50);
	g2.draw(l1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(l2);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Cubes and Legos, different positions and different sizes, by Richard Wang", 20,20);
    }


    /** Draw a picture with a few Cubes and Legos
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Cubes.
	
	Cube large = new Cube(100,50,100);
	Cube smallCC = new Cube(20,50,20);
	Cube tallSkinny = new Cube(20,150,80);
	Cube shortFat = new Cube(20,250,39);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
        Lego h1 = new Lego(100,250,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black Cube that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a Cube that's 4x as big (2x the original)
	// and moved over 150 more pixels to right
	// and rotated 1 radian.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	h2 = ShapeTransforms.rotatedCopyOf(h2, 1);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Cubes and a few Legos, some rotated, by Richard Wang", 20,20);
    }
  
    /** Draw a different picture with two Cubes
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Two Cubes, one rotated, by Richard Wang", 20,20);

	
	// Draw some Cubes.
	
       Cube large = new Cube(100,50,10);
       Cube small = new Cube(20,50,50);
       
       g2.setColor(Color.GREEN);   g2.draw(small);
       Shape	h2 = ShapeTransforms.rotatedCopyOf(large, 1);
       g2.setColor(Color.RED);
       g2.draw(h2);
       
       
    }
    

}
