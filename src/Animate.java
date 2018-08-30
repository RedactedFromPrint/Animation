import javax.swing.*;
import java.awt.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;
    
    MovingRoad road1 = new MovingRoad();

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
            g.fillPolygon(road1.getX(), road1.getY(), 4);
        }
    }
//need 5 road pieces on screen at a time
    private void drive() {
        while(true){
            road1.checkBounds();
            road1.moveRoad();
            try{
                Thread.sleep(30);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    
}