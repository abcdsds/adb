package test.test.test.templatematching;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.concurrent.CountDownLatch;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONObject;
import org.junit.Test;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

import test.test.test.opencv.OpenCvService;
import test.test.test.util.uitls;

public class test extends uitls {

	private String ragnarFilePath = "C:\\Users\\ds\\Downloads\\DesKidRagnarLocationXY.json";
	private String globalFilePath = "C:\\Users\\ds\\Downloads\\DesKidGlobalLocationXY.json";
	private String mainImgPath = "C:\\img\\screen.png";
	public static CountDownLatch latch = new CountDownLatch(1);

	@Test
	public static void dkTest() {

		// JSONObject ragnarJo = getJsonObject(ragnarFilePath);
		// System.out.println(ragnarJo.getJSONObject("DesKidRagnarLocationXY").getJSONObject("needTicket").get("1"));

		// JSONObject globalJo = getJsonObject(globalFilePath);
		// System.out.println(globalJo.getJSONObject("DesKidGlobalLocationXY").get("Home"));

		// OpenCvService openCvService = new OpenCvService();

		// openCvService.setMainImg(mainImgPath);

		// openCvService.mainImageRelease();\

		// ImageWindow newWin = new ImageWindow("test",
		// openCvService.getMainimageMat());
		// ImageIcon icon = new ImageIcon(toBufferedImage(newWin.img));

		JFrame frame = new JFrame();
		// Mat main = openCvService.getMainimageMat();
		// ImageIcon icon = new ImageIcon(toBufferedImage(main));
		// JLabel lbl = new JLabel(icon);
		// lbl.setPreferredSize(new Dimension(main.width(), main.height()));

		// frame.setLocation(main.width(), main.height());
		// frame.setResizable(true);
		// frame.add(lbl);
		// frame.pack();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);

//        frame.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println(e.getX());
//				System.out.println(e.getY());
//				System.out.println(e.getXOnScreen());
//				System.out.println(e.getYOnScreen());
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		
//		});
//		
//        frame.addWindowListener(new java.awt.event.WindowAdapter() {
//	            @Override
//	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		              
//	            }
//	     });

		// JLabel lbl = new JLabel(icon);
		// newWin.setFrameLabelVisible(frame, lbl);
//        try {
//			latch.await();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		System.out.println("1");

	}
}
