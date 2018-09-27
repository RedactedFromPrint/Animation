import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class PalmTrees {
	
	private int num;
	private int count;
	private int leftX;
	private int rightX;
	private int y;
	private int width;
	private int height;
	private int xInc;
	private int treeXInc;
	private int yInc;
	private int frame;
	private int bottomYSim;

	BufferedImage tree = null;{
    	try {
    		tree = ImageIO.read(new File("src/palm tree.png"));
    	} catch (IOException e) {
    	}
    }
	
	public PalmTrees(int instance) {
		num = instance*3;
		count = 0;
		leftX = 398;
    	rightX = 463;
    	y = 263;
    	width = 8;
    	height = 13;
    	xInc = 7;
    	treeXInc = -2;
    	yInc = 1;
    	frame = 0;
    	bottomYSim = 272;
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
    		
    		//Left
    		g.drawImage(tree, leftX+2-treeXInc, y-height+5, -width, height, null);

    		//Right
    		g.drawImage(tree, rightX+treeXInc, y-height+5, width, height, null);
    		
    		checkBounds();
        	move();
    	}
    }
	
	public void move() {
		
		//Move Trees
		if (bottomYSim % 5 == 0) {
			yInc *= 2;
		}
		leftX -= xInc;
		rightX += xInc;
		bottomYSim += yInc*2;
		y += yInc;
		
		if (frame < 6) {
			treeXInc--;
		} else if (frame < 10){
			treeXInc += width/8;
		} else if (frame < 14){
			treeXInc += width/5;
		} else if (frame < 15){
			treeXInc += width/4;
		} else {
			treeXInc += width/3;
		}
		
		//Scale Tree
    	width += 8;
   		height += 13;
	}
	
	public void checkBounds() {
		if (frame > 33) {
			num = 2;
			count = 0;
			leftX = 398;
	    	rightX = 463;
	    	y = 263;
	    	width = 8;
	    	height = 13;
	    	xInc = 7;
	    	treeXInc = -2;
	    	yInc = 1;
	    	frame = 0;
	    	bottomYSim = 272;
		}
	}
	
}