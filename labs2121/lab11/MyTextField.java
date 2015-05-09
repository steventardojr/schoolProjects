import javax.swing.JTextField;
import java.util.Observer;
import java.util.Observable;

public class MyTextField extends JTextField implements Observer {
	Model model;
	
	public MyTextField(Model model) {
		super("0");
		this.model = model;
	}
	
	public void update(Observable obs, Object obj) {
		this.setText(String.valueOf(this.model.getValue()));
	}
}