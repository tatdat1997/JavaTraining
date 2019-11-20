package java_core;

import java.io.FileReader;
import java.util.Properties;

public class Demo_Properties {
	public static void main(String[] args) throws Exception {
        // create reader object
        FileReader reader = new FileReader("config.properties");
 
        // crate properties object
        Properties properties = new Properties();
        properties.load(reader);
 
        // show file info
        System.out.println(properties.getProperty("siteName"));
        System.out.println(properties.getProperty("siteUrl"));
        System.out.println(properties.getProperty("DB"));        
    }
}
