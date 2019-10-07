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
		Scanner scanner = new Scanner(System.in);
		int info_id, student_id;
    	String add,birth;
    	Double score;
    	System.out.println("Nhập thông tin sinh viên: ");
		System.out.print("Mã số thông tin: ");
		info_id = scanner.nextInt();
		System.out.print("Mã số sinh viên: ");
		student_id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Địa chỉ: ");
		add = scanner.nextLine();
		System.out.print("Điểm trung bình: ");
		score = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Ngày sinh: ");
		birth = scanner.nextLine();
		try {
			java.util.Date birth_day = format.parse(birth);
			StudentInfo newstudent = new StudentInfo();
			newstudent.newStudent(info_id,student_id,add,score,birth_day);
			fst.save(newstudent.printInfo(), link);
		}catch(Exception e) {
            e.printStackTrace();
        }
		scanner.close();
	}
//	public void edit(String link) {
//		StudentInfoDAO fst = new StudentInfoDAO();
//		List<StudentInfo> student = new ArrayList<StudentInfo>();
//		student = fst.newList(link);
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập mã số sinh viên: ");
//    	student_id = scanner.nextInt();
//    	for (StudentInfo list : student) {
//			if (list.student_id == student_id) {
//				String info = list.printInfo();
//				list.printInfoPretty();
//				Boolean c = true;
//				int number;
//				System.out.println("------Sửa thông tin sinh viên------");
//				System.out.println("|    1 - Mã số thông tin          |");
//				System.out.println("|    2 - Mã số sinh viên          |");
//				System.out.println("|    3 - Địa chỉ                  |");
//				System.out.println("|    4 - Điểm trung bình          |");
//				System.out.println("|    5 - Ngày sinh                |");
//				System.out.println("|    6 - Lưu                      |");
//				System.out.println("|    0 - Kết thúc                 |");
//				System.out.println("-----------------------------------");
//				do {
//					System.out.println("Chọn thông tin cần thay đổi: ");
//					number = scanner.nextInt();
//					switch (number) {
//					case 1:
//						String info_id_change;
//						System.out.print("Mã số thông tin: ");
//						scanner.nextLine();
//						info_id_change = scanner.nextLine();
//						list.editInfo_id(Integer.parseInt(info_id_change));
//						System.out.println();
//						break;
//					case 2:
//						String student_id_change;
//						System.out.print("Mã số sinh viên: ");
//						scanner.nextLine();
//						student_id_change = scanner.nextLine();
//						list.editStudent_id(Integer.parseInt(student_id_change));
//						System.out.println();
//						break;
//					case 3:
//						String address_id_change;
//						System.out.print("Địa chỉ: ");
//						scanner.nextLine();
//						address_id_change = scanner.nextLine();
//						list.editAddress(address_id_change);
//						break;
//					case 4:
//						String score_id_change;
//						System.out.print("Điểm trung bình: ");
//						scanner.nextLine();
//						score_id_change = scanner.nextLine();
//						list.editScore(Double.parseDouble(score_id_change));
//						System.out.println();
//						break;
//					case 5:
//						String birth_day_old;
//						System.out.print("Ngày sinh: ");
//						scanner.nextLine();
//						birth_day_old = scanner.nextLine();
//						try {
//							
//							Date birth_change = format.parse(birth_day_old);
//							list.editBirth(birth_change);
//							System.out.println();
//						}catch(Exception e) {
//		                    e.printStackTrace();
//		                }
//						break;
//					case 6:
//						System.out.println("Thay đổi thông tin thành công: ");
//						list.printInfoPretty();;
//						fst.delete(info, link);
//						fst.save(list.printInfo(), link);
//						break;
//					case 0:
//						c = false;
//						break;
//					default:
//						break;
//					}
//				}while(c);
//			}
//		}
//    	scanner.close();
//	}
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
