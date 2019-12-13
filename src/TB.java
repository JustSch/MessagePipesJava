import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TB extends Thread{
	private InputStream pis1;
	private OutputStream pos2;
	private ObjectInputStream ois2;
	private InputStream pis4;
	
	public TB(InputStream pis1, OutputStream pos2, ObjectInputStream ois2, InputStream pis4) {
		this.pis1 = pis1;
		this.pos2=pos2;
		this.ois2 = ois2;
		this.pis4=pis4;
	}

	public void run() {
		try {
			pos2.write(2);  // sends primitive int 2 to TA

			System.out.println("Recieved from TA: " + String.valueOf(pis1.read()));  //reads primitive value sent from TA

			ois2 = new ObjectInputStream(pis4);
			Message m;
			try {
				m = (Message) ois2.readObject();
				System.out.println("TB receives: "+m);  //reads Object sent by TC then prints it
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
