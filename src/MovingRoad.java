import java.awt.Color;
import java.awt.Graphics;

public class MovingRoad {
	private int num;
	private int count;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	private int y1;
	private int y2;
	private int xInc;
	private int yInc;
	private int x1Mark2;
	private int x2Mark2;
	private int x3Mark2;
	private int x4Mark2;
	private int markInc;
	private int incCount;
    
    public MovingRoad(int instance) {
    	num = instance*10;
    	count = 0;
    	x1 = 372;
    	x2 = 398;
    	x3 = 463;
    	x4 = 488;
    	y1 = 272;
    	y2 = 268;
    	xInc = 7;
    	yInc = 1;
    	x1Mark2 = 428;
    	x2Mark2 = 429;
    	x3Mark2 = 431;
    	x4Mark2 = 432;
    	markInc = 1;
    	incCount = 0;
    }
    
    public boolean checkCount() {
    	if (count < num) {
    		return false;
    	}
    	else {return true;}
    }
    
    public void drawRoad(Graphics g) {
    	if (!checkCount()) {
    		count++;
    	}else {
    	incCount++;
    	
    	//Road
    	g.setColor(new Color(30,200,178));
    	int[] xMoving = {x1,x2,x3,x4};
        int[] yMoving = {y1,y2,y2,y1};
    	g.fillPolygon(xMoving, yMoving, 4);
    	
    	//Middle Marker
    	g.setColor(Color.LIGHT_GRAY);
    	int[] xMark2 = {x1Mark2,x2Mark2,x3Mark2,x4Mark2};
    	g.fillPolygon(xMark2, yMoving, 4);
    	checkBounds();
		moveRoad();
    	}
    }
    
    public void moveRoad(){
    	//Road
    	if (y1 % 5 == 0) {
    		xInc *= 2;
    		yInc *= 2;
    	}
    	x1 -= xInc*2;
    	x2 -= xInc;
    	x3 += xInc;
    	x4 += xInc*2;
    	y1 += yInc*2;
    	y2 += yInc;
    	
    	//Markers
    	if (incCount % 2 == 0) {
    		x1Mark2 -= markInc;
        	x4Mark2 += markInc;
    	}
    	if (incCount % 4 == 0) {
    		x2Mark2 -= markInc;
        	x3Mark2 += markInc;
    	}
    	if (y1 > 300 && incCount % 2 != 0) {
    		x1Mark2 -= markInc;
        	x4Mark2 += markInc;
    	}
    }
    
    public void checkBounds(){
    	
    	if (y2 > 480) {
    		num = 4;
    		count = 0;
    		x1 = 372;
    	    x2 = 398;
    	    x3 = 463;
    	    x4 = 488;
    	    y1 = 272;
    	    y2 = 268;
    	    xInc = 7;
    	    yInc = 1;
    	    x1Mark2 = 428;
        	x2Mark2 = 429;
        	x3Mark2 = 431;
        	x4Mark2 = 432;
        	markInc = 1;
        	incCount = 0;
    	}
    }
}
