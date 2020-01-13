package test.test.test.templatematching;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.opencv.core.Core.MinMaxLocResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;

public class templatematching {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub


		String OS = System.getProperty("os.name").toLowerCase();
		String env = "C:/Users/ds/Downloads/platform-tools/";
		String mainFilePath="C:\\img\\";
		String subFilePath="C:\\img\\sub\\";
		File f = new File(subFilePath);


		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}

		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);




		while (true) {

			//int slayers_stack = 0;
			ProcessBuilder pb = new ProcessBuilder().redirectErrorStream(true);
			pb.command("cmd.exe", "/c" , env+"adb exec-out screencap -p > c:\\img\\screen.png");
			pb.start();

			Thread.sleep(1000);

			Mat source = Imgcodecs.imread(mainFilePath+"screen.png");
			
			for (File info : FileUtils.listFiles(f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
				final Mat template = Imgcodecs.imread(subFilePath+info.getName());
				Mat outputImage = new Mat();   

				for (int i=0; i<1; i++) {
					//Template matching method
					Imgproc.matchTemplate(source, template, outputImage, i);


					MinMaxLocResult mmr = org.opencv.core.Core.minMaxLoc(outputImage);

					if (mmr.minVal < 10000000) {
						//System.out.println("이미지 없음");
						System.out.println(info.getName());

						switch (info.getName()) { 
						case "buy_complete_1.png":

							break;

						case "full.png":
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 350 500");
							pb.start();
							Thread.sleep(1000);
							break;
						case "fight_2.png":

							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 500 300");
							pb.start();
							Thread.sleep(30000);
							break;

						case "main.png":

							break;
							
						case "alreadyCompleteBattle.png":
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 330 550");
							pb.start();
							Thread.sleep(1000);
							break;

						case "need_ticket.png":

							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 500");
							pb.start();
							Thread.sleep(1000);
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 530 410");
							pb.start();
							Thread.sleep(1000);
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 330 550");
							pb.start();
							Thread.sleep(1000);
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 330 550");
							pb.start();
							Thread.sleep(1000);
							break;

						case "notice_image.png":

							break;

						case "ragnar_1.png": // 0
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 500 200");
							pb.start();
							Thread.sleep(1000);
							break;

						case "slayers_1.png":
							
//							System.out.println("slayers 0 ");
//							Random rand = new Random();
//							int chkValue = rand.nextInt(2);
//							String code = "200";
//							
//							if (chkValue == 1 ) {
//								code = "400";
//							}
//							
//							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 "+code);
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 200");
							pb.start();
							
							Thread.sleep(1000);	
							
							System.out.println("slayers 1 ");

//							slayers_stack++;
//							
//							if (slayers_stack > 4) {
//								
//								pb = new ProcessBuilder().redirectErrorStream(true);
//								pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 500 150");
//								pb.start();
//							}
							
							//							if(info.getName().equals("check_1.png")) {
							//
							//								pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 200");
							//								pb.start();
							//								Thread.sleep(1000);
							//							}else if(info.getName().equals("check_2.png")) {
							//
							//								pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 400");
							//								pb.start();
							//								Thread.sleep(1000);	
							//							}

							break;

						case "battle_end_1.png":

							
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 300");
							pb.start();
							break;

						case "battle_end_2.png":
							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 500 700");
							pb.start();
							break;

//						case "check_1.png":
//
//							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 200");
//							pb.start();
//							Thread.sleep(1000);	
//							
//							break;
//
//						case "check_2.png":
//
//							pb.command("cmd.exe", "/c" , env+"adb shell input touchscreen tap 300 400");
//							pb.start();
//							Thread.sleep(1000);	
//
//							break;
						}
					}
					
					template.release();
					outputImage.release();



				}

				//System.out.println(i + " : " + (int)mmr.maxVal);
				//System.out.println(i + " : " + (int)mmr.minVal);

				//System.out.println(mmr.maxLoc);

				//Point matchLoc=mmr.minLoc;
				//Draw rectangle on result image
				//Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
				//		matchLoc.y + template.rows()), new Scalar(255, 255, 255));

				//Imgcodecs.imwrite(mainFilePath+"test\\"+i+" : "+(info.getName().replace("\\.","")) +" sonuc.jpg", source);
				//        System.out.println("Complated.");
			}
			
			source.release();

		}

	}

	//		final Mat source = Imgcodecs.imread(mainFilePath+"screen.png");
	//
	//		final Mat template = Imgcodecs.imread(subFilePath+"fight_1.png");
	//
	//		Mat outputImage=new Mat();    
	//		int machMethod=Imgproc.LINE_AA;


	//        Class<Imgproc> imgp = Imgproc.class;
	//        
	//        Imgproc imgp2 = new Imgproc();
	//        
	//        Arrays.stream(imgp.getFields()).forEach(f -> {
	//        	
	//        	System.out.println(f.getName());
	//        	
	//
	//				Imgproc.matchTemplate(source, template, outputImage, 5);
	//			
	//        	 
	//        	    
	//             MinMaxLocResult mmr = org.opencv.core.Core.minMaxLoc(outputImage);
	//             
	//             if (mmr.maxVal < 0.7) {
	//             	System.out.println("이미지 없음");
	//             }
	//             System.out.println((int)mmr.maxVal);
	//
	//             //System.out.println(mmr.maxLoc);
	//             
	//             Point matchLoc=mmr.minLoc;
	//             //Draw rectangle on result image
	//             Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
	//                     matchLoc.y + template.rows()), new Scalar(255, 255, 255));
	//      
	//             Imgcodecs.imwrite(mainFilePath+"test\\"+f.getName()+" sonuc.jpg", source);
	////             System.out.println("Complated.");
	//             
	//        });



	//		for (int i=0; i<1; i++) {
	//			//Template matching method
	//			Imgproc.matchTemplate(source, template, outputImage, i);
	//
	//
	//			MinMaxLocResult mmr = org.opencv.core.Core.minMaxLoc(outputImage);
	//
	//			if (mmr.minVal > 10000000) {
	//				System.out.println("이미지 없음");
	//			}
	//			System.out.println(i + " : " + (int)mmr.maxVal);
	//			System.out.println(i + " : " + (int)mmr.minVal);
	//			
	//			//System.out.println(mmr.maxLoc);
	//
	//			Point matchLoc=mmr.minLoc;
	//			//Draw rectangle on result image
	//			Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
	//					matchLoc.y + template.rows()), new Scalar(255, 255, 255));
	//
	//			Imgcodecs.imwrite(mainFilePath+"test\\"+i+" sonuc.jpg", source);
	//			//        System.out.println("Complated.");
	//		}

}


