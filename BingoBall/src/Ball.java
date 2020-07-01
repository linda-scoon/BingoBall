
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 * A representation of a Bingo Ball
 * 
 * @author dave
 */
public class Ball implements Serializable {
	private int xCentre;
	private int yCentre;
	private int radius;
	private int value;

	/**
	 * Constructs a Ball with a given value
	 * 
	 * @param val Value of the ball
	 */
	public Ball(int val) {
		xCentre = 100;
		yCentre = 100;
		radius = 50;
		value = val;
	}

	/**
	 * Draws the Ball
	 * 
	 * @param g2 The graphics context to use when drawing
	 */
	public void draw(Graphics2D g2) {
		Ellipse2D.Double ball = new Ellipse2D.Double(xCentre - radius, yCentre - radius, radius * 2, radius * 2);
		g2.setColor(Color.red);
		g2.draw(ball);
		g2.setColor(Color.BLACK);
		g2.drawString(" " + value + " ", xCentre - 7, yCentre + 5);
	}

	public int getValue() {
		return value;
	}
}
