package org.test.db_check;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class javafx_main extends Application {

    private ConfigurableApplicationContext context;

    // public static void main(String[] args) {
    // launch(args);
    // }

    @Override
    public void init() {
        this.context = SpringApplication.run(DbCheckApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sendData.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();

        primaryStage.setTitle("Checking the Database");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() {
        this.context.close();
    }

}
