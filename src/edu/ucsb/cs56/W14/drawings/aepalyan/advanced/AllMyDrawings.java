package edu.ucsb.cs56.w14.drawings.aepalyan.advanced;

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
 * @author Eric Palyan 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Lollipops 
     */

    public static void drawPicture1(Graphics2D g2) {

	Lollipop pop1 = new Lollipop(100,250,75,75);
	g2.setColor(Color.CYAN); g2.draw(pop1);
	
	// Make a black lollipop that's half the size, 
	// and moved over 150 pixels in x direction

	Shape pop2 = ShapeTransforms.scaledCopyOfLL(pop1,0.5,0.5);
	pop2 = ShapeTransforms.translatedCopyOf(pop2,150,0);
	g2.setColor(Color.BLACK); g2.draw(pop2);
	
	// Here's a lollipop that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	pop2 = ShapeTransforms.scaledCopyOfLL(pop2,4,4);
	pop2 = ShapeTransforms.translatedCopyOf(pop2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(pop2); 
	

	// Draw two lollipops with swirls
	
	LollipopWithSwirls popSw1 = new LollipopWithSwirls(100,350,75,75);
	LollipopWithSwirls popSw2 = new LollipopWithSwirls(200,350,100,100);
	
	g2.draw(popSw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(popSw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Lollipops by Eric Palyan", 20,20);
    }


    /** Draw a picture with a few lollipops
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Lollipop large = new Lollipop(100,50,150,150);
	Lollipop smallCC = new Lollipop(20,50,30,30);
	LollipopWithSwirls tallSkinny = new LollipopWithSwirls(20,150,20,40);
	LollipopWithSwirls shortFat = new LollipopWithSwirls(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Lollipop pop1 = new Lollipop(100,250,125,125);
	g2.setColor(Color.CYAN); g2.draw(pop1);
	
	// Make a black lollipop that's half the size, 
	// and moved over 150 pixels in x direction
	Shape pop2 = ShapeTransforms.scaledCopyOfLL(pop1,0.5,0.5);
	pop2 = ShapeTransforms.translatedCopyOf(pop2,150,0);
	g2.setColor(Color.BLACK); g2.draw(pop2);
	
	// Here's a lollipop that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	pop2 = ShapeTransforms.scaledCopyOfLL(pop2,4,4);
	pop2 = ShapeTransforms.translatedCopyOf(pop2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(pop2); 
	
	// Draw two houses with Windows
	
	LollipopWithSwirls pw1 = new LollipopWithSwirls(50,350,40,40);
	LollipopWithSwirls pw2 = new LollipopWithSwirls(200,200,200,200);
	
	g2.draw(pw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape pw3 = ShapeTransforms.rotatedCopyOf(pw2, Math.PI/4.0);

	g2.draw(pw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Lollipops by Eric Palyan", 20,20);
    }
  
    /** Draw a different picture with a lollipop
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Lollipops by Eric Palyan", 20,20);

	
	// Draw some coffee cups.
	
       LollipopWithSwirls large = new LollipopWithSwirls(100,50,225,150);
       Lollipop smallCC = new Lollipop(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
