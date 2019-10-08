package pkg_Info;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentInfo extends HumanInfo{
	private Integer studentId;
	private Double avegareScore;

	public StudentInfo(Integer infoId, Integer student_id, String address, Double avegare_score, Date day_of_birth) {
		super();
		this.infoId = infoId;
		this.studentId = student_id;
		this.address = address;
		this.avegareScore = avegare_score;
		this.dayOfBirth = day_of_birth;
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
	public String printInfo() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = this.infoId+","+this.studentId+","+this.address+","+this.avegareScore+ ","+format.format(this.dayOfBirth);
		return info;
	}
	public void printInfoPretty() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = "infoId: "+this.infoId+", Student_ID: "+this.studentId+", Address: "+this.address
				+", Avegare score: "+this.avegareScore+ ",Day of birth: "+format.format(this.dayOfBirth);
		System.out.println(info);
	}
}
