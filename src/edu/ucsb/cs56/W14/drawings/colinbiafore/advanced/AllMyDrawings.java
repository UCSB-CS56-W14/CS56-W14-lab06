package edu.ucsb.cs56.w14.drawings.colinbiafore.advanced;

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
 * @author Colin Biafore
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Trees
     */

    public static void drawPicture1(Graphics2D g2) {
	
	// Create a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 

	// Set the stroke to thick
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.BLACK);
	
	//Draw a single tree
	Tree t1 = new Tree(80,175,150);
	g2.draw(t1);
	
	

	//Copy first tree and move it 150 pixels in the x direction
	//Repeat ant create rows of trees 150 and -150 pixels in the y direction
	

	Shape t2 = ShapeTransforms.translatedCopyOf(t1,150,0);
	g2.draw(t2);

	
	Shape t3 = ShapeTransforms.translatedCopyOf(t1, 300, 0);
	g2.draw(t3);

	Shape t4 = ShapeTransforms.translatedCopyOf(t1, 450, 0);
	g2.draw(t4);
	
	//set color of above and below rows to red
	g2.setColor(Color.RED);

	Shape t5 = ShapeTransforms.translatedCopyOf(t1, 75, -150);
	g2.draw(t5);

	Shape t6 = ShapeTransforms.translatedCopyOf(t1, 225, -150);
	g2.draw(t6);

	Shape t7 = ShapeTransforms.translatedCopyOf(t1, 375, -150);
	g2.draw(t7);

	Shape t8 = ShapeTransforms.translatedCopyOf(t1, 75, 150);
	g2.draw(t8);

	Shape t9 = ShapeTransforms.translatedCopyOf(t1, 225, 150);
	g2.draw(t9);

	Shape t10 = ShapeTransforms.translatedCopyOf(t1, 375, 150);
	g2.draw(t10);

	//Sign the drawing
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few trees by Colin Biafore", 20,20);
    }


    /** Draw a picture with a few trees and christmas trees
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	

	//Create original stroke variable so switching is easy
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.BLACK);

	Tree t1 = new Tree(300,50,175);
	
	
	Shape t2 = ShapeTransforms.rotatedCopyOf(t1,Math.PI);
	g2.setColor(Color.GREEN);
	g2.draw(t2);

	ChristmasTree ct1 = new ChristmasTree(300,50,175);
	Shape ct2 = ShapeTransforms.rotatedCopyOf(ct1, Math.PI);
	ct2 = ShapeTransforms.translatedCopyOf(ct2,130,110);
	ct2 = ShapeTransforms.rotatedCopyOf(ct2,Math.PI/2.0);
	g2.setStroke(orig);
	g2.setColor(Color.RED);
	g2.draw(ct2);

	Tree t3 = new Tree(300,280,175);
	g2.setStroke(thick);
	g2.setColor(Color.GREEN);
	g2.draw(t3);

	ChristmasTree ct3 = new ChristmasTree(300,50,175);
	Shape ct4 = ShapeTransforms.rotatedCopyOf(ct3, Math.PI);
	ct4 = ShapeTransforms.translatedCopyOf(ct4,-130,110);
	ct4 = ShapeTransforms.rotatedCopyOf(ct4,3 *(Math.PI/2.0));
	g2.setStroke(orig);
	g2.setColor(Color.RED);
	g2.draw(ct4);

      
	
	//Sign the drawing
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("More trees with a few Christmas trees by Colin Biafore", 20,20);
    }
  
    /** Draw a picture with a few Christmas Trees
     */

    public static void drawPicture3(Graphics2D g2) {
	int y = 0;
	int z = 0;
	g2.drawString("Christmas Trees by Colin Biafore", 20,20);


	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	

	//Create original stroke variable so switching is easy
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.RED);
	
	// label the drawing
	

	for(int i = 0; i < 5; i++) {
	   

	ChristmasTree ct1 = new ChristmasTree(100 + z,30 , 250);
	
	if(y == 0) {
	    g2.setColor(Color.GREEN);
	    y += 1;
	} else {
	    g2.setColor(Color.RED);
	    y -= 1;
	}

	g2.draw(ct1);
	
	z += 100;
	}
	

       
       
    }
    

}
