package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import dbaccess.*;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class contains the 25 queries upon which information is retrieved,
* added, deleted, and updated. Each query has its own button and fields
* for user input if needed.
*/

@SuppressWarnings("serial")
public class Queries extends javax.swing.JFrame {
	private TableInfo ti;
	private QueryAnswerer qa;

	private JButton query1But;
	private JTextField query1Field;
	private JButton query2But;
	private JTextField query2Field;
	private JButton query3But;
	private JTextField query3Field;
	private JButton query4But;
	private JTextField query4Field;
	private JButton query5But;
	private JTextField query5Field;
	private JButton query6But;
	private JTextField query6Field;
	private JButton query7But;
	private JTextField query7Field;
	private JButton query8But;
	private JTextField query8Field;
	private JButton query9But;
	private JTextField query9Field;
	private JTextField query9Field1;
	private JButton query10But;
	private JTextField query10Field;
	private JButton query11But;
	private JTextField query11Field;
	private JTextField query11Field1;
	private JButton query12But;
	private JTextField query12Field;
	private JTextField query12Field1;
	private JButton query13But;
	private JTextField query13Field;
	private JButton query14But;
	private JTextField query14Field;
	private JTextField query14Field1;
	private JButton query15But;
	private JTextField query15Field;
	private JTextField query15Field1;
	private JButton query16But;
	private JTextField query16Field;
	private JButton query17But;
	private JTextField query17Field;
	private JButton query18But;
	private JTextField query18Field;
	private JButton query19But;
	private JTextField query19Field;
	private JButton query20But;
	private JTextField query20Field;
	private JButton query21But;
	private JTextField query21Field;
	private JButton query22But;
	private JTextField query22Field;
	private JTextField query22Field1;
	private JButton query23But;
	private JTextField query23Field;
	private JButton query24But;
	private JButton query25But;
	private SimpleDateFormat sdf;
	
	private JTextArea msgArea;
	private JScrollPane sp;
	
	public Queries(TableInfo ti, QueryAnswerer qa) {
		super("Queries");
		this.ti = ti;
		this.qa = qa;
		initGUI();
		sdf = new SimpleDateFormat("MM-dd-yyyy");
	}
	
