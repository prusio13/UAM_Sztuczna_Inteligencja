package szi;

public class Agent {
    
    public static final String LEFT = "left";
    public static final String RIGHT = "left";
    public static final String UP = "up";
    public static final String DOWN = "down";
    
    int width;
    int height;
    //IMAGE
    int positionX = 560;
    int positionY = 250;
    
    public Agent(int width, int height) {
        this.height = height;
        this.width = width;
    }
    
    public void moveAgent(String way, int howFar) {
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
