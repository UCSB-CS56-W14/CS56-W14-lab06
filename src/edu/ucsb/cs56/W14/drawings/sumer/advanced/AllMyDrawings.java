package edu.ucsb.cs56.w14.drawings.sumer.advanced;

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
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Stereo h1 = new Stereo(100,250,100,75);
	g2.setColor(Color.RED); g2.draw(h1);

	Stereo h3 = new Stereo(50,100,70,50);
	g2.setColor(Color.RED); g2.draw(h3);

	StereoWithButtons h2 = new StereoWithButtons(400,250,100,75);
	g2.setColor(Color.BLACK); g2.draw(h2);

	StereoWithButtons h4 = new StereoWithButtons(250,300,50,40);
	g2.setColor(Color.GREEN); g2.draw(h4);

	
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	g2.drawString("A stereo by Sumer", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Stereo large = new Stereo(100,100,225,150);
	StereoWithButtons smallCC = new StereoWithButtons(20,100,40,30);
	Stereo tallSkinny = new Stereo(20,150,20,40);
	StereoWithButtons shortFat = new StereoWithButtons(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Stereo h1 = new Stereo(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black stereo that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a stereo that's 4x as big (2x the original)
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
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Stereos by Sumer Sinha", 20,20);

	Stereo hw8 = new Stereo(300,350,100,70);
       
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second stereo 45 degrees around its center.
	Shape hw9 = ShapeTransforms.rotatedCopyOf(hw8, Math.PI/4.0);
	g2.draw(hw9);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Stereos by Sumer Sinha", 20,20);

	
	
       StereoWithButtons large = new StereoWithButtons(100,150,225,150);
       StereoWithButtons smallCC = new StereoWithButtons(60,150,40,30);

	
       Stereo hw1 = new Stereo(100,400,80,30);
       Stereo hw2 = new Stereo(400,250,200,300);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second stereo 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	g2.draw(hw3);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
