package new_Package;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import pkg_DAO.StudentInfoDAO;
import pkg_Info.StudentInfo;
import new_Package.SortBy;


public class StudentInfoManager {
	private List<StudentInfo> listStudent;
	public void setStudentInfo(List<StudentInfo> ListStudent) {
		this.listStudent = ListStudent;
	}
	public List<StudentInfo> getStudentInfo() {
		return listStudent;
	}
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	Scanner scanner = new Scanner(System.in);
	public void addStudent(String link) {
		Boolean check = true;
	    do {
			try {
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
				System.out.print("Ngày sinh (dd-MM-yyyy): ");
				birth = scanner.nextLine();
				if(birth.contains("/")) {
					birth =birth.replaceAll("/", "-");
				}
				try {
					java.util.Date birth_day = format.parse(birth);
					StudentInfo newStudent = new StudentInfo(info_id, student_id, add, score, birth_day);
					this.saveToFile(newStudent.printInfo(), link);
					newStudent.printInfoPretty();
					System.out.println("Sinh viên được tạo mới thành công");
					check = false;
				}catch(Exception e) {
		            e.printStackTrace();
		        }
			}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    }
		while (check);
	}
	
	public void editStudent(String link) {
		Boolean check = true;
	    do {
			try {
				this.listStudent = StudentInfoDAO.loadStudent(link);
				Integer student_id;
				System.out.println("Nhập mã số sinh viên: ");
		    	student_id = scanner.nextInt();
		    	boolean check_id = true;
		    	for (StudentInfo list : this.listStudent) {
					if (list.getStudentId() == student_id) {
						check_id = false;
						String info = list.printInfo();
						list.printInfoPretty();
						Boolean c = true;
						int number;
						System.out.println("------Sửa thông tin sinh viên------");
						System.out.println("|    1 - Mã số thông tin          |");
						System.out.println("|    2 - Mã số sinh viên          |");
						System.out.println("|    3 - Địa chỉ                  |");
						System.out.println("|    4 - Điểm trung bình          |");
						System.out.println("|    5 - Ngày sinh                |");
						System.out.println("|    6 - Lưu                      |");
						System.out.println("|    0 - Kết thúc                 |");
						System.out.println("-----------------------------------");
						do {
							System.out.println("Chọn thông tin cần thay đổi: ");
							number = scanner.nextInt();
							switch (number) {
							case 1:
								Integer info_id_change;
								System.out.print("Mã số thông tin: ");
								scanner.nextLine();
								info_id_change = scanner.nextInt();
								list.editInfoId(info_id_change);
								break;
							case 2:
								String student_id_change;
								System.out.print("Mã số sinh viên: ");
								scanner.nextLine();
								student_id_change = scanner.nextLine();
								list.editStudentId(Integer.parseInt(student_id_change));
								break;
							case 3:
								String address_id_change;
								System.out.print("Địa chỉ: ");
								scanner.nextLine();
								address_id_change = scanner.nextLine();
								list.editAddress(address_id_change);
								break;
							case 4:
								String score_id_change;
								System.out.print("Điểm trung bình: ");
								scanner.nextLine();
								score_id_change = scanner.nextLine();
								list.editScore(Double.parseDouble(score_id_change));
								break;
							case 5:
								String birth_day_old;
								System.out.print("Ngày sinh: ");
								scanner.nextLine();
								birth_day_old = scanner.nextLine();
								try {
									
									Date birth_change = format.parse(birth_day_old);
									list.editBirth(birth_change);
								}catch(Exception e) {
				                    e.printStackTrace();
				                }
								break;
							case 6:
								System.out.println("Thay đổi thông tin thành công: ");
								list.printInfoPretty();
								this.deleteLine(info, link);
								this.saveToFile(list.printInfo(), link);
								check = false;
								break;
							case 0:
								c = false;
								check = false;
								break;
							default:
								System.out.println("Vui lòng nhập số từ 0 - 6!");
								break;
							}
						}while(c);
					}
				}
		    	if(check_id) {
		    		System.out.println("Sinh viên có mã số "+student_id+" không tồn tại!");
		    	}
			}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    }while(check);
	}
	public void removeStudent(String link) {
		this.listStudent = StudentInfoDAO.loadStudent(link);
		Integer id;
		Boolean check = true;
	    do {
	    	try{
				System.out.println("Nhập mã số sinh viên muốn xóa: ");
		    	id = scanner.nextInt();
		    	boolean check_id = true;
		    	boolean check1 = true;
		    	for (StudentInfo list : this.listStudent) {
					if (list.getStudentId() == id) {
						check_id = false;
						String key;
						scanner.nextLine();

						do {
							System.out.println("Bạn muốn xóa sinh viên có mã "+id+": Y/N");
							key = scanner.nextLine();
							switch (key) {
							case "Y":
								this.deleteLine(list.printInfo(), link);
								System.out.println("Xóa thành công");
								check1 = false;
								check = false;
								break;
							case "N":
								break;
							default:
								check= true;
								System.out.println("Vui lòng xác nhận Y hoặc N!");
								break;
							}
						}while(check1);
					}
		    	}
		    	if(check_id) {
		    		System.out.println("Sinh viên có mã số "+id+" không tồn tại!");
		    	}
	    	}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    }while(check);
	}
	
	public void sortBy(SortBy type) {
		List<StudentInfo> studentList = new ArrayList<StudentInfo>();
		studentList = StudentInfoDAO.loadStudent("E:\\JavaTraining\\Student_manager\\StudentInfoDAO.txt");
		StudentInfo temp;
		
		if(type == SortBy.GPA) {
			for (int i = 0; i < studentList.size(); i++) {
				for (int j = 0; j < studentList.size(); j++) {
					if(studentList.get(i).getAvegareScore() > studentList.get(j).getAvegareScore()) {
						temp =studentList.get(i);
						studentList.set(i, studentList.get(j));
						studentList.set(j, temp);
					}
				}
			}
		}else {
			if(type == SortBy.Name) {
				for (int i = 0; i < studentList.size(); i++) {
					for (int j = 0; j < studentList.size(); j++) {
						if(studentList.get(i).getStudentId() > studentList.get(j).getStudentId()) {
							temp =studentList.get(i);
							studentList.set(i, studentList.get(j));
							studentList.set(j, temp);
						}
					}
				}
			}
		}
		for (StudentInfo list : studentList) {
			list.printInfoPretty();
		}
	}
	public void sortByGPA(List<StudentInfo> studentList) {
		StudentInfo temp;
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getAvegareScore() > studentList.get(j).getAvegareScore()) {
					temp =studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
		}
		for (StudentInfo list : studentList) {
			list.printInfoPretty();
		}
	}
	public void sortByName(List<StudentInfo> studentList) {
		StudentInfo temp;
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getStudentId() > studentList.get(j).getStudentId()) {
					temp =studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
		}
		for (StudentInfo list : studentList) {
			list.printInfoPretty();
		}
	}
	public void saveToFile(String info, String link) {
		String File = link; // link file will write info
		try(FileWriter fw = new FileWriter(File, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(info);
		  
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	public void showStudent(String link) {
		List<StudentInfo> studentList = new ArrayList<StudentInfo>();
		studentList = StudentInfoDAO.loadStudent(link);
		for (StudentInfo list : studentList) {
			list.printInfoPretty();
		}
	}
	public void deleteLine(String lines, String link) {
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
	        System.out.println("Không thể xóa file");
	        return;
	      } 
	      //Doi ten file
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Không thể đổi tên file");
	    }
	    catch (FileNotFoundException ex) {
	    	ex.printStackTrace();
	    }
	    catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	}
}
