
public class MovingRoad {
	
	private int x1;
    private int x2;
    private int x3;
    private int x4;
    private int y1;
    private int y2;
    private int xInc;
    private int yInc;
    private int[] xMoving = {x1,x2,x3,x4};
    private int[] yMoving = {y1,y2,y2,y1};
    
    public MovingRoad() {
    	x1 = 372;
        x2 = 398;
        x3 = 463;
        x4 = 488;
        y1 = 272;
        y2 = 268;
        xInc = 7;
        yInc = 1;
    }
    
    public int[] getX() {
    	return xMoving;
    }
    
    public int[] getY() {
    	return yMoving;
    }
    
    public void moveRoad(){
    	x1 -= xInc*2;
    	x2 -= xInc;
    	x3 += xInc;
    	x4 += xInc*2;
    	y1 += yInc*2;
    	y2 += yInc*1;
    }
    
    public void checkBounds(){
    	if (y1 % 5 == 0) {
    		xInc *= 2;
    		yInc *= 2;
    	}
    	
    	if (y2 > 474) {
    		x1 = 372;
    	    x2 = 398;
    	    x3 = 463;
    	    x4 = 488;
    	    y1 = 272;
    	    y2 = 268;
    	    xInc = 7;
    	    yInc = 1;
    	}
    }
}
