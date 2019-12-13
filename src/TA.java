import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TA extends Thread {

	private InputStream pis1;
	private OutputStream pos1;
	private ObjectInputStream ois;
	private InputStream pis3;

	public TA(InputStream pis1, OutputStream pos1, ObjectInputStream ois, InputStream pis3) {
		// TODO Auto-generated constructor stub
		this.pis1 = pis1;
		this.pos1 = pos1;
		this.ois = ois;
		this.pis3 = pis3;
	}

	public void run() {
		try {
			pos1.write(1);

			System.out.println("Recieved from TB: " + String.valueOf(pis1.read()));

			ois = new ObjectInputStream(pis3);
			Message m;
			try {
				m = (Message) ois.readObject();
				System.out.println("TA receives: "+m);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
