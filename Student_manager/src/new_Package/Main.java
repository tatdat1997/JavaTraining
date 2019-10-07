package new_Package;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import new_Package.StudentInfo;
import new_Package.StudentInfoDAO;

public class Main {
	public static void main(String args[]){
	String link ="E:/Bài Tập/StudentInfoDAO.txt";
	int student_id;
	StudentInfoDAO fst = new StudentInfoDAO();
	List<StudentInfo> student = new ArrayList<StudentInfo>();
	student = fst.newList(link);
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	Scanner scanner = new Scanner(System.in);
    System.out.println("======== Quản lý thông tin sinh viên ========");
    System.out.println("=     1. Tạo mới sinh viên.                 =");
    System.out.println("=     2. Sửa thông tin sinh viên theo ID.   =");
    System.out.println("=     3. Xóa sinh viên theo ID_SV           =");
    System.out.println("=     4. Sắp xếp.                           =");
    System.out.println("=     5. Xem danh sách sinh viên.           =");
    System.out.println("=     0. Thoát                              =");
    System.out.println("=============================================");
    System.out.println("");
    Integer num;
    Boolean end = true;
    do {
    	System.out.println("Mời bạn chọn thao tác (0-6):");
        num = scanner.nextInt();
//        String info;
	    switch (num) { 
	        case 1:
	        	fst.add(link);
				break;
	        case 2:
	        	System.out.println("Nhập mã số sinh viên: ");
	        	student_id = scanner.nextInt();
	        	for (StudentInfo list : student) {
					if (list.student_id == student_id) {
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
								String info_id_change;
								System.out.print("Mã số thông tin: ");
								scanner.nextLine();
								info_id_change = scanner.nextLine();
								list.editInfo_id(Integer.parseInt(info_id_change));
								System.out.println();
								break;
							case 2:
								String student_id_change;
								System.out.print("Mã số sinh viên: ");
								scanner.nextLine();
								student_id_change = scanner.nextLine();
								list.editStudent_id(Integer.parseInt(student_id_change));
								System.out.println();
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
								System.out.println();
								break;
							case 5:
								String birth_day_old;
								System.out.print("Ngày sinh: ");
								scanner.nextLine();
								birth_day_old = scanner.nextLine();
								try {
									
									Date birth_change = format.parse(birth_day_old);
									list.editBirth(birth_change);
									System.out.println();
								}catch(Exception e) {
				                    e.printStackTrace();
				                }
								break;
							case 6:
								System.out.println("Thay đổi thông tin thành công: ");
								list.printInfoPretty();;
								fst.delete(info, link);
								fst.save(list.printInfo(), link);
								break;
							case 0:
								c = false;
								break;
							default:
								break;
							}
						}while(c);
					}
				}
				break;
	        case 3:
	        	System.out.println("Nhập mã số sinh viên muốn xóa: ");
	        	student_id = scanner.nextInt();
	        	for (StudentInfo list : student) {
					if (list.student_id == student_id) {
						String key;
						System.out.println("Bạn muốn xóa sinh viên có mã "+student_id+": Y/N");
						scanner.nextLine();
						key = scanner.nextLine();
						switch (key) {
						case "Y":
							fst.delete(list.printInfo(), link);
							System.out.println("Xóa thành công");
							break;
						case "N":
							break;
						default:
							break;
						}
					}
	        	}
				break;
	        case 4:
	        	System.out.println("--------------Sắp xếp-------------");
				System.out.println("|    1 - Sắp xếp theo GPA.        |");
				System.out.println("|    2 - Sắp xếp theo Student ID. |");
				System.out.println("|    0 - Trở lại.                 |");
				System.out.println("-----------------------------------");
				Boolean check = true;
				Integer number;
				do {
					System.out.println("Chọn kiểu sắp xếp: ");
					number = scanner.nextInt();
					switch (number) {
					case 1:
						System.out.println("Danh sách sinh viên ban đầu: ");
						for (StudentInfo list : student) {
							list.printInfoPretty();
						}
						System.out.println("Danh sách sinh viên sau khi sắp xếp: ");
						List<StudentInfo> student_new=fst.sortGPA(student);
						for (StudentInfo list : student_new) {
							list.printInfoPretty();
						}
						break;
					case 2:
						System.out.println("Danh sách sinh viên ban đầu: ");
						for (StudentInfo list : student) {
							list.printInfoPretty();
						}
						System.out.println("Danh sách sinh viên sau khi sắp xếp: ");
						student_new = fst.sortByName(student);
						for (StudentInfo list : student_new) {
							list.printInfoPretty();
						}
						break;
					case 0:
						check = false;
						break;
					default:
						break;
					}
					}while(check);
				break;
			case 6:
				System.out.println("Danh sách sinh viên: ");
				for (StudentInfo list : student) {
					list.printInfoPretty();
				}
				break;
			case 0:
				end = false;
				break;	
			default:
				break;
			}
    	}while(end);
    scanner.close();
	}
}
