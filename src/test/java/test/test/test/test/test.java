package test.test.test.test;

import test.test.test.opencv.OpenCvService;
import test.test.test.pb.PbServices;

public class test {

	private static String env = "C:/Users/ds/Downloads/platform-tools/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PbServices pbServices = new PbServices();
		OpenCvService openCv = new OpenCvService();
		
		pbServices.startPb("cmd.exe", "/c" , env+"adb shell input touchscreen tap 500 200");
		
	}

}
