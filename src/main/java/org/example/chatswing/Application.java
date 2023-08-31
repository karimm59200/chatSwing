package org.example.chatswing;

import javax.swing.*;
import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException {
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String message;
                ChatFrame chatFrame = new ChatFrame("Chat Swing", new OutputStreamWriter(System.out));
                while((message = keyboard.readLine() )!= null){
                    //System.out.println(message + "\n");
                    chatFrame.appendMessage( message + "\n");
                }


            }


    }





