package ru.tsibrovskii.PingPongTask;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int step = 2;
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + step);
            if(this.rect.getX() >= 300 || this.rect.getX() <= 0) {
                step *= -1;
            }
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt() ;
            }
        }
    }
}
