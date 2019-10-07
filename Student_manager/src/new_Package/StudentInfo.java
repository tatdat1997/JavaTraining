package new_Package;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentInfo {
	Integer info_id, student_id;
	String address;
	Double avegare_score;
	Date day_of_birth;
	public void newStudent(int id, int student, String add, Double score,Date birth) {
		info_id			= id;
		student_id		= student;
		address			= add;
		avegare_score	= score;
		day_of_birth	= birth;
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
