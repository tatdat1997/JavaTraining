package java_core;

import java.io.*;

public class File_Demo {
	public static void main(String[] args) throws Exception {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("E:\\PLSQL_DOC\\Book2.csv"));
			out.write("aString1\n");
			out.close();
			boolean success = (new File("E:\\PLSQL_DOC\\Book1.csv")).delete();
			if (success) {
				System.out.println("The file has been successfully deleted");
			}
			BufferedReader in = new BufferedReader(new FileReader("E:\\PLSQL_DOC\\Book2.csv"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("exception occoured " + e);
			System.out.println("File does not exist or you are trying to read a file that has been deleted");
		}
	}
}
