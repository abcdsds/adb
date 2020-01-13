package test.test.test.opencv;

import nu.pattern.OpenCV;

public class OpenCvInit {
	
	private String OS = System.getProperty("os.name").toLowerCase();
	
	public OpenCvInit () {
		
		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}
		
		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
	}

}
