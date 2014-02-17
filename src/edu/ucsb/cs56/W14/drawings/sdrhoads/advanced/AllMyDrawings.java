package edu.ucsb.cs56.w14.drawings.sdrhoads.advanced;

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
 * @author Sidney Rhoads
 * @version for CS56, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {
	 
	Pizza p1 = new Pizza(100,250,100,100);
	g2.setColor(Color.ORANGE); 
	g2.draw(p1);
	
	// Make a pizza that's half the size, 
	// and moved over 150 pixels in x direction

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.RED); 
	g2.draw(p2);
	
	// Here's a pizza that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
     
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
		
	// thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFBF00)); 
	g2.draw(p2); 
	
	
	PepperoniPizza pp1 = new PepperoniPizza(50,350,70,50);
	PepperoniPizza pp2 = new PepperoniPizza(200,350,90,80);
	
	g2.draw(pp1);
	g2.setColor(new Color(0xFF9966)); g2.draw(pp2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Beautiful Pizzas by Sidney Rhoads", 20,20);
    }


    /** Draw a picture with a pizzas and pepperoni pizza
     */
    public static void drawPicture2(Graphics2D g2) {
	
	 // thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);


	// Draw some pizza.
	PepperoniPizza pp1 = new PepperoniPizza(50,300,70,50);
	PepperoniPizza pp2 = new PepperoniPizza(200,300,90,80);
	
	Shape pp3 = ShapeTransforms.scaledCopyOfLL(pp2,0.7,0.7);
	pp3 = ShapeTransforms.translatedCopyOf(pp3,150,0);
	
	g2.setColor(Color.RED); g2.draw(pp1);
	g2.setColor(new Color(0xFF9966)); g2.draw(pp2);
	g2.setColor(Color.YELLOW); g2.draw(pp3);

	// Draw the Town
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,340,200,100);
	
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw1);
	g2.setColor(Color.BLUE); g2.draw(hw2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Pizza Parade is in Town", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
			
		 // thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		
		// label the drawing
		g2.drawString("Pizza Parade Afterparty", 40,40);
		g2.setColor(Color.MAGENTA); g2.drawString("Dance your pants off!", 400,400);
		
		
		// Draw some pizza.
		
		PepperoniPizza pp1 = new PepperoniPizza(30,300,70,50);
		PepperoniPizza pp2 = new PepperoniPizza(200,300,90,80);
		
		Shape rpp1 = ShapeTransforms.rotatedCopyOf(pp1, Math.toRadians(-30));
		
		Shape rpp2 = ShapeTransforms.rotatedCopyOf(pp2, Math.toRadians(180));
		
		Shape pp3 = ShapeTransforms.scaledCopyOfLL(pp2,0.7,0.7);
		pp3 = ShapeTransforms.translatedCopyOf(pp3,150,0);
		pp3 = ShapeTransforms.rotatedCopyOf(pp3, Math.PI/8.0);
       
		g2.setColor(Color.RED);     g2.draw(rpp1);
		g2.setColor(Color.ORANGE);   g2.draw(rpp2);
		g2.setColor(Color.YELLOW);   g2.draw(pp3);
       
       
    }
    

}
