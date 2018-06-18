package ru.mzainullin.iterators.multithread.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    private void sleep2sec(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect)).start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();

        while(!Thread.currentThread().isInterrupted()){
            sleep2sec();
            if (Thread.interrupted()) {
                stage.setOnCloseRequest(
                        event -> Thread.interrupted()
                );
            }

            System.out.println("Завершение работы потока");
        }


    }
}