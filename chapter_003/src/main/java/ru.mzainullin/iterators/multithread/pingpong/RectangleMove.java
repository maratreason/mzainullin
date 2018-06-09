package ru.mzainullin.iterators.multithread.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            if (this.rect.getX() == 300) {
                try {
                    Thread.sleep(0);
                    new Thread () {
                        @Override
                        public void run() {
                            new Thread(new RectangleMoveBack(rect)).start();
                        }
                    }.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.rect.setX(this.rect.getX() + 1);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
