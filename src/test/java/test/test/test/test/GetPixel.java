package test.test.test.test;

import java.util.Arrays;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


import test.test.test.opencv.OpenCvService;

public class GetPixel {

	private static String mainImgPath = "C:\\img\\screen2.png";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenCvService openCvService = new OpenCvService();
		
		
		
		Mat A = openCvService.setMainImg(mainImgPath,Imgcodecs.IMREAD_COLOR);
		int x = 962;
		int y = 107;
		
		int size = (int) (A.total() * A.channels());
		byte[] temp = new byte[size]; // use double[] instead of byte[]
		
		System.out.println(A.channels());
		System.out.println(A.get(x, y,temp));
		System.out.println(Imgcodecs.imread(mainImgPath).get(x, y));
		
		
//		Mat C = A.clone();
//		A.convertTo(A, CvType.CV_64FC3); //New line added. 
//		int size = (int) (A.total() * A.channels());
//		double[] temp = new double[size]; // use double[] instead of byte[]
//		A.get(0, 0, temp);
//		for (int i = 0; i < size; i++)
//		   temp[i] = (temp[i] / 2);  // no more casting required.
//		C.put(0, 0, temp);
//		
//		System.out.println(C.`);
//		
//		A.release();
	}

}
