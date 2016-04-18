package szi;


import szi.data.Cell;

import java.util.TimerTask;

public class Agent extends TimerTask {

    private Window window;
    
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

    public void AddWindow(Window window) {
        this.window = window;
    }

    public void moveAgent(String way) {
        if (way.equals(UP) && positionY > 1) {
            if (CheckNextStep(UP)) {
                positionY--;
            }

        } else if (way.equals(DOWN) && positionY < 13) {
            if (CheckNextStep(DOWN)) {
                positionY++;
            }

        } else if (way.equals(LEFT) && positionX > 0) {
            if (CheckNextStep(LEFT)) {
                positionX--;
            }

        } else if(way.equals(RIGHT) && positionX < 23) {
                if (CheckNextStep(RIGHT)) {
                    positionX++;
                }
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

    public boolean CheckNextStep(String direction) {
        if (direction.equals(UP)) {
            if (window.cells[positionX][positionY - 1].isCrossable()) {
                return true;
            }

        } else if (direction.equals(DOWN)) {
            if (window.cells[positionX][positionY + 1].isCrossable()) {
                return true;
            }

        } else if (direction.equals(LEFT)) {
            if (window.cells[positionX - 1][positionY].isCrossable()) {
                return true;
            }

        } else if(direction.equals(RIGHT)) {
            if (window.cells[positionX + 1][positionY].isCrossable()) {
                return true;
            }
        }
        return false;
    }
}
