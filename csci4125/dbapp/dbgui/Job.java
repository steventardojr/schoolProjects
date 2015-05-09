package dbgui;

import dbaccess.*;

/**
* WorkforceIS
* Written by Steven Tardo and Philip Williams
* Built upon code provided by Dr. Shengru Tu
* This class models the job table found in the database,
* and through the other applications, instances can be created
* which allow for adding and removing (hiring and firing) of
* jobs based on the person and job profile.
*/

public class Job {
	private String job_code;
	private String pos_code;
	private String type;
	private Double pay_rate;
	private String pay_type;
	private String comp_id;
	private String per_id;
	private QueryAnswerer qa;
	
	public Job(String jc, String pc, String tp, Double pr, String pt, String cp, String pi, QueryAnswerer qa) {
		this.job_code = jc;
		this.pos_code = pc;
		this.type = tp;
		this.pay_rate = pr;
		this.pay_type = pt;
		this.comp_id = cp;
		this.per_id = pi;
		this.qa = qa;
	}
	
	public Job(String jc, String pc, String cp, String pi, QueryAnswerer qa) {
		this.job_code = jc;
		this.pos_code = pc;
		this.comp_id = cp;
		this.per_id = pi;
		this.qa = qa;
	}
	
	public String addNewJob() {
		try {
			String returnStatement = qa.addJob(job_code, pos_code, type, pay_rate, pay_type, comp_id, per_id);
			return returnStatement;
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
	}
	
	public String removeJob() {
		try {
			String returnStatement = qa.removeJob(job_code, pos_code, comp_id, per_id);
			return returnStatement;
		}
		catch (Exception e) {
			return e.getMessage() + "\n";
		}
	}
}
