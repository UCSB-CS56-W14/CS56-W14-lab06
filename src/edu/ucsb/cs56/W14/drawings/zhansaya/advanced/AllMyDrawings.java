package edu.ucsb.cs56.w14.drawings.zhansaya.advanced;

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
 * @author Zhansaya Abdikarimova
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Pies 
     */

    public static void drawPicture1(Graphics2D g2){

	Pie p1 = new Pie(400,250,55);
	g2.setColor(Color.RED); 
	g2.draw(p1);
	
	// Draw a Pie with apples 
	ApplePie ap1 = new ApplePie(200,150,100);
	g2.setColor(new Color(0x8F00FF));
	g2.draw(ap1);
    }


    /** Draw a picture with a few Pies 
     */
    public static void drawPicture2(Graphics2D g2){
	
	
	Pie p1 = new Pie(100,250,75);
	g2.setColor(Color.RED); 
	g2.draw(p1);
	
	// Make a green Pie that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.GREEN); 
	g2.draw(p2);
	
	// Here's a Pie that's 3x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,3,3);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, 
				       BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(242,179,111)); 
	g2.draw(p2); 
	
	// Draw two Pies with Apples	
	ApplePie ap1 = new ApplePie(50,50,25);
	ApplePie ap2 = new ApplePie(300,150,100);
       	g2.draw(ap1);
	g2.setColor(new Color(0x8F0000)); 

	// Rotate the second Pie 45 degrees around its center.
	Shape ap3 = ShapeTransforms.rotatedCopyOf(ap2, Math.PI/4.0);
	g2.draw(ap3);
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	
	g2.drawString("A bunch of simple and apple pies by Zhansaya Abdikarimova", 20,20);
    }
  
    /** Draw a different picture with a few pies and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
		g2.drawString("A sample of coffee cup by Phill Conrad", 20,20);
		g2.drawString("Apple pie and created by Zhansaya Abdikarimova",20,40);

		// Draw some coffee cups
		CoffeeCup cc = new CoffeeCup(20,50,70,50);
		g2.setColor(Color.RED);   g2.draw(cc);

		// Here some simple pie and  apple pies
		Pie p1 = new Pie(125, 250, 75);
		g2.setColor(Color.CYAN);
		g2.draw(p1);  

		ApplePie p2 = new ApplePie(325, 150, 100);
		g2.setColor(Color.ORANGE);
		g2.draw(p2);
	
       
       
       
    }
    

}
