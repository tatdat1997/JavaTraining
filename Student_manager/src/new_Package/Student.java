package new_Package;
import java.util.*; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Student {
	int info_id;
	String address,name;
	Double average_score;
	String day_of_birth;
	void add(int inf_id, String Name, String addr, Double score, String bd ) {
		info_id			= inf_id;
		name		= Name;
		address			= addr;
		average_score	= score;
		day_of_birth	= bd;
	}
	void show() {
		System.out.println("ID: "+info_id+"; Name: "+name+"; Address: "+address
				+"; Average score: "+average_score+"; Day of birth: "+day_of_birth);
	}
	
	public class StudentInfoDAO{
		public List<List<String>> newList(String link) {
			String linkFile = link;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        List<List<String>> student = new ArrayList<List<String>>();
	        try {
	        	br = new BufferedReader(new FileReader(linkFile));
	            while ((line = br.readLine()) != null) {
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                List<String> temp = new ArrayList<String>();
	                temp.add("Info_ID :"+info[0]);
	                temp.add("Student_ID: "+info[1]);
	                temp.add("Address: "+info[2]);
	                temp.add("Avenrage score: "+info[3]);
	                temp.add("Day of birth: "+info[4]);
	                student.add(temp);
	            }
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
	        finally {
	        	if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return student;
		}
	}
	
	public static void main(String args[]){  
		Student A = new Student();
		StudentInfoDAO list1;

		
		String csvFile = "E:/Bài Tập/StudentInfoDAO.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<List<String>> student = new ArrayList<List<String>>();
        try {
        	br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] info = line.split(cvsSplitBy);
                List<String> temp = new ArrayList<String>();
                temp.add("Info_ID :"+info[0]);
                temp.add("Student_ID: "+info[1]);
                temp.add("Address: "+info[2]);
                temp.add("Avenrage score: "+info[3]);
                temp.add("Day of birth: "+info[4]);
                student.add(temp);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
        	if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("======== Quản lý thông tin sinh viên ========");
        System.out.println("=     1. Tạo mới sinh viên.                 =");
        System.out.println("=     2. Sửa thông tin sinh viên theo ID.   =");
        System.out.println("=     3. Xóa sinh viên theo ID_SV           =");
        System.out.println("=                   Sắp xếp.                =");
        System.out.println("=     4. Sắp xếp theo info_ID.              =");
        System.out.println("=     5. Sắp xếp theo ID_SV.                =");
        System.out.println("=     6. Xem danh sách sinh viên.           =");
        System.out.println("=     0. Thoát                              =");
        System.out.println("=============================================");
        System.out.println("");
        Integer num;
        
        do{
        	System.out.println("Mời bạn chọn thao tác (0-6):");
            num = scanner.nextInt();
	        switch (num) { 
		        case 1:
		        	int info_id, student_id;
		        	String add,birth;
		        	Double score;
					System.out.println("Info ID: ");
					info_id = scanner.nextInt();
					System.out.println("Student ID: ");
					student_id = scanner.nextInt();
					System.out.println("Address: ");
					add = scanner.nextLine();
					System.out.println("Average score: ");
					score = scanner.nextDouble();
					System.out.println("Day of birth: ");
					birth = scanner.nextLine();
					break;
		        case 2:
					System.out.println();
					break;
		        case 3:
					System.out.println();
					break;
		        case 4:
					System.out.println();
					break;
		        case 5:
					System.out.println();
					break;
				case 6:
					System.out.println();
					break;
			default:
				break;
			}
        }while(num == 0);
        
	 }  
}

