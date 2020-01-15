package test.test.test.opencv;

import org.opencv.core.Mat;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;

public class OpenCvService {
	
	private String OS = System.getProperty("os.name").toLowerCase();
	private Mat mainImg;
	private Mat compareImg;
	private Mat resultImg;
	private MinMaxLocResult mmr;

	
	public OpenCvService () {
		
		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}
		
		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
	}
	
	public boolean compare () {
	
		if (mmr.minVal < 10000000) {
			return true;
		}
		return false;
	}
	
	public void calMmr(int method) {
		Imgproc.matchTemplate(mainImg, compareImg, resultImg, method);
		mmr = org.opencv.core.Core.minMaxLoc(resultImg);
	}
	
	public Mat setMainImg(String file) {
		mainImg = Imgcodecs.imread(file);
		return mainImg;
	}
	
	public Mat setCompareImg(String file) {
		compareImg = Imgcodecs.imread(file);
		return compareImg;
	}
	
	public Mat setResultImg(String file) {
		resultImg = Imgcodecs.imread(file);
		return resultImg;
	}
	
	public void mainImageRelease() {
		mainImg.release();
	}
	
	public void compareImageRelease() {
		compareImg.release();
	}
	
	public void resultImageRelease() {
		resultImg.release();
	}

}
