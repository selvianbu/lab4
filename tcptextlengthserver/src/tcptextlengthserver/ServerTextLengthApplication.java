package tcptextlengthserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextLengthApplication {
	
	public static void main(String[] args) throws IOException {
		
		//Launch the server name
		ServerTextLengthFrame serverFrame = new ServerTextLengthFrame();
		serverFrame.setVisible(true);
		
		//BInding to a port 
		int portNo = 2622;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		TextProcessor textProcessor = new TextProcessor();
		
		//Counter to keep track of the requested connection
		int totalRequest = 0;
		
		while(true) {
			
			serverFrame.updateServerStatus(false);
			
			Socket clientSocket = serverSocket.accept();
			
			String textLength = textProcessor.getTextLength();
			
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
			
			//send text length back to the client
			outputStream.writeBytes(textLength);
			
			//close the socket
			clientSocket.close();
			
			// Update the request status
			
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + textLength);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
	}

}
