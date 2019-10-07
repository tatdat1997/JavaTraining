package new_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;



public class StudentInfoManager extends StudentInfo {
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public void add(String link) {
		StudentInfoDAO fst = new StudentInfoDAO();
		Scanner scan = new Scanner(System.in);
		int info_id, student_id;
    	String add,birth;
    	Double score;
    	System.out.println("Nhập thông tin sinh viên: ");
		System.out.print("Mã số thông tin: ");
		info_id = scan.nextInt();
		System.out.print("Mã số sinh viên: ");
		student_id = scan.nextInt();
		scan.nextLine();
		System.out.print("Địa chỉ: ");
		add = scan.nextLine();
		System.out.print("Điểm trung bình: ");
		score = scan.nextDouble();
		scan.nextLine();
		System.out.print("Ngày sinh (dd-MM-yyyy): ");
		birth = scan.nextLine();
		if(birth.contains("/")) {
			birth =birth.replaceAll("/", "-");
		}
		try {
			java.util.Date birth_day = format.parse(birth);
			StudentInfo newstudent = new StudentInfo();
			newstudent.newStudent(info_id,student_id,add,score,birth_day);
			fst.save(newstudent.printInfo(), link);
		}catch(Exception e) {
            e.printStackTrace();
        }
	}
	public void delete(String lines, String link) {
		try {
	      File inFile = new File(link);
	      if (!inFile.isFile()) {
	        System.out.println("Đây không phải file");
	        return;
	      }
	      // Construct the new file that will later be renamed
	      // to the original filename. 
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
	      BufferedReader br = new BufferedReader(new FileReader(link));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	      String line = null;
	      //Read from the original file and write to the new 
	      //unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {

	        if (!line.trim().equals(lines)) {

	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();

	      //Xoa file
	      if (!inFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      } 
	      //Doi ten file
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Could not rename file");
	    }
	    catch (FileNotFoundException ex) {
	    	ex.printStackTrace();
	    }
	    catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	}
	public List<StudentInfo> sortGPA(List<StudentInfo> student) {
		StudentInfo temp;
		for (int i = 0; i < student.size(); i++) {
			for (int j = 0; j < student.size(); j++) {
				if(student.get(i).avegare_score > student.get(j).avegare_score) {
					temp =student.get(i);
					student.set(i, student.get(j));
					student.set(j, temp);
				}
			}
		}
		return student;
	}
	public List<StudentInfo> sortByName(List<StudentInfo> student) {
		StudentInfo temp;
		for (int i = 0; i < student.size(); i++) {
			for (int j = 0; j < student.size(); j++) {
				if(student.get(i).student_id > student.get(j).student_id) {
					temp =student.get(i);
					student.set(i, student.get(j));
					student.set(j, temp);
				}
			}
		}
		return student;
	}
}
