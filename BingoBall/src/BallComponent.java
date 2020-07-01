import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BallComponent extends JPanel {
	private Ball ball;

	public BallComponent(Ball ball) {
		this.ball = ball;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		ball.draw(g2);
	}

	public void setBall(Ball ball) {
		this.ball = ball;
//		repaint();
	}



}
