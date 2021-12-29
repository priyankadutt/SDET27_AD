package work;

import com.crm.autodesk.genericUtility.JavaUtility;

public class Date {
	
	public static void main(String[] args) {
		
		JavaUtility ju = new JavaUtility();
		String date = ju.getSystemDateAndTime();
		System.out.println(date);
	}

}
