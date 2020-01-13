package test.test.test.pb;

import java.io.IOException;

public class Pb {

	private ProcessBuilder pb;

	public Pb() {
		this.pb = new ProcessBuilder().redirectErrorStream(true);
	}
		
	public void setCommandPb(String command1,String command2, String command3) {
		pb.command(command1,command2,command3);
	}
	
	public void startPb () {
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitPb (long time) {
		try {
			pb.wait(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
    public void startPb (String command1, String command2 , String command3) {
    	
		setCommandPb(command1, command2, command3);	
		startPb();
		
	}
}
