package edu.ucsb.cs56.w14.drawings.alecharrell.advanced;
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
   A party dog                                                             
   @author Alec Harrell                                                     
   @version for CS56, W14, UCSB, 03/05/2014                     
                                              
*/
public class partyDog extends Dog implements Shape
{
    /**                                                                
     * Constructor for objects of class HouseWithWindows                      
     */

    public partyDog(double x, double y, double width, double height)
    {
        // construct the basic house shell                                      
        super(x,y,width,height);

        // get the GeneralPath that we are going to append stuff to             
        GeneralPath gp = this.get();
	

        // Look up the meaning of the second parameter of append                
        // (Hint--is a method of "GeneralPath")                                 

	GeneralPath partyHat = new GeneralPath();

        // left side of cup                                                                      

        partyHat.moveTo(x+(width/8),y+(height/8));
        partyHat.lineTo(x+(width/2),y-(height/2));
        partyHat.lineTo(x+width-(width/8),y+(height/8));
        
        

        
        gp.append(partyHat, false);
    }
}       
