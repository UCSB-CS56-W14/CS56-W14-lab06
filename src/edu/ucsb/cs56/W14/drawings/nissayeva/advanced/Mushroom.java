package edu.ucsb.cs56.w14.drawings.nissayeva.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Line2D; 
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A Mushroom (wrapper around a General Path, implements Shape)
      
   @author Natasha Issayeva 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class Mushroom extends GeneralPathWrapper implements Shape
{

    
    /**
      Constructor for objects of class Mushroom
     
        @param x  x coordinate of lower left corner of mushroom top
	@param y  y coordinate of lower left corner of mushroom top
	@param width  width of mushroom top
	@param height  height of whole mushroom
    */

    public Mushroom(double x, double y, double width, double height)
    {
	height = 200;
	Rectangle2D.Double stem = new Rectangle2D.Double(x+width/6,
							 y, (2*width)/3,
							 height/3);

	Line2D.Double top1 = new Line2D.Double(x, y, x+width, y);

	Line2D.Double top2 = new Line2D.Double(x, y, x, y-(height/3));

	Line2D.Double top3 = new Line2D.Double(x, y-(height/3), 
					       x+width/3,
					       y-(2*height)/3);

	Line2D.Double top4 = new Line2D.Double(x+width/3,
					       y-(2*height)/3,
					       x+(2*width)/3,
					       y-(2*height)/3);

	Line2D.Double top5 = new Line2D.Double(x+(2*width)/3,
					       y-(2*height)/3,
					       x+width, y-height/3);

	Line2D.Double top6 = new Line2D.Double(x+width, y-height/3,
					       x+width, y);


	GeneralPath wholeMushroom =  this.get();
	wholeMushroom.append(stem, false);
	wholeMushroom.append(top1, false);
	wholeMushroom.append(top2, false);
	wholeMushroom.append(top3, false);
	wholeMushroom.append(top4, false);
	wholeMushroom.append(top5, false);
	wholeMushroom.append(top6, false);
	
        
    }

}
