package edu.ucsb.cs56.w14.drawings.andrewberls.advanced;


import java.awt.Rectangle;
import java.awt.Shape; // general class for shapes
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an Ipod that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Andrew Berls
   @version for CS56, W14, UCSB, 02/12/2014

*/
public class Ipod extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       @param x the coordinate of the left edge
       @param y the coordinate of the top
       @param width the width of the iPod
     */
    public Ipod(double x, double y, double bodyWidth)
    {
        double padding = 10;
        double bodyHeight = 1.5 * bodyWidth;
        double screenWidth = bodyWidth - (2*padding);
        double screenHeight = .66 * bodyWidth;
        double screenX = x + (bodyWidth - screenWidth)/2;
        double screenY = y + (bodyWidth - screenWidth)/2;

        double scrollOuterRadius = 0.35 * screenWidth;
        double scrollOuterX = x + bodyWidth/2;
        double scrollOuterY = y + screenHeight + (padding/2) + (bodyHeight-screenHeight)/2;

        Rectangle2D.Double body   = new Rectangle2D.Double(x, y, bodyWidth, bodyHeight);
        Rectangle2D.Double screen = new Rectangle2D.Double(screenX, screenY, screenWidth, screenHeight);

        Ellipse2D.Double scrollWheelOuter = new Ellipse2D.Double(scrollOuterX-scrollOuterRadius, scrollOuterY-scrollOuterRadius,
                                                                 scrollOuterRadius*2, scrollOuterRadius*2);


        // put the whole iPod together
        GeneralPath iPod = this.get();
        iPod.append(body, false);
        iPod.append(screen, false);
        iPod.append(scrollWheelOuter, false);
    }

}
