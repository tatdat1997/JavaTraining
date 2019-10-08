package new_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pkg_DAO.StudentInfoDAO;
import pkg_Info.HumanInfo;
import pkg_Info.StudentInfo;

public class Main {
	public static void main(String args[]){
	HumanInfo person = new StudentInfo();
	person.setInfoId(1145);
	String link ="E:/Bài Tập/StudentInfoDAO.txt";
	StudentInfoManager fst = new StudentInfoManager();
	List<StudentInfo> student = new ArrayList<StudentInfo>();
	student = StudentInfoDAO.loadStudent(link);
	Scanner scanner = new Scanner(System.in);
    System.out.println("======== Quản lý thông tin sinh viên ========");
    System.out.println("=     1. Tạo mới sinh viên.                 =");
    System.out.println("=     2. Sửa thông tin sinh viên theo ID.   =");
    System.out.println("=     3. Xóa sinh viên theo ID_SV           =");
    System.out.println("=     4. Sắp xếp theo GPA.                  =");
    System.out.println("=     5. Sắp xếp theo Student ID.           =");
    System.out.println("=     6. Xem danh sách sinh viên.           =");
    System.out.println("=     0. Thoát                              =");
    System.out.println("=============================================");
    Integer num;
    Boolean end = true;
    do {
    	System.out.println("Mời bạn chọn thao tác (0-6):");
        num = scanner.nextInt();
	    switch (num) { 
	        case 1:
	        	fst.add(link);
				break;
	        case 2:
	        	fst.edit(link);
				break;
	        case 3:
	        	fst.remove(link);
				break;
	        case 4:
	        	fst.sortBy(SortBy.GPA);
				break;
	        case 5:
	        	fst.sortBy(SortBy.Name);
	        	break;
			case 6:
				fst.show(student);
				break;
			case 0:
				end = false;
				break;	
			default:
				System.out.println("Vui lòng nhập số từ 0 - 6!");
				break;
			}
    	}while(end);
    scanner.close();
	}
}
