package edu.ucsb.cs56.w14.drawings.wjli.advanced;

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
    /** Draw a picture with a few houses and fruits
     */

    public static void drawPicture1(Graphics2D g2) {

	House h1 = new House(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
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
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	CandiedFruitWithOrange cf1 = new CandiedFruitWithOrange(400, 200, 600);
	g2.setColor(Color.RED); 
	g2.draw(cf1);

	CandiedFruitWithOrange cf2 = new CandiedFruitWithOrange(200, 130, 500);
	g2.setColor(Color.ORANGE); 
	g2.draw(cf2);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few houses by Phill Conrad and a few fruits by Oliver", 20,20);
    }


    /** Draw a picture with a few houses, fruits and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	CoffeeCup large = new CoffeeCup(100,50,225,150);
	CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
	CoffeeCup tallSkinny = new CoffeeCup(20,150,20,40);
	CoffeeCup shortFat = new CoffeeCup(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	House h1 = new House(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
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
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

	CandiedFruitWithOrange cf1 = new CandiedFruitWithOrange(400, 200, 600);
	g2.setColor(Color.RED); 
	g2.draw(cf1);

	CandiedFruitWithOrange cf2 = new CandiedFruitWithOrange(200, 130, 500);
	g2.setColor(Color.ORANGE); 
	g2.draw(cf2);
	 
	Shape hw4 = ShapeTransforms.rotatedCopyOf(cf2, Math.PI/3.0);
	g2.setColor(Color.BLUE);
	g2.draw(hw4);	

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups, a few houses by Phill Conrad and a bunch of fruits by Oliver", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad and a series of fruits by Oliver (Looks soooooo delicious!!!)", 20,20);

	
	// Draw some coffee cups and some fruits.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);

	CandiedFruitWithOrange cf1 = new CandiedFruitWithOrange(400, 180, 500);
	g2.setColor(Color.ORANGE); 
	g2.draw(cf1);

	CandiedFruitWithOrange cf2 = new CandiedFruitWithOrange(400, 170, 450);
	g2.setColor(Color.YELLOW);
	Shape hw1 = ShapeTransforms.rotatedCopyOf(cf2, Math.PI*13.0/7.0); 
	g2.draw(hw1);

	CandiedFruitWithOrange cf3 = new CandiedFruitWithOrange(400, 160, 400);
	g2.setColor(Color.GREEN);
	Shape hw2 = ShapeTransforms.rotatedCopyOf(cf3, Math.PI*11.0/6.0); 
	g2.draw(hw2);

	CandiedFruitWithOrange cf4 = new CandiedFruitWithOrange(400, 150, 350);
	g2.setColor(Color.BLUE);
	Shape hw3 = ShapeTransforms.rotatedCopyOf(cf4, Math.PI*9.0/5.0); 
	g2.draw(hw3);

	CandiedFruitWithOrange cf5 = new CandiedFruitWithOrange(400, 140, 300);
	g2.setColor(Color.MAGENTA);
	Shape hw4 = ShapeTransforms.rotatedCopyOf(cf5, Math.PI*7.0/4.0); 
	g2.draw(hw4);

	CandiedFruitWithOrange cf6 = new CandiedFruitWithOrange(400, 130, 250);
	g2.setColor(Color.RED);
	Shape hw5 = ShapeTransforms.rotatedCopyOf(cf6, Math.PI*5.0/3.0); 
	g2.draw(hw5);
       
       
    }
    

}
