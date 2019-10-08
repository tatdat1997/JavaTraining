package pkg_Info;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentInfo extends HumanInfo{
	private Integer studentId;
	private Double avegareScore;	
	public StudentInfo() {
		super();
	}
	public StudentInfo(Integer infoId, Integer studentId, String address, Double avegareScore, Date dayOfBirth) {
		super(infoId, address, dayOfBirth);
		this.studentId = studentId;
		this.avegareScore = avegareScore;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer student_Id) {
		this.studentId = student_Id;
	}
	public Double getAvegareScore() {
		return avegareScore;
	}
	public void setAvegareScore(Double avegare_Score) {
		this.avegareScore = avegare_Score;
	}
	public void editStudentId(int studentIdNew) {
		this.studentId = studentIdNew;
	}
	public void editScore(Double scoreNew) {
		this.avegareScore = scoreNew;
	}
	@Override
	public String printInfo() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = this.infoId+"&"+this.studentId+"&"+this.address+"&"+this.avegareScore+ "&"+format.format(this.dayOfBirth);
		return info;
	}
	@Override
	public void printInfoPretty() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = "Info_Id: "+this.infoId+", Student_ID: "+this.studentId+", Address: "+this.address
				+", Avegare score: "+this.avegareScore+ ",Day of birth: "+format.format(this.dayOfBirth);
		System.out.println(info);
	}
}
