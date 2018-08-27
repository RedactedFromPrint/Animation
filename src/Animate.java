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
            int[] xBase = {0,0,398,463,this.getWidth(),this.getWidth()};
            int[] yBase = {height,height-154,height-212,height-212,height-154,height};
            g.fillPolygon(xBase, yBase, 6);
            
            //Road Markers
            g.setColor(new Color(30,200,178));
            int[] xColor = {0,0,398,463,this.getWidth(),this.getWidth()};
            int[] yColor = {height,height-154,height-212,height-212,height-154,height};
            g.fillPolygon(xColor, yColor, 4);
            
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