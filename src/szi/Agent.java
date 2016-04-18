package szi;


import java.util.TimerTask;

public class Agent extends TimerTask {
    
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String UP = "up";
    public static final String DOWN = "down";
    
    int width = 30;
    int height = 30;
    //IMAGE
    int positionX;
    int positionY;

    public void run() {
        //Window.window.repaint();
    }

    public Agent(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void moveAgent(String way) {
        if (way.equals(UP) && positionY > 1) {
            positionY--;

        } else if (way.equals(DOWN) && positionY < 13) {
            positionY++;

        } else if (way.equals(LEFT) && positionX > 0) {
            positionX--;

        } else if(way.equals(RIGHT) && positionX < 23) {
            positionX++;
        }
        repaintGraphic();
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

    public void repaintGraphic() {
        Window.window.repaint();
    }
}