	private void initGUI() {
		try {
			{
				query1But = new JButton();
				getContentPane().add(query1But);
				query1But.setText("Query 1");
				query1But.setBounds(14, 14, 175, 28);
				query1But.setEnabled(true);
				query1But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query1ActionPerformed(evt);
					}
				});
			}
			{
				query1Field = new JTextField("Company ID");
				getContentPane().add(query1Field);
				query1Field.setBounds(14, 45, 175, 28);
			}
			
			{
				query2But = new JButton();
				getContentPane().add(query2But);
				query2But.setText("Query 2");
				query2But.setBounds(14, 90, 175, 28);
				query2But.setEnabled(true);
				query2But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query2ActionPerformed(evt);
					}
				});
			}
			{
				query2Field = new JTextField("Company ID");
				getContentPane().add(query2Field);
				query2Field.setBounds(14, 121, 175, 28);
			}
			
			{
				query3But = new JButton();
				getContentPane().add(query3But);
				query3But.setText("Query 3");
				query3But.setBounds(14, 166, 175, 28);
				query3But.setEnabled(true);
				query3But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query3ActionPerformed(evt);
					}
				});
			}
			{
				query3Field = new JTextField("Company ID");
				getContentPane().add(query3Field);
				query3Field.setBounds(14, 197, 175, 28);
			}
			
			{
				query4But = new JButton();
				getContentPane().add(query4But);
				query4But.setText("Query 4");
				query4But.setBounds(14, 242, 175, 28);
				query4But.setEnabled(true);
				query4But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query4ActionPerformed(evt);
					}
				});
			}
			{
				query4Field = new JTextField("Person Name");
				getContentPane().add(query4Field);
				query4Field.setBounds(14, 273, 175, 28);
			}
			
			{
				query5But = new JButton();
				getContentPane().add(query5But);
				query5But.setText("Query 5");
				query5But.setBounds(14, 318, 175, 28);
				query5But.setEnabled(true);
				query5But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query5ActionPerformed(evt);
					}
				});
			}
			{
				query5Field = new JTextField("Project Name");
				getContentPane().add(query5Field);
				query5Field.setBounds(14, 349, 175, 28);
			}
			
			{
				query6But = new JButton();
				getContentPane().add(query6But);
				query6But.setText("Query 6");
				query6But.setBounds(14, 394, 175, 28);
				query6But.setEnabled(true);
				query6But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query6ActionPerformed(evt);
					}
				});
			}
			{
				query6Field = new JTextField("Person Name");
				getContentPane().add(query6Field);
				query6Field.setBounds(14, 425, 175, 28);
			}
			
			{
				query7But = new JButton();
				getContentPane().add(query7But);
				query7But.setText("Query 7");
				query7But.setBounds(14, 470, 175, 28);
				query7But.setEnabled(true);
				query7But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query7ActionPerformed(evt);
					}
				});
			}
			{
				query7Field = new JTextField("Person Name");
				getContentPane().add(query7Field);
				query7Field.setBounds(14, 501, 175, 28);
			}
			
			{
				query8But = new JButton();
				getContentPane().add(query8But);
				query8But.setText("Query 8");
				query8But.setBounds(14, 546, 175, 28);
				query8But.setEnabled(true);
				query8But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query8ActionPerformed(evt);
					}
				});
			}
			{
				query8Field = new JTextField("POS Code");
				getContentPane().add(query8Field);
				query8Field.setBounds(14, 577, 175, 28);
			}
			
			{
				query9But = new JButton();
				getContentPane().add(query9But);
				query9But.setText("Query 9");
				query9But.setBounds(14, 622, 175, 28);
				query9But.setEnabled(true);
				query9But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query9ActionPerformed(evt);
					}
				});
			}
			{
				query9Field = new JTextField("POS Code");
				getContentPane().add(query9Field);
				query9Field.setBounds(14, 653, 175, 28);
			}
			{
				query9Field1 = new JTextField("Person Name");
				getContentPane().add(query9Field1);
				query9Field1.setBounds(14, 679, 175, 28);
			}
			
			{
				query10But = new JButton();
				getContentPane().add(query10But);
				query10But.setText("Query 10");
				query10But.setBounds(217, 14, 175, 28);
				query10But.setEnabled(true);
				query10But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query10ActionPerformed(evt);
					}
				});
			}
			{
				query10Field = new JTextField("POS Code");
				getContentPane().add(query10Field);
				query10Field.setBounds(217, 45, 175, 28);
			}
			
			{
				query11But = new JButton();
				getContentPane().add(query11But);
				query11But.setText("Query 11");
				query11But.setBounds(217, 90, 175, 28);
				query11But.setEnabled(true);
				query11But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query11ActionPerformed(evt);
					}
				});
			}
			{
				query11Field = new JTextField("POS Code");
				getContentPane().add(query11Field);
				query11Field.setBounds(217, 121, 175, 28);
			}
			{
				query11Field1 = new JTextField("Person Name");
				getContentPane().add(query11Field1);
				query11Field1.setBounds(217, 147, 175, 28);
			}
			
			{
				query12But = new JButton();
				getContentPane().add(query12But);
				query12But.setText("Query 12");
				query12But.setBounds(217, 192, 175, 28);
				query12But.setEnabled(true);
				query12But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query12ActionPerformed(evt);
					}
				});
			}
			{
				query12Field = new JTextField("POS Code");
				getContentPane().add(query12Field);
				query12Field.setBounds(217, 223, 175, 28);
			}
			{
				query12Field1 = new JTextField("Person Name");
				getContentPane().add(query12Field1);
				query12Field1.setBounds(217, 249, 175, 28);
			}
			
			{
				query13But = new JButton();
				getContentPane().add(query13But);
				query13But.setText("Query 13");
				query13But.setBounds(217, 294, 175, 28);
				query13But.setEnabled(true);
				query13But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query13ActionPerformed(evt);
					}
				});
			}
			{
				query13Field = new JTextField("POS Code");
				getContentPane().add(query13Field);
				query13Field.setBounds(217, 325, 175, 28);
			}
			
			{
				query14But = new JButton();
				getContentPane().add(query14But);
				query14But.setText("Query 14");
				query14But.setBounds(217, 370, 175, 28);
				query14But.setEnabled(true);
				query14But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query14ActionPerformed(evt);
					}
				});
			}
			{
				query14Field = new JTextField("POS Code");
				getContentPane().add(query14Field);
				query14Field.setBounds(217, 401, 175, 28);
			}
			{
				query14Field1 = new JTextField("Person Name");
				getContentPane().add(query14Field1);
				query14Field1.setBounds(217, 427, 175, 28);
			}
			
			{
				query15But = new JButton();
				getContentPane().add(query15But);
				query15But.setText("Query 15");
				query15But.setBounds(217, 472, 175, 28);
				query15But.setEnabled(true);
				query15But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query15ActionPerformed(evt);
					}
				});
			}
			{
				query15Field = new JTextField("POS Code");
				getContentPane().add(query15Field);
				query15Field.setBounds(217, 503, 175, 28);
			}
			{
				query15Field1 = new JTextField("Person Name");
				getContentPane().add(query15Field1);
				query15Field1.setBounds(217, 529, 175, 28);
			}
			
			
			{
				query16But = new JButton();
				getContentPane().add(query16But);
				query16But.setText("Query 16");
				query16But.setBounds(217, 574, 175, 28);
				query16But.setEnabled(true);
				query16But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query16ActionPerformed(evt);
					}
				});
			}
			{
				query16Field = new JTextField("Person Name");
				getContentPane().add(query16Field);
				query16Field.setBounds(217, 605, 175, 28);
			}
			{
				query17But = new JButton();
				getContentPane().add(query17But);
				query17But.setText("Query 17");
				query17But.setBounds(217, 676, 175, 28);
				query17But.setEnabled(true);
				query17But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query17ActionPerformed(evt);
					}
				});
			}
			{
				query17Field = new JTextField("Person Name");
				getContentPane().add(query17Field);
				query17Field.setBounds(217, 708, 175, 28);
			}
			
			{
				query18But = new JButton();
				getContentPane().add(query18But);
				query18But.setText("Query 18");
				query18But.setBounds(420, 14, 175, 28);
				query18But.setEnabled(true);
				query18But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query18ActionPerformed(evt);
					}
				});
			}
			{
				query18Field = new JTextField("POS Code");
				getContentPane().add(query18Field);
				query18Field.setBounds(420, 45, 175, 28);
			}
			
			{
				query19But = new JButton();
				getContentPane().add(query19But);
				query19But.setText("Query 19");
				query19But.setBounds(420, 90, 175, 28);
				query19But.setEnabled(true);
				query19But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query19ActionPerformed(evt);
					}
				});
			}
			{
				query19Field = new JTextField("POS Code");
				getContentPane().add(query19Field);
				query19Field.setBounds(420, 121, 175, 28);
			}
			
			{
				query20But = new JButton();
				getContentPane().add(query20But);
				query20But.setText("Query 20");
				query20But.setBounds(420, 166, 175, 28);
				query20But.setEnabled(true);
				query20But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query20ActionPerformed(evt);
					}
				});
			}
			{
				query20Field = new JTextField("POS Code");
				getContentPane().add(query20Field);
				query20Field.setBounds(420, 197, 175, 28);
			}
			
			{
				query21But = new JButton();
				getContentPane().add(query21But);
				query21But.setText("Query 21");
				query21But.setBounds(420, 242, 175, 28);
				query21But.setEnabled(true);
				query21But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query21ActionPerformed(evt);
					}
				});
			}
			{
				query21Field = new JTextField("POS Code");
				getContentPane().add(query21Field);
				query21Field.setBounds(420, 273, 175, 28);
			}
			
			{
				query22But = new JButton();
				getContentPane().add(query22But);
				query22But.setText("Query 22");
				query22But.setBounds(420, 318, 175, 28);
				query22But.setEnabled(true);
				query22But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query22ActionPerformed(evt);
					}
				});
			}
			{
				query22Field = new JTextField("POS Code");
				getContentPane().add(query22Field);
				query22Field.setBounds(420, 349, 175, 28);
			}
			{
				query22Field1 = new JTextField("k");
				getContentPane().add(query22Field1);
				query22Field1.setBounds(590, 349, 65, 28);
			}
			
			{
				query23But = new JButton();
				getContentPane().add(query23But);
				query23But.setText("Query 23");
				query23But.setBounds(420, 394, 175, 28);
				query23But.setEnabled(true);
				query23But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query23ActionPerformed(evt);
					}
				});
			}
			{
				query23Field = new JTextField("POS Code");
				getContentPane().add(query23Field);
				query23Field.setBounds(420, 425, 175, 28);
			}
			
			{
				query24But = new JButton();
				getContentPane().add(query24But);
				query24But.setText("Query 24");
				query24But.setBounds(420, 470, 175, 28);
				query24But.setEnabled(true);
				query24But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query24ActionPerformed(evt);
					}
				});
			}
			
			{
				query25But = new JButton();
				getContentPane().add(query25But);
				query25But.setText("Query 25");
				query25But.setBounds(420, 515, 175, 28);
				query25But.setEnabled(true);
				query25But.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						query25ActionPerformed(evt);
					}
				});
			}
			
			{
				msgArea = new JTextArea();
				getContentPane().add(msgArea);
				msgArea.setText("Database Message\n");
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
	
	private void query1ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT name FROM person NATURAL JOIN works NATURAL JOIN job WHERE comp_id = '" + query1Field.getText() + "'";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				msgArea.append("Name: " + name +"\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query2ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT pay_rate, name FROM person NATURAL JOIN works NATURAL JOIN Job WHERE comp_id = '" + query2Field.getText() + "' ORDER BY pay_rate desc";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				Double payRate = rs.getDouble("pay_rate");
				msgArea.append("Name: " + name + " Pay Rate: " + payRate + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query3ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "WITH salary_sum AS (SELECT name, CASE  WHEN pay_type = 'W' THEN SUM(pay_rate * 1920) WHEN pay_type = 'S' THEN SUM(pay_rate) END AS sum_salary FROM job NATURAL JOIN company WHERE comp_id = '" + query3Field.getText() + "' GROUP BY name, pay_type) SELECT name, SUM(sum_salary) FROM salary_sum GROUP BY name";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				Double payRate = rs.getDouble("SUM(sum_salary)");
				msgArea.append("Name: " + name + " Salary Sum: " + payRate + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query4ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT job_code FROM works NATURAL JOIN person WHERE name = '" + query4Field.getText() + "'";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String jobCode = rs.getString("job_code");
				msgArea.append("Job Code: " + jobCode + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query5ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT name FROM person NATURAL JOIN works NATURAL JOIN project NATURAL JOIN job_project WHERE title = '" + query5Field.getText() + "'";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				msgArea.append("Name: " + name + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query6ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT ks_code, title, description, lvl FROM person NATURAL JOIN knowledge_skill NATURAL JOIN person_skill WHERE name = '" + query6Field.getText() + "' ORDER BY lvl";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
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
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query7ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT ks_code FROM Requires WHERE pos_code = (SELECT pos_code FROM job NATURAL JOIN job_profile NATURAL JOIN works NATURAL JOIN person WHERE name = '" + query7Field.getText() + "') MINUS SELECT ks_code FROM person NATURAL JOIN person_skill NATURAL JOIN works WHERE name = '" + query7Field.getText() + "'";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				msgArea.append("KS Code: " + ks_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query8ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT ks_code, title, description, lvl FROM Requires NATURAL JOIN Knowledge_skill WHERE pos_code = '" + query8Field.getText() + "' ORDER BY lvl";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
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
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query9ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT ks_code FROM requires WHERE pos_code = '" + query9Field.getText() + "' MINUS SELECT ks_code FROM person_skill NATURAL JOIN person WHERE name = '" + query9Field1.getText() + "'";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				msgArea.append("KS Code: " + ks_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query10ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT c_code, title FROM Course c WHERE NOT EXISTS((SELECT ks_code FROM Requires WHERE pos_code = '" + query10Field.getText() + "') MINUS (SELECT ks_code FROM course_set c2 WHERE c2.c_code = c.c_code))";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String c_code = rs.getString("c_code");
				String title = rs.getString("title");
				msgArea.append("Course Code: " + c_code + "  Title: " + title + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query11ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			String sql = "SELECT c_code, title FROM Course c WHERE EXISTS ((SELECT ks_code FROM Requires WHERE pos_code = '" + query11Field.getText() + "') MINUS (select ks_code from person_skill NATURAL JOIN person where name = '" + query11Field1.getText() + "')) AND NOT EXISTS(((SELECT ks_code FROM Requires WHERE pos_code = '" + query11Field.getText() + "') MINUS (select ks_code from person_skill NATURAL JOIN person where name = '" + query11Field1.getText() + "')) MINUS (SELECT ks_code FROM course_set c2 WHERE c2.c_code = c.c_code))";
			ResultSet rs = this.ti.runSQLQuery(sql);
			
			while(rs.next()) {
				String c_code = rs.getString("c_code");
				String title = rs.getString("title");
				msgArea.append("Course Code: " + c_code + "  Title: " + title + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query12ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		
		try {
			String s1 = query12Field.getText();
			String s2 = query12Field1.getText();
			ResultSet rs = qa.query12Answerer(s1, s2);
			
			while(rs.next()) {
				String c_code = rs.getString("c_code");
				String title = rs.getString("title");
				String sec_number = rs.getString("sec_number");
				Date complete_date = rs.getDate("complete_date");
				msgArea.append("Course Code: " + c_code + "  Title: " + title + "\n");
				msgArea.append("Section Number: " + sec_number + "  Complete Date: " + sdf.format(complete_date) + "\n\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query13ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query13Answerer(query13Field.getText());
			
			while(rs.next()) {
				String c_code1 = rs.getString("c_code1");
				String c_code2 = rs.getString("c_code2");
				String c_code3 = rs.getString("c_code3");
				msgArea.append("Course Set:\n");
				msgArea.append("Course Code 1: " + c_code1 + "\n");
				msgArea.append("Course Code 2: " + c_code2 + "\n");
				if (c_code3 == null)
					msgArea.append("Course Code 3: N/A \n\n");
				else
					msgArea.append("Course Code 3: " + c_code3 + "\n\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query14ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query14Answerer(query14Field.getText(), query14Field1.getText());
			
			while(rs.next()) {
				String c_code1 = rs.getString("c_code1");
				String c_code2 = rs.getString("c_code2");
				String c_code3 = rs.getString("c_code3");
				msgArea.append("Course Code 1: " + c_code1 + "\n");
				msgArea.append("Course Code 2: " + c_code2 + "\n");
				if (c_code3 == null) {
					msgArea.append("Course Code 3: N/A \n\n");
				}
				else {
					msgArea.append("Course Code 3: " + c_code3 + "\n\n");
				}
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query15ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query15Answerer(query15Field.getText(), query15Field1.getText());
			
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
	
	private void query16ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query16Answerer(query16Field.getText());
			
			while(rs.next()) {
				String pos_code = rs.getString("pos_code");
				msgArea.append("POS Code: " + pos_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query17ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query17Answerer(query17Field.getText());
			
			while(rs.next()) {
				String pos_code = rs.getString("pos_code");
				int max_pay = rs.getInt("hpay");
				msgArea.append("POS Code: " + pos_code + "  Pay: " + max_pay + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query18ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query18Answerer(query18Field.getText());
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				msgArea.append("Name: " + name + "  Email: " + email + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query19ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query19Answerer(query19Field.getText());
			
			while(rs.next()) {
				String name = rs.getString("name");
				msgArea.append("Name: " + name + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query20ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query20Answerer(query20Field.getText());
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				int personccnt = rs.getInt("personccnt");
				msgArea.append("KS Code: " + ks_code + "  Count: " + personccnt + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query21ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query21Answerer(query21Field.getText());
			
			while(rs.next()) {
				String name = rs.getString("name");
				String cnt = rs.getString("leastNumber");
				msgArea.append("Name: " + name + "  Missing Skill Count: " + cnt + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query22ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query22Answerer(query22Field.getText(), query22Field1.getText());
			
			while(rs.next()) {
				String name = rs.getString("name");
				int skillCount = rs.getInt("leastNumber");
				msgArea.append("Name: " + name + "  Missing Skill Count: " + skillCount + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query23ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query23Answerer(query23Field.getText());
			
			while(rs.next()) {
				String ks_code = rs.getString("ks_code");
				String person_count = rs.getString("personCount");
				msgArea.append("KS Code: " + ks_code + "  Number of People Missing Skill: " + person_count + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query24ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query24Answerer();
			
			while(rs.next()) {
				String pos_code = rs.getString("pos_code");
				msgArea.append("POS Code: " + pos_code + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
	
	private void query25ActionPerformed(ActionEvent evt) {
		msgArea.setText("");
		try {
			ResultSet rs = qa.query25Answerer();
			
			while(rs.next()) {
				String c_code = rs.getString("c_code");
				String title = rs.getString("title");
				msgArea.append("Course Code: " + c_code + ", Title: " + title + "\n");
			}
			rs.close();
		}
		catch (Exception e) {
			msgArea.setText(e.getMessage());
		}
	}
}
