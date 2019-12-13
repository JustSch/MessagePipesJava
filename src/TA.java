import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TA extends Thread {

	private InputStream pis2;
	private OutputStream pos1;
	private ObjectInputStream ois;
	private InputStream pis3;

	public TA(InputStream pis2, OutputStream pos1, ObjectInputStream ois, InputStream pis3) {
		// TODO Auto-generated constructor stub
		this.pis2 = pis2;
		this.pos1 = pos1;
		this.ois = ois;
		this.pis3 = pis3;
	}

	public void run() {
		try {
			pos1.write(1);  //writes primitive int 1 to pipe

			System.out.println("Recieved from TB: " + String.valueOf(pis2.read())); //receives primitive from TB

			ois = new ObjectInputStream(pis3);
			Message m;
			try {
				m = (Message) ois.readObject();
				System.out.println("TA receives: "+m);  //Receives object from TC and prints it to console
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
