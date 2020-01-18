package test.test.test.util;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.opencv.core.Mat;

public class uitls{

	public JSONObject getJsonObject(String filePath) {
		try {
			
			JSONTokener jsonTokener = new JSONTokener(new FileReader(new File(filePath)));
			return (JSONObject) jsonTokener.nextValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONArray getJsonArray(String filePath) {
		try {
			
			JSONTokener jsonTokener = new JSONTokener(new FileReader(new File(filePath)));
			return (JSONArray) jsonTokener.nextValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Image toBufferedImage(Mat m) {
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
	
	public static JFrame CreateFrame(String name, Image img) {
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
