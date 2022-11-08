package kr.ac.college.bean;

public class LecBean {
	private int lecNo;
	private String lecName;
	private int lecCredit;
	private int lecTime;
	private String lecClass;
	public int getLecNo() {
		return lecNo;
	}
	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}
	public void setLecNo(String lecNo) {
		this.lecNo = Integer.parseInt(lecNo);
	}
	
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	
	public int getLecCredit() {
		return lecCredit;
	}
	public void setLecCredit(int lecCredit) {
		this.lecCredit = lecCredit;
	}
	public void setLecCredit(String lecCredit) {
		this.lecCredit = Integer.parseInt(lecCredit);
	}
	
	public int getLecTime() {
		return lecTime;
	}
	public void setLecTime(int lecTime) {
		this.lecTime = lecTime;
	}
	public void setLecTime(String lecTime) {
		this.lecTime = Integer.parseInt(lecTime);
	}
	
	public String getLecClass() {
		return lecClass;
	}
	public void setLecClass(String lecClass) {
		this.lecClass = lecClass;
	}
	
	
}
