import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BallClient {


	public static void main(String args[]) {

		Ball ball = new Ball(0);
		BallComponent ballPaint = new BallComponent(ball);

		JButton button = new JButton("Get Ball");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					getBall(ballPaint, ball);
				}
			}

		});

		JFrame frame = new JFrame("Bingo balls");
		frame.setSize(400, 400);
		frame.add(ballPaint, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 */
	public static void getBall(BallComponent ballPaint, Ball ball) {
		String hostName = "localhost";
		int port = 8818;


		try (Socket client = new Socket(hostName, port);) {
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());

			ball = (Ball) in.readObject();
			ballPaint.setBall(ball);
			ballPaint.repaint();

			System.out.println("Closing connection" + ball.getValue());
			client.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
