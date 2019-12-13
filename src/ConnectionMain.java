import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ConnectionMain {

	static private PipedInputStream pis1;
	static private PipedOutputStream pos1;

	static private PipedInputStream pis2;
	static private PipedOutputStream pos2;
	
	static private PipedInputStream pis3;
	static private PipedOutputStream pos3;
	
	static private ObjectOutputStream oos;
	static private ObjectInputStream ois;
	static private ObjectInputStream ois2;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pipe setup");

		try {
			pos1 = new PipedOutputStream();
			pis1 = new PipedInputStream(pos1);
			pos2 = new PipedOutputStream();
			pis2 = new PipedInputStream(pos2);
			
			TA ta = new TA(pis1, pos1,ois,oos);
			TB tb = new TB(pis2, pos2,ois2,oos);
			TC tc = new TC(oos);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
