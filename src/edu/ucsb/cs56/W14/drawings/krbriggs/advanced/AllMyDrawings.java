package edu.ucsb.cs56.w14.drawings.krbriggs.advanced;

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
 * @author Kevin Briggs	
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few santas and hats 
     */

    public static void drawPicture3(Graphics2D g2) {

	SantaHat h1 = new SantaHat(100,250,5,10);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black hat that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a hat that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two hats with santas
	
	SantaWithHat hw1 = new SantaWithHat(50,350,10);
	SantaWithHat hw2 = new SantaWithHat(200,350,25);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few santa hats and santas by Phill Kevin Briggs", 20,20);
    }

    

    public static void drawPicture2(Graphics2D g2) {



	SantaHat large = new SantaHat(100,50,22,15);
	SantaHat smallCC = new SantaHat(20,50,4,30);
	SantaHat tallSkinny = new SantaHat(200,105,2,4);
	SantaHat shortFat = new SantaHat(20,250,4,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	SantaHat h1 = new SantaHat(100,250,5,7);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black hat that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a hat that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two hats
	
	SantaHat hw1 = new SantaHat(50,350,14,17);
	SantaHat hw2 = new SantaHat(200,350,12,19);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second hat 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	
	g2.drawString("A bunch of santa hats by Kevin Briggs", 20,20);

    }
  
   

    public static void drawPicture1(Graphics2D g2) {
	
	
       
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	
	
	
	SantaHat hw1 = new SantaWithHat(50,350,17);
	SantaHat hw2 = new SantaWithHat(200,350,19);
	SantaHat hw3 = new SantaWithHat(100,350,19);
	SantaHat hw4 = new SantaWithHat(300,350,19);
	SantaHat hw5 = new SantaWithHat(200,250,19);
	SantaHat hw6 = new SantaWithHat(200,150,19);
	SantaHat hw7 = new SantaWithHat(200,35,19);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	
	Shape hw32 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	
	Shape hw33 = ShapeTransforms.rotatedCopyOf(hw3, 3*Math.PI/4.0);
	 
	Shape hw34 = ShapeTransforms.rotatedCopyOf(hw4, Math.PI);
	
	Shape hw35 = ShapeTransforms.rotatedCopyOf(hw5, 2*Math.PI);
	
	Shape hw36 = ShapeTransforms.rotatedCopyOf(hw6, Math.PI/2.0);
	 
	Shape hw37 = ShapeTransforms.rotatedCopyOf(hw7, Math.PI/4.0);



	g2.draw(hw32);
	g2.setColor(new Color(0x006400));
	g2.draw(hw33);
	g2.setColor(new Color(0x0000FF)); 
	g2.draw(hw34);
	g2.setColor(new Color(0xFF4500)); 
	g2.draw(hw35);
	g2.setColor(new Color(0xDC143C));
	g2.draw(hw37);
	
	




	
	
	g2.drawString("A bunch of rotated santas by Kevin Briggs", 20,20);
       
    }
 

}
