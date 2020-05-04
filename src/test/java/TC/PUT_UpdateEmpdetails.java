package TC;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;
import Utills.RestUtills;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class PUT_UpdateEmpdetails extends Baseclass {
	
	static String uname= RestUtills.empname();
	static String age=RestUtills.empage();
	static String salary =RestUtills.empsalary();

	@BeforeClass
	public static void put() throws InterruptedException {
		logger.info("*********Started TC004_Put_Employee_Record **********");
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		httprequst=RestAssured.given();
		JSONObject json  = new JSONObject();
		json.put("name", uname);
		json.put("salary", salary);
		json.put("age", age);
		httprequst.header("Content-Type","application/json");
		
		httprequst.body(json.toJSONString());
		response = httprequst.request(Method.PUT,"/update/"+empid);
		Thread.sleep(3000);
		
	}
	@Test
	public void checkresponse() {
		
		String responsebody = response.getBody().asString();
		logger.info("Response body is ="+responsebody);
		
	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}

	@Test
	void checkserverType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}

	@Test
	void checkcontentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, null);

	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC004_Put_Employee_Record **********");
	}


	
	
	
}
