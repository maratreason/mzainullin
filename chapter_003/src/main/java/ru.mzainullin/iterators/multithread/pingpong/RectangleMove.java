package ru.mzainullin.iterators.multithread.pingpong;

import javafx.scene.shape.Rectangle;


public class RectangleMove implements Runnable {

    private static final double CHANGE = -1;
    private double moveX = 1D;
    private double moveY = 0.5D;

    private final Rectangle rect;
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {

            if (this.rect.getX() >= 300D || this.rect.getX() <= 0D) {
                this.moveX *= CHANGE;
            }

            if (this.rect.getY() >= 300D || this.rect.getY() <= 0D) {
                this.moveY *= CHANGE;
            }

            this.rect.setX(this.rect.getX() + moveX);
            this.rect.setY(this.rect.getY() + moveY);

            }


            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}

