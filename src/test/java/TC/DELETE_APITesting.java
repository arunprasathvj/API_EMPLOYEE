package TC;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class DELETE_APITesting extends Baseclass {

	
	@BeforeClass
	public void delect() throws InterruptedException {
		logger.info("*********Started TC005_Delete_Employee_Record **********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequst= RestAssured.given();
		response = httprequst.request(Method.GET,"/employees");
		JsonPath jsonresponse=response.jsonPath();
		String empID =jsonresponse.get("[0].id");
		response = httprequst.request(Method.DELETE,"/delete/"+empID);
		Thread.sleep(3000);
	}
	@Test
	void checkresponsebody() {
		
		String responsebody = response.getBody().asString();
		logger.info("Response Body = "+responsebody);
		
		
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
		logger.info("*********  Finished TC005_Delete_Employee_Record **********");
	}
} 
