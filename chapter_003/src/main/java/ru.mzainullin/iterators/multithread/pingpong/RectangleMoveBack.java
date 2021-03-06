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
            if (this.rect.getX() == 1) {
                try {
                    Thread.sleep(0);
                    this.rect.setX(this.rect.getX() - 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.rect.setX(this.rect.getX() - 1);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
