package test.test.test.templatematching;

import org.json.JSONObject;
import org.junit.Test;

import test.test.test.util.JsonService;

public class test extends JsonService {

	private String ragnarFilePath = "C:\\Users\\ds\\Downloads\\DesKidRagnarLocationXY.json";
	private String globalFilePath = "C:\\Users\\ds\\Downloads\\DesKidGlobalLocationXY.json";
	
	
	@Test
	public void dkTest() {

		JSONObject ragnarJo = getJsonObject(ragnarFilePath);
		System.out.println(ragnarJo.getJSONObject("DesKidRagnarLocationXY").getJSONObject("needTicket").get("1"));
		
		JSONObject globalJo = getJsonObject(globalFilePath);
		System.out.println(globalJo.getJSONObject("DesKidGlobalLocationXY").get("Home"));
		
	}
}
