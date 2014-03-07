package edu.ucsb.cs56.w14.drawings.khuu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a barbell that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
 @author Phill Conrad 
 @author Lesley Khuu
   @version for CS56, Winter 2014, UCSB
   
*/
public class Hanoi extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of tower of hanoi
       @param y y coord of lower left corner of tower of hanoi
       @param width width of the tower of hanoi
       @param height of hanoi (including the three blocks)
     */
    public Hanoi(double x, double y, double width, double height)
    {
        double bottomSectionWidth = width;
        double blockHeight = height/3;
        double middleSectionX = x+(bottomSectionWidth/6);
        double middleSectionY = y+height/3;
        double topSectionX = x+(bottomSectionWidth/3);
        double topSectionY = y+(2*(height/3));
        
        double middleSectionWidth = 2*bottomSectionWidth/3;
        double topSectionWidth = bottomSectionWidth/3;
       
        
//        double leftSectionWidth = width/6;
//        double leftSectionHeight = height;
//        double middleSectionWidth = leftSectionWidth*4;
//        double middleSectionHeight = leftSectionHeight/2;
//        double middleSectionX = x+leftSectionWidth;
//        double middleSectionY = y + height/2 - middleSectionHeight/2;

        
        Rectangle2D.Double bottomSection =
            new Rectangle2D.Double(x, topSectionY ,
                                   bottomSectionWidth, blockHeight);
        Rectangle2D.Double middleSection =
        new Rectangle2D.Double(middleSectionX, middleSectionY ,
                               middleSectionWidth, blockHeight);
        Rectangle2D.Double topSection =
        new Rectangle2D.Double(topSectionX, y ,
                               topSectionWidth, blockHeight);
                          
        
       
        GeneralPath g2 = this.get();
        g2.append(bottomSection, false);
        g2.append(middleSection, false);
        g2.append(topSection, false); 
        
    }

}
