package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.sql.*;
import dbaccess.*;
import java.util.*;
import javax.swing.JComboBox;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class contains the project app, which helps
* companies create new projects, remove old projects
* after completion, and allows companies to estimate
* project costs and training required based on their
* current employees pay and the length of the project.
*/

@SuppressWarnings("serial")
public class Project extends javax.swing.JFrame {
	private QueryAnswerer qa;

	private String compID;
	private JButton addProjectBut;
	private JTextField addProjectTitleField;
	private JComboBox<String> addProjectDirectorBox;
	private JTextField addProjectBudgetField;
	private JTextField addProjectStartDateField;
	private JTextField addProjectEndDateField;
	private JButton removeProjBut;
	private JComboBox<String> removeProjField;
	private JButton addJobCodesToProjectBut;
	private JComboBox<String> addJobCodeProjectNameBox;
	private JComboBox<String> addJobCodeBox;
	private JButton estimateCostBut;
	private JComboBox<String> estimateCostBox;
	private JButton skillsRequiredBut;
	private JComboBox<String> skillsRequiredBox;
	
	private JTextArea msgArea;
	private JScrollPane sp;
	
	public Project(String compID, QueryAnswerer qa) {
		super("Project");
		this.qa = qa;
		this.compID = compID;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				addProjectBut = new JButton();
				getContentPane().add(addProjectBut);
				addProjectBut.setText("Add Project");
				addProjectBut.setBounds(14, 14, 185, 28);
				addProjectBut.setEnabled(true);
				addProjectBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addProjectButActionPerformed(evt);
					}
				});
			}
			{
				addProjectTitleField = new JTextField("Title");
				getContentPane().add(addProjectTitleField);
				addProjectTitleField.setBounds(14, 40, 185, 28);
				addProjectTitleField.setEnabled(true);
			}
			{
				ArrayList<String> personList = new ArrayList<String>();
				try {
					ResultSet rs = qa.peopleFromCompany(this.compID);
					
					while(rs.next()) {
						personList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				addProjectDirectorBox = new JComboBox<String>();
				getContentPane().add(addProjectDirectorBox);
				addProjectDirectorBox.setBounds(14, 65, 185, 28);
				addProjectDirectorBox.setEnabled(true);
				addProjectDirectorBox.addItem("Select Director");
				String[] listOfPeople = personList.toArray(new String[personList.size()]);
				for (int i = 0; i < listOfPeople.length; i++) {
					addProjectDirectorBox.addItem(listOfPeople[i]);
				}
			}
			{
				addProjectBudgetField = new JTextField("Budget Code (5 Characters)");
				getContentPane().add(addProjectBudgetField);
				addProjectBudgetField.setBounds(14, 90, 185, 28);
				addProjectBudgetField.setEnabled(true);
			}
			{
				addProjectStartDateField = new JTextField("Start Date (MM-DD-YYYY)");
				getContentPane().add(addProjectStartDateField);
				addProjectStartDateField.setBounds(14, 115, 185, 28);
				addProjectStartDateField.setEnabled(true);
			}
			{
				addProjectEndDateField = new JTextField("End Date (MM-DD-YYYY)");
				getContentPane().add(addProjectEndDateField);
				addProjectEndDateField.setBounds(14, 140, 185, 28);
				addProjectEndDateField.setEnabled(true);
			}
			
			{
				removeProjBut = new JButton();
				getContentPane().add(removeProjBut);
				removeProjBut.setText("Remove Project");
				removeProjBut.setBounds(215, 40, 175, 28);
				removeProjBut.setEnabled(true);
				removeProjBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						removeProjButActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> projList = new ArrayList<String>();
				try {
					ResultSet rs = qa.titleFromProject(this.compID);
					
					while(rs.next()) {
						projList.add(rs.getString("title"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				removeProjField = new JComboBox<String>(projList.toArray(new String[projList.size()]));
				getContentPane().add(removeProjField);
				removeProjField.setBounds(215, 14, 175, 28);
				removeProjField.setEnabled(true);
			}
			
			{
				addJobCodesToProjectBut = new JButton();
				getContentPane().add(addJobCodesToProjectBut);
				addJobCodesToProjectBut.setText("Add Employee to Project");
				addJobCodesToProjectBut.setBounds(14, 265, 185, 28);
				addJobCodesToProjectBut.setEnabled(true);
				addJobCodesToProjectBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addJobCodesToProjectActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> projList = new ArrayList<String>();
				try {
					ResultSet rs = qa.titleFromProject(this.compID);
					
					while(rs.next()) {
						projList.add(rs.getString("title"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				addJobCodeProjectNameBox = new JComboBox<String>(projList.toArray(new String[projList.size()]));
				getContentPane().add(addJobCodeProjectNameBox);
				addJobCodeProjectNameBox.setBounds(14, 215, 175, 28);
				addJobCodeProjectNameBox.setEnabled(true);
				addJobCodeProjectNameBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addNamesToJobCodeBoxActionPerformed(evt);
					}
				});
			}
			{
				String proj_id = "";
				ResultSet rs = qa.projIdFromTitle(addJobCodeProjectNameBox.getSelectedItem().toString());
				try {
					while(rs.next()) {
						proj_id = rs.getString("proj_id");
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n");
				}
				ArrayList<String> projList = new ArrayList<String>();
				try {
					rs = qa.nameFromWorks(this.compID, proj_id);
					
					while(rs.next()) {
						projList.add(rs.getString("name"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				String[] listOfProj = projList.toArray(new String[projList.size()]);
				addJobCodeBox = new JComboBox<String>(listOfProj);
				getContentPane().add(addJobCodeBox);
				addJobCodeBox.setBounds(14, 240, 175, 28);
				addJobCodeBox.setEnabled(true);
			}
			
			{
				estimateCostBut = new JButton();
				getContentPane().add(estimateCostBut);
				estimateCostBut.setText("Estimate Project Cost");
				estimateCostBut.setBounds(14, 340, 185, 28);
				estimateCostBut.setEnabled(true);
				estimateCostBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						estimateCostActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> projList = new ArrayList<String>();
				try {
					ResultSet rs = qa.titleFromProject(this.compID);
					
					while(rs.next()) {
						projList.add(rs.getString("title"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				estimateCostBox = new JComboBox<String>(projList.toArray(new String[projList.size()]));
				getContentPane().add(estimateCostBox);
				estimateCostBox.setBounds(14, 315, 175, 28);
				estimateCostBox.setEnabled(true);
			}
			
			{
				skillsRequiredBut = new JButton();
				getContentPane().add(skillsRequiredBut);
				skillsRequiredBut.setText("Show Required Training");
				skillsRequiredBut.setBounds(14, 415, 185, 28);
				skillsRequiredBut.setEnabled(true);
				skillsRequiredBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						skillsRequiredActionPerformed(evt);
					}
				});
			}
			{
				ArrayList<String> projList = new ArrayList<String>();
				try {
					ResultSet rs = qa.titleFromProject(this.compID);
					
					while(rs.next()) {
						projList.add(rs.getString("title"));
					}
					rs.close();
				}
				catch (Exception e) {
					msgArea.append(e.getMessage() + "\n\n");
				}
				skillsRequiredBox = new JComboBox<String>(projList.toArray(new String[projList.size()]));
				getContentPane().add(skillsRequiredBox);
				skillsRequiredBox.setBounds(14, 390, 175, 28);
				skillsRequiredBox.setEnabled(true);
			}
			
			{
				msgArea = new JTextArea();
				getContentPane().add(msgArea);
				msgArea.setText("");
				msgArea.setEditable(true);
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
	
	
	private void addProjectButActionPerformed(ActionEvent evt) {
		if (!(addProjectTitleField.getText().matches("[A-Za-z0-9 ]{1,20}"))) {
			msgArea.append("Too many characters in Title field\n");
			msgArea.append("Project Not Added\n\n");
			return;
		}
		if (!(addProjectBudgetField.getText().matches("[A-Za-z0-9]{1,5}"))) {
			msgArea.append("Too many or invalid characters in Budget field\n");
			msgArea.append("Project Not Added\n\n");
			return;
		}
		if (!(addProjectStartDateField.getText().matches("[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}-[0-9]{4}"))) {
			msgArea.append("Too many or invalid characters in Start Date field\n");
			msgArea.append("Project Not Added\n\n");
			return;
		}
		if (!(addProjectEndDateField.getText().matches("[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}-[0-9]{4}"))) {
			msgArea.append("Too many or invalid characters in End Date field\n");
			msgArea.append("Project Not Added\n\n");
			return;
		}
		
		String projectTitle = addProjectTitleField.getText();
		String directorName = addProjectDirectorBox.getSelectedItem().toString();
		String directorID = "";
		Random randomInt = new Random();
		String newProjID = ((Integer)randomInt.nextInt(99999)).toString();
		String budget = addProjectBudgetField.getText();
		String startDate = addProjectStartDateField.getText(); 
		String endDate = addProjectEndDateField.getText();
		String job_code = "";
		try {
			ResultSet rs = qa.peridFromName(directorName);
			
			while(rs.next()) {
				directorID = rs.getString("per_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		try {
			ResultSet rs = qa.jobFromWorks(directorID, this.compID);
			
			while(rs.next()) {
				job_code = rs.getString("job_code");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			qa.newProject(newProjID, projectTitle, directorID, budget, startDate, endDate, this.compID, job_code);
			msgArea.append("Project Successfully Added!\n\n");
			removeProjField.addItem(projectTitle);
			addJobCodeBox.removeItem(directorName);
			addJobCodeProjectNameBox.addItem(projectTitle);
			estimateCostBox.addItem(projectTitle);
			skillsRequiredBox.addItem(projectTitle);
			}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void removeProjButActionPerformed(ActionEvent evt) {
		String title = removeProjField.getSelectedItem().toString();
		String proj_id = "";
		try {
			ResultSet rs = qa.projIdFromTitle(title);
			
			while(rs.next()) {
				proj_id = rs.getString("proj_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			ResultSet rs = qa.nameFromJobProject(proj_id);
			
			while(rs.next()) {
				addJobCodeBox.addItem(rs.getString("name"));
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			qa.removeProj(proj_id);
			msgArea.append("Project Successfully Removed!\n\n");
			removeProjField.removeItem(title);
			addJobCodeProjectNameBox.removeItem(title);
			estimateCostBox.removeItem(title);
			skillsRequiredBox.removeItem(title);
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void addJobCodesToProjectActionPerformed(ActionEvent evt) {
		String person_name = addJobCodeBox.getSelectedItem().toString();
		String proj_name = addJobCodeProjectNameBox.getSelectedItem().toString();
		String job_code = "";
		String proj_id = "";
		try {
			ResultSet rs = qa.jobFromWorksPerson(person_name);
			
			while(rs.next()) {
				job_code = rs.getString("job_code");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			ResultSet rs = qa.projIdFromTitle(proj_name);
			
			while(rs.next()) {
				proj_id = rs.getString("proj_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			qa.addToProj(job_code, proj_id);
			addJobCodeBox.removeItem(person_name);
			msgArea.append("Person Successfully Added!\n");
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n");
	}
	
	private void estimateCostActionPerformed(ActionEvent evt) {
		String proj_name = estimateCostBox.getSelectedItem().toString();
		String proj_id = "";
		int numberOfProjectDays = 0;
		Double salarySum = 0.0;
		try {
			ResultSet rs = qa.estimateCostID(proj_name);
			
			while(rs.next()) {
				proj_id = rs.getString("proj_id");
				numberOfProjectDays = rs.getInt("numberOfDays");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			msgArea.append("The estimated project cost is $");
			ResultSet rs = qa.estimateCost(proj_id);
			
			while(rs.next()) {
				salarySum = rs.getDouble("proj_sum");
			}
			Double sumCost = (Double)(salarySum/numberOfProjectDays);
			int estimatedCost = (int)(Math.round(sumCost));
			msgArea.append(Integer.toString(estimatedCost) + "\n");
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void skillsRequiredActionPerformed(ActionEvent evt) {
		String proj_name = estimateCostBox.getSelectedItem().toString();
		String proj_id = "";
		try {
			ResultSet rs = qa.projIdFromTitle(proj_name);
			
			while(rs.next()) {
				proj_id = rs.getString("proj_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		
		try {
			msgArea.append("The skills required are: \n");
			ResultSet rs = qa.skillsNeeded(proj_id);
			
			while(rs.next()) {
				msgArea.append(rs.getString("skillsNeeded"));
				msgArea.append("\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() +"\n\n");
		}
		try {
			msgArea.append("Which can be taught by the following courses: \n");
			ResultSet rs = qa.skillsRequired(proj_id);
			
			while(rs.next()) {
				msgArea.append(rs.getString("title"));
				msgArea.append("\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		msgArea.append("\n\n");
	}
	
	private void addNamesToJobCodeBoxActionPerformed(ActionEvent evt) {
		String proj_id = "";
		ResultSet rs = qa.projIdFromTitle(addJobCodeProjectNameBox.getSelectedItem().toString());
		try {
			while(rs.next()) {
				proj_id = rs.getString("proj_id");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n");
		}
		ArrayList<String> projList = new ArrayList<String>();
		try {
			rs = qa.nameFromWorks(this.compID, proj_id);
			
			while(rs.next()) {
				projList.add(rs.getString("name"));
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.append(e.getMessage() + "\n\n");
		}
		String[] listOfProj = projList.toArray(new String[projList.size()]);
		addJobCodeBox.removeAllItems();
		for (int i = 0; i < listOfProj.length; i++) {
			addJobCodeBox.addItem(listOfProj[i]);
		}
	}
}
