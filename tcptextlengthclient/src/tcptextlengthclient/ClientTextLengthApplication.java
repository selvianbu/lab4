package tcptextlengthclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextLengthApplication {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Launch client-side frame
		ClientTextLengthFrame clientTextLengthFrame = new ClientTextLengthFrame();
		clientTextLengthFrame.setVisible(true);
		
		//COnnect to the server @localhost port 2622
		Socket socket = new Socket(InetAddress.getLocalHost(), 2622);
		
		
		//update the status of the connection
		clientTextLengthFrame.updateConnectionStatus(socket.isConnected());
		
		//Read from network
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		
		//Display the length of the text
		String textLength = bufferedReader.readLine();
		clientTextLengthFrame.updateServerTextLength(textLength);
		
		//close 
		bufferedReader.close();
		socket.close();
		
	}

}
