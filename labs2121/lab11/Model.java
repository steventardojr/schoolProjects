import javax.swing.JTextField;
import java.util.Observable;

public class Model extends Observable {
	private int value;
	
	public Model() {
		this.value = 0;
	}
	
	public void increaseValue() {
		this.value++;
		setChanged();
		notifyObservers();
	}
	
	public void decreaseValue() {
		this.value--;
		setChanged();
		notifyObservers();
	}
	
	public int getValue() {
		return this.value;
	}
}