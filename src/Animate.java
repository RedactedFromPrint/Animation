import javax.swing.*;
import java.awt.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 200; // Starting X coordinate
    private int oneY = 200; // Starting Y coordinate

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;

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
        moveDot();
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
            int height = this.getHeight();
            g.setColor(new Color(36,171,203));
            int[] xBase = {0,0,398,463,845,845};
            int[] yBase = {480,326,268,268,326,480};
            g.fillPolygon(xBase, yBase, 6);
            
            //Moving Road
            g.setColor(new Color(30,200,178));
            int x1 = 0;
            int x2 = 312;
            int x3 = 547;
            int x4 = 845;
            int y1 = 326;
            int y2 = 299;
            int[] xMoving = {x1,x2,x3,x4};
            int[] yMoving = {y1,y2,y2,y1};
            g.fillPolygon(xMoving, yMoving, 4);
            
        }
    }

    private void moveDot() {
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    private void moveLoc(){
    	if(up){
            oneY-=1;
        }
        if(down){
            oneY+=1;
        }
        if(left){
            oneX-=1;
        }
        if(right){
            oneX+=1;
        }	
    }
    private void checkBounds(){
    	if(oneX >= 583){
            right = false;
            left = true;
        }
        if(oneX <= 7){
            right = true;
            left = false;
        }
        if(oneY >= 559){
            up = true;
            down = false;
        }
        if(oneY <= 7){
            up = false;
            down = true;
        }	
    }
}