import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;

public class TC extends Thread{

	private ObjectOutputStream oos;
	private ObjectOutputStream oos2;
	private OutputStream pos3;
	private OutputStream pos4;
	
	public TC(ObjectOutputStream oos, ObjectOutputStream oos2, OutputStream pos3, OutputStream pos4) {
		this.oos = oos;
		this.oos2 = oos2;
		this.pos3 = pos3;
		this.pos4 = pos4;
	}

	public void run() {
		Message m = new Message(3,3);  
		
		System.out.println( "TC sends: " );
        System.out.println( m );
        
        try {
			oos = new ObjectOutputStream( pos3 );  //sends object to TA
			oos.writeObject( m );
			
			oos2 = new ObjectOutputStream(pos4);  //send object to TB
			oos2.writeObject(m);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		
	}
}
