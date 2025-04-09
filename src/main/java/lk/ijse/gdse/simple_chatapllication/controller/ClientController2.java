package lk.ijse.gdse.simple_chatapllication.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class ClientController2 implements Initializable {

    @FXML
    private AnchorPane client;

    @FXML
    private Button client2btn;

    @FXML
    private TextField client2txt;

    @FXML
    private TextArea client2txtarea;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    @FXML
    void SendOnAction(ActionEvent event) throws IOException {
        String msg = client2txt.getText();



        if (out != null) {
            out.writeUTF(msg); // Send to client
            out.flush();

            client2txtarea.appendText("Client: " + msg + "\n");
            client2txt.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(() -> {
            try {
                socket = new Socket("localhost", 3000);


                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());


                String msg;
                while ((msg = in.readUTF()) != null) {
                    String finalMsg = msg;
                    Platform.runLater(() -> client2txtarea.appendText("Server: " + finalMsg + "\n"));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}