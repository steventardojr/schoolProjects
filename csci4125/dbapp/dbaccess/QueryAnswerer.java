package dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class QueryAnswerer {

	private Connection conn;
	final String host = "localhost"; 
	final String port = "1521";
	final String sID = "nbdb";
	private ResultSet rs;

	public QueryAnswerer(	String host, 
						String port, 
						String sID, 
						String username, 
						String passwd) throws SQLException { 
		conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
	}

	public QueryAnswerer(String username, String passwd) throws SQLException { 
		this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
 
	}

	public QueryAnswerer(Connection conn) throws SQLException { 
		this.conn = conn; 
	}
	
	public ResultSet query7Answerer(String s1) {
		String pstate = "SELECT ks_code FROM Requires WHERE pos_code = "
												+ "(SELECT pos_code FROM job NATURAL JOIN job_profile NATURAL JOIN works NATURAL JOIN person "
												+ "WHERE name = ?) MINUS SELECT ks_code FROM person NATURAL JOIN person_skill NATURAL JOIN works "
												+ "WHERE name = ?";
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query9Answerer(String s1, String s2) {
		String pstate = "SELECT ks_code FROM requires WHERE pos_code = ? "
										+ "MINUS SELECT ks_code FROM person_skill NATURAL JOIN person WHERE name = ?";
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query12Answerer(String s1, String s2) {
		String pstate = "WITH coursesNeeded AS (SELECT c_code, title FROM Course c "
											+ "WHERE EXISTS ((SELECT ks_code FROM Requires WHERE pos_code = ?) "
											+ "MINUS (select ks_code from person_skill NATURAL JOIN person where name = ?)) "
									+ "AND NOT EXISTS (((SELECT ks_code FROM Requires WHERE pos_code = ?) "
											+ "MINUS (select ks_code from person_skill NATURAL JOIN person where name = ?)) "
									+ "MINUS (SELECT ks_code FROM course_set c2 WHERE c2.c_code = c.c_code))) "
									+ "SELECT c_code, title, sec_number, complete_date from coursesNeeded natural join section "
											+ "WHERE complete_date = (SELECT MIN(complete_date) from section)";
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.setString(3,s1);
			pstatement.setString(4,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}

	public ResultSet query13Answerer(String s1) {
		String pstate = "WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code " 
											+ "FROM CourseSet CSet JOIN Course_set CS ON CSet.c_code1=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code2=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code3=CS.c_code), " 
										+ "Cover_CSet(csetID, setSize) AS ( SELECT csetID, setSize FROM CourseSet CSet " 
											+ "WHERE NOT EXISTS ( SELECT ks_code FROM Requires WHERE pos_code = ? MINUS " 
											+ "SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID)) " 
										+ "SELECT c_code1, c_code2, c_code3 FROM Cover_CSet NATURAL JOIN CourseSet " 
											+ "WHERE setSize = (SELECT MIN(setSize) FROM Cover_CSet)";
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query14Answerer(String s1, String s2) {
		String pstate = "WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code " 
											+ "FROM CourseSet CSet JOIN Course_set CS ON CSet.c_code1=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code2=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code3=CS.c_code), " 
										+ "Cover_CSet(csetID, setSize) AS ( SELECT csetID, setSize FROM CourseSet CSet " 
											+ "WHERE EXISTS ((SELECT ks_code FROM Requires WHERE pos_code = ?) " 
											+ "MINUS (select ks_code from person_skill where per_id = ?)) AND NOT EXISTS " 
											+ "(((SELECT ks_code FROM Requires WHERE pos_code = ?) " 
											+ "MINUS (select ks_code from person_skill where per_id = ?)) " 
											+ "MINUS ( SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID))) " 
										+ "SELECT csetID, c_code1, c_code2, c_code3 FROM Cover_CSet NATURAL JOIN CourseSet WHERE setSize = (SELECT MIN(setSize) FROM Cover_CSet)";
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.setString(3,s1);
			pstatement.setString(4,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query15Answerer(String s1, String s2) {
		String pstate = "WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code " 
											+ "FROM CourseSet CSet JOIN Course_set CS ON CSet.c_code1=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code2=CS.c_code UNION " 
											+ "SELECT csetID, ks_code FROM CourseSet CSet JOIN Course_Set CS ON CSet.c_code3=CS.c_code), " 
										+ "Cover_CSet(csetID, setSize) AS ( SELECT csetID, setSize FROM CourseSet CSet " 
											+ "WHERE EXISTS ((SELECT ks_code FROM Requires WHERE pos_code = ?) MINUS " 
											+ "(select ks_code from person_skill NATURAL JOIN person where name = ?)) AND NOT EXISTS " 
											+ "(((SELECT ks_code FROM Requires WHERE pos_code = ?) MINUS " 
											+ "(select ks_code from person_skill NATURAL JOIN person where name = ?)) MINUS " 
											+ "( SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID))), " 
										+ "CourseSets AS (SELECT csetID, c_code1, c_code2, c_code3 FROM Cover_CSet NATURAL JOIN CourseSet " 
											+ "WHERE setSize = (SELECT MIN(setSize) FROM Cover_CSet)), " 
										+ "CoursePrice (c_code, c_price) AS (SELECT c_code, MIN(price) AS c_price " 
											+ "FROM Course NATURAL JOIN Section GROUP BY c_code), " 
										+ "SumOfCSet AS (SELECT csetID, c_code1, c_code2, c_code3, " 
											+ "((SELECT c_price FROM CoursePrice CP WHERE CP.c_code = CourseSets.c_code1) + " 
											+ "(SELECT c_price FROM CoursePrice CP WHERE CP.c_code = CourseSets.c_code2) + " 
											+ "NVL((SELECT c_price FROM CoursePrice CP WHERE CP.c_code = CourseSets.c_code3), 0)) as sumOfCourses " 
											+ "FROM CourseSets) SELECT c_code1, c_code2, c_code3, sumOfCourses From SumOfCset " 
											+ "WHERE sumOfCourses = (SELECT MIN(sumOfCourses) FROM SumOfCSet)";

		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.setString(3,s1);
			pstatement.setString(4,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query16Answerer(String s1) {
		String pstate = "Select distinct pos_code from job_profile P where not exists " 
											+ "((select ks_code from requires PS where PS.pos_code= P.pos_code) MINUS " 
											+ "(select ks_code from person_skill NATURAL JOIN person where name = ?))"; 
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query17Answerer(String s1) {
		String pstate = "WITH QP AS (SELECT distinct pos_code FROM job_profile P WHERE NOT EXISTS " 
											+ "((SELECT ks_code FROM requires WHERE pos_code = P.pos_code) MINUS " 
											+ "(SELECT ks_code FROM person_skill NATURAL JOIN person WHERE name = ?))), " 
										+ "pos_payrate AS ( SELECT pos_code, MAX(Pay_rate) AS hpay FROM QP NATURAL JOIN job GROUP BY pos_code) " 
										+ "SELECT pos_code, hpay FROM Pos_Payrate WHERE hpay = (SELECT MAX(hpay) FROM pos_payrate)"; 
		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query18Answerer(String s1) {
		String pstate = "WITH PersonRequiredSkillCnt(per_id, skillCnt) AS ( "
											+ "SELECT per_id, COUNT(ks_code) "
											+ "FROM person_skill NATURAL JOIN requires "
											+ "WHERE pos_code = ? "
											+ "GROUP BY per_id), "
										+ "requiredSkillCnt(cnt) AS ( "
											+ "SELECT COUNT(*) FROM requires "
											+ "WHERE pos_Code = ?) "
										+ "SELECT name, email "
											+ "FROM PersonRequiredSkillCnt NATURAL JOIN requiredSkillCnt NATURAL JOIN person "
											+ "WHERE skillCnt = cnt";

		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query19Answerer(String s1) {
		String pstate = "SELECT name FROM person NATURAL JOIN " 
											+ "(SELECT distinct per_id  FROM person rs1 WHERE 1  = " 
												+ "(SELECT COUNT(*)  FROM (SELECT ks_code FROM requires WHERE pos_code = ? MINUS " 
												+ "SELECT ks_code FROM person_skill rs2 WHERE rs2.per_id = rs1.per_id)))"; 


		
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query20Answerer(String s1) {
		String pstate = "WITH requiredSkill(ks_code) AS "
												+ "(SELECT ks_code FROM requires WHERE pos_code = ?), "
									+ "Missing1List(per_id) AS (SELECT per_id FROM "
												+ "(SELECT distinct per_id FROM person rs1 "
														+ "WHERE 1  = (SELECT COUNT(*) FROM "
																+ "(SELECT ks_code FROM requires "
																		+ "WHERE pos_code = ? "
																+ "MINUS SELECT ks_code FROM person_skill rs2 "
																+ "WHERE rs2.per_id = rs1.per_id)))), "
									+ "PersonMissingSkill(per_id, ks_code) AS "
											+ "(SELECT per_id, ks_code FROM missing1List MI, requiredSkill RS "
													+ "WHERE ks_code IN "
															+ "(SELECT ks_code FROM requiredSkill "
													+ "MINUS SELECT ks_code FROM person_skill PS "
															+ "WHERE PS.per_id = MI.per_id)) "
									+ "SELECT ks_code, COUNT(per_id) AS personCCnt "
											+ "FROM personmissingskill "
													+ "GROUP BY ks_code "
														+ "ORDER BY personCCnt asc";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query21Answerer(String s1) {
		String pstate = "WITH PersonRequiredSkillCnt(per_id, skillCnt) AS ("
											+ "SELECT per_id, COUNT(ks_code) "
											+ "FROM person_skill NATURAL JOIN requires "
												+ "WHERE pos_code = ? "
												+ "GROUP BY per_id), "
										+ "requiredSkillCnt(cnt) AS ("
											+ "SELECT COUNT(*) FROM requires "
											+ "WHERE pos_code = ?), "
										+ "nobodyQualified as (SELECT per_id, cnt - skillCnt as leastNumber "
											+ "FROM PersonRequiredSkillCnt, requiredSkillCnt "
												+ "WHERE skillCnt = cnt -1) "
										+ "SELECT name, leastNumber "
											+ "from nobodyQualified NATURAL JOIN person";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2, s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query22Answerer(String s1, String s2) {
		String pstate = "WITH requiredSkill(ks_code) AS ("
										+ "SELECT ks_code FROM requires "
											+ "WHERE pos_code = ?), "
										+ "requiredSkillCnt(cnt) AS ("
											+ "SELECT COUNT(*) FROM requires "
												+ "WHERE pos_code = ?), "
										+ "MissingKList(per_id, skillcnt) AS ("
											+ "SELECT per_id, count(ks_code) as skillcnt "
												+ "FROM person_skill NATURAL JOIN requiredSkill "
													+ "GROUP BY per_id "
														+ "HAVING COUNT(DISTINCT ks_code) + ? >= "
															+ "(SELECT COUNT(DISTINCT ks_code) FROM requiredSkill)), "
										+ "leastMissing as (SELECT DISTINCT per_id, cnt - skillcnt as leastNumber "
											+ "FROM missingklist, requiredSkillCnt) "
										+ "SELECT name, leastNumber FROM leastMissing NATURAL JOIN person "
											+ "ORDER by leastNumber ASC, name";


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			pstatement.setString(3,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query23Answerer(String s1) {
		String pstate = "WITH requiredSkill(ks_code) AS (SELECT ks_code FROM requires "
												+ "WHERE pos_code = ? GROUP BY ks_code), "
										+ "requiredSkillCnt(cnt) AS (SELECT COUNT(*) FROM requires WHERE pos_code = ?), "
										+ "MissingKList(per_id, skillcnt) AS (SELECT per_id, count(ks_code) as skillcnt "
											+ "FROM person_skill NATURAL JOIN requiredSkill GROUP BY per_id "
											+ "HAVING COUNT(DISTINCT ks_code) <= "
												+ "(SELECT COUNT(DISTINCT ks_code) FROM requiredSkill)), "
										+ "skillMissing as (SELECT DISTINCT ks_code, per_id FROM missingklist, requiredSkill "
											+ "MINUS SELECT ks_code, per_id from person_skill) "
										+ "select ks_code, count(per_id) as personCount "
											+ "from skillMissing group by ks_code order by personCount desc"; 
 


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2, s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query24Answerer() {
		String pstate = "WITH vacantJobs(pos_code, numberOfJobs) as "
											+ "(SELECT pos_code, COUNT(job_code) from job WHERE job_code NOT IN (SELECT job_code FROM WORKS) GROUP BY pos_code), "
										+ "	unemployedPeople(per_id) AS (SELECT per_id FROM person MINUS SELECT per_id from works), "
										+ "qualifiedJobless(pos_code, numberOfPeople) AS (SELECT pos_code, COUNT(per_id) AS numberOfPeople "
											+ "FROM (SELECT pos_code, per_id "
												+ "FROM vacantJobs VJ, unemployedPeople UP "
													+ "WHERE NOT EXISTS ((SELECT ks_code FROM person_skill PS "
														+ "where PS.per_id = UP.per_id) "
														+ "MINUS (SELECT ks_code FROM requires R "
															+ "WHERE R.pos_code = VJ.pos_code))) GROUP BY pos_code), "
										+ "unqualifiedJobless(pos_code, numberOfUnqualified) AS (SELECT pos_code,"
											+ "CASE "
											+	 "WHEN numberOFJobs-numberOfPeople < 0 THEN 0 "
											+ "WHEN numberOfJobs-numberOfPeople >= 0 THEN numberOfJobs-numberOFPeople "
											+ "END as numberOfUnqualified "
												+ "FROM vacantJobs NATURAL JOIN qualifiedJobless) "
											+ "SELECT pos_code FROM unqualifiedJobless "
												+ "WHERE numberOfUnqualified = "
													+ "(SELECT MAX(numberOfUnqualified) FROM unqualifiedJobless) ORDER BY pos_code";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet query25Answerer() {
		String pstate = "WITH vacantJobs(pos_code, numberOfJobs) as "
											+ "(SELECT pos_code, COUNT(job_code) from job WHERE job_code NOT IN (SELECT job_code FROM WORKS) GROUP BY pos_code), "
										+ "	unemployedPeople(per_id) AS (SELECT per_id FROM person MINUS SELECT per_id from works), "
										+ "qualifiedJobless(pos_code, numberOfPeople) AS (SELECT pos_code, COUNT(per_id) AS numberOfPeople "
											+ "FROM (SELECT pos_code, per_id "
												+ "FROM vacantJobs VJ, unemployedPeople UP "
													+ "WHERE NOT EXISTS ((SELECT ks_code FROM person_skill PS "
														+ "where PS.per_id = UP.per_id) "
														+ "MINUS (SELECT ks_code FROM requires R "
															+ "WHERE R.pos_code = VJ.pos_code))) GROUP BY pos_code), "
										+ "unqualifiedJobless(pos_code, numberOfUnqualified) AS (SELECT pos_code,"
											+ "CASE "
											+	 "WHEN numberOFJobs-numberOfPeople < 0 THEN 0 "
											+ "WHEN numberOfJobs-numberOfPeople >= 0 THEN numberOfJobs-numberOFPeople "
											+ "END as numberOfUnqualified "
												+ "FROM vacantJobs NATURAL JOIN qualifiedJobless), "
									+ "unqualifiedProfiles AS "
											+ "(SELECT pos_code FROM unqualifiedJobless "
													+ "WHERE numberOfUnqualified = "
															+ "(SELECT MAX(numberOfUnqualified) FROM unqualifiedJobless)) "
									+ "SELECT DISTINCT c_code, title "
											+ "FROM unqualifiedProfiles NATURAL JOIN course_set NATURAL JOIN course "
													+ "WHERE ks_code NOT IN "
															+ "(SELECT ks_code from unqualifiedJobless NATURAL JOIN person_skill)"
																+ " ORDER BY c_code";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public String addJob(String jc, String pc, String tp, Double pr, String pt, String cp, String pi) {
		String pstate =  "insert into job values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,jc);
			pstatement.setString(2,pc);
			pstatement.setString(3,tp);
			pstatement.setDouble(4,pr);
			pstatement.setString(5,pt);
			pstatement.setString(6,cp);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
		
		pstate = "insert into works values (?, ?)";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,pi);
			pstatement.setString(2,jc);
			pstatement.executeUpdate();
			return "Employee Successfully Added!\n";
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
	}
	
	public String removeJob(String jc, String pc, String cp, String pi) {
		String job_code = "";
		String pstate = "SELECT job_code FROM works NATURAL JOIN job WHERE per_id = ? "
										+ "AND comp_id = ?";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,pi);
			pstatement.setString(2,cp);
			ResultSet rs = pstatement.executeQuery();
			
			while(rs.next()) {
				job_code = rs.getString("job_code");
			}
			rs.close();
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
		
		pstate = "delete from job where job_code = ?";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,job_code);
			pstatement.executeUpdate();
			return "Employee Successfully Fired!\n";
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
	}
	
	public ResultSet nameFromCompany() {
		String pstate = "SELECT name FROM company";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet posFromJobProfile() {
		String pstate = "SELECT pos_code FROM job_profile";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet compidFromCompany(String s1) {
		String pstate = "SELECT comp_id FROM company WHERE name = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1, s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet peopleFromCompany(String s1) {
		String pstate = "SELECT DISTINCT name FROM person NATURAL JOIN works NATURAL JOIN job WHERE comp_id = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1, s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet nameFromPerson() {
		String pstate = "SELECT name FROM person";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ksFromKnowledgeSkill() {
		String pstate = "SELECT ks_code FROM knowledge_skill";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet peridFromName(String s1) {
		String pstate = "SELECT per_id FROM person WHERE name = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public void addSkill(String s1, String s2) {
		String pstate = "insert into person_skill values (?, ?)";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public ResultSet ksCodeNotInPersonSkill(String s1) {
		String pstate = "SELECT DISTINCT ks_code FROM knowledge_skill WHERE ks_code NOT IN (SELECT ks_code FROM person_skill WHERE per_id = ?) ORDER BY ks_code";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet posFromWorks(String s1, String s2) {
		String pstate = "SELECT pos_code FROM works NATURAL JOIN job where comp_id = ? AND per_id = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public void addPerson(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11) {
		String pstate = "insert into person values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.setString(3,s3);
			pstatement.setString(4,s4);
			pstatement.setString(5,s5);
			pstatement.setString(6,s6);
			pstatement.setString(7,s7);
			pstatement.setString(8,s8);
			pstatement.setString(9,s9);
			pstatement.setString(10,s10);
			pstatement.setString(11,s11);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public ResultSet titleFromJobProfile(String s1) {
		String pstate = "SELECT title FROM works NATURAL JOIN job_profile NATURAL JOIN person NATURAL JOIN job WHERE name = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet currentSkills(String s1) {
		String pstate = "SELECT ks_code, title, description, lvl FROM person NATURAL JOIN knowledge_skill NATURAL JOIN person_skill WHERE name = ? ORDER BY lvl";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet jobInfo(String s1) {
		String pstate = "SELECT title, description FROM job_profile WHERE pos_code = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ksInfo(String s1) {
		String pstate = "SELECT title, description, lvl FROM knowledge_skill WHERE ks_code = ?";


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet titleFromProject(String s1) {
		String pstate = "SELECT title FROM project WHERE comp_id = ?";


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet nameFromWorks(String s1, String s2) {
		String pstate = "SELECT name FROM works NATURAL JOIN job NATURAL JOIN person WHERE comp_id = ? "
										+ "AND name NOT IN (SELECT name from job_project NATURAL JOIN works NATURAL JOIN person "
												+ "WHERE proj_id = ?)";


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet jobFromWorks(String s1, String s2) {
		String pstate = "SELECT job_code FROM works NATURAL JOIN job WHERE per_id = ? AND comp_id = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public void newProject(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		String pstate = "insert into project values (?, ?, ?, ?, to_date(?, 'MM-DD-YYYY'), to_date(?, 'MM-DD-YYYY'), ?)";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.setString(3,s3);
			pstatement.setString(4,s4);
			pstatement.setString(5,s5);
			pstatement.setString(6,s6);
			pstatement.setString(7,s7);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		pstate = "insert into job_project values (?, ?)";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s8);
			pstatement.setString(2,s1);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public ResultSet projIdFromTitle(String s1) {
		String pstate = "SELECT proj_id FROM project WHERE title = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet nameFromJobProject(String s1) {
		String pstate = "SELECT name FROM job_project NATURAL JOIN works NATURAL JOIN person WHERE proj_id = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public void removeProj(String s1) {
		String pstate = "delete from project where proj_id = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public ResultSet jobFromWorksPerson(String s1) {
		String pstate = "SELECT job_code FROM works NATURAL JOIN job NATURAL JOIN person WHERE name = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public void addToProj(String s1, String s2) {
		String pstate = "insert into job_project values (?, ?)";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s2);
			pstatement.executeUpdate();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public ResultSet estimateCostID(String s1) {
		String pstate = "SELECT proj_id, (to_number(end_date-start_date)) as numberOfDays FROM project WHERE title = ?";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet estimateCost(String s1) {
		String pstate = "WITH salary_sum AS "
				+ "(SELECT CASE WHEN pay_type = 'W' THEN SUM(pay_rate * 1920) "
				+ "WHEN pay_type = 'S' THEN SUM(pay_rate) END AS sum_salary "
				+ "FROM job_project NATURAL JOIN job WHERE proj_id = ? GROUP BY pay_type) "
				+ "SELECT SUM(sum_salary) as proj_sum FROM salary_sum";
		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet skillsNeeded(String s1) {
		String pstate = "SELECT DISTINCT ks_code AS skillsNeeded FROM requires NATURAL JOIN job NATURAL JOIN job_project "
											+ "WHERE proj_id = ? AND ks_code NOT IN "
												+ "(SELECT ks_code FROM person_skill WHERE per_id IN "
													+ "(SELECT per_id FROM works NATURAL JOIN job_project WHERE proj_id = ?)) ORDER BY ks_code ASC";

		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
	
	public ResultSet skillsRequired(String s1) {
		String pstate = "WITH skillsRequired AS (SELECT DISTINCT ks_code FROM requires NATURAL JOIN job NATURAL JOIN job_project "
											+ "WHERE proj_id = ? AND ks_code NOT IN "
												+ "(SELECT ks_code FROM person_skill WHERE per_id IN "
													+ "(SELECT per_id FROM works NATURAL JOIN job_project WHERE proj_id = ?))) "
										+ "SELECT title FROM course NATURAL JOIN course_set NATURAL JOIN skillsRequired ORDER BY title ASC";


		try {
			PreparedStatement pstatement = conn.prepareStatement(pstate);
			pstatement.setString(1,s1);
			pstatement.setString(2,s1);
			rs = pstatement.executeQuery();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return rs;
	}
}
