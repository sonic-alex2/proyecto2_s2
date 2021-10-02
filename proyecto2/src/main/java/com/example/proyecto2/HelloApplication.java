package com.example.proyecto2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloApplication extends Application /*implements Runnable*/{

    //public void HelloController(){
    //    Thread mihilo = new Thread(this);
    //    mihilo.start();
    //}

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 640);
        stage.setTitle("Programa de Parqueo");
        //scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //HelloApplication a = new HelloApplication();
        launch();
    }

    //@Override
    //public void run() {


    //}
}