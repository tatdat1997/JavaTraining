package new_Package;


import java.util.Scanner;
import pkg_Info.HumanInfo;
import pkg_Info.StudentInfo;

public class Main {
	
	public static void main(String args[]){
		
	HumanInfo person = new StudentInfo();
	person.setInfoId(1145);
	person.setDateOfBirth("26-1-1997");
	person.setAddress("LA");
	
	String link ="E:\\TrainningJava\\JavaTraining\\Student_manager\\StudentInfoDAO.txt";
	StudentInfoManager fst = new StudentInfoManager();
	Scanner scanner = new Scanner(System.in);
    System.out.println("======== Quản lý thông tin sinh viên ========");
    System.out.println("=     1. Tạo mới sinh viên.                 =");
    System.out.println("=     2. Sửa thông tin sinh viên theo ID.   =");
    System.out.println("=     3. Xóa sinh viên theo ID_SV           =");
    System.out.println("=     4. Sắp xếp theo GPA.                  =");
    System.out.println("=     5. Sắp xếp theo Student ID.           =");
    System.out.println("=     6. Xem danh sách sinh viên.           =");
    System.out.println("=     7. Xuất file CSV.                     =");
    System.out.println("=     0. Thoát                              =");
    System.out.println("=============================================");
    Integer num;
    Boolean end = true;
    do {
    	try {
    	System.out.println("Mời bạn chọn thao tác (0-7):");
        num = scanner.nextInt();
	    switch (num) { 
	        case 1:
	        	fst.addStudent(link);
				break;
	        case 2:
	        	fst.editStudent(link);
				break;
	        case 3:
	        	fst.removeStudent(link);
				break;
	        case 4:
	        	fst.sortBy("GPA");        //sort by GPA
				break;
	        case 5:
	        	fst.sortBy("Name");       //sort by Name
	        	break;
			case 6:
				fst.showStudent(link);
				break;
			case 7:
				fst.printCSV("CSV_DEMO.TXT", "E:\\TrainningJava\\JavaTraining\\Student_manager");
				break;
			case 0:
				end = false;
				break;	
			default:
				System.out.println("Vui lòng nhập số từ 0 - 6!");
				break;
			}
    	} catch (Exception e) {
    		System.out.println("Có lỗi trong qúa trình xử lý!?! Vui lòng nhập số từ 0 - 6!");
    		scanner.nextLine();
    	}
	} while (end);
    scanner.close();
	}
}
