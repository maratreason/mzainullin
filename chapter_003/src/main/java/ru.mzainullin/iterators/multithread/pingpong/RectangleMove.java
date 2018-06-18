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

        while (true) {
            if (this.rect.getX() >= 300D || this.rect.getX() <= 0D) {
                this.moveX *= CHANGE;
            }

            if (this.rect.getY() >= 300D || this.rect.getY() <= 0D) {
                this.moveY *= CHANGE;
            }

            if (this.rect.getX() < 300 || this.rect.getY() < 300) {
                this.rect.setX(this.rect.getX() + moveX);
                this.rect.setY(this.rect.getY() + moveY);
            } else if (this.rect.getX() == 300 || this.rect.getY() == 300) {
                while (this.rect.getX() > 0 || this.rect.getY() > 0) {
                    if (this.rect.getX() > 0 || this.rect.getY() > 0) {
                        this.rect.setX(this.rect.getX() - moveX);
                        this.rect.setY(this.rect.getY() - moveY);
                    } else {
                        this.rect.setX(this.rect.getX() + moveX);
                        this.rect.setY(this.rect.getY() + moveY);
                    }
                }
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

