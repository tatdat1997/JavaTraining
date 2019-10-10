package new_Package;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import pkg_DAO.StudentInfoDAO;
import pkg_Info.StudentInfo;
import new_Package.SortBy;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoManager class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */
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
				int infoId, studentId;
		    	String add,birth;
		    	Double score;
		    	System.out.println("Nhập thông tin sinh viên: ");
				System.out.print("Mã số thông tin: ");
				infoId = scanner.nextInt();
				System.out.print("Mã số sinh viên: ");
				studentId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Địa chỉ: ");
				add = scanner.nextLine();
				System.out.print("Điểm trung bình: ");
				score = scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Ngày sinh (dd-MM-yyyy): ");
				birth = scanner.nextLine();
				if(birth.contains("/")) {
					birth = birth.replaceAll("/", "-");
				}	
				//Create new StudentInfo
				StudentInfo newStudent = new StudentInfo(infoId, studentId, add, score, birth);
				//Save info student in file.
				this.saveToFile(newStudent.printInfo(), link); 		
				//Show info student.
				newStudent.printInfoPretty();							
				System.out.println("Sinh viên được tạo mới thành công");
				check = false;
			}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    }
		while (check);
	}
	
	/*
	 * EditStudent edit info student by student_id in list StudentInfo 
	 * and save it again in file.
	 * Use editInfoId,.. to edit info in StudentInfo.
	 */
	public void editStudent(String link) {
		Boolean check = true;
	    do {
			try {
				//Get list StudentInfo from file
				this.listStudent = StudentInfoDAO.loadStudent(link);
				Integer studentId;
				System.out.println("Nhập mã số sinh viên: ");
				studentId = scanner.nextInt();
		    	boolean checkId = true;
		    	for (StudentInfo list : this.listStudent) {
					if (list.getStudentId() == studentId) {	//find Student by student_id
						checkId = false;
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
								Integer infoIdChange;
								System.out.print("Mã số thông tin: ");
								scanner.nextLine();
								infoIdChange = scanner.nextInt();
								list.editInfoId(infoIdChange);							//edit Info id
								break;
							case 2:
								String studentIdChange;
								System.out.print("Mã số sinh viên: ");
								scanner.nextLine();
								studentIdChange = scanner.nextLine();
								list.editStudentId(Integer.parseInt(studentIdChange));	//edit Student id
								break;
							case 3:
								String addressIdChange;
								System.out.print("Địa chỉ: ");
								scanner.nextLine();
								addressIdChange = scanner.nextLine();
								list.editAddress(addressIdChange);						//edit Address
								break;
							case 4:
								String scoreIdChange;
								System.out.print("Điểm trung bình: ");
								scanner.nextLine();
								scoreIdChange = scanner.nextLine();
								list.editScore(Double.parseDouble(scoreIdChange));		//edit Average score
								break;
							case 5:
								String birthDayChange;
								System.out.print("Ngày sinh: ");
								scanner.nextLine();
								birthDayChange = scanner.nextLine();
								list.editBirth(birthDayChange);							//edit day of birth
								break;
							case 6:
								System.out.println("Thay đổi thông tin thành công: ");
								list.printInfoPretty();
								//Delete student info of this student in file
								this.deleteLine(info, link);
								//Save new student info of this student in file
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
						} while (c);
					}
				}
		    	if(checkId) {
		    		System.out.println("Sinh viên có mã số "+studentId+" không tồn tại!");
		    	}
			}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    } while (check);
	}
	
	/*
 	* Remove student from file by Student id
 	*/
	public void removeStudent(String link) {
		//Get list StudentInfo from file
		this.listStudent = StudentInfoDAO.loadStudent(link);
		Integer studentId;
		Boolean check = true;
	    do {
	    	try{
				System.out.println("Nhập mã số sinh viên muốn xóa: ");
				studentId = scanner.nextInt();
		    	boolean checkId = true;
		    	boolean check1 = true;
		    	for (StudentInfo list : this.listStudent) {
					if (list.getStudentId() == studentId) {		//find Student by student_id
						checkId = false;
						String key;
						scanner.nextLine();
						do {
							System.out.println("Bạn muốn xóa sinh viên có mã " + studentId + ": Y/N");
							key = scanner.nextLine();
							switch (key) {
							case "Y":
								//Delete line have info student in file
								this.deleteLine(list.printInfo(), link);
								System.out.println("Xóa thành công");
								check1 = false;
								check = false;
								break;
							case "N":
								check1 = false;
								check = false;
								break;
							default:
								check= true;
								System.out.println("Vui lòng xác nhận Y hoặc N!");
								break;
							}
						} while (check1);
					}
		    	}
		    	if(checkId) {
		    		System.out.println("Sinh viên có mã số " + studentId + " không tồn tại!");
		    	}
	    	}catch(Exception e){
				System.out.println("Cú pháp không chính xác vui lòng thao tác lại.");
				scanner.nextLine();
			}
	    } while (check);
	}
	
	/*
	 * Sort list StudentInfo from file
	 * Sort by GPA and Sort by Name
	 * Use enum SortBy
	 */
	public void sortBy(SortBy type) {
		//Get list StudentInfo from file
		this.listStudent = StudentInfoDAO.loadStudent("E:\\JavaTraining\\Student_manager\\StudentInfoDAO.txt");
		if(type == SortBy.GPA) {		//Sort by GPA
			this.sortByGPA(this.listStudent);
		}else {
			if(type == SortBy.Name) {		//Sort by Name
				this.sortByName(this.listStudent);
			}
		}
	}
	public void sortByGPA(List<StudentInfo> studentList) {
		StudentInfo temp;
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = i+1; j < studentList.size(); j++) {
				if (studentList.get(i).getAverageScore() < studentList.get(j).getAverageScore()) {
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
			for (int j = i+1; j < studentList.size(); j++) {
				if(studentList.get(i).getStudentId() < studentList.get(j).getStudentId()) {
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
		BufferedWriter br = null;
		try (FileWriter fw = new FileWriter(File, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw)) {
		    out.println(info);
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
			e.printStackTrace();
		}finally {
        	if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public void showStudent(String link) {
		//Load list StudentInfo from file
		this.listStudent = StudentInfoDAO.loadStudent(link);
		for (StudentInfo list : listStudent) {
			list.printInfoPretty();		//Show list StudentInfo
		}
	}
	public void deleteLine(String lines, String link) {
		 BufferedReader br = null;
		try {
	      File inFile = new File(link);
	      if (!inFile.isFile()) {
	        System.out.println("Đây không phải file");
	        return;
	      }
	      // Construct the new file that will later be renamed to the original filename. 
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
	      br = new BufferedReader(new FileReader(link));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	      String line = null;
	      //Read from the original file and write to the new 
	      //Unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {
	        if (!line.trim().equals(lines)) {
	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();
	      //Delete file
	      if (!inFile.delete()) {
	        System.out.println("Không thể xóa file");
	        return;
	      } 
	      //Rename file
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Không thể đổi tên file");
	    } catch (FileNotFoundException ex) {
	    	ex.printStackTrace();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }finally {
        	if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
