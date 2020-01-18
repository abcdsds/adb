package test.test.test.opencv;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;

public class OpenCvService {
	
	private String OS = System.getProperty("os.name").toLowerCase();
	private Mat mainImg;
	private Mat compareImg;
	private Mat resultImg;
	private MinMaxLocResult mmr;
	private int x = -1;
	private int y = -1;
	

	
	public OpenCvService () {
		
		if(OS.indexOf("linux")>=0 || (OS.indexOf("mac")>=0&&OS.indexOf("os")>0)){
			OpenCV.loadLocally();
		}else{
			OpenCV.loadShared();
		}
		
		System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	public boolean compare () {
	
		if (mmr.minVal < 10000000) {
			return true;
		}
		return false;
	}
	
	public Mat getMainimageMat() {
		return mainImg;
	}
	
	public void showImage() {
		HighGui.imshow("test", mainImg);
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
	
	
	
	public Image toBufferedImage(Mat m) {
		int type = BufferedImage.TYPE_BYTE_GRAY;

		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}

		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);

		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);

		return image;
	}
	
	
	public JFrame CreateFrame(String name, Image img) {
		JFrame frame = new JFrame(name);
		ImageIcon icon = new ImageIcon(img);
		
		JLabel lbl = new JLabel(icon);
		frame.add(lbl);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getX());
				//System.out.println(e.getY());
				x = e.getXOnScreen();
				y = e.getYOnScreen();
				System.out.println("X = " + e.getXOnScreen());
				System.out.println("Y = " + e.getYOnScreen());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}


		});
		
		return frame;
	}

}
