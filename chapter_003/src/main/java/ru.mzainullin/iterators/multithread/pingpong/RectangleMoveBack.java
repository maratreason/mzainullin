package ru.mzainullin.iterators.multithread.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMoveBack implements Runnable {
    private final Rectangle rect;

    public RectangleMoveBack(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            this.rect.setX(this.rect.getX() - 3);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
