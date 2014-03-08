package edu.ucsb.cs56.w14.drawings.colinbiafore.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a tree that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Colin Biafore
   @version for CS56, Winter 14, UCSB, 02/28/2014
   
*/
public class Tree extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of base of tree
       @param y y coord of base of tree
       @param height of tree 
     */
    public Tree(double x, double y, double height)
    {

	
	//Tree Trunk
	Line2D.Double treeTrunk = new Line2D.Double(x,y,x,y + height);
	
	//Top Branch
	Line2D.Double branch11 = new Line2D.Double(x,y,x-height/7,y+height/7);	
	Line2D.Double branch12 = new Line2D.Double(x,y,x+height/7,y+height/7);
	Line2D.Double branch13 = new Line2D.Double(x,y+height/14,x-height/7,y+height/7);
	Line2D.Double branch14 = new Line2D.Double(x,y+height/14,x+height/7,y+height/7);

	//Top Middle Branch
	Line2D.Double branch21 = new Line2D.Double(x,y+(3*height)/14,x-(3*height)/14,y+(5*height)/14);
	Line2D.Double branch22 = new Line2D.Double(x,y+(3*height)/14,x+(3*height)/14,y+(5*height)/14);
	Line2D.Double branch23 = new Line2D.Double(x,y+(4*height)/14,x-(3*height)/14,y+(5*height)/14);
	Line2D.Double branch24 = new Line2D.Double(x,y+(4*height)/14,x+(3*height)/14,y+(5*height)/14);

	//Bottom Middle Branch
	Line2D.Double branch31 = new Line2D.Double(x,y+(6*height)/14,x-(4*height)/14,y+(8*height)/14);
	Line2D.Double branch32 = new Line2D.Double(x,y+(6*height)/14,x+(4*height)/14,y+(8*height)/14);
	Line2D.Double branch33 = new Line2D.Double(x,y+(7*height)/14,x-(4*height)/14,y+(8*height)/14);
	Line2D.Double branch34 = new Line2D.Double(x,y+(7*height)/14,x+(4*height)/14,y+(8*height)/14);

	//Bottom Branch
	Line2D.Double branch41 = new Line2D.Double(x,y+(9*height)/14,x-(5*height)/14,y+(11*height)/14);
	Line2D.Double branch42 = new Line2D.Double(x,y+(9*height)/14,x+(5*height)/14,y+(11*height)/14);
	Line2D.Double branch43 = new Line2D.Double(x,y+(10*height)/14,x-(5*height)/14,y+(11*height)/14);
	Line2D.Double branch44 = new Line2D.Double(x,y+(10*height)/14,x+(5*height)/14,y+(11*height)/14);

	//Put the whole tree together
	GeneralPath wholeTree = this.get();
	wholeTree.append(treeTrunk,false);
	wholeTree.append(branch11,false);
	wholeTree.append(branch12,false);
	wholeTree.append(branch13,false);
	wholeTree.append(branch14,false);
	wholeTree.append(branch21,false);
	wholeTree.append(branch22,false);
	wholeTree.append(branch23,false);
	wholeTree.append(branch24,false);
	wholeTree.append(branch31,false);
	wholeTree.append(branch32,false);
	wholeTree.append(branch33,false);
	wholeTree.append(branch34,false);
	wholeTree.append(branch41,false);
	wholeTree.append(branch42,false);
	wholeTree.append(branch43,false);
	wholeTree.append(branch44,false);
	

    }

}
