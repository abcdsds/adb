package test.test.test.adb;

import java.io.IOException;

public class adbCommand {

	private ProcessBuilder pb;
	private String env = "C:/Users/ds/Downloads/platform-tools/";
	
	public adbCommand() {
		this.pb = new ProcessBuilder().redirectErrorStream(true);
		pb.command("cmd.exe", "/c" , env+"adb usb");
		pb.command("cmd.exe", "/c" , env+"adb kill-server");
		pb.command("cmd.exe", "/c" , env+"adb start-server");
		
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void capture(String mainImgPath) {
		pb.command("cmd.exe", "/c" , env+"adb exec-out screencap -p > "+mainImgPath);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("capture Error : " + e);
			e.printStackTrace();
		}
	}
	
	public void click(String xy) {
		pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap "+xy);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("click Error : " + e);
			e.printStackTrace();
		}
	}
}
