
/**
 * @author mould_pa
 * This program creates a LineDesign on to a graphics display
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;



/**
 * This class makes a LineDesign that can be displayed on a graphics display
 */
public class LineDesign 
{
	private double x;
	private double y;
	private int l;
	private int degrees;
	private int max;
	Color  lineColor;
	
	/** Constructor class for the LineDesign
	 * @param startX
	 * @param startY
	 * @param length
	 * @param angle
	 * @param color
	 */
	 LineDesign (int startX,int startY,int length,int angle,Color color)
	 {
		x =  startX;
		y =  startY;
		l =  length;
		degrees = angle;
		lineColor = color;
		max =100;
	}
	
	/** A method that sets the maximum number of lines to the given value
	 * @param maxLines
	 */
	public void setMaxLines (int maxLines)
	{
		max = maxLines;
	}

	/** A method that draws the design on the graphics
	 * 
	 * @param g
	 */
	 public void draw ( Graphics2D g2)
	 {   double xStart = x;
		 double yStart = y;
		 boolean	done = false;
	     int current = degrees;
	     int count= 1;
	   
	     	
		 while(!done  )
	    {
			 double radians = ((current*Math.PI)/180);
	    	 double b = (xStart+(l*Math.cos(radians)));
	    	 double h = (yStart- (l*Math.sin(radians)));
	    	 System.out.println("OLD: X Value:"+xStart+" Y Value:"+yStart+""); 
	    	 System.out.println("NEW: X Value:"+b+" Y Value:"+h+"");
	    	 System.out.println("Line "+count);
	    		
	    	 g2.setStroke(new BasicStroke(2));
	  		 Line2D.Double line = new Line2D.Double(xStart,yStart,b,h);	
	  		 g2.setColor(lineColor);
	  		 g2.draw(line);
	    	 if ((b==xStart && h==yStart) || count>=max)
	    	 {
	    	 done = true; 
	    	 }
	    	 else
	    	 {	    			 
	    	 current = (degrees+current)%360;
	    	 xStart =  b;
	    	 yStart =  h; 
	    	 count++;
	    	 }
	     }
	 }
}


	 
	    	 
	    		 
	 
	 
		
				
			
	 
		


		
		
		
		
		
		
		
		
		

	      
	
			
			

