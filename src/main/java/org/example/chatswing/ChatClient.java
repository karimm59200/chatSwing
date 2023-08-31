package org.example.chatswing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 3000);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Writer output = new OutputStreamWriter(socket.getOutputStream());
        ChatFrame chatFrame = new ChatFrame(" client Chat Swing", output);

        String message;
        while((message = input.readLine()) != null){
            chatFrame.appendMessage(message + "\n");
        }
        socket.close();
        chatFrame.appendMessage("Connection perdue ! ");
    }
}
