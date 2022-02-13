package ResponseVerification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class VerifyUsingDataProviderTest {
@Test(dataProvider="getData")
	public void create(String createdBy,String projectName,String status,int teamzise) {
	
	
	Object pojo = new PojoClass(createdBy,projectName,status,teamzise);
	given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.log().all();
	
		
	}
@DataProvider
public Object[][] getData(){
	Object[][] objArray=new Object[2][4];
	objArray[0][0]="karthik";
	objArray[0][1]="karthik project";
	objArray[0][2]="completed";
	objArray[0][3]=250;
	
	objArray[1][0]="apoorva";
	objArray[1][1]="apoorva project";
	objArray[1][2]="on going";
	objArray[1][3]=300;
	
	
	return objArray;
	
	
	
}




}
