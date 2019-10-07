package pkg_Info;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentInfo {
	private Integer info_id;
	private Integer student_id;
	private String address;
	private Double avegare_score;
	private Date day_of_birth;

	public StudentInfo(Integer info_id, Integer student_id, String address, Double avegare_score, Date day_of_birth) {
		super();
		this.info_id = info_id;
		this.student_id = student_id;
		this.address = address;
		this.avegare_score = avegare_score;
		this.day_of_birth = day_of_birth;
	}
	public int get_Info_Id() {
		return info_id;
	}
	public void setInfo_Id(Integer info_id) {
		this.info_id = info_id;
	}
	public int get_Student_Id() {
		return student_id;
	}
	public void set_Student_Id(Integer student_id) {
		this.student_id = student_id;
	}
	public String get_Address() {
		return address;
	}
	public void set_Address(String address) {
		this.address = address;
	}
	public Double get_Avegare_score() {
		return avegare_score;
	}
	public void set_Avegare_score(Double avegare_score) {
		this.avegare_score = avegare_score;
	}
	public Date get_Day_of_birth() {
		return day_of_birth;
	}
	public void set_Day_of_birth(Date day_of_birth) {
		this.day_of_birth = day_of_birth;
	}
	
	public void editInfo_id(int info_id_new) {
		info_id = info_id_new;
	}
	public void editStudent_id(int student_id_new) {
		student_id = student_id_new;
	}
	public void editAddress(String address_new) {
		address = address_new;
	}
	public void editScore(Double score_new) {
		avegare_score = score_new;
	}
	public void editBirth(Date birth_new) {
		day_of_birth = birth_new;
	}
	public String printInfo() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = info_id+","+student_id+","+address+","+avegare_score+ ","+format.format(day_of_birth);
		return info;
	}
	public void printInfoPretty() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = "Info_ID: "+info_id+", Student_ID: "+student_id+", Address: "+address
				+", Avegare score: "+avegare_score+ ",Day of birth: "+format.format(day_of_birth);
		System.out.println(info);
		
	}
}
