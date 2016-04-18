package szi;


import java.util.TimerTask;

public class Agent extends TimerTask {
    
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String UP = "up";
    public static final String DOWN = "down";
    
    int width = 50;
    int height = 50;
    //IMAGE
    int positionX;
    int positionY;

    public void run() {
        Window.window.repaint();
    }

    public Agent(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void moveAgent(String way) {
        if (way.equals(UP)) {
            positionY--;

        } else if (way.equals(DOWN)) {
            positionY++;

        } else if (way.equals(LEFT)) {
            positionX--;

        } else if(way.equals(RIGHT)) {
            positionX++;
        }
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getX() {
        return this.positionX;
    }
    
    public int getY() {
        return this.positionY;
    }
}
