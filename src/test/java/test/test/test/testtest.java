package test.test.test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class testtest {

	public static void main (String[] args) throws IOException, InterruptedException { 


		ProcessBuilder pb = new ProcessBuilder().redirectErrorStream(true);

		///////////////////////////////////////////////////////////// ȯ�溯�� �������°� 
		//		Map<String, String> map = pb.environment();
		//		Set<String> keys = map.keySet();
		// 		for (String key : keys) {
		//			System.out.println(key + " : " +map.get(key));
		//		}		
		//////////////////////////////////////////////////////////////

		String env = "C:/Users/ds/Downloads/platform-tools/";
		//pb.directory(new File("C:\\"));
		//pb.command("cmd.exe","/c adb -s emulator-5554 shell getevent");
		pb.command("cmd.exe", "/c" , env+"adb devices -l");
		//pb.command("cmd.exe", "/c" , env+"adb -s emulator-5554 shell getevent");

		final Process process = pb.start();
		final StringWriter writer = new StringWriter();

		System.out.println("�ڤӤ�����");
		Thread.sleep(2000);
		System.out.println("��� ��");
		new Thread(new Runnable() {
			public void run() {
				try {
					IOUtils.copy(process.getInputStream(), writer);
					System.out.println("���� �Ϸ�");
					System.out.println(writer.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		final int exitValue = process.waitFor();
		final String processOutput = writer.toString();
		System.out.println(processOutput);

		//		Process process = pb.start();
		//		
		//		BufferedReader reader = 
		//				new BufferedReader(new InputStreamReader(process.getInputStream()));
		//		StringBuilder builder = new StringBuilder();
		//		String line = null;
		//		while ( (line = reader.readLine()) != null) {
		//			builder.append(line);
		//			builder.append(System.getProperty("line.separator"));
		//		}
		//		String result = builder.toString();
		//
		//		System.out.println(result);

		//		System.out.println("����");
		//String output = IOUtils.toString(pb.start().getInputStream());
		//	    
		//		System.out.println("������");
		//System.out.println(output);
		//		
		//		System.out.println(getHexToDec("0000005e"));
		//3 57 94
	}

	/**
	 * Hex -> 10���� ��ȯ
	 * @param hex
	 * @return
	 */
	private static String getHexToDec(String hex) {
		long v = Long.parseLong(hex, 16);  
		return String.valueOf(v);
	}

	/**
	 * 10���� -> Hex ��ȯ
	 * @param dec
	 * @return
	 */
	private String getDecToHex(String dec){

		Long intDec = Long.parseLong(dec);
		return Long.toHexString(intDec).toUpperCase();
	}
}

