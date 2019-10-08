package new_Package;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import pkg_DAO.StudentInfoDAO;
import pkg_Info.StudentInfo;



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
	public void add(String link) {		
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
			StudentInfo newstudent = new StudentInfo(info_id,student_id,add,score,birth_day);
			this.save(newstudent.printInfo(), link);
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
	public void edit(String link) {
		this.listStudent = StudentInfoDAO.loadStudent(link);
		Integer student_id;
		System.out.println("Nhập mã số sinh viên: ");
    	student_id = scanner.nextInt();
    	boolean check = true;
    	for (StudentInfo list : this.listStudent) {
			if (list.getStudentId() == student_id) {
				check = false;
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
						list.printInfoPretty();;
						this.delete(info, link);
						this.save(list.printInfo(), link);
						break;
					case 0:
						c = false;
						break;
					default:
						System.out.println("Vui lòng nhập số từ 0 - 6!");
						break;
					}
				}while(c);
			}
		}
    	if(check) {
    		System.out.println("Sinh viên có mã số "+student_id+" không tồn tại!");
    	}
	}
	public void remove(String link) {
		List<StudentInfo> student = new ArrayList<StudentInfo>();
		student = StudentInfoDAO.loadStudent(link);
		Integer id;
		System.out.println("Nhập mã số sinh viên muốn xóa: ");
    	id = scanner.nextInt();
    	boolean check = true;
    	for (StudentInfo list : student) {
			if (list.getStudentId() == id) {
				check = false;
				String key;
				System.out.println("Bạn muốn xóa sinh viên có mã "+id+": Y/N");
				scanner.nextLine();
				key = scanner.nextLine();
				switch (key) {
				case "Y":
					this.delete(list.printInfo(), link);
					System.out.println("Xóa thành công");
					break;
				case "N":
					break;
				default:
					System.out.println("Vui lòng xác nhận Y hoặc N!");
					break;
				}
			}
    	}
    	if(check) {
    		System.out.println("Sinh viên có mã số "+id+" không tồn tại!");
    	}
	}
	public void sortGPA(List<StudentInfo> student) {
		StudentInfo temp;
		for (int i = 0; i < student.size(); i++) {
			for (int j = 0; j < student.size(); j++) {
				if(student.get(i).getAvegareScore() > student.get(j).getAvegareScore()) {
					temp =student.get(i);
					student.set(i, student.get(j));
					student.set(j, temp);
				}
			}
		}
		for (StudentInfo list : student) {
			list.printInfoPretty();
		}
	}
	public void sortByName(List<StudentInfo> student) {
		StudentInfo temp;
		for (int i = 0; i < student.size(); i++) {
			for (int j = 0; j < student.size(); j++) {
				if(student.get(i).getStudentId() > student.get(j).getStudentId()) {
					temp =student.get(i);
					student.set(i, student.get(j));
					student.set(j, temp);
				}
			}
		}
		for (StudentInfo list : student) {
			list.printInfoPretty();
		}
	}
	public void save(String info, String link) {
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
	public void show(List<StudentInfo> student) {
		for (StudentInfo list : student) {
			list.printInfoPretty();
		}
	}
}
