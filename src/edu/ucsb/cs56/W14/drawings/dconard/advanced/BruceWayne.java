package edu.ucsb.cs56.w14.drawings.dconard.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w14.drawings.dconard.simple.*;

/**
   A Bruce Wayne is a semi-normal man.
   
      
   @author Dwayne Conrard 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class BruceWayne extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for objects of class BruceWayne
     */
    public BruceWayne(double x, double y, double width, double height)
    {
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
                
        GeneralPath leftSide = new GeneralPath();
	leftSide.moveTo(195,200);
	leftSide.lineTo(195,230);//neck
	leftSide.lineTo(150,230);//shoulder
	leftSide.lineTo(140,250);//shoulder slant
	leftSide.lineTo(140,340);//armleft
	leftSide.lineTo(165,340);//armbottom
	leftSide.lineTo(160,260);//armright
	leftSide.lineTo(170,270);//armpit
	leftSide.lineTo(170,350);//chest
	leftSide.lineTo(160,510);//legleft
	leftSide.lineTo(185,510);//legbottom
	leftSide.lineTo(200,360);//legright
	leftSide.lineTo(220,360);//middle

        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 140.0, 0.0);
	Circle head = new Circle(210,170,35);
       
        GeneralPath wholeCup = new GeneralPath ();
	wholeCup.append(head,false);
        wholeCup.append(leftSide, false);
        wholeCup.append(rightSide, false);
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeCup, -ORIG_ULX + x, -ORIG_ULY + y);
 
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
        
	this.set(new GeneralPath(s));
        
    }

}
