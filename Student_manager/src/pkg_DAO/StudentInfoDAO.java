package pkg_DAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import pkg_Info.StudentInfo;

import java.text.SimpleDateFormat;

public class StudentInfoDAO{
	public static List<StudentInfo> loadStudent(String link) {
		String linkFile = link;
        BufferedReader br = null;
        String line = "";
		List<StudentInfo> student = new ArrayList<StudentInfo>();
		try {
        	br = new BufferedReader(new FileReader(linkFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
            	
                String[] info = line.split(",");
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                try {
	                java.util.Date birth = sdf.parse(info[4]); 
	                
	                StudentInfo student1 = new StudentInfo(Integer.parseInt(info[0]),Integer.parseInt(info[1]),info[2],
	                		Double.parseDouble(info[3]),birth);
	                student.add(student1);
                }catch(Exception e) {
                    e.printStackTrace();
                }
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
}

