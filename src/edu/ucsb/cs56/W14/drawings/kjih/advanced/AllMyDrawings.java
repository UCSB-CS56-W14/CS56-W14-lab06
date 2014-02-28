package edu.ucsb.cs56.w14.drawings.kjih.advanced;

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
 * @author Kevin Jih
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Radios without buttons 
     */

    public static void drawPicture1(Graphics2D g2) {

	Radio r1 = new Radio(100,250,50,75);
	g2.setColor(Color.BLUE); 
	g2.draw(r1);
	
	// Make a red radio that's double the size, 
	// and moved over 150 pixels in x direction

	Shape r2 = ShapeTransforms.scaledCopyOfLL(r1,2,2);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	g2.setColor(Color.RED); 
	g2.draw(r2);
	
	// A black radio with a thicker stroke
	// moved 150 pixels in the x directoin
	// moved 25 pixels in the y direction
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	r2 = ShapeTransforms.translatedCopyOf(r2,150,25);
	g2.setStroke(thick);
	g2.setColor(Color.BLACK); 
	g2.draw(r2); 
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Radios without buttons by Kevin Jih", 20,20);
    }


    /** Draw a picture of some radios of varius sizes
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some radios of various sizes.
	
	Radio large = new Radio(100,50,225,150);
	Radio smallCC = new Radio(20,50,40,30);
	Radio tallSkinny = new Radio(20,150,20,40);
	Radio shortFat = new Radio(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Radio r1 = new Radio(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(r1);
	
	// Make a black radio that's half the size, 
	// and moved over 150 pixels in x direction
	Shape r2 = ShapeTransforms.scaledCopyOfLL(r1,0.5,0.5);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	g2.setColor(Color.BLACK); g2.draw(r2);
	
	// Here's a radio that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	r2 = ShapeTransforms.scaledCopyOfLL(r2,4,4);
	r2 = ShapeTransforms.translatedCopyOf(r2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(r2); 
	
	// Draw two radios with buttons
	
	RadioWithButtons rw1 = new RadioWithButtons(50,350,40,75);
	RadioWithButtons rw2 = new RadioWithButtons(200,350,200,100);
	
	g2.draw(rw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second radio 45 degrees around its center.
	Shape rw3 = ShapeTransforms.rotatedCopyOf(rw2, Math.PI/4.0);

	g2.draw(rw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Radios by Kevin Jih", 20,20);
    }
  
    /** Draw a different picture of a few radios
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Radios by Kevin Jih", 20,20);

	
	// Draw some radios.
	
       Radio large = new Radio(100,50,225,150);
       Radio smallRB = new RadioWithButtons(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallRB);

       // Rotate second radio with buttons by 30 degrees around its center
       // move 100 pixels in the y direcion
       g2.setColor(Color.BLUE);
       Shape smallRB2 = ShapeTransforms.rotatedCopyOf(smallRB, Math.PI/6.0);
       smallRB2 = ShapeTransforms.translatedCopyOf(smallRB2, 0, 150);
       g2.draw(smallRB2);
       
       
    }
    

}
