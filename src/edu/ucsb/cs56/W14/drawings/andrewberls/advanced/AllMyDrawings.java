package edu.ucsb.cs56.w14.drawings.andrewberls.advanced;

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
    /** Draw a picture with two basic iPods
     */

    public static void drawPicture1(Graphics2D g2) {
        // Large black iPod in top left
        Ipod i1 = new Ipod(100, 100, 200);
        g2.setColor(Color.BLACK); g2.draw(i1);

        // Make a squashed iPod and move it over
        Shape i2 = ShapeTransforms.scaledCopyOfLL(i1,0.75,0.5);
        i2 = ShapeTransforms.translatedCopyOf(i2,250,0);
        g2.setColor(Color.BLACK); g2.draw(i2);

        // Label the drawing
        g2.setColor(Color.BLACK);
        g2.drawString("An iPod and its squashed twin by Andrew Berls", 20,20);
    }


    /** Draw a picture with some colored iPods with detail
     */
    public static void drawPicture2(Graphics2D g2) {
        // Left
        Ipod i1 = new Ipod(75, 100, 150);
        g2.setColor(Color.RED); g2.draw(i1);

        // Middle
        Ipod i2 = new Ipod(225, 137, 125);
        g2.setColor(Color.BLUE); g2.draw(i2);

        // Right
        IpodDetail i3 = new IpodDetail(350, 25, 200);
        g2.setColor(Color.ORANGE); g2.draw(i3);

        // Label the drawing
        g2.setColor(Color.BLACK);
        g2.drawString("An few iPods lined up by Andrew Berls", 20,20);
    }

    /** Draw a different picture with iPods all over the place
     */

    public static void drawPicture3(Graphics2D g2) {
        // Large black iPod in top left
        IpodDetail i1 = new IpodDetail(100, 100, 200);
        g2.setColor(Color.BLACK); g2.draw(i1);

        // Red iPod on the bottom right
        Ipod i2 = new Ipod(400, 200, 115);
        g2.setColor(Color.RED); g2.draw(i2);

        // Rotated blue iPod in upper right
        IpodDetail i3t = new IpodDetail(400, 0, 125);
        g2.setColor(Color.BLUE);
        Shape i3 = ShapeTransforms.rotatedCopyOf(i3t, Math.PI/-2.0);
        g2.draw(i3);

        // Label the drawing
        g2.drawString("A bunch of iPods by Andrew Berls", 20,20);
    }


}
