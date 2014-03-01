package edu.ucsb.cs56.w14.drawings.dcoffill.advanced;

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
 * @author David Coffill
 * @version for CS10, lab06, Spring 2009
 * @version Updated for CS 56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few laptops
     */

    public static void drawPicture1(Graphics2D g2) {

		// Draw a laptop that's a stylish cyan
		Laptop laptop = new Laptop(50, 200, 160, 90);
		g2.setColor(Color.CYAN); g2.draw(laptop);

		// Make a black laptop that's half the size,
		// and moved over 200 pixels in x direction

		Shape laptop3 = ShapeTransforms.scaledCopyOfLL(laptop,0.5,0.5);
		laptop3 = ShapeTransforms.translatedCopyOf(laptop3 , 200,0);
		g2.setColor(Color.BLACK); g2.draw(laptop3);

		// Scale and translate the laptop
		laptop3 = ShapeTransforms.scaledCopyOfLL(laptop3,4,4);
		laptop3 = ShapeTransforms.translatedCopyOf(laptop3,150,0);

		// Draw with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);


		// Change stroke size and color
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7));
		g2.draw(laptop3);

		// Draw two laptops with screens

		LaptopWithScreen lws1 = new LaptopWithScreen(200, 300, 100, 70);
		LaptopWithScreen lws2 = new LaptopWithScreen(50, 400, 120, 90);


		g2.draw(lws1);
		g2.setColor(new Color(0x02AC58)); g2.draw(lws2);

		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("A collection of laptops, by David Coffill", 20,20);
    }


    /** Draw a picture with a few laptops
     */
    public static void drawPicture2(Graphics2D g2) {
		Stroke orig=g2.getStroke();

		// Draw a couple of laptops here
		Laptop laptop = new Laptop(80, 250, 160, 90);
		Laptop laptop2 = new Laptop(200, 400, 250, 120);
		LaptopWithScreen laptop3 = new LaptopWithScreen(400, 140, 192, 108);

		Shape rLaptop2 = ShapeTransforms.rotatedCopyOf(laptop2, -Math.PI/4.0);
		Shape rotatedLaptop = ShapeTransforms.rotatedCopyOf(laptop3, Math.PI/4.0);


		g2.setColor(Color.CYAN); g2.draw(laptop);
		g2.setColor(Color.ORANGE); g2.draw(rLaptop2);
		g2.setColor(Color.MAGENTA); g2.draw(rotatedLaptop);



		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("Laptops and rotation, by David Coffill", 20,20);
    }
  
    /** Draw a different picture with a few laptops
     */

    public static void drawPicture3(Graphics2D g2) {
	
		// label the drawing
	
		g2.drawString("Even more laptops, by David Coffill", 20,20);



		// Draw some laptops of different sizes
    	Laptop laptop1 = new Laptop(18, 150, 150, 100);
		LaptopWithScreen laptop2 = new LaptopWithScreen(250, 350, 225, 150);

		g2.setColor(Color.MAGENTA);     g2.draw(laptop1);
		g2.setColor(Color.GRAY);   g2.draw(laptop2);
       
       
    }
    

}
