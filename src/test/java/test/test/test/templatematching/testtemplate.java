package test.test.test.templatematching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;
import test.test.test.adb.adbCommand;

public class testtemplate {

	private static String mainImgPath = "C:\\img\\screen2.png";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		test ();
	}

	public static String test () throws InterruptedException {
		String OS = System.getProperty("os.name").toLowerCase();
		//String mainFilePath="C:\\img\\screen2.png";
		String subFilePath="C:\\img\\sub\\";
		String dayFilePath="C:\\img\\day\\reverse\\";
		
		
		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}

		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
		
		adbCommand pb = new adbCommand();
		pb.click("435 229");
		//
		Thread.sleep(1000);
		//
		pb.capture(mainImgPath);
		//
		Thread.sleep(1000);
		
		final Mat source = Imgcodecs.imread(mainImgPath);
		final Mat template = Imgcodecs.imread(dayFilePath+"reverseCancel.png");
		Mat outputImage=new Mat();   
		
		Imgproc.matchTemplate(source, template, outputImage, 0);


		MinMaxLocResult mmr = org.opencv.core.Core.minMaxLoc(outputImage);
		
		System.out.println((int)mmr.minVal);
		System.out.println((int)mmr.maxVal);
				
		System.out.println("X = " + (source.rows() - (mmr.minLoc.y+template.rows())));
		//System.out.println(350);
		System.out.println("Y = " + (mmr.minLoc.x+template.cols()));
		//System.out.println(600);
		
		Point matchLoc=mmr.minLoc;
		Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
				matchLoc.y + template.rows()), new Scalar(255, 255, 255));
		Imgcodecs.imwrite(dayFilePath+"_"+0+" sonuc.jpg", source);
		        System.out.println("Complated.");
		
		return null;
	}
}
