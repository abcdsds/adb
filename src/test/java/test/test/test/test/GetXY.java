package test.test.test.test;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

import test.test.test.adb.adbCommand;
import test.test.test.opencv.OpenCvService;
import test.test.test.util.uitls;

public class GetXY extends uitls{

	private static String mainImgPath = "C:\\img\\screen2.png";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mode = "descild";
		
		adbCommand pb = new adbCommand();
		pb.capture(mainImgPath);
		
		OpenCvService openCvService = new OpenCvService();

		JFrame frame = openCvService.CreateFrame("Test",openCvService.toBufferedImage(openCvService.setMainImg(mainImgPath)),mode);
		frame.setVisible(true);
		
	}
}
