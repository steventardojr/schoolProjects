package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.sql.*;
import dbaccess.*;
import java.util.ArrayList;
import java.util.Random;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class contains the company app, that helps companies
* find potential employees based on training they already have,
* training that is required, and allows companies to hire and fire
* employees based on the job profile for which they are working.
* It also contains the starting point for the project app.
*/

@SuppressWarnings("serial")
public class Company extends javax.swing.JFrame {
	private QueryAnswerer qa;

	private JButton enterNameBut;
	private JComboBox<String> nameBox;
	private String companyName;
	private String compID;
	private JButton addEmployeeBut;
	private JComboBox<String> addEmployeeNameBox;
	private JComboBox<String> addEmployeePosBox;
	private JComboBox<String> addEmployeeJobTypeBox;
	private JTextField addEmployeePayRateField;
	private JComboBox<String> addEmployeePayTypeBox;
	private JButton peopleQualifiedBut;
	private JComboBox<String> peopleQualifiedBox;
	private JButton peopleMissing1But;
	private JButton skillsMissing1But;
	private JButton numberOfSkillsMissingBut;
	private JComboBox<String> numberOfSkillsMissingBox;
	private JButton skillsPeopleMissingBut;
	private JButton fireEmployeeBut;
	private JComboBox<String> fireEmployeeBox;
	private JComboBox<String> fireEmployeeJobBox;
	private JButton projectBut;
	private JLabel posLabel;
	private JButton unqualifiedWorkersBut;
	private JButton unqualifiedCoursesBut;
	private JButton addSkillBut;
	private JComboBox<String> addSkillBox;
	private JComboBox<String> addSkillPersonBox;
	
	private JTextArea msgArea;
	private JScrollPane sp;
	
	public Company(QueryAnswerer qa) {
		super("Company");
		this.qa = qa;
		initGUI();
		compID = "";
	}
	
