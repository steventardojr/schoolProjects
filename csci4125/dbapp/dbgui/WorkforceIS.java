package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.io.StringWriter; 
import java.io.PrintWriter;
import dbaccess.*;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class contains the starting point for the WorkforceIS System,
* which helps potential employees find jobs for which they are qualified
* and training required for jobs that they are not yet qualified. It also
* helps companies find potential employees, hire and fire employees,
* and set up projects, with estimates on project costs and training required.
* This class contains the database login screen, and buttons for launching the
* various applications.
*/

@SuppressWarnings("serial")
public class WorkforceIS extends javax.swing.JFrame {
	private JLabel menuTitle;
	private JLabel usernameLab;
	private JLabel passwdLab;
	private JButton loginBut;
	private JButton selectBut;
	private JButton personBut;
	private JButton companyBut;
	private JPasswordField passwdField;
	private JTextField usernameField;
	private TableInfo ti;
	private QueryAnswerer qa;
	
	private java.sql.Connection conn;
	private JTextArea msgArea;
	private JTextField sidField;
	private JLabel sidLab;
	private JTextField portField;
	private JLabel portLab;
	private JTextField hostField;
	private JLabel hostLab;
	private TableUpdate tu;
	private JScrollPane sp;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		WorkforceIS inst = new WorkforceIS();
		inst.setVisible(true);
	}
	
	public WorkforceIS() {
		super("WorkforceIS");
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				menuTitle = new JLabel();
				getContentPane().add(menuTitle);
				menuTitle.setText("Menu");
				menuTitle.setBounds(85, 133, 63, 28);
			}
			{
				usernameLab = new JLabel();
				getContentPane().add(usernameLab);
				usernameLab.setText("User Name");
				usernameLab.setBounds(35, 14, 91, 28);
			}
			{
				usernameField = new JTextField();
				getContentPane().add(usernameField);
				usernameField.setBounds(133, 14, 119, 28);
			}
			{
				passwdLab = new JLabel();
				getContentPane().add(passwdLab);
				passwdLab.setText("Password");
				passwdLab.setBounds(35, 49, 105, 28);
			}
			{
				passwdField = new JPasswordField();
				getContentPane().add(passwdField);
				passwdField.setBounds(133, 49, 119, 28);
				passwdField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						loginButActionPerformed(evt);
					}
				});
			}
			{
				loginBut = new JButton();
				getContentPane().add(loginBut);
				loginBut.setText("Login");
				loginBut.setBounds(14, 91, 175, 28);
				loginBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						loginButActionPerformed(evt);
					}
				});
			}
			{
				selectBut = new JButton();
				getContentPane().add(selectBut);
				selectBut.setText("Queries");
				selectBut.setBounds(14, 231, 175, 28);
				selectBut.setEnabled(false);
				selectBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						selectButActionPerformed(evt);
					}
				});
			}
			{
				personBut = new JButton();
				getContentPane().add(personBut);
				personBut.setText("Person App");
				personBut.setBounds(14, 161, 175, 28);
				personBut.setEnabled(false);
				personBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						personButActionPerformed(evt);
					}
				});
			}
			{
				companyBut = new JButton();
				getContentPane().add(companyBut);
				companyBut.setText("Company App");
				companyBut.setBounds(14, 196, 175, 28);
				companyBut.setEnabled(false);
				companyBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						companyButActionPerformed(evt);
					}
				});
			}
			{
				hostLab = new JLabel();
				getContentPane().add(hostLab);
				hostLab.setText("Database Host");
				hostLab.setBounds(289, 14, 105, 28);
			}
			{
				hostField = new JTextField();
				getContentPane().add(hostField);
				hostField.setText("dbsvcs.cs.uno.edu");
				hostField.setBounds(392, 14, 147, 28);
			}
			{
				portLab = new JLabel();
				getContentPane().add(portLab);
				portLab.setText("Database Port");
				portLab.setBounds(294, 49, 98, 28);
			}
			{
				portField = new JTextField();
				getContentPane().add(portField);
				portField.setText("1521");
				portField.setBounds(392, 49, 70, 28);
			}
			{
				sidLab = new JLabel();
				getContentPane().add(sidLab);
				sidLab.setText("Database Name (SID)");
				sidLab.setBounds(250, 84, 147, 28);
			}
			{
				sidField = new JTextField();
				getContentPane().add(sidField);
				sidField.setText("orcl");
				sidField.setBounds(392, 84, 119, 28);
			}
			{
				msgArea = new JTextArea();
				getContentPane().add(msgArea);
				msgArea.setText("Database Message\n");
				msgArea.setBounds(203, 119, 462, 231);
				msgArea.setEditable(false);
			}
			{
				sp = new JScrollPane(msgArea);
				getContentPane().add(sp);
				sp.setBounds(390, 119, 462, 231);
				
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(900, 400);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private void loginButActionPerformed(ActionEvent evt) {
		String username = usernameField.getText();
		char[] password = passwdField.getPassword();
		String passwd = new String(password);
		String host = hostField.getText();
		String port = portField.getText();
		String sid = sidField.getText();
		DBConnection dbc = new DBConnection(host, port, sid);
		try {
			conn = dbc.getDBConnection(username, passwd);
			tu = new TableUpdate(conn);
			ti = tu.getTableInfo();
			qa = tu.getQA();
			selectBut.setEnabled(true);
			personBut.setEnabled(true);
			companyBut.setEnabled(true);
			passwdField.setText("");
		} catch (java.sql.SQLException sqle) {
			StringWriter strMsg = new StringWriter();
			PrintWriter prtMsg = new PrintWriter(strMsg);
			sqle.printStackTrace(prtMsg); 
			msgArea.setText(strMsg.toString());
		}
	}

	private void selectButActionPerformed(ActionEvent evt) {
		Queries qs = new Queries(ti, qa);
		qs.setVisible(true);
	}
	private void personButActionPerformed(ActionEvent evt) {
		Person pr = new Person(qa);
		pr.setVisible(true);
	}
	private void companyButActionPerformed(ActionEvent evt) {
		Company cp = new Company(qa);
		cp.setVisible(true);
	}
}
