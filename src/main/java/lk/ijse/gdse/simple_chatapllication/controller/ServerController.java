package lk.ijse.gdse.simple_chatapllication.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class ServerController implements Initializable {


    @FXML
    private AnchorPane server;

    @FXML
    private Button serverbtn;

    @FXML
    private TextField servertxt;

    @FXML
    private TextArea servertxtarea;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(() -> {
            try {
               ServerSocket serverSocket = new ServerSocket(3000);
                socket = serverSocket.accept();

                 in = new DataInputStream(socket.getInputStream());
                 out = new DataOutputStream(socket.getOutputStream());


                String msg;
                while ((msg = in.readUTF()) != null) {
                    String finalMsg = msg;
                    servertxtarea.appendText("Client: " + finalMsg + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void SendOnAction(ActionEvent event) throws IOException {
        String msg = servertxt.getText();

        if (out != null) {
            out.writeUTF(msg); // Send to client
            out.flush();

            servertxtarea.appendText("Server: " + msg + "\n");
            servertxt.clear();
        }
    }
}