import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class BallServer {

	public static void main(String[] args) {
		Random r = new Random();
		int port = 8818;

		while (true) {
		try (ServerSocket server = new ServerSocket(port);) {

			System.out.println("CONNECTING ...");
			Socket client = server.accept();
			System.out.println("CONNECTED ...");

				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
				Ball ball = new Ball(r.nextInt(99) + 1);
				out.writeObject(ball);
				out.flush();

				System.out.println("Closing connection ss");
				client.close();

		} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

}
