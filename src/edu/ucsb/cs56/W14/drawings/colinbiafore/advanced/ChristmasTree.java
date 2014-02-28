package edu.ucsb.cs56.w14.drawings.colinbiafore.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w14.drawings.colinbiafore.simple.Circle;
/**
   A Christmas Tree
      
   @author Colin Biafore
   @version for CS56, Winter 14, UCSB, 02/28/2014
   
*/
public class ChristmasTree extends Tree implements Shape
{
    
    /**
     * Constructor for objects of class Tree
     */
    public ChristmasTree(double x, double y, double height)
    {
	// construct the basic tree 
	super(x,y,height);

	double radius = (height/14)/2;

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	Circle ornament11 = new Circle(x - height/7,y+height/7 + radius,radius);
	Circle ornament12 = new Circle(x + height/7,y+height/7 + radius,radius);
	Circle ornament21 = new Circle(x-(3*height)/14,y+(5*height)/14 + radius,radius);
	Circle ornament22 = new Circle(x+(3*height)/14,y+(5*height)/14 + radius,radius);
	Circle ornament31 = new Circle(x-(4*height)/14,y+(8*height)/14 + radius,radius);
	Circle ornament32 = new Circle(x+(4*height)/14,y+(8*height)/14 + radius,radius);
	Circle ornament41 = new Circle(x-(5*height)/14,y+(11*height)/14 + radius,radius);
	Circle ornament42 = new Circle(x+(5*height)/14,y+(11*height)/14 + radius,radius);

	
	// add the ornaments to the tree
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeTree = this.get();
        wholeTree.append(ornament11, false);
        wholeTree.append(ornament12, false);
        wholeTree.append(ornament21, false); 
	wholeTree.append(ornament22, false);
        wholeTree.append(ornament31, false);
        wholeTree.append(ornament32, false);
	wholeTree.append(ornament41, false);
	wholeTree.append(ornament42, false);
    }

}
