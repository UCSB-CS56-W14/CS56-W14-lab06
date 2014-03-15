package edu.ucsb.cs56.w14.drawings.tomcraig.advanced;

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
    /** Draw a picture with a few houses
     */

    public static void drawPicture1(Graphics2D g2)
    {
    	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

		//Make on eye to the left side of the screen
		Eye eye1 = new Eye(100, 250, 50, 75);
		g2.setColor(Color.BLACK);
		g2.draw(eye1);

		Shape eye2 = ShapeTransforms.scaledCopyOfLL(eye1, 2.5, 2.5);
		eye2 = ShapeTransforms.translatedCopyOf(eye2, 205, 32);
		g2.setColor(Color.RED);
		g2.draw(eye2);

		//eye2 = ShapeTransforms.scaledCopyOfLL(eye1, 3, 3);
		eye2 = ShapeTransforms.translatedCopyOf(eye1, 450, 42);

		Stroke orig = g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x0079443B));
		g2.draw(eye2);

		EyeWithIris eyeW1 = new EyeWithIris(50, 350, 30, 43);
		EyeWithIris eyeW2 = new EyeWithIris(100, 200, 500, 350);
	    g2.setColor(new Color(0x0079443B));
		g2.draw(eyeW1);

		g2.setColor(new Color(0x00DE3163));
		g2.draw(eyeW2);

		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("I see you by Tom Craig", 20,20);

	}


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2)
    {
		Eye large = new Eye(200, 100, 200, 100);
		Eye small = new Eye(100, 600, 400, 500);
		Eye skinny = new Eye(20, 150, 20, 20);
		Eye fatty = new Eye(10, 190, 10, 10);

		g2.setColor(Color.WHITE);
		g2.draw(large);
		g2.setColor(Color.BLACK);
		g2.draw(small);
		g2.setColor(Color.RED);
		g2.draw(skinny);
		g2.setColor(Color.BLUE);
		g2.draw(fatty);

		Stroke thick = new BasicStroke (7.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

		EyeWithIris lazy = new EyeWithIris(450, 500, 100, 8);

		g2.setColor(Color.CYAN);
		g2.draw(lazy);

		Stroke orig = g2.getStroke();
		g2.setColor(new Color(0x0066FF00));
		g2.draw(lazy);


		Shape eyeW1 = new EyeWithIris(350, 300, 100, 10);
		Shape eyeW2 = ShapeTransforms.scaledCopyOfLL(eyeW1,0.5,0.5);
		Shape eyeW3 = ShapeTransforms.rotatedCopyOf(eyeW2, Math.PI/2.0);


		g2.draw(eyeW1);
		g2.setColor(new Color(0x0036454F));
		g2.draw(eyeW2);
		g2.setColor(new Color(0x0036453F));
		g2.setStroke(thick);

		g2.draw(eyeW3);

		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("I'm watching you by Tom Craig", 20,20);
    }

    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2)
    {

		// label the drawing
		g2.drawString("I know what you what you did last summer by Tom Craig", 20,20);

		Shape large = new Eye(100,50,75,150);
		Shape small = ShapeTransforms.rotatedCopyOf(large, Math.PI/4.0);

		g2.setColor(Color.GREEN);
		g2.draw(large);
		g2.setColor(Color.RED);
		g2.draw(small);
    }
}
