package pkg_Info;

import java.util.Date;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfo class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */
public class StudentInfo extends HumanInfo{
	private Integer studentId;
	private Double avegareScore;	
	//Create new StudentInfo
	public StudentInfo() {
		super();
	}
	public StudentInfo(Integer infoId, Integer studentId, String address, Double avegareScore, Date dateOfBirth) {
		super(infoId, address, dateOfBirth);
		this.studentId = studentId;
		this.avegareScore = avegareScore;
	}
	public StudentInfo(Integer infoId, Integer studentId, String address, Double avegareScore, String dayOfBirth) {
		super(infoId, address, dayOfBirth);
		this.studentId = studentId;
		this.avegareScore = avegareScore;
	}
	public int getStudentId() {			//Get Student Id
		return studentId;
	}
	public void setStudentId(Integer student_Id) {		//Set Student Id
		this.studentId = student_Id;
	}
	public Double getAverageScore() {		
		return avegareScore;
	}
	public void setAverageScore(Double averageScoreNew) {		
		this.avegareScore = averageScoreNew;
	}
	public void editStudentId(int studentIdNew) {		
		this.studentId = studentIdNew;
	}
	public void editScore(Double scoreNew) {			
		this.avegareScore = scoreNew;
	}
	@Override
	/*
	 *Override printInfo in HunmanInfo
	 *Print Info of student to save in file 
	 */
	public String printInfo() {
		// TODO Auto-generated method stub
		String info = this.infoId + "&" + this.studentId + "&" + this.address + "&" + this.avegareScore
						+ "&" + this.format.format(this.dateOfBirth);
		return info;
	}
	@Override
	/*
	 *Override printInfoPretty in HunmanInfo
	 *Print Info of student to show.
	 */
	public void printInfoPretty() {
		// TODO Auto-generated method stub
		String info = "Info_Id: " + this.infoId + ", Student_ID: " + this.studentId+", Address: " + this.address
				        + ", Avegare score: " + this.avegareScore +  ",Day of birth: " + this.format.format(this.dateOfBirth);
		System.out.println(info);
	}
}
