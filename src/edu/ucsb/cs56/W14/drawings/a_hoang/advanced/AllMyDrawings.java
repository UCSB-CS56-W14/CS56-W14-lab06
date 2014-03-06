package edu.ucsb.cs56.w14.drawings.a_hoang.advanced;

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
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Board b1 = new Board(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two houses with Windows
	
	Skateboard sb1 = new Skateboard(50,350,140,75);
	Skateboard sb2 = new Skateboard(200,350,200,100);
	
	g2.draw(sb1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few houses by Anthony Hoang", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Boards
	
	Board large = new Board(100,50,225,150);
	Board smallB = new Board(20,50,40,30);
	Board tallSkinny = new Board(20,150,20,40);
	Board shortFat = new Board(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallB);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Board B1 = new Board(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(B1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape B2 = ShapeTransforms.scaledCopyOfLL(B1,0.5,0.5);
	B2 = ShapeTransforms.translatedCopyOf(B2,150,0);
	g2.setColor(Color.BLACK); g2.draw(B2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 50 more pixels to right.
	B2 = ShapeTransforms.scaledCopyOfLL(B2,4,4);
	B2 = ShapeTransforms.translatedCopyOf(B2,50,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(B2); 
	
	// Draw two houses with Windows
	
	Skateboard sb1 = new Skateboard(350,0,200,120);
	Skateboard sb2 = new Skateboard(300,100,250,140);
	
	g2.draw(sb1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape sb3 = ShapeTransforms.rotatedCopyOf(sb2, Math.PI/4.0);

	g2.draw(sb3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Boards and a few Skateboards by Anthony Hoang", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Boards by Anthony Hoang", 20,20);

	
	// Draw some Boards
	
       Skateboard large = new Skateboard(100,50,225,150);
       Skateboard smallB = new Skateboard(30,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallB);
       
       
    }
    

}
