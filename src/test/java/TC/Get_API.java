package TC;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;
import io.restassured.RestAssured;
import io.restassured.http.Method;


public class Get_API extends Baseclass {
	
	@BeforeClass
	 void get() throws InterruptedException {
		
		logger.info(" ***** Method is Started *******");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequst = RestAssured.given();
		response = httprequst.request(Method.GET,"/employees");	
		Thread.sleep(5000);
		
	}
	
	@Test
	public void responsebody() {
		String responsebody = response.getBody().asString();
		logger.info("Response Body  is "+responsebody);
		
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
	@Test
	public void checkcontentencoding() {
		String contentencoding = response.header("Content-Encoding");
		logger.info("encoding is ="+ contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
		
	}
	@Test
	public void checkcontentlength() {
		String contentlenght = response.header("Content-Length");
		
		logger.info("content lenght is ="+ contentlenght);
		if(Integer.parseInt(contentlenght)<100)
			logger.warn("Lenth is lessthen 100");
		
		Assert.assertTrue(Integer.parseInt(contentlenght)>100);
		
	}
	
	@Test
	public void checkresponsetime() {
		long responsetime = response.getTime();
		logger.info("content lenght is ="+ responsetime);
		if(responsetime>2000)
			logger.warn("time to over ");
		
		Assert.assertTrue(responsetime<10000);
		
	}
	
	@AfterClass
	void teardown () {
		
		logger.info("****** All Methods Are Pass ******");
	}
}