	private void initGUI() {
		try {
			{
				enterNameBut = new JButton();
				getContentPane().add(enterNameBut);
				enterNameBut.setText("OK");
				enterNameBut.setBounds(14, 45, 175, 28);
				enterNameBut.setEnabled(true);
				enterNameBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enterNameButActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> nameList = new ArrayList<String>();
				try {
					ResultSet rs = qa.nameFromCompany();
					
					while(rs.next()) {
						nameList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				nameBox = new JComboBox<String>(nameList.toArray(new String[nameList.size()]));
				getContentPane().add(nameBox);
				nameBox.setBounds(14, 14, 175, 28);
				nameBox.setEnabled(true);
			}

			{
				addEmployeeBut = new JButton();
				getContentPane().add(addEmployeeBut);
				addEmployeeBut.setText("Add Employee");
				addEmployeeBut.setBounds(14, 95, 175, 28);
				addEmployeeBut.setEnabled(false);
				addEmployeeBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addEmployeeButActionPerformed(evt);
					}
				});
			}
			{
				addEmployeeNameBox = new JComboBox<String>();
				getContentPane().add(addEmployeeNameBox);
				addEmployeeNameBox.setBounds(14, 125, 175, 28);
				addEmployeeNameBox.setEnabled(false);
				addEmployeeNameBox.addItem("Select a Person");
			}
			{
				addEmployeePosBox = new JComboBox<String>();
				getContentPane().add(addEmployeePosBox);
				addEmployeePosBox.setBounds(14, 155, 175, 28);
				addEmployeePosBox.setEnabled(false);
				addEmployeePosBox.addItem("Select a POS Code");
			}
			{
				addEmployeeJobTypeBox = new JComboBox<String>();
				getContentPane().add(addEmployeeJobTypeBox);
				addEmployeeJobTypeBox.setBounds(14, 185, 175, 28);
				addEmployeeJobTypeBox.setEnabled(false);
				addEmployeeJobTypeBox.addItem("Select Job Type");
				addEmployeeJobTypeBox.addItem("FT");
				addEmployeeJobTypeBox.addItem("PT");
			}
			{
				addEmployeePayRateField = new JTextField("Pay Rate");
				getContentPane().add(addEmployeePayRateField);
				addEmployeePayRateField.setBounds(14, 215, 175, 28);
				addEmployeePayRateField.setEnabled(false);
			}
			{
				addEmployeePayTypeBox = new JComboBox<String>();
				getContentPane().add(addEmployeePayTypeBox);
				addEmployeePayTypeBox.setBounds(14, 245, 175, 28);
				addEmployeePayTypeBox.setEnabled(false);
				addEmployeePayTypeBox.addItem("Select Pay Type");
				addEmployeePayTypeBox.addItem("S");
				addEmployeePayTypeBox.addItem("W");
			}
			
			
			{
				posLabel = new JLabel("Select a Profile");
				getContentPane().add(posLabel);
				posLabel.setBounds(14, 275, 175, 28);
				posLabel.setEnabled(false);
			}
			{
				peopleQualifiedBut = new JButton();
				getContentPane().add(peopleQualifiedBut);
				peopleQualifiedBut.setText("Who's qualified for a particular job?");
				peopleQualifiedBut.setBounds(14, 325, 300, 28);
				peopleQualifiedBut.setEnabled(false);
				peopleQualifiedBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						peopleQualifiedButActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> posList = new ArrayList<String>();
				try {
					ResultSet rs = qa.posFromJobProfile();
					
					while(rs.next()) {
						posList.add(rs.getString("pos_code"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				peopleQualifiedBox = new JComboBox<String>(posList.toArray(new String[posList.size()]));
				getContentPane().add(peopleQualifiedBox);
				peopleQualifiedBox.setBounds(14, 295, 175, 28);
				peopleQualifiedBox.setEnabled(false);
			}
			
			{
				peopleMissing1But = new JButton();
				getContentPane().add(peopleMissing1But);
				peopleMissing1But.setText("Who's missing 1 skill for a particular job?");
				peopleMissing1But.setBounds(14, 355, 300, 28);
				peopleMissing1But.setEnabled(false);
				peopleMissing1But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						peopleMissing1ButActionPerformed(evt);
					}
				});
			}
			
			{
				skillsMissing1But = new JButton();
				getContentPane().add(skillsMissing1But);
				skillsMissing1But.setText("What skills do people need just 1 for a particular job?");
				skillsMissing1But.setBounds(14, 385, 375, 28);
				skillsMissing1But.setEnabled(false);
				skillsMissing1But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						skillsMissing1ButActionPerformed(evt);
					}
				});
			}
			
			{
				numberOfSkillsMissingBut = new JButton();
				getContentPane().add(numberOfSkillsMissingBut);
				numberOfSkillsMissingBut.setText("How many skills are people missing for a particular job? (Up to k Skills)");
				numberOfSkillsMissingBut.setBounds(14, 415, 485, 28);
				numberOfSkillsMissingBut.setEnabled(false);
				numberOfSkillsMissingBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						numberOfSkillsMissingButActionPerformed(evt);
					}
				});
			}
			{
				numberOfSkillsMissingBox = new JComboBox<String>();
				getContentPane().add(numberOfSkillsMissingBox);
				numberOfSkillsMissingBox.setBounds(495, 415, 58, 28);
				numberOfSkillsMissingBox.setEnabled(false);
				numberOfSkillsMissingBox.addItem("k");
				for (int i = 1; i <= 10; i++) {
					numberOfSkillsMissingBox.addItem(Integer.toString(i));
				}
			}
			
			{
				skillsPeopleMissingBut = new JButton();
				getContentPane().add(skillsPeopleMissingBut);
				skillsPeopleMissingBut.setText("What skills are people missing the least for a particular job?");
				skillsPeopleMissingBut.setBounds(14, 445, 425, 28);
				skillsPeopleMissingBut.setEnabled(false);
				skillsPeopleMissingBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						skillsPeopleMissingButActionPerformed(evt);
					}
				});
			}
			
			{
				fireEmployeeBut = new JButton();
				getContentPane().add(fireEmployeeBut);
				fireEmployeeBut.setText("Fire Employee");
				fireEmployeeBut.setBounds(215, 155, 175, 28);
				fireEmployeeBut.setEnabled(false);
				fireEmployeeBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						fireEmployeeButActionPerformed(evt);
					}
				});
			}
			{
				fireEmployeeBox = new JComboBox<String>();
				getContentPane().add(fireEmployeeBox);
				fireEmployeeBox.setBounds(215, 95, 175, 28);
				fireEmployeeBox.setEnabled(false);
				fireEmployeeBox.addItem("Select a Person");
				fireEmployeeBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						fireEmployeeBoxActionPerformed(evt);
					}
				});
			}
			{
				fireEmployeeJobBox = new JComboBox<String>();
				getContentPane().add(fireEmployeeJobBox);
				fireEmployeeJobBox.setBounds(215, 125, 175, 28);
				fireEmployeeJobBox.setEnabled(false);
				fireEmployeeJobBox.addItem("Select Job Code");
			}
			{
				addSkillBut = new JButton();
				getContentPane().add(addSkillBut);
				addSkillBut.setText("Add Skill to Employee");
				addSkillBut.setBounds(215, 265, 175, 28);
				addSkillBut.setEnabled(false);
				addSkillBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addSkillButActionPerformed(evt);
					}
				});
			}
			{
				addSkillPersonBox = new JComboBox<String>();
				getContentPane().add(addSkillPersonBox);
				addSkillPersonBox.setBounds(215, 205, 175, 28);
				addSkillPersonBox.setEnabled(false);
				addSkillPersonBox.addItem("Select a Person");
				addSkillPersonBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addSkillPersonBoxActionPerformed(evt);
					}
				});
			}
			{
				addSkillBox = new JComboBox<String>();
				getContentPane().add(addSkillBox);
				addSkillBox.setBounds(215, 235, 175, 28);
				addSkillBox.setEnabled(false);
				addSkillBox.addItem("Select a Skill");
			}
			{
				projectBut = new JButton();
				getContentPane().add(projectBut);
				projectBut.setText("Project App");
				projectBut.setBounds(415, 95, 175, 28);
				projectBut.setEnabled(false);
				projectBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						trainingButActionPerformed(evt);
					}
				});
			}
			{
				unqualifiedWorkersBut = new JButton();
				getContentPane().add(unqualifiedWorkersBut);
				unqualifiedWorkersBut.setText("What job profiles have the most unqualified workers?");
				unqualifiedWorkersBut.setBounds(14, 495, 400, 28);
				unqualifiedWorkersBut.setEnabled(false);
				unqualifiedWorkersBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						unqualifiedWorkersButActionPerformed(evt);
					}
				});
			}
			{
				unqualifiedCoursesBut = new JButton();
				getContentPane().add(unqualifiedCoursesBut);
				unqualifiedCoursesBut.setText("What courses can train the most unqualified workers?");
				unqualifiedCoursesBut.setBounds(14, 545, 400, 28);
				unqualifiedCoursesBut.setEnabled(false);
				unqualifiedCoursesBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						unqualifiedCoursesButActionPerformed(evt);
					}
				});
			}
			
			{
				msgArea = new JTextArea();
				getContentPane().add(msgArea);
				msgArea.setText("");
				msgArea.setEditable(false);
				msgArea.setBounds(670, 14, 470, 720);
			}
			{
				sp = new JScrollPane(msgArea);
				getContentPane().add(sp);
				sp.setBounds(670, 14, 470, 720);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(1160, 775);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	
	private void enterNameButActionPerformed(ActionEvent evt) {
		companyName = nameBox.getSelectedItem().toString();
		try {
			ResultSet rs = qa.compidFromCompany(companyName);
			
			while(rs.next()) {
				compID = rs.getString("comp_id");
			}
			rs.close();
			if (compID == "") {
				msgArea.append("Invalid Company Name\n\n");
			}
			else {
				
				ArrayList<String> nameList = new ArrayList<String>();
				try {
					rs = qa.peopleFromCompany(this.compID);
					
					while(rs.next()) {
						nameList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				String[] listOfNames = nameList.toArray(new String[nameList.size()]);
				fireEmployeeBox.removeAllItems();
				fireEmployeeBox.addItem("Select a Person");
				for (int i = 0; i < listOfNames.length; i++) {
					fireEmployeeBox.addItem(listOfNames[i]);
				}
				addSkillPersonBox.removeAllItems();
				addSkillPersonBox.addItem("Select a Person");
				for (int i = 0; i < listOfNames.length; i++) {
					addSkillPersonBox.addItem(listOfNames[i]);
				}
				
				
				ArrayList<String> personList = new ArrayList<String>();
				try {
					rs = qa.nameFromPerson();
					
					while(rs.next()) {
						personList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				String[] listOfPeople = personList.toArray(new String[personList.size()]);
				addEmployeeNameBox.removeAllItems();
				addEmployeeNameBox.addItem("Select a Person");
				for (int i = 0; i < listOfPeople.length; i++) {
					addEmployeeNameBox.addItem(listOfPeople[i]);
				}
				
				ArrayList<String> posList = new ArrayList<String>();
				try {
					rs = qa.posFromJobProfile();
					
					while(rs.next()) {
						posList.add(rs.getString("pos_code"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				String[] listOfPOS = posList.toArray(new String[posList.size()]);
				addEmployeePosBox.removeAllItems();
				addEmployeePosBox.addItem("Select a POS Code");
				for (int i = 0; i < listOfPOS.length; i++) {
					addEmployeePosBox.addItem(listOfPOS[i]);
				}
				
				ArrayList<String> ksList = new ArrayList<String>();
				try {
					rs = qa.ksFromKnowledgeSkill();
					
					while(rs.next()) {
						ksList.add(rs.getString("ks_code"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				String[] listOfKS = ksList.toArray(new String[ksList.size()]);
				addSkillBox.removeAllItems();
				addSkillBox.addItem("Select a Skill");
				for (int i = 0; i < listOfKS.length; i++) {
					addSkillBox.addItem(listOfKS[i]);
				}
				
				fireEmployeeBox.setEnabled(true);
				addEmployeeBut.setEnabled(true);
				addEmployeeNameBox.setEnabled(true);
				addEmployeePosBox.setEnabled(true);
				addEmployeeJobTypeBox.setEnabled(true);
				addEmployeePayRateField.setEnabled(true);
				addEmployeePayTypeBox.setEnabled(true);
				peopleQualifiedBut.setEnabled(true);
				peopleQualifiedBox.setEnabled(true);
				peopleMissing1But.setEnabled(true);
				skillsMissing1But.setEnabled(true);
				numberOfSkillsMissingBut.setEnabled(true);
				skillsPeopleMissingBut.setEnabled(true);
				fireEmployeeBut.setEnabled(true);
				projectBut.setEnabled(true);
				posLabel.setEnabled(true);
				peopleQualifiedBox.setEnabled(true);
				unqualifiedWorkersBut.setEnabled(true);
				unqualifiedCoursesBut.setEnabled(true);
				addSkillBut.setEnabled(true);
				addSkillPersonBox.setEnabled(true);
				addSkillBox.setEnabled(true);
				fireEmployeeJobBox.setEnabled(true);
				numberOfSkillsMissingBox.setEnabled(true);
			}
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n\n");
		}
	}
	
	private void addEmployeeButActionPerformed(ActionEvent evt) {
		if (!(addEmployeePayRateField.getText().matches("\\d{1,7}\\.{0,1}\\d{0,2}"))) {
			msgArea.append("Invalid Pay Rate\n");
			msgArea.append("Job Not Added\n\n");
			return;
		}
		String personName = addEmployeeNameBox.getSelectedItem().toString();
		String perID = "";
		Random randomInt = new Random();
		String newJobID = ((Integer)randomInt.nextInt(99999)).toString();
		String pos_code = addEmployeePosBox.getSelectedItem().toString();
		String type = addEmployeeJobTypeBox.getSelectedItem().toString();
		Double pay_rate = Double.parseDouble(addEmployeePayRateField.getText());
		String pay_type = addEmployeePayTypeBox.getSelectedItem().toString();
		try {
			ResultSet rs = qa.peridFromName(personName);
			
			while(rs.next()) {
				perID = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n\n\n");
		}
		
		Job job = new Job(newJobID, pos_code, type, pay_rate, pay_type, compID, perID, this.qa);
		
		msgArea.append(job.addNewJob() + "\n");
		fireEmployeeBox.removeItem(personName);
		fireEmployeeBox.addItem(personName);
		addSkillPersonBox.removeItem(personName);
		addSkillPersonBox.addItem(personName);
	}
	
	private void peopleQualifiedButActionPerformed(ActionEvent evt) {
		String pos_code = peopleQualifiedBox.getSelectedItem().toString();
		msgArea.append("The following people are qualified:\n");
		try {
			ResultSet rs = qa.query18Answerer(pos_code);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				msgArea.append(name + ",  Email: " + email + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void peopleMissing1ButActionPerformed(ActionEvent evt) {
		String pos_code = peopleQualifiedBox.getSelectedItem().toString();
		msgArea.append("The following people are only missing 1 skill:\n");
		try {
			ResultSet rs = qa.query19Answerer(pos_code);
			
			while(rs.next()) {
				String name = rs.getString("name");
				msgArea.append(name + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void skillsMissing1ButActionPerformed(ActionEvent evt) {
		String pos_code = peopleQualifiedBox.getSelectedItem().toString();
		int personccnt = 0;
		msgArea.append("The following skills are missing:\n");
		try {
			ResultSet rs = qa.query20Answerer(pos_code);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				personccnt = rs.getInt("personccnt");
				msgArea.append("KS Code: " + ks_code + "\n");
				msgArea.append("Number of People Missing Skill: " + personccnt + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void numberOfSkillsMissingButActionPerformed(ActionEvent evt) {
		String pos_code = peopleQualifiedBox.getSelectedItem().toString();
		msgArea.append("The following people are missing skills:\n");
		try {
			ResultSet rs = qa.query22Answerer(pos_code, numberOfSkillsMissingBox.getSelectedItem().toString());
			
			while(rs.next()) {
				String name = rs.getString("name");
				int skillCount = rs.getInt("leastNumber");
				msgArea.append("Name: " + name + ",  Missing Skill Count: " + skillCount + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void skillsPeopleMissingButActionPerformed(ActionEvent evt) {
		String pos_code = peopleQualifiedBox.getSelectedItem().toString();
		msgArea.append("The following skills are missing:\n");
		try {
			ResultSet rs = qa.query23Answerer(pos_code);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				String person_count = rs.getString("personCount");
				msgArea.append("KS Code: " + ks_code + ",  Number of People Missing Skill: " + person_count + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void fireEmployeeButActionPerformed(ActionEvent evt) {
		String personName = fireEmployeeBox.getSelectedItem().toString();
		String pos_code = fireEmployeeJobBox.getSelectedItem().toString();
		String per_id = "";
		String job_code = "";
		try {
			ResultSet rs = qa.peridFromName(personName);
			
			while(rs.next()) {
				per_id = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage());
		}
		
		Job job = new Job(job_code, pos_code, compID, per_id, this.qa);
		
		msgArea.append(job.removeJob());
		fireEmployeeJobBox.removeItem(pos_code);
		if (fireEmployeeJobBox.getItemCount() == 0) {
			fireEmployeeBox.removeItem(personName);
			addSkillPersonBox.removeItem(personName);
		}
		msgArea.append("\n");
	}
	
	private void trainingButActionPerformed(ActionEvent evt) {
		Project pj = new Project(compID, qa);
		pj.setVisible(true);
	}
	
	private void unqualifiedWorkersButActionPerformed(ActionEvent evt) {
		msgArea.append("The following job profiles have the most unqualified workers:\n");
		try {
			ResultSet rs = qa.query24Answerer();
			
			while(rs.next()) {
				String pos_code = rs.getString("pos_code");
				msgArea.append("POS Code: " + pos_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void unqualifiedCoursesButActionPerformed(ActionEvent evt) {
		msgArea.append("The following courses can train the most unqualified workers:\n");
		try {
			ResultSet rs = qa.query25Answerer();
			
			while(rs.next()) {
				String title = rs.getString("title");
				msgArea.append(title + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void addSkillButActionPerformed(ActionEvent evt) {
		String per_name = addSkillPersonBox.getSelectedItem().toString();
		String ks_code = addSkillBox.getSelectedItem().toString();
		String per_id = "";
		try {
			ResultSet rs = qa.peridFromName(per_name);
			
			while(rs.next()) {
				per_id = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			qa.addSkill(per_id, ks_code);
			msgArea.append("Skill successfully added\n");
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		addSkillBox.removeItem(ks_code);
		msgArea.append("\n\n");
	}
	
	private void addSkillPersonBoxActionPerformed(ActionEvent evt) {
		String per_id = "";
		try {
			ResultSet rs = qa.peridFromName(addSkillPersonBox.getSelectedItem().toString());
			
			while(rs.next()) {
				per_id = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
		}
		
		ArrayList<String> ksList = new ArrayList<String>();
		try {
			ResultSet rs = qa.ksCodeNotInPersonSkill(per_id);
			
			while(rs.next()) {
				ksList.add(rs.getString("ks_code"));
			}
			rs.close();
		}
		catch (Exception e) {
		}
		String[] listOfKS = ksList.toArray(new String[ksList.size()]);
		addSkillBox.removeAllItems();
		addSkillBox.addItem("Select a Skill");
		for (int i = 0; i < listOfKS.length; i++) {
			addSkillBox.addItem(listOfKS[i]);
		}
	}
	
	private void fireEmployeeBoxActionPerformed(ActionEvent evt) {
		String per_id = "";
		try {
			ResultSet rs = qa.peridFromName(fireEmployeeBox.getSelectedItem().toString());
			
			while(rs.next()) {
				per_id = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
		}
		
		ArrayList<String> posList = new ArrayList<String>();
		try {
			ResultSet rs = qa.posFromWorks(compID, per_id);
			
			while(rs.next()) {
				posList.add(rs.getString("pos_code"));
			}
			rs.close();
		}
		catch (Exception e) {
		}
		String[] listOfPOS = posList.toArray(new String[posList.size()]);
		fireEmployeeJobBox.removeAllItems();
		fireEmployeeJobBox.addItem("Select a Skill");
		for (int i = 0; i < listOfPOS.length; i++) {
			fireEmployeeJobBox.addItem(listOfPOS[i]);
		}
	}
}
