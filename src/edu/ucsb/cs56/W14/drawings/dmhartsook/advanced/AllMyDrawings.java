package edu.ucsb.cs56.w14.drawings.dmhartsook.advanced;

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
    /** Draw a picture with a few cookies
     */

    public static void drawPicture1(Graphics2D g2) {

	Cookie c1 = new Cookie(70,150,50);
	g2.setColor(new Color(210, 180, 140));
    g2.draw(c1);
	
	// Make a dark brown cookie that's half the size,
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(new Color(139,125,107)); g2.draw(c2);
	
	// Here's a cookie that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(205,183,158));
	g2.draw(c2);
	
	// Draw two chocolate chip cookies
	
	ChocolateChipCookie cc1 = new ChocolateChipCookie(100,350,75);
	ChocolateChipCookie cc2 = new ChocolateChipCookie(300,350,100);
	
	g2.draw(cc1);
	g2.setColor(new Color(139,131,120)); g2.draw(cc2);
	
	// FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cookies by Deanna Hartsook", 20,20);
    }


    /** Draw a picture with a few chocolate chip cookies
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some chocolate chip cookies.
	
	ChocolateChipCookie large = new ChocolateChipCookie(130,340,110);
	ChocolateChipCookie small = new ChocolateChipCookie(100,75,40);
	ChocolateChipCookie medium = new ChocolateChipCookie(220,150,80);
	ChocolateChipCookie small2 = new ChocolateChipCookie(420,300,45);
	
	g2.setColor(new Color(139,69,19));     g2.draw(large);
	g2.setColor(new Color(205,133,63));   g2.draw(small);
	g2.setColor(new Color(222,184,135));    g2.draw(medium);
	g2.setColor(new Color(160,82,45)); g2.draw(small2);
	
	// Make a black cookie that's half the size,
	// and moved over 160 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(medium,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,160,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a cookie that's 3x as big (1.5x the original)
	// and moved over 90 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,3,3);
	c2 = ShapeTransforms.translatedCopyOf(c2,90,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Chocolate Chip Yumminess by Deanna Hartsook", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
