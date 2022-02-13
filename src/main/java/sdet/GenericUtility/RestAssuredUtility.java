package sdet.GenericUtility;

import io.restassured.response.Response;
/**
 *  this class coints generic method specific to rest assured
 * @author Dell
 *
 */

public class RestAssuredUtility {
	
	/**
	 * 
	 *this method will return the json data for the json path specified 
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
       
	
	public String getJSONData(Response resp,String jsonPath ) {
	 String jsonData=resp.jsonPath().get(jsonPath);
	 return jsonData;
	}
}
