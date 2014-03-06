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
   Batman, a psychotic madman who dresses as a Bat and beats up even weirder people at night
   because of childhood trauma...
   
      
   @author Dwayne Conard 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class Batman extends BruceWayne implements Shape
{
    /**
     * Constructor for objects of class Batman
     */
    public Batman()
    {
	super();

	GeneralPath earLeft = new GeneralPath();
	GeneralPath gloveLeft = new GeneralPath();
	GeneralPath bootLeft = new GeneralPath();
	GeneralPath capeLeft = new GeneralPath();
	GeneralPath pants = new GeneralPath();
	GeneralPath mask = new GeneralPath();

	//Creating Ears
	earLeft.moveTo(180,150);
	earLeft.lineTo(175,100);
	earLeft.lineTo(190,145);
	Shape earRight = ShapeTransforms.horizontallyFlippedCopyOf(earLeft);
        earRight = ShapeTransforms.translatedCopyOf(earRight, 70, 0.0);

	//Creating Gloves
	gloveLeft.moveTo(140,305);
	gloveLeft.lineTo(165,310);
        Shape gloveRight = ShapeTransforms.horizontallyFlippedCopyOf(gloveLeft);
        gloveRight = ShapeTransforms.translatedCopyOf(gloveRight, 140, 0.0);
	
	//Creating Boots
	bootLeft.moveTo(165,440);
	bootLeft.lineTo(190,440);
	Shape bootRight  = ShapeTransforms.horizontallyFlippedCopyOf(bootLeft);
        bootRight = ShapeTransforms.translatedCopyOf(bootRight, 89, 0.0);

	//Creating Cape
	capeLeft.moveTo(150,340);
	capeLeft.lineTo(135,495);
	capeLeft.lineTo(160,490);
	capeLeft.moveTo(185,490);
	capeLeft.lineTo(215,490);
	
	Shape capeRight = ShapeTransforms.horizontallyFlippedCopyOf(capeLeft);
        capeRight = ShapeTransforms.translatedCopyOf(capeRight, 150, 0.0);

	//Creating pants
	pants.moveTo(170,330);
	pants.lineTo(250,330);
	pants.moveTo(170,350);
	pants.lineTo(205,360);
	pants.moveTo(250,350);
	pants.lineTo(220,360);

	//Creaing mask
	mask.moveTo(175,170);
	mask.lineTo(210,180);
	mask.lineTo(245,170);
	mask.moveTo(200,190);
	mask.lineTo(220,190);

	mask.lineTo(222,195);
	mask.moveTo(200,190);
	mask.lineTo(198,195);

	mask.moveTo(187,165);
	mask.lineTo(200,167);
	mask.moveTo(220,167);
	mask.lineTo(233,165);

	//Adding the SymbolPatch
	java.awt.geom.Ellipse2D.Double symbolPatch = 
	    new java.awt.geom.Ellipse2D.Double(180,255,60,30);

	//Appending to the Figure
	wholeFigure.append(earLeft, false);
        wholeFigure.append(earRight, false);
        wholeFigure.append(gloveLeft, false);
        wholeFigure.append(gloveRight, false);
        wholeFigure.append(bootLeft, false);
        wholeFigure.append(bootRight, false);
        wholeFigure.append(capeLeft, false);
        wholeFigure.append(capeRight, false);
        wholeFigure.append(pants, false);
        wholeFigure.append(mask, false);
	wholeFigure.append(symbolPatch, false);
    }
}
