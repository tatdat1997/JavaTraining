package new_Package;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
	private HashMap<Integer,StudentInfo> mapStudent;
	public void setStudentInfo(HashMap<Integer,StudentInfo> MapStudent) {
		this.mapStudent = MapStudent;
	}
	public HashMap<Integer,StudentInfo> getStudentInfo() {
		return mapStudent;
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
				this.mapStudent = StudentInfoDAO.loadStudent(link);
				Integer studentId;
				System.out.println("Nhập mã số sinh viên: ");
				studentId = scanner.nextInt();
		    	boolean checkId = true;
					if (this.mapStudent.get(studentId) != null) {	//find Student by student_id
						checkId = false;
						StudentInfo student = this.mapStudent.get(studentId);
						String info = student.printInfo();
						student.printInfoPretty();
						
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
								student.editInfoId(infoIdChange);							//edit Info id
								break;
							case 2:
								String studentIdChange;
								System.out.print("Mã số sinh viên: ");
								scanner.nextLine();
								studentIdChange = scanner.nextLine();
								student.editStudentId(Integer.parseInt(studentIdChange));	//edit Student id
								break;
							case 3:
								String addressIdChange;
								System.out.print("Địa chỉ: ");
								scanner.nextLine();
								addressIdChange = scanner.nextLine();
								student.editAddress(addressIdChange);						//edit Address
								break;
							case 4:
								String scoreIdChange;
								System.out.print("Điểm trung bình: ");
								scanner.nextLine();
								scoreIdChange = scanner.nextLine();
								student.editScore(Double.parseDouble(scoreIdChange));		//edit Average score
								break;
							case 5:
								String birthDayChange;
								System.out.print("Ngày sinh: ");
								scanner.nextLine();
								birthDayChange = scanner.nextLine();
								student.editBirth(birthDayChange);							//edit day of birth
								break;
							case 6:
								System.out.println("Thay đổi thông tin thành công: ");
								student.printInfoPretty();
								//Delete student info of this student in file
								this.deleteLine(info, link);
								//Save new student info of this student in file
								this.saveToFile(student.printInfo(), link);	
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
		this.mapStudent = StudentInfoDAO.loadStudent(link);
		Integer studentId;
		Boolean check = true;
	    do {
	    	try{
				System.out.println("Nhập mã số sinh viên muốn xóa: ");
				studentId = scanner.nextInt();
		    	boolean checkId = true;
		    	boolean check1 = true;		    	
					if (this.mapStudent.get(studentId) != null) {		//find Student by student_id
						checkId = false;
						String key;
						scanner.nextLine();
						do {
							System.out.println("Bạn muốn xóa sinh viên có mã " + studentId + ": Y/N");
							key = scanner.nextLine();
							switch (key) {
							case "Y":
								//Delete line have info student in file
								this.deleteLine(this.mapStudent.get(studentId).printInfo(), link);
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
	public void sortBy(String type) {
		//Get list StudentInfo from file
		this.mapStudent = StudentInfoDAO.loadStudent("E:\\JavaTraining\\Student_manager\\StudentInfoDAO.txt");
		if(type.equals(SortBy.SortbyGPA.getvalue())) {		//Sort by GPA
			TreeSet<StudentInfo> studentTree = StudentInfoDAO.loadByGPA("E:\\JavaTraining\\Student_manager\\StudentInfoDAO.txt");
			this.sortByGPA(studentTree);
		}else {
			if(type.equals(SortBy.SortByName.getvalue())) {		//Sort by Name
				this.sortByName(this.mapStudent);
			}
		}
	}

//	public void sortByGPA(HashMap<Integer, StudentInfo> mapStudent) {
//		List<Map.Entry<Integer, StudentInfo>> entryList = new ArrayList<Map.Entry<Integer, StudentInfo>>(
//				mapStudent.entrySet());
//		Collections.sort(entryList, new Comparator<Map.Entry<Integer, StudentInfo>>() {
//			@Override
//			public int compare(Map.Entry<Integer, StudentInfo> integerStudentInfoEntry,
//					Map.Entry<Integer, StudentInfo> integerStudentInfoEntry2) {
//				return integerStudentInfoEntry.getValue().getAverageScore()
//						.compareTo(integerStudentInfoEntry2.getValue().getAverageScore());
//			}
//		});
//		entryList.forEach(entry -> {
//			entry.getValue().printInfoPretty();
//		});
//	}
	public void sortByGPA(TreeSet<StudentInfo> studentTree) {
		for (StudentInfo student : studentTree) {
            student.printInfoPretty();
        }
	}
	public void sortByName(HashMap<Integer,StudentInfo> mapStudent) {
		mapStudent.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Integer, StudentInfo>comparingByKey())
		  .forEach(entry -> {
			     entry.getValue().printInfoPretty();
		  }); 
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
	
	public void printCSV(String FileName, String Location) throws IOException {
		String File = Location+"\\"+FileName; // link file will write info
		FileOutputStream fout = null;
		this.mapStudent = StudentInfoDAO.loadStudent("E:\\JavaTraining\\Student_manager\\StudentInfoDAO.txt");
		try {
			fout = new FileOutputStream(File);
			OutputStreamWriter csvFile =  new OutputStreamWriter(fout);
			csvFile.write("Info_ID");
			csvFile.write(",");
			csvFile.write("Student_ID");
			csvFile.write(",");
			csvFile.write("Address");
			csvFile.write(",");
			csvFile.write("Score");
			csvFile.write(",");
			csvFile.write("Date of birth");
			csvFile.write("\n");
            for (Integer key : this.mapStudent.keySet()) {            	
            	csvFile.write(String.valueOf(this.mapStudent.get(key).getInfoId()));
            	csvFile.write(",");
            	csvFile.write(String.valueOf(this.mapStudent.get(key).getStudentId()));
            	csvFile.write(",");
            	String address = String.valueOf(this.mapStudent.get(key).getAddress());
            	address = address.replaceAll(",", "-");
            	csvFile.write(address);
            	csvFile.write(",");
            	csvFile.write(String.valueOf(this.mapStudent.get(key).getAverageScore()));
            	csvFile.write(",");
            	
            	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            	String date = format.format(this.mapStudent.get(key).getDayOfBirth());
            	csvFile.write(date);
            	csvFile.write("\n");
            }
            System.out.println("Xuất file thành công: "+Location+"\\"+FileName);
            csvFile.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // close file output stream
            fout.close();
        }
	}

	public void showStudent(String link) {
		//Load list StudentInfo from file
		this.mapStudent = StudentInfoDAO.loadStudent(link);
		mapStudent.forEach((key, value) -> {
            value.printInfoPretty();
        });
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
