package org.example.chatswing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
         Socket socket = serverSocket.accept();

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         Writer output = new OutputStreamWriter(socket.getOutputStream());
         ChatFrame chatFrame = new ChatFrame(" Serveur Chat Swing", output);

            String message;
         while((message = input.readLine()) != null){
             chatFrame.appendMessage(message + "\n");
         }
        serverSocket.close();
        chatFrame.appendMessage("Connection perdue ! ");
    }
}
