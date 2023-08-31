package org.example.chatswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ChatFrame   {



    private JFrame frame;
    private  JTextArea chatTextArea;

    private  JScrollPane chatscrollPane;

    private  JTextField newMessageTextField;



    public ChatFrame(String title, Writer output){

//        super(title);
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {

                frame = new JFrame(title);

                frame.setLayout(new BorderLayout());

                chatTextArea = new JTextArea();
                chatTextArea.setEditable(false);
                chatscrollPane = new JScrollPane(chatTextArea);
                frame.add(chatscrollPane, BorderLayout.CENTER);

                newMessageTextField = new JTextField();
                newMessageTextField.addActionListener(e-> {
                    String message = newMessageTextField.getText();
                    newMessageTextField.setText("");
                    try {
                        output.write(message + "\n");
                        output.flush();
                    } catch (IOException e1) {
                        chatTextArea.append("Impossible d'envoyer le message : " + message + "\n" +" l'une des deux parties est déconnectée");
                    }
                    newMessageTextField.setText("");
                    chatTextArea.append("Moi : "+message + "\n");
                    //System.out.println(message);
                });
                frame.add(newMessageTextField, BorderLayout.SOUTH);

                frame.setLocationByPlatform(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMaximumSize(new Dimension(400, 400));
                frame.setPreferredSize(new Dimension(400, 400));
                frame.pack();
                frame.setVisible(true);


            }
        }));




    }




    public void appendMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

//                System.out.println(Thread.currentThread().getName()); // afin de connaitre le nom du thread
                chatTextArea.append("Lui: " + message + "\n");
            }
        });

    }


}


