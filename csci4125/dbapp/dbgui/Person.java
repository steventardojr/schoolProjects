package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;
import dbaccess.*;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class contains the person app, which helps a person
* determine which jobs they are qualified, and what training
* and courses that provide this training are required.
*/

@SuppressWarnings("serial")
public class Person extends javax.swing.JFrame {
	private QueryAnswerer qa;

	private JLabel nameLabel;
	private JButton enterNameBut;
	private JComboBox<String> nameBox;
	private String personName;
	private JButton currentlyEmployedBut;
	private JButton currentSkillsBut;
	private JButton skillsNeededBut;
	private JButton skillsNeededforNewJobBut;
	private JLabel skillsNeededLabel;
	private JComboBox<String> skillsNeededforNewJobBox;
	private JButton oneCourseBut;
	private JButton coursesNeededBut;
	private JButton cheapestCoursesNeededBut;
	private JButton currentlyQualifiedBut;
	private JButton highestPayingJobBut;
	private JButton getJobInfoBut;
	private JComboBox<String> getJobInfoBox;
	private JButton getKsInfoBut;
	private JComboBox<String> getKsInfoBox;
	private JButton addPersonBut;
	private JTextField addPersonNameField;
	private JTextField addPersonStreetField;
	private JTextField addPersonCityField;
	private JTextField addPersonStateField;
	private JTextField addPersonZipField;
	private JTextField addPersonEmailField;
	private JComboBox<String> addPersonGenderBox;
	private JTextField addPersonHomePhoneField;
	private JTextField addPersonWorkPhoneField;
	private JTextField addPersonCellPhoneField;
	private JLabel skillInfoLabel;
	private JLabel ksInfoLabel;
	private SimpleDateFormat sdf;
	private JLabel trainingOpLabel;
	
	private JTextArea msgArea;
	private JScrollPane sp;
	
	public Person(QueryAnswerer qa) {
		super("Person");
		this.qa = qa;
		initGUI();
		sdf = new SimpleDateFormat("MM-dd-yyyy");
	}
	
	private void initGUI() {
		try {
			{
				nameLabel = new JLabel("Select a Person");
				getContentPane().add(nameLabel);
				nameLabel.setBounds(55, 20, 175, 28);
			}
			{
				enterNameBut = new JButton();
				getContentPane().add(enterNameBut);
				enterNameBut.setText("OK");
				enterNameBut.setBounds(14, 70, 175, 28);
				enterNameBut.setEnabled(true);
				enterNameBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enterNameButActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> personList = new ArrayList<String>();
				try {
					ResultSet rs = qa.nameFromPerson();
					
					while(rs.next()) {
						personList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				nameBox = new JComboBox<String>(personList.toArray(new String[personList.size()]));
				getContentPane().add(nameBox);
				nameBox.setBounds(14, 45, 175, 28);
				nameBox.setEnabled(true);
			}
			
			{
				addPersonBut = new JButton();
				getContentPane().add(addPersonBut);
				addPersonBut.setText("Add Person");
				addPersonBut.setBounds(425, 14, 175, 28);
				addPersonBut.setEnabled(true);
				addPersonBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addPersonButActionPerformed(evt);
					}
				});
			}
			{
				addPersonNameField = new JTextField("Name");
				getContentPane().add(addPersonNameField);
				addPersonNameField.setBounds(425, 40, 175, 28);
			}
			{
				addPersonStreetField = new JTextField("Street");
				getContentPane().add(addPersonStreetField);
				addPersonStreetField.setBounds(425, 65, 175, 28);
			}
			{
				addPersonCityField = new JTextField("City");
				getContentPane().add(addPersonCityField);
				addPersonCityField.setBounds(425, 90, 175, 28);
			}
			{
				addPersonStateField = new JTextField("State (2 Letters)");
				getContentPane().add(addPersonStateField);
				addPersonStateField.setBounds(425, 115, 175, 28);
			}
			{
				addPersonZipField = new JTextField("Zip");
				getContentPane().add(addPersonZipField);
				addPersonZipField.setBounds(425, 140, 175, 28);
			}
			{
				addPersonEmailField = new JTextField("Email Address");
				getContentPane().add(addPersonEmailField);
				addPersonEmailField.setBounds(425, 165, 175, 28);
			}
			{
				addPersonGenderBox = new JComboBox<String>();
				getContentPane().add(addPersonGenderBox);
				addPersonGenderBox.setBounds(425, 190, 175, 28);
				addPersonGenderBox.addItem("Select a Gender");
				addPersonGenderBox.addItem("M");
				addPersonGenderBox.addItem("F");
			}
			{
				addPersonHomePhoneField = new JTextField("Home Phone (***-***-****)");
				getContentPane().add(addPersonHomePhoneField);
				addPersonHomePhoneField.setBounds(425, 215, 200, 28);
			}
			{
				addPersonWorkPhoneField = new JTextField("Work Phone (***-***-****)");
				getContentPane().add(addPersonWorkPhoneField);
				addPersonWorkPhoneField.setBounds(425, 240, 200, 28);
			}
			{
				addPersonCellPhoneField = new JTextField("Cell Phone (***-***-****)");
				getContentPane().add(addPersonCellPhoneField);
				addPersonCellPhoneField.setBounds(425, 265, 200, 28);
			}

			{
				currentlyEmployedBut = new JButton();
				getContentPane().add(currentlyEmployedBut);
				currentlyEmployedBut.setText("What are my current jobs?");
				currentlyEmployedBut.setBounds(14, 115, 210, 28);
				currentlyEmployedBut.setEnabled(false);
				currentlyEmployedBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						currentlyEmployedButActionPerformed(evt);
					}
				});
			}

			
			{
				currentSkillsBut = new JButton();
				getContentPane().add(currentSkillsBut);
				currentSkillsBut.setText("What are my current skills?");
				currentSkillsBut.setBounds(14, 150, 220, 28);
				currentSkillsBut.setEnabled(false);
				currentSkillsBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						currentSkillsButActionPerformed(evt);
					}
				});
			}
			
			{
				skillsNeededBut = new JButton();
				getContentPane().add(skillsNeededBut);
				skillsNeededBut.setText("What skills am I missing for my current job?");
				skillsNeededBut.setBounds(14, 185, 330, 28);
				skillsNeededBut.setEnabled(false);
				skillsNeededBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						skillsNeededButActionPerformed(evt);
					}
				});
			}
			
			{
				skillsNeededforNewJobBut = new JButton();
				getContentPane().add(skillsNeededforNewJobBut);
				skillsNeededforNewJobBut.setText("What skills am I missing for this job?");
				skillsNeededforNewJobBut.setBounds(14, 305, 320, 28);
				skillsNeededforNewJobBut.setEnabled(false);
				skillsNeededforNewJobBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						skillsNeededforNewJobActionPerformed(evt);
					}
				});
			}
			{
				trainingOpLabel = new JLabel("Training Optimization Services");
				getContentPane().add(trainingOpLabel);
				trainingOpLabel.setBounds(14, 240, 225, 28);
				trainingOpLabel.setEnabled(false);
			}
			{
				skillsNeededLabel = new JLabel("Select a Profile");
				getContentPane().add(skillsNeededLabel);
				skillsNeededLabel.setBounds(55, 260, 175, 28);
				skillsNeededLabel.setEnabled(false);
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
				skillsNeededforNewJobBox = new JComboBox<String>(posList.toArray(new String[posList.size()]));
				getContentPane().add(skillsNeededforNewJobBox);
				skillsNeededforNewJobBox.setBounds(14, 280, 175, 28);
				skillsNeededforNewJobBox.setEnabled(false);
			}
			
			{
				oneCourseBut = new JButton();
				getContentPane().add(oneCourseBut);
				oneCourseBut.setText("Can I take one course to cover all my missing skills for this job?");
				oneCourseBut.setBounds(14, 330, 470, 28);
				oneCourseBut.setEnabled(false);
				oneCourseBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						oneCourseActionPerformed(evt);
					}
				});
			}
			
			{
				coursesNeededBut = new JButton();
				getContentPane().add(coursesNeededBut);
				coursesNeededBut.setText("What courses do I need to cover this job?");
				coursesNeededBut.setBounds(14, 355, 350, 28);
				coursesNeededBut.setEnabled(false);
				coursesNeededBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						coursesNeededActionPerformed(evt);
					}
				});
			}
			
			{
				cheapestCoursesNeededBut = new JButton();
				getContentPane().add(cheapestCoursesNeededBut);
				cheapestCoursesNeededBut.setText("What are the cheapest courses I need to cover this job?");
				cheapestCoursesNeededBut.setBounds(14, 380, 420, 28);
				cheapestCoursesNeededBut.setEnabled(false);
				cheapestCoursesNeededBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cheapestCoursesNeededActionPerformed(evt);
					}
				});
			}
			
			{
				currentlyQualifiedBut = new JButton();
				getContentPane().add(currentlyQualifiedBut);
				currentlyQualifiedBut.setText("What jobs am I currently qualified for?");
				currentlyQualifiedBut.setBounds(14, 440, 280, 28);
				currentlyQualifiedBut.setEnabled(false);
				currentlyQualifiedBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						currentlyQualifiedActionPerformed(evt);
					}
				});
			}
			
			{
				highestPayingJobBut = new JButton();
				getContentPane().add(highestPayingJobBut);
				highestPayingJobBut.setText("What is the highest paying job I am currently qualified for?");
				highestPayingJobBut.setBounds(14, 480, 400, 28);
				highestPayingJobBut.setEnabled(false);
				highestPayingJobBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						highestPayingJobButActionPerformed(evt);
					}
				});
			}
			{
				skillInfoLabel = new JLabel("Select a Profile");
				getContentPane().add(skillInfoLabel);
				skillInfoLabel.setBounds(55, 535, 175, 28);
				skillInfoLabel.setEnabled(true);
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
				getJobInfoBox = new JComboBox<String>(posList.toArray(new String[posList.size()]));
				getContentPane().add(getJobInfoBox);
				getJobInfoBox.setBounds(14, 555, 175, 28);
				getJobInfoBox.setEnabled(true);
			}
			{
				getJobInfoBut = new JButton();
				getContentPane().add(getJobInfoBut);
				getJobInfoBut.setText("Get Job Info");
				getJobInfoBut.setBounds(14, 585, 230, 28);
				getJobInfoBut.setEnabled(true);
				getJobInfoBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getJobInfoButActionPerformed(evt);
					}
				});
			}
			
			{
				ksInfoLabel = new JLabel("Select a Skill");
				getContentPane().add(ksInfoLabel);
				ksInfoLabel.setBounds(55, 625, 175, 28);
				ksInfoLabel.setEnabled(true);
			}
			{
				ArrayList<String> ksList = new ArrayList<String>();
				try {
					ResultSet rs = qa.ksFromKnowledgeSkill();
					
					while(rs.next()) {
						ksList.add(rs.getString("ks_code"));
					}
					rs.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				getKsInfoBox = new JComboBox<String>(ksList.toArray(new String[ksList.size()]));
				getContentPane().add(getKsInfoBox);
				getKsInfoBox.setBounds(14, 645, 175, 28);
				getKsInfoBox.setEnabled(true);
			}
			{
				getKsInfoBut = new JButton();
				getContentPane().add(getKsInfoBut);
				getKsInfoBut.setText("Get Knowledge Skill Info");
				getKsInfoBut.setBounds(14, 675, 230, 28);
				getKsInfoBut.setEnabled(true);
				getKsInfoBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getKsInfoButActionPerformed(evt);
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
		personName = nameBox.getSelectedItem().toString();
		String per_id = "";
		try {
			ResultSet rs = qa.peridFromName(personName);
			
			while(rs.next()) {
				per_id = rs.getString("per_id");
			}
			rs.close();
			if (per_id == "") {
				msgArea.append("Invalid Person Name\n\n");
			}
			else {
				currentlyEmployedBut.setEnabled(true);
				currentSkillsBut.setEnabled(true);
				skillsNeededBut.setEnabled(true);
				skillsNeededforNewJobBut.setEnabled(true);
				skillsNeededforNewJobBox.setEnabled(true);
				oneCourseBut.setEnabled(true);
				coursesNeededBut.setEnabled(true);
				cheapestCoursesNeededBut.setEnabled(true);
				currentlyQualifiedBut.setEnabled(true);
				highestPayingJobBut.setEnabled(true);
				skillsNeededLabel.setEnabled(true);
				trainingOpLabel.setEnabled(true);
			}
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n\n");
		}
	}
	
	private void addPersonButActionPerformed(ActionEvent evt) {
		if (!(addPersonNameField.getText().matches("\\D{1,20}"))) {
			msgArea.append("Too many characters in Name field\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonStreetField.getText().matches("[A-Za-z0-9 ]{1,30}"))) {
			msgArea.append("Too many characters in Street field\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonCityField.getText().matches("[A-Za-z0-9 ]{1,20}"))) {
			msgArea.append("Too many characters in City field\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonStateField.getText().matches("[A-Z]{2}"))) {
			msgArea.append("Invalid State Format\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonZipField.getText().matches("\\d{5}"))) {
			msgArea.append("Invalid Zip Code Format\nPerson Not Added\n\n");
			return;
		}
		if (!(addPersonEmailField.getText().matches("[\\D*(@{1})\\D*]{1,30}"))) {
			msgArea.append("Invalid Email Format or\n");
			msgArea.append("Too many characters in Email field\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonHomePhoneField.getText().matches("(\\d{3})-(\\d{3})-(\\d{4})"))) {
			msgArea.append("Invalid Home Phone Number\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonCellPhoneField.getText().matches("(\\d{3})-(\\d{3})-(\\d{4})"))) {
			msgArea.append("Invalid Cell Phone Number\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		if (!(addPersonWorkPhoneField.getText().matches("(\\d{3})-(\\d{3})-(\\d{4})"))) {
			msgArea.append("Invalid Work Phone Number\n");
			msgArea.append("Person Not Added\n\n");
			return;
		}
		
		personName = addPersonNameField.getText();
		Random randomInt = new Random();
		String per_id = ((Integer)randomInt.nextInt(99999)).toString();
		try {
			qa.addPerson(per_id, personName, addPersonStreetField.getText(), addPersonCityField.getText(), addPersonStateField.getText(), addPersonZipField.getText(), addPersonEmailField.getText(), addPersonGenderBox.getSelectedItem().toString(), addPersonHomePhoneField.getText(), addPersonCellPhoneField.getText(), addPersonWorkPhoneField.getText());
			currentlyEmployedBut.setEnabled(true);
			currentSkillsBut.setEnabled(true);
			skillsNeededBut.setEnabled(true);
			skillsNeededforNewJobBut.setEnabled(true);
			skillsNeededforNewJobBox.setEnabled(true);
			oneCourseBut.setEnabled(true);
			coursesNeededBut.setEnabled(true);
			cheapestCoursesNeededBut.setEnabled(true);
			currentlyQualifiedBut.setEnabled(true);
			highestPayingJobBut.setEnabled(true);
			skillsNeededLabel.setEnabled(true);
			trainingOpLabel.setEnabled(true);
			nameBox.addItem(personName);
			msgArea.append("Person Successfully Added!\n\n\n");
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage()+"\n\n");
		}
		addPersonGenderBox.removeAllItems();
		addPersonGenderBox.addItem("Select a Gender");
		addPersonGenderBox.addItem("M");
		addPersonGenderBox.addItem("F");
	}
	
	private void currentlyEmployedButActionPerformed(ActionEvent evt) {
		msgArea.append("Your current jobs are:\n");
		try {
			ResultSet rs = qa.titleFromJobProfile(personName);
			
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
	
	private void currentSkillsButActionPerformed(ActionEvent evt) {
		msgArea.append("Your current skills are:\n");
		try {
			ResultSet rs = qa.currentSkills(personName);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				String lvl = rs.getString("lvl");
				msgArea.append("KS Code: " + ks_code + "  Title: " + title + "\n");
				msgArea.append("Description: " + desc + "  Level: " + lvl + "\n\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void skillsNeededButActionPerformed(ActionEvent evt) {
		msgArea.append("You need the following skills:\n");
		try {
			ResultSet rs = qa.query7Answerer(personName);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				msgArea.append("KS Code: " + ks_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void skillsNeededforNewJobActionPerformed(ActionEvent evt) {
		msgArea.append("You need the following skills:\n");
		try {
			ResultSet rs = qa.query9Answerer(skillsNeededforNewJobBox.getSelectedItem().toString(), personName);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				msgArea.append("KS Code: " + ks_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void oneCourseActionPerformed(ActionEvent evt) {
		msgArea.append("You can take the following courses,\n");
		msgArea.append("The following section ends the soonest:\n");
		try {
			ResultSet rs = qa.query12Answerer(skillsNeededforNewJobBox.getSelectedItem().toString(), personName);

			while(rs.next()) {
				String c_code = rs.getString("c_code");
				String title = rs.getString("title");
				String sec_number = rs.getString("sec_number");
				Date complete_date = rs.getDate("complete_date");
				msgArea.append("Course Code: " + c_code + ",  Title: " + title + "\n");
				msgArea.append("Section Number: " + sec_number + ",  Complete Date: " + sdf.format(complete_date) + "\n\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void coursesNeededActionPerformed(ActionEvent evt) {
		msgArea.append("You need the following courses (Each set covers the skills required):\n");
		try {
			ResultSet rs = qa.query14Answerer(skillsNeededforNewJobBox.getSelectedItem().toString(), personName);
			
			while(rs.next()) {
				String c_code1 = rs.getString("c_code1");
				String c_code2 = rs.getString("c_code2");
				String c_code3 = rs.getString("c_code3");
				msgArea.append("Course Set:\n");
				msgArea.append("Course Code 1: " + c_code1 + "\n");
				msgArea.append("Course Code 2: " + c_code2 + "\n");
				if (c_code3 != null) {
					msgArea.append("Course Code 3: " + c_code3 + "\n");
				}
				msgArea.append("\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void cheapestCoursesNeededActionPerformed(ActionEvent evt) {
		msgArea.append("These are the cheapest courses to cover all the skills required:\n");
		try {
			ResultSet rs = qa.query15Answerer(skillsNeededforNewJobBox.getSelectedItem().toString(), personName);
			
			while(rs.next()) {
				String c_code1 = rs.getString("c_code1");
				String c_code2 = rs.getString("c_code2");
				String c_code3 = rs.getString("c_code3");
				String courseSetPrice = rs.getString("sumOfCourses");
				msgArea.append("Course Set:\n");
				msgArea.append("Course Code 1: " + c_code1 + "\n");
				msgArea.append("Course Code 2: " + c_code2 + "\n");
				if (c_code3 != null) {
					msgArea.append("Course Code 3: " + c_code3 + "\n");
				}
				msgArea.append("Price: $" + courseSetPrice + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void currentlyQualifiedActionPerformed(ActionEvent evt) {
		msgArea.append("You are currently qualified for the following jobs:\n");
		try {
			ResultSet rs = qa.query16Answerer(personName);
			
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
	
	private void highestPayingJobButActionPerformed(ActionEvent evt) {
		msgArea.append("The highest paying job you are currently qualified for is:\n");
		try {
			ResultSet rs = qa.query17Answerer(personName);
			
			while(rs.next()) {
				String pos_code = rs.getString("pos_code");
				int max_pay = rs.getInt("hpay");
				msgArea.append("POS Code: " + pos_code + "  Pay: $" + max_pay + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void getJobInfoButActionPerformed(ActionEvent evt) {
		msgArea.append("");
		try {
			ResultSet rs = qa.jobInfo(getJobInfoBox.getSelectedItem().toString());
			
			while(rs.next()) {
				String title = rs.getString("title");
				String desc = rs.getString("description");
				msgArea.append("Title: " + title + "\nDescription: " + desc + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void getKsInfoButActionPerformed(ActionEvent evt) {
		msgArea.append("");
		try {
			ResultSet rs = qa.ksInfo(getKsInfoBox.getSelectedItem().toString());
			
			while(rs.next()) {
				String title = rs.getString("title");
				String desc = rs.getString("description");
				String lvl = rs.getString("lvl");
				msgArea.append("Title: " + title + "\nDescription: " + desc + "\nLevel: " + lvl + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
}
