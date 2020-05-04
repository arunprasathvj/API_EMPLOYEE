package Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	public static RequestSpecification httprequst;
	public static Logger logger ;
	public static  Response response; 
	public static String empid="44" ;
	
	@BeforeClass
	public void startup() {
		
		logger = Logger.getLogger("My Api Project");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}
	

}
