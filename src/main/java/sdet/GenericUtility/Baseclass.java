package sdet.GenericUtility;

import static io.restassured.RestAssured.*;

import org.junit.Before;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class Baseclass {
	public DataBaseUtility dlib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	
	
	
	@BeforeSuite
	
public void basicConfig() throws Throwable {

	baseURI="http://localhost";
	port=8084;
	dlib.connectDb();
	System.out.println("=========database connected==========");
}
@AfterSuite
public void config() throws Throwable {
	
	dlib.closeDb();
	System.out.println("==========database closed=============");
	
	
}



}
