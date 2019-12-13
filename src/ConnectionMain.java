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
	
	static private PipedInputStream pis4;
	static private PipedOutputStream pos4;
	
	static private ObjectOutputStream oos;
	static private ObjectOutputStream oos2;
	static private ObjectInputStream ois;
	static private ObjectInputStream ois2;
	
	//based on connectionmanager, message, sender, receiver code on website
	public static void main(String[] args) {
		
		try {
			pos1 = new PipedOutputStream();  //pipes to send from and receive from TA
			pis1 = new PipedInputStream(pos1);
			
			pos2 = new PipedOutputStream();    //pipes to send from and receive from TB
			pis2 = new PipedInputStream(pos2);
			
			pos3 = new PipedOutputStream();  //pipes to send from and receive from TC
			pis3 = new PipedInputStream(pos3);
			
			pos4 = new PipedOutputStream();  //pipes to send from and receive from TC
			pis4 = new PipedInputStream(pos4);
			
			TA ta = new TA(pis2, pos1,ois,pis3);
			TB tb = new TB(pis1, pos2,ois2,pis4);
			TC tc = new TC(oos,oos2,pos3,pos4);
			
			ta.start();
			tb.start();
			tc.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
