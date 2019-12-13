import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TB extends Thread{
	private InputStream pis2;
	private OutputStream pos2;
	private ObjectInputStream ois2;
	private InputStream pis4;
	
	public TB(InputStream pis2, OutputStream pos2, ObjectInputStream ois2, InputStream pis4) {
		// TODO Auto-generated constructor stub
		this.pis2 = pis2;
		this.pos2=pos2;
		this.ois2 = ois2;
		this.pis4=pis4;
	}

	public void run() {
		try {
			pos2.write(2);

			System.out.println("Recieved from TA: " + String.valueOf(pis2.read()));

			ois2 = new ObjectInputStream(pis4);
			Message m;
			try {
				m = (Message) ois2.readObject();
				System.out.println("TB receives: "+m);
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
