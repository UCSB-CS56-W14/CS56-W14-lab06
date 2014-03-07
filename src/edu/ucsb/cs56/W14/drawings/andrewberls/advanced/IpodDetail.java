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
public class IpodDetail extends Ipod implements Shape
{
    /**
       Constructor
       @param x the coordinate of the left edge
       @param y the coordinate of the top
       @param width the width of the iPod
     */
    public IpodDetail(double x, double y, double bodyWidth)
    {

        // Create the basic shell that we will be adding to
        super(x, y, bodyWidth);

        double padding = 10;
        double screenWidth = bodyWidth - (2*padding);
        double screenHeight = .66 * bodyWidth;
        double screenX = x + (bodyWidth - screenWidth)/2;
        double screenY = y + (bodyWidth - screenWidth)/2;

        double scrollInnerRadius = 0.38 * (0.35*screenWidth);
        double scrollInnerX = x + bodyWidth/2;
        double scrollInnerY = y + screenHeight + (padding/2) + ((1.5 * bodyWidth)-screenHeight)/2;

        double albumWidth = 0.4 * (bodyWidth - (2*padding));
        double albumHeight = albumWidth;
        double albumX = screenX + padding;
        double albumY = screenY + padding;

        double progressWidth = screenWidth - (2*padding);
        double progressHeight = padding;
        double progressX = screenX + padding;
        double progressY = screenY + screenHeight - (2*padding);


        // The extended class adds the button inside the scroll wheel,
        // and a box for album art/progress bar on the screen

        Ellipse2D.Double scrollWheelInner = new Ellipse2D.Double(scrollInnerX-scrollInnerRadius, scrollInnerY-scrollInnerRadius,
                                                                 scrollInnerRadius*2, scrollInnerRadius*2);

        Rectangle2D.Double progress = new Rectangle2D.Double(progressX, progressY,
                                            progressWidth, progressHeight);

        Rectangle2D.Double album = new Rectangle2D.Double(albumX, albumY,
                                            albumWidth, albumHeight);

        // put the whole iPod together
        GeneralPath iPodDetail = this.get();
        iPodDetail.append(scrollWheelInner, false);
        iPodDetail.append(album, false);
        iPodDetail.append(progress, false);
    }

}
