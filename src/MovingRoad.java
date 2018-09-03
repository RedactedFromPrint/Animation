import java.awt.*;

public class MovingRoad {
	
	private int num;
	private int count;
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	private int bottomY;
	private int topY;
	private int inc;
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
	private int frame;
    
    public MovingRoad(int instance) {
    	num = instance*10;
    	count = 0;
    	x1 = 372;
    	x2 = 398;
    	x3 = 463;
    	x4 = 488;
    	bottomY = 267;
    	topY = 263;
    	inc = 1;
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
    	frame = 0;
    	
    }
    
    public boolean checkframe() {
    	if (count < num) {
    		return false;
    	} else {return true;}
    }
    
    public void draw(Graphics g) {
    	if (!checkframe()) {
    		count++;
    	} else {
    		frame++;

    		//Road
    		g.setColor(new Color(30,200,178));
    		int[] xMoving = {x1,x2,x3,x4};
    		int[] yMoving = {bottomY,topY,topY,bottomY};
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
    		move();
    		
    	}
    }
    
    public void move(){
    	if (topY < 268) {
    		bottomY++;
    		topY++;
    	} else {
    		//Road
    		if (bottomY % 5 == 0) {
    			inc *= 2;
    		}
    		x1 -= inc*14;
    		x2 -= inc*7;
    		x3 += inc*7;
    		x4 += inc*15;
    		bottomY += inc*2;
    		topY += inc;

	    	//Outside Markers
	    	if (topY <= 271) {
	    		markInc *= 3;
	    	} else if (frame % 7 == 0 && topY > 271) {
	    		markInc *= 2;
	    	}
	    	
	    	//Left Marker
	    	x1Mark1 -= markInc/2;
	    	x4Mark1 -= markInc/2;
	    	if (frame % 2 == 0) {
	    		x2Mark1 -= markInc/2;
	    		x3Mark1 -= markInc/2;
	    		x1Mark1--;
	    		x2Mark1--;
	    		x3Mark1++;
	    		x4Mark1++;
	    	}
	
	    	//Middle Marker
	    	if (frame % 2 == 0) {
	    		x1Mark2--;
	    		x4Mark2++;
	    	}
	    	if (frame % 4 == 0) {
	    		x2Mark2--;
	    		x3Mark2++;
	    	}
	    	if (bottomY > 300 && frame % 2 == 1) {
	    		x1Mark2--;
	    		x4Mark2++;
	    	}
	    	
	    	//Right Marker
	    	x1Mark3 += markInc/2;
	    	x4Mark3 += markInc/2;
	    	if (frame % 2 == 0) {
	    		x2Mark3 += markInc/2;
	    		x3Mark3 += markInc/2;
	    		x1Mark3++;
	    		x2Mark3++;
	    		x3Mark3--;
	    		x4Mark3--;
	    	}
    	}
    }
    
    public void checkBounds(){
    	
    	if (topY > 450) {
    		num = 0;
    		count = 0;
    		x1 = 372;
    	    x2 = 398;
    	    x3 = 463;
    	    x4 = 488;
    	    bottomY = 267;
    	    topY = 263;
    	    inc = 1;
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
        	frame = 0;
    	}
    }
}
