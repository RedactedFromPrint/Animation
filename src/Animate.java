import javax.swing.*;
import java.awt.*;
import java.util.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;
    
    private boolean start = true;
    
    ArrayList<MovingRoad> roads = new ArrayList<MovingRoad>();{
    	for (int i = 0; i < 3; i++) {
    		roads.add(new MovingRoad(i));
    	}
    }
    
    ArrayList<PalmTrees> trees = new ArrayList<PalmTrees>();{
    	for (int i = 0; i < 12; i++) {
    		trees.add(new PalmTrees(i));
    	}
    }

    public static void main(String[] args) {
    	new Animate().go();
    }

    private void go() {
        frame = new JFrame("Vaporwave Animated Road");
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
			if (start) {
				for (int i = 0; i < 25; i++) {
					for (MovingRoad road: roads) {
		        		road.draw(g);
		        	}
					/*for (PalmTrees tree: trees) {
		        		tree.draw(g);
		        	}*/
				}
				start = false;
			}
			
        	//Road Base
            g.setColor(new Color(36,171,203));
            g.fillRect(0, 0, 851, 480);
            
            //Moving Road
            for (MovingRoad road: roads) {
        		road.draw(g);
        	}
            
            //Sky
            g.setColor(new Color(217,102,169));
    		int[] xSky = {0,0,398,463,851,851};
    		int[] ySky = {0,326,268,268,322,0};
    		g.fillPolygon(xSky, ySky, 6);
    		
    		//Trees
    		/*for (PalmTrees tree: trees) {
        		tree.draw(g);
        	}*/
    		
        }
    }
    
    
    private void drive() {
        while(true){
            try{
                Thread.sleep(35);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
}