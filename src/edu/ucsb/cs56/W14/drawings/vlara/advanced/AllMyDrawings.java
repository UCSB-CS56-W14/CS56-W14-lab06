package edu.ucsb.cs56.w14.drawings.vlara.advanced;

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
 * @author Vincente Lara 
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few hourglasses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Hourglass h1 = new Hourglass(156,356,45,88);
	g2.setColor(Color.darkGray); g2.draw(h1);
	
	// Make a blue hourglass, 
	// and moved over 150 pixels in x direction
	// and 25 pixels in y direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.25,0.25);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,25);
	g2.setColor(Color.blue); g2.draw(h2);
	
	// Here's a hourglass that's 6x as big (3x the original)
	// and moved 150  more pixels to down.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,0,150);
	
	// Drawn with a thinner stroke
	Stroke thin = new BasicStroke (5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thin);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two houses with Windows
	
	HourglassFull hw1 = new HourglassFull(30,400,18,91);
	HourglassFull hw2 = new HourglassFull(200,350,50,100); //initally 200,100
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.magenta); 
	g2.drawString("A few Hourglasses by Vincente Lara", 25,25);
    }


    /** Draw a picture with a few hourglasses
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some hourglasses.
	
/*
	HourglassFull large = new HourglassFull(100,50,225,150);
	HourglassFull smallCC = new HourglassFull(20,50,40,30);
	HourglassFull tallSkinny = new HourglassFull(20,150,20,40);
	HourglassFull shortFat = new HourglassFull(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
*/
	
	HourglassFull hf1 = new HourglassFull(25,30,100,300);
	g2.setColor(Color.CYAN); g2.draw(hf1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(hf1,0.5,0.5);
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
	
	// Draw two houses with Windows
	
	HourglassFull hw1 = new HourglassFull(50,350,40,75);
	HourglassFull hw2 = new HourglassFull(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A couple Hourglasses by Vincente Lara", 20,20);

	
	// Draw some coffee cups.
	
       HourglassFull large = new HourglassFull(100,50,225,150);
       HourglassFull smallCC = new HourglassFull(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
