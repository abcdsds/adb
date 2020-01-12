package test.test.test.templatematching;

import org.opencv.core.Mat;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;

public class testtemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test ();
	}

	public static String test () {
		String OS = System.getProperty("os.name").toLowerCase();
		String mainFilePath="C:\\img\\";
		String subFilePath="C:\\img\\sub\\";
		
		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}

		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
		
		final Mat source = Imgcodecs.imread(mainFilePath+"screen.png");
		final Mat template = Imgcodecs.imread(subFilePath+"fight_2.png");
		Mat outputImage=new Mat();   
		
		Imgproc.matchTemplate(source, template, outputImage, 0);


		MinMaxLocResult mmr = org.opencv.core.Core.minMaxLoc(outputImage);
		
		System.out.println((int)mmr.minVal);
		
		return null;
	}
}
