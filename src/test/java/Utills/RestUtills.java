package Utills;

import org.apache.commons.lang3.RandomStringUtils;

import net.bytebuddy.utility.RandomString;

public class RestUtills {
	
	public static  String empname() {
		
		String genaratestring = RandomStringUtils.randomAlphabetic(1);
		return ("arun"+genaratestring);
	}
public static String empsalary() {
		
		String genaratestring = RandomStringUtils.randomNumeric(5);
		return (genaratestring);
	}

public static String empage() {
	
	String genaratestring = RandomStringUtils.randomNumeric(2);
	return (genaratestring);
}

}
