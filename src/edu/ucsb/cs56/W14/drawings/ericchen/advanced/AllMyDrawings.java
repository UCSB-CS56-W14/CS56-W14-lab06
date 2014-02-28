package edu.ucsb.cs56.w14.drawings.ericchen.advanced;

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
 * @author Eric Chen 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few cameras
     */

    public static void drawPicture1(Graphics2D g2) {

	Camera c1 = new Camera(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black camera that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a camera that's 4x as big (2x the original)
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
	
	// Draw two cameras with Stands
	
	CameraWithStand cs1 = new CameraWithStand(50,350,40,75);
	CameraWithStand cs2 = new CameraWithStand(200,350,200,100);
	
	g2.draw(cs1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cs2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cameras by Eric Chen", 20,20);
    }


    /** Draw a picture with a few cameras and cameras with stands
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some cameras.
	
	Camera large = new Camera(100,50,225,150);
	Camera smallC = new Camera(20,50,40,30);
	Camera tallSkinny = new Camera(20,150,20,40);
	Camera shortFat = new Camera(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	CameraWithStand cs1 = new CameraWithStand(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(cs1);
	
	// Make a black camera with stand that's half the size, 
	// and moved over 150 pixels in x direction
	Shape cs2 = ShapeTransforms.scaledCopyOfLL(cs1,0.5,0.5);
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	g2.setColor(Color.BLACK); g2.draw(cs2);
	
	// Here's a camera with stand that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	cs2 = ShapeTransforms.scaledCopyOfLL(cs2,4,4);
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(cs2); 
	
	// Draw two cameras with stands
	
	CameraWithStand cs3 = new CameraWithStand(50,350,40,75);
	CameraWithStand cs4 = new CameraWithStand(200,350,200,100);
	
	g2.draw(cs1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second camera with stand 45 degrees around its center.
	Shape cs5 = ShapeTransforms.rotatedCopyOf(cs4, Math.PI/4.0);

	g2.draw(cs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Cameras and Cameras with stands by Eric Chen", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Cameras by Eric Chen", 20,20);

	
	// Draw some coffee cups.
	
       Camera large = new Camera(100,50,225,150);
       Camera smallC = new Camera(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallC);
       
       
    }
    

}
