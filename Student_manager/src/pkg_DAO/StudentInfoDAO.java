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


/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoDAO class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public class StudentInfoDAO{
	/*
	 * Load list student from file list student
	 */
	public static List<StudentInfo> loadStudent(String link) {
		String linkFile = link;
        BufferedReader br = null;
        String line = "";
		List<StudentInfo> studentList = new ArrayList<StudentInfo>();
		try {
        	br = new BufferedReader(new FileReader(linkFile));
            while ((line = br.readLine()) != null) {
                //Split at | to get info
                String[] info = line.split("\\|");
                //Create new StudentInfo
                StudentInfo student1 = new StudentInfo(Integer.parseInt(info[0]), Integer.parseInt(info[1]),
                						info[2], Double.parseDouble(info[3]), info[4]);
                //Add new StudentInfo in List Student
                studentList.add(student1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return studentList;
	}
	/*
	 * Save student in file list student
	 */
	public void saveToFile(String info, String link) {
		String file = link; // link file will write info
		try(FileWriter fw = new FileWriter(file, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(info);
		  
		} catch (IOException e) {
			e.printStackTrace();
		    //Exception handling left as an exercise for the reader
		}
	}
}

