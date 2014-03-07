package edu.ucsb.cs56.w14.drawings.khuu.advanced;

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
 * @author Lesley Khuu
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Tower of Hanois
     */

    public static void drawPicture1(Graphics2D g2) {

	Hanoi h1 = new Hanoi(50,50,300,50);
	g2.setColor(Color.CYAN); g2.draw(h1);

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
        
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2);
	
	BiggerHanoi hw1 = new BiggerHanoi(50,150,400,75);
	BiggerHanoi hw2 = new BiggerHanoi(200,350,200,25);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Tower of Hanois by Lesley Khuu", 20,20);
    }


    /** Draw a picture with a few Tower of Hanois
     */
    public static void drawPicture2(Graphics2D g2) {

	
	Hanoi largeH = new Hanoi(100,400,225,50);
	Hanoi smallH = new Hanoi(20,50,300,30);
	Hanoi tallH = new Hanoi(20,150,100,10);
	Hanoi shortH = new Hanoi(20,250,200,20);
	
	g2.setColor(Color.RED);     g2.draw(largeH);
	g2.setColor(Color.GREEN);   g2.draw(smallH);
	g2.setColor(Color.BLUE);    g2.draw(tallH);
	g2.setColor(Color.MAGENTA); g2.draw(shortH);
	
	Hanoi h1 = new Hanoi(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
        
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2);
	
	BiggerHanoi hw1 = new BiggerHanoi(50,350,40,75);
	BiggerHanoi hw2 = new BiggerHanoi(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF));
        
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Tower of Hanois by Lesley Khuu", 20,20);
    }
  
    /** Draw a different picture with a few Tower of Hanois
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Tower of Hanois by Lesley Khuu", 20,20);

	
       Hanoi largeH = new Hanoi(0,50,400,20);
       Hanoi smallH = new Hanoi(20,50,40,30);
       
       g2.setColor(Color.pink);     g2.draw(largeH);
       g2.setColor(Color.gray);   g2.draw(smallH);
       
       
    }
    

}
