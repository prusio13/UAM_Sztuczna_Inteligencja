package szi;

public class Agent {
    
    public static final String LEFT = "left";
    public static final String RIGHT = "left";
    public static final String UP = "up";
    public static final String DOWN = "down";
    
    int width = 50;
    int height = 50;
    //IMAGE
    int positionX = 5;
    int positionY = 5;
    
    public Agent(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void moveAgent(String way) {
        switch (way) {
            case UP:
                positionY--;
                break;
            case DOWN:
                positionY++;
                break;
            case LEFT:
                positionX--;
                break;
        }
        if(way == RIGHT) {
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
