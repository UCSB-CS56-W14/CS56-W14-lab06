package edu.ucsb.cs56.w14.drawings.ricklee.advanced;

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
 * @author Rick Lee 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few stickmans
     */

    public static void drawPicture1(Graphics2D g2) {

	Stickman s1 = new Stickman(100,250,100);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black stickman that's half the size, 
	// and moved over 150 pixels in x direction

	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a stickman that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	
	// Draw two stickmans with hats
	
	StickmanWithHat sh1 = new StickmanWithHat(50,350,75);
	StickmanWithHat sh2 = new StickmanWithHat(200,350,100);
	
	g2.draw(sh1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sh2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few stickmans by Rick Lee", 20,20);
	
     }
    

    /** Draw a picture with a few stickmans
     */
    public static void drawPicture2(Graphics2D g2) {

	Stickman s1 = new Stickman(50,300,100);
	g2.setColor(Color.GREEN); g2.draw(s1);
	
	// Make a black stickman that's half the size, 
	// and moved over 50 pixels in x direction
	// and 100 pixels in the y direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,50,150);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a stickman that's 2x big
	// and rotate 45 degrees
	// and moved over 70 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,2,2);
	s2 = ShapeTransforms.rotatedCopyOf(s2,Math.PI/4);
	s2 = ShapeTransforms.translatedCopyOf(s2,70,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.RED); 
	g2.draw(s2); 
	
	
	// Draw two stickmans with hats
	
	StickmanWithHat sh1 = new StickmanWithHat(500,250,100);
	StickmanWithHat sh2 = new StickmanWithHat(400,450,150);
	
	g2.draw(sh1);
	Shape sh3 = ShapeTransforms.rotatedCopyOf(sh2,Math.PI);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sh3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A couple stickmans by Rick Lee", 20,20);
    }
  
    /** Draw a different picture upside-down stickmans
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A some upside-down stickman by Rick Lee", 20,20);

	
	// Draw some stickman
	
       Stickman s = new Stickman(400,250,150);
       StickmanWithHat sh = new StickmanWithHat(100,400,200);
       
       Shape s1 = ShapeTransforms.rotatedCopyOf(s,Math.PI);
       Shape sh1 = ShapeTransforms.rotatedCopyOf(sh,Math.PI);

       g2.setColor(Color.RED);     g2.draw(s1);
       g2.setColor(Color.GREEN);   g2.draw(sh1);
           
    }
   
}
