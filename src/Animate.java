import javax.swing.*;
import java.awt.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;

    private int x1 = 372;
    private int x2 = 398;
    private int x3 = 463;
    private int x4 = 488;
    private int y1 = 272;
    private int y2 = 268;
    
    private int xInc = 7;
    private int yInc = 1;

    public static void main(String[] args) {
        new Animate().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(851, 480);
        frame.setLocation(250,100);
        drive();
    }

    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
        	//Background
            g.setColor(new Color(217,102,169));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            //Road Base
            g.setColor(new Color(36,171,203));
            int[] xBase = {0,0,398,463,845,845};
            int[] yBase = {480,326,268,268,322,480};
            g.fillPolygon(xBase, yBase, 6);
            
            //Moving Road
            g.setColor(new Color(30,200,178));
            int[] xMoving = {x1,x2,x3,x4};
            int[] yMoving = {y1,y2,y2,y1};
            g.fillPolygon(xMoving, yMoving, 4);
            
        }
    }
//need 5 road pieces on screen at a time
    private void drive() {
        while(true){
            checkBounds();
            moveRoad();
            try{
                Thread.sleep(30);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    private void moveRoad(){
    	x1 -= xInc*2;
    	x2 -= xInc;
    	x3 += xInc;
    	x4 += xInc*2;
    	y1 += yInc*2;
    	y2 += yInc*1;
    	
    }
    private void checkBounds(){
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