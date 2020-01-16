package test.test.test.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class JsonService {

	public JSONObject getJsonObject(String filePath) {
		try {
			
			JSONTokener jsonTokener = new JSONTokener(new FileReader(new File(filePath)));
			return (JSONObject) jsonTokener.nextValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONArray getJsonArray(String filePath) {
		try {
			
			JSONTokener jsonTokener = new JSONTokener(new FileReader(new File(filePath)));
			return (JSONArray) jsonTokener.nextValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
