import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TA extends Thread{

	private PipedInputStream pis1;
	private PipedOutputStream pos1;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	public TA(PipedInputStream pis1, PipedOutputStream pos1, ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated constructor stub
		this.pis1 = pis1;
		this.pos1 = pos1;
		this.ois=ois;
		this.oos = oos;
	}

	public void run() {
		
	}
}
