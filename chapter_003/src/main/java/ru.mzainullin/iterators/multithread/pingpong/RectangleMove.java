package ru.mzainullin.iterators.multithread.pingpong;

import javafx.scene.shape.Rectangle;


public class RectangleMove implements Runnable {

    private final Rectangle rect;
    int count = 0;
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {

        while (true) {

            if (this.rect.getX() < 300) {
                this.rect.setX(this.rect.getX() + 1);
            } else if (this.rect.getX() == 300) {
                while (this.rect.getX() > 0) {
                    if (this.rect.getX() > 0) {
                        this.rect.setX(this.rect.getX() - 1);
                    } else {
                        this.rect.setX(this.rect.getX() + 1);
                    }

                }
            }




            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

