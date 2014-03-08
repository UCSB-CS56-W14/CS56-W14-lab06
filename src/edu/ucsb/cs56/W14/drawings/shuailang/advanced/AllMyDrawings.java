package edu.ucsb.cs56.w14.drawings.shuailang.advanced;

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
 * @author Shuai Lang
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few shoer heads 
     */

    public static void drawPicture1(Graphics2D g2) {
	/*
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
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few houses by Phill Conrad", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
	showerHead s1 = new showerHead(150,100,60,8);
	g2.setColor(Color.BLUE);
	g2.draw(s1);

	// Make a black showerHead that's half the size,
        // and moved over 150 pixels in x direction

        Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
        s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
        g2.setColor(Color.BLACK); g2.draw(s2);

	// Here's a shoer that's 4x as big (2x the original)
        // and moved over 150 more pixels to right.
        s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
        s2 = ShapeTransforms.translatedCopyOf(s2,150,0);

	// We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.
					JOIN_BEVEL);

       

	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7));
	g2.draw(s2);
	

	//draw a shower with water comes out
	showerHeadWithWater ww1 = new showerHeadWithWater(150,100,60,8);
	g2.setColor(Color.CYAN); g2.draw(ww1);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

        g2.setStroke(orig);
        g2.setColor(Color.BLACK);
        g2.drawString("A few shower heads by Shuai Lang", 20,20);

    }	
    public static void drawPicture2(Graphics2D g2) {
	/*
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
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
	*/
	showerHead s1 = new showerHead(230,170,100,13);
        g2.setColor(Color.RED);
        g2.draw(s1);

	showerHeadWithWater ww1 = new showerHeadWithWater(150,100,200,24);
        g2.setColor(Color.ORANGE); g2.draw(ww1);
	

	
	showerHead s3 = new showerHead(150,100,60,8);
        g2.setColor(Color.RED);
        g2.draw(s1);
	
	// Make a black showerHead that's half the size,
        // and moved over 150 pixels in x direction

        Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
        s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
        g2.setColor(Color.BLACK); g2.draw(s2);

	// Here's a house that's 4x as big (2x the original)
        // and moved over 150 more pixels to right.
        s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
        s2 = ShapeTransforms.translatedCopyOf(s2,150,0);

        // We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.
                                        JOIN_BEVEL);



        // #002FA7 is "International Klein Blue" according to Wikipedia
        // In HTML we use #, but in Java (and C/C++) its 0x

        Stroke orig=g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(Color.ORANGE);
	g2.draw(s2);


	//draw a shower with water comes out
        showerHeadWithWater ww2 = new showerHeadWithWater(150,100,60,8);
        g2.setColor(Color.CYAN); g2.draw(ww2);


	// Rotate the second house 45 degrees around its center.
        Shape hw3 = ShapeTransforms.rotatedCopyOf(ww1, Math.PI/4.0);

        g2.draw(hw3);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

        g2.setStroke(orig);
        g2.setColor(Color.BLACK);
        g2.drawString("A few shower heads by Shuai Lang", 20,20);



    }
  
    /** Draw a different picture with a few shower heads
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of shower heads by Shuai Lang", 20,20);

	
	// Draw some shower heads.
	
       showerHeadWithWater large = new showerHeadWithWater(100,50,225,15);
       showerHead smallCC = new showerHead(20,50,40,5);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
