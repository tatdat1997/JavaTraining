package new_Package;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {
	public static void main(String[] args) {
		Locale localeEn = new Locale("en");
		ResourceBundle labels = ResourceBundle.getBundle("messages", localeEn);
		System.out.println("======== Quản lý thông tin sinh viên ========");
	    System.out.println("=     "+labels.getString("case_1")+"        =");
	    System.out.println("=     "+labels.getString("case_2")+"        =");
	    System.out.println("=     "+labels.getString("case_3")+"        =");
	    System.out.println("=     "+labels.getString("case_4")+"        =");
	    System.out.println("=     "+labels.getString("case_5")+"        =");
	    System.out.println("=     "+labels.getString("case_6")+"        =");
	    System.out.println("=     "+labels.getString("case_7")+"        =");
	    System.out.println("=     "+labels.getString("case_8")+"        =");
	    System.out.println("=     "+labels.getString("case_9")+"        =");
	    System.out.println("=     "+labels.getString("case_0")+"        =");
	    System.out.println("=============================================");
	}
}
