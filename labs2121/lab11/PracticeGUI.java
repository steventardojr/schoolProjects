import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PracticeGUI extends JFrame {
	// Instance Variables
	private MyTextField textField;
	private JButton upButton;
	private JButton downButton;
	private ButtonListener listener;
	private Color color1 = new Color(255, 255, 255);
	private Color color2 = new Color(0, 0, 0);
	private Model model;
	
	// Constructor
	public PracticeGUI() {
		this.model = new Model();
		this.setTitle("Practice GUI");
		this.listener = new ButtonListener(model);
		this.textField = new MyTextField(model);
		this.textField.setEnabled(false);
		this.textField.setDisabledTextColor(color1);
		this.textField.setBackground(color2);
		this.model.addObserver(this.textField);
		this.upButton = new JButton("UP");
		this.upButton.addActionListener(listener);
		this.upButton.setActionCommand("up");
		this.downButton = new JButton("DOWN");
		this.downButton.addActionListener(listener);
		this.downButton.setActionCommand("down");
		this.setLayout(new GridLayout(3,0));
		this.add(this.textField);
		this.add(this.upButton);
		this.add(this.downButton);
	}
	
	private class ButtonListener implements ActionListener {
		private Model model;
		
		public ButtonListener(Model model) {
			this.model = model;
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			String command = source.getActionCommand();
			if (command.equals("up")) {
				this.model.increaseValue();
			}
			
			if (command.equals("down")) {
				this.model.decreaseValue();
			}
		}
	}
	
	public static void main(String[] args) {
		PracticeGUI gui = new PracticeGUI();
		gui.setTitle("Practice GUI");
		gui.setSize(600, 400);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
