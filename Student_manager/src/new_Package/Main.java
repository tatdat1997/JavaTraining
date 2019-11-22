package new_Package;


import java.util.Locale;
import java.util.ResourceBundle;
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
	Locale localeEn = null;
    System.out.println("======  Ngôn ngữ - Language  ======");
    System.out.println("=           1. English.           =");
    System.out.println("=           2. Việt Nam.          =");
    System.out.println("=           0. Thoát/Exit.        =");
    System.out.println("===================================");
    String c;
    Boolean stop = true;
    do {
    	try {
    		System.out.println("Vui lòng chọn ngôn ngữ! - Plaese select language:");
        c = scanner.nextLine();
	    switch (c) { 
	        case "1":
	        	localeEn = new Locale("en");
	        	stop = false;
				break;
	        case "2":
	        	localeEn = new Locale("vi");
	        	stop = false;
				break;
	        case "0":
	        	stop = false;
				break;
			default:
				System.out.println("Vui lòng chọn ngôn ngữ! - Plaese select language!");
				break;
			}
    	} catch (Exception e) {
    		System.out.println("Có lỗi trong qúa trình xử lý!?! Vui lòng nhập số từ 0 - 9!");
    		scanner.nextLine();
    	}
	} while (stop);
    ResourceBundle labels = ResourceBundle.getBundle("messages", localeEn);
    System.out.println(labels.getString("case_title"));
    System.out.println(labels.getString("case_1"));
    System.out.println(labels.getString("case_2"));
    System.out.println(labels.getString("case_3"));
    System.out.println(labels.getString("case_4"));
    System.out.println(labels.getString("case_5"));
    System.out.println(labels.getString("case_6"));
    System.out.println(labels.getString("case_7"));
    System.out.println(labels.getString("case_8"));
    System.out.println(labels.getString("case_9"));
    System.out.println(labels.getString("case_0"));
    System.out.println("============================================");
    Integer num;
    Boolean end = true;
    do {
    	try {
    	System.out.println(labels.getString("msg1"));
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
				fst.printCSV("E:\\TrainningJava\\JavaTraining\\Student_manager\\CSV_DEMO.CSV",link);
				break;
			case 8:
				fst.printStudentInfo("E:\\TrainningJava\\JavaTraining\\Student_manager\\Ob1_Student.TXT", link);
				break;
			case 9:
				fst.readStudentInfo("E:\\TrainningJava\\JavaTraining\\Student_manager\\Ob1_Student.TXT");
				break;
			case 0:
				end = false;
				break;	
			default:
				System.out.println(labels.getString("msg2"));
				break;
			}
    	} catch (Exception e) {
    		System.out.println(labels.getString("error1"));
    		scanner.nextLine();
    	}
	} while (end);
    scanner.close();
	}
}
