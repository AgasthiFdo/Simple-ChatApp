package lk.ijse.gdse.simple_chatapllication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader serverLoader = new FXMLLoader(getClass().getResource("/view/server.fxml"));
        Parent serverRoot = serverLoader.load();
        Stage serverStage = new Stage();
        serverStage.setTitle("Server");
        serverStage.setScene(new Scene(serverRoot));
        serverStage.show();

        // Load Client UI
        FXMLLoader clientLoader = new FXMLLoader(getClass().getResource("/view/client.fxml"));
        Parent clientRoot = clientLoader.load();
        Stage clientStage = new Stage();
        clientStage.setTitle("Client");
        clientStage.setScene(new Scene(clientRoot));
        clientStage.show();

        FXMLLoader client1Loader = new FXMLLoader(getClass().getResource("/view/client1.fxml"));
        Parent client1Root = client1Loader.load();
        Stage client1Stage = new Stage();
        client1Stage.setTitle("Client1");
        client1Stage.setScene(new Scene(client1Root));
        client1Stage.show();

        FXMLLoader client2Loader = new FXMLLoader(getClass().getResource("/view/client2.fxml"));
        Parent client2Root = client2Loader.load();
        Stage client2Stage = new Stage();
        client2Stage.setTitle("Client2");
        client2Stage.setScene(new Scene(client2Root));
        client2Stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}