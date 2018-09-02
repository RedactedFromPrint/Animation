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
	private int x1Mark1;
	private int x2Mark1;
	private int x3Mark1;
	private int x4Mark1;
	private int x1Mark2;
	private int x2Mark2;
	private int x3Mark2;
	private int x4Mark2;
	private int x1Mark3;
	private int x2Mark3;
	private int x3Mark3;
	private int x4Mark3;
	private int markInc;
	private int incCount;
    
    public MovingRoad(int instance) {
    	num = instance*10;
    	count = 0;
    	x1 = 372;
    	x2 = 398;
    	x3 = 463;
    	x4 = 488;
    	y1 = 268;
    	y2 = 264;
    	xInc = 7;
    	yInc = 1;
    	x1Mark1 = 399;
    	x2Mark1 = 413;
    	x3Mark1 = 414;
    	x4Mark1 = 400;
    	x1Mark2 = 428;
    	x2Mark2 = 429;
    	x3Mark2 = 431;
    	x4Mark2 = 432;
    	x1Mark3 = 460;
    	x2Mark3 = 446;
    	x3Mark3 = 447;
    	x4Mark3 = 461;
    	markInc = 1;
    	incCount = 0;
    }
    
    public boolean checkCount() {
    	if (count < num) {
    		return false;
    	} else {return true;}
    }
    
    public void drawRoad(Graphics g) {
    	if (!checkCount()) {
    		count++;
    	} else {
    		incCount++;

    		//Road
    		g.setColor(new Color(30,200,178));
    		int[] xMoving = {x1,x2,x3,x4};
    		int[] yMoving = {y1,y2,y2,y1};
    		g.fillPolygon(xMoving, yMoving, 4);

    		//Markers
    		g.setColor(Color.LIGHT_GRAY);

    		//Left Marker
    		int[] xMark1 = {x1Mark1,x2Mark1,x3Mark1,x4Mark1};
    		g.fillPolygon(xMark1, yMoving, 4);

    		//Middle Marker
    		int[] xMark2 = {x1Mark2,x2Mark2,x3Mark2,x4Mark2};
    		g.fillPolygon(xMark2, yMoving, 4);
    		
    		//Left Marker
    		int[] xMark3 = {x1Mark3,x2Mark3,x3Mark3,x4Mark3};
    		g.fillPolygon(xMark3, yMoving, 4);


    		checkBounds();
    		moveRoad();
    		
    	}
    }
    
    public void moveRoad(){
    	if (y2 < 268) {
    		y1++;
    		y2++;
    	} else {
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

	    	//Outside Markers
	    	if (y2 <= 271) {
	    		markInc *= 3;
	    	} else if (incCount % 7 == 0 && y2 > 271) {
	    		markInc *= 2;
	    	}
	    	
	    	//Left Marker
	    	x1Mark1 -= markInc/2;
	    	x4Mark1 -= markInc/2;
	    	if (incCount % 2 == 0) {
	    		x2Mark1 -= markInc/2;
	    		x3Mark1 -= markInc/2;
	    	}
	    	if (incCount % 2 == 0) {
	    		x1Mark1--;
	    		x2Mark1--;
	    		x3Mark1++;
	    		x4Mark1++;
	    	}
	
	    	//Middle Marker
	    	if (incCount % 2 == 0) {
	    		x1Mark2--;
	    		x4Mark2++;
	    	}
	    	if (incCount % 4 == 0) {
	    		x2Mark2--;
	    		x3Mark2++;
	    	}
	    	if (y1 > 300 && incCount % 2 == 1) {
	    		x1Mark2--;
	    		x4Mark2++;
	    	}
	    	
	    	//Right Marker
	    	x1Mark3 += markInc/2;
	    	x4Mark3 += markInc/2;
	    	if (incCount % 2 == 0) {
	    		x2Mark3 += markInc/2;
	    		x3Mark3 += markInc/2;
	    	}
	    	if (incCount % 2 == 0) {
	    		x1Mark3++;
	    		x2Mark3++;
	    		x3Mark3--;
	    		x4Mark3--;
	    	}
    	}
    }
    
    public void checkBounds(){
    	
    	if (y2 > 450) {
    		num = 0;
    		count = 0;
    		x1 = 372;
    	    x2 = 398;
    	    x3 = 463;
    	    x4 = 488;
    	    y1 = 267;
    	    y2 = 263;
    	    xInc = 7;
    	    yInc = 1;
    	    x1Mark1 = 399;
        	x2Mark1 = 413;
        	x3Mark1 = 414;
        	x4Mark1 = 400;
    	    x1Mark2 = 428;
        	x2Mark2 = 429;
        	x3Mark2 = 431;
        	x4Mark2 = 432;
        	x1Mark3 = 460;
        	x2Mark3 = 446;
        	x3Mark3 = 447;
        	x4Mark3 = 461;
        	markInc = 1;
        	incCount = 0;
    	}
    }
}
