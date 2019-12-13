import java.io.Serializable;

class Message implements Serializable {
	public int number, id;

	public Message(int number, int id) {  //similar to message class of dimu
		this.number = number;
		this.id = id;
	}
	
	public String toString() {
		return "Number: "+number+" ID: "+id;
	}
}