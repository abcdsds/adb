package test.test.test.util;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.opencv.core.Mat;

public class uitls{

	
	public static JSONObject getJsonObject(String filePath) {
		try {
			
			JSONTokener jsonTokener = new JSONTokener(new FileReader(new File(filePath)));
			return (JSONObject) jsonTokener.nextValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static JSONArray getJsonArray(String filePath) {
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
