package edu.ucsb.cs56.w14.drawings.xin.advanced;

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
 * @author Yue Xin 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few balloons 
     */

    public static void drawPicture1(Graphics2D g2) {

	Balloon b1 = new Balloon(100,250,40);
	g2.setColor(Color.PINK); g2.draw(b1);
	
	// Make a red balloon that's half the size, 
	// and moved over 200 pixels in x direction and 50 pixels in y direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,200,50);
	g2.setColor(Color.RED); g2.draw(b2);
	
	// Here's a balloon that's 4x as big (2x the original)
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
	g2.setColor(new Color(0xFFFF66)); 
	g2.draw(b2); 
	
	// Draw two balloons with strings 
	
	BalloonWithString bs1 = new BalloonWithString(200,50,30);
	BalloonWithString bs2 = new BalloonWithString(300,80,50);
	
	g2.draw(bs1);
	g2.setColor(new Color(0x996699)); g2.draw(bs2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.RED); 
	g2.drawString("A few balloons by Yue Xin", 20,20);
    }


    /** Draw a picture with a few balloons 
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some balloons with string.
	
	BalloonWithString red = new BalloonWithString(100,70,40);
	BalloonWithString pink = new BalloonWithString(200,70,40);
	BalloonWithString yellow = new BalloonWithString(300,70,40);

	// We'll draw this with a thicker stroke                                                                                                             
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig=g2.getStroke();
        g2.setStroke(thick);

	g2.setColor(Color.RED);     g2.draw(red);
	g2.setColor(Color.PINK);   g2.draw(pink);
	g2.setColor(Color.YELLOW);    g2.draw(yellow);

	Shape bs1 = ShapeTransforms.scaledCopyOfLL(red,2,2);
        bs1 = ShapeTransforms.rotatedCopyOf(red,Math.PI/6.0);
	bs1 = ShapeTransforms.translatedCopyOf(bs1,350,80);
        g2.setColor(Color.CYAN); g2.draw(bs1);
	
	Balloon b1 = new Balloon(100,350,30);

	g2.setColor(Color.CYAN); g2.draw(b1);
	
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,1,1);
	b2 = ShapeTransforms.rotatedCopyOf(b2,Math.PI/6.0);
	b2 = ShapeTransforms.translatedCopyOf(b2,80,0);
	g2.setColor(Color.BLUE); g2.draw(b2);

	Balloon b3 = new Balloon(250,350,30);
	g2.setColor(new Color(0x9999FF));
	g2.draw(b3);
 
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.RED); 
	g2.drawString("A bunch of balloons and balloons with strings by Yue Xin", 20,20);
    }
  
    /** Draw a different picture with a few balloons with string
     */

    public static void drawPicture3(Graphics2D g2) {
       
	// Draw some balloons with string.
	BalloonWithString bs1 = new BalloonWithString(100,70,40);
        
        // We'll draw this with a thicker stroke                                                                                                             
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        Stroke orig=g2.getStroke();
        g2.setStroke(thick);

        g2.setColor(new Color(0x663399));    
	g2.draw(bs1);

        Shape bs2 = ShapeTransforms.scaledCopyOfLL(bs1,1,1);
        bs2 = ShapeTransforms.rotatedCopyOf(bs2,Math.PI/6.0);
        bs2 = ShapeTransforms.translatedCopyOf(bs2,100,0);
        g2.setColor(Color.CYAN); g2.draw(bs2);

	Shape bs3=ShapeTransforms.verticallyFlippedCopyOf(bs2);
	bs3=ShapeTransforms.translatedCopyOf(bs3,100,300);
	g2.setColor(Color.BLACK); g2.draw(bs3);     

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING                                                                                                           
        g2.setStroke(orig);
        g2.setColor(Color.RED);
        g2.drawString("A few balloons with string by Yue Xin", 20,20);
       
       
    }
    

}
