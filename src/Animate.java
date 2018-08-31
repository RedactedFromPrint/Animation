import javax.swing.*;
import java.awt.*;
import java.util.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;
    
    ArrayList<MovingRoad> roads = new ArrayList<MovingRoad>();{
    	for (int i = 0; i < 3; i++) {
    		roads.add(new MovingRoad(i));
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
        	//Background
            g.setColor(new Color(217,102,169));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            //Road Base
            g.setColor(new Color(36,171,203));
            int[] xBase = {0,0,398,463,851,851};
            int[] yBase = {480,326,268,268,322,480};
            g.fillPolygon(xBase, yBase, 6);
            
            //Moving Road
            for (MovingRoad road: roads) {
        		road.drawRoad(g);
        	}
        }
    }
    
    
    private void drive() {
        while(true){
        	for (MovingRoad road: roads) {
        		if (road.checkNum()) {
        			road.checkBounds();
        			road.moveRoad();
        		}
        	}
            try{
                Thread.sleep(35);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
}
