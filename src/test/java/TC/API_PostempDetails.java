package TC;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;
import Utills.RestUtills;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class API_PostempDetails extends Baseclass {
	
	String empname = RestUtills.empname();
	String salary = RestUtills.empsalary();
	String age = RestUtills.empage();
   @BeforeClass
	void post() throws InterruptedException {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequst = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("name", empname);
		json.put("salary", salary);
		json.put("age", age);
		httprequst.header("Content-Type", "application/json");
		httprequst.body(json.toJSONString());
		
		response = httprequst.request(Method.POST,"/create");
		Thread.sleep(2000);
	}
   
   @Test
	void checkresponse () {
		String responsebody = response.getBody().asString();
		logger.info("Ressponse Body is ="+ responsebody);
		Assert.assertEquals(responsebody.contains(empname), true);
		Assert.assertEquals(responsebody.contains(salary), true);
		Assert.assertEquals(responsebody.contains(age), true);
	
	}
	@Test
	public void checkstatuscode() {
		int statuscode = response.getStatusCode();
		logger.info("status code is ="+ statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test
	public void checkstatusline() {
		String statusline = response.getStatusLine();
		logger.info("status Line is ="+ statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
	@Test
	public void checkcontenttype() {
		String contenttype = response.header("Content-Type");
		logger.info("content type is ="+ contenttype);
		Assert.assertEquals(contenttype, "application/json;charset=utf-8");
		
	}
	@Test
	public void checkserver() {
		String serve = response.header("Server");
		logger.info("server type is ="+ serve);
		Assert.assertEquals(serve, "nginx/1.16.0");
		
	}
	
	
	@AfterClass
	void teardown () {
		
		logger.info("****** All Methods Are Pass ******");
	}
	
	
}
