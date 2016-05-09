package szi;

import java.util.TimerTask;

public class Agent extends TimerTask {

    private Window window;

    public static final String WEST = "west";
    public static final String EAST = "east";
    public static final String NORTH = "north";
    public static final String SOUTH = "south";


    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String FORWARD = "forward";
    public static final String BACKWARD = "backward";

    private static String icon;

    int width = 40;
    int height = 40;
    //IMAGE
    int positionX;
    int positionY;
    int rotation;
    public void run() {
        //nop
    }

    public Agent(int positionX, int positionY) {
        this(positionX,positionY,0);
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    public Agent(int positionX, int positionY, int rotation) {
        icon = System.getProperty("user.dir") + "/src/graphics/tractor-" + NORTH + ".png";
        this.positionX = positionX;
        this.positionY = positionY;
        this.rotation = rotation;
    }

    public void addWindow(Window window) {
        this.window = window;
    }

    public void moveAgent(String way) {
        if (way.equals(LEFT)) {
            rotation = (rotation - 1 + 4) % 4;
        }
        if (way.equals(RIGHT)) {
            rotation = (rotation + 1) % 4;
        }
        String absoluteDirection = LocalToAbsolute();
        icon = System.getProperty("user.dir") + "/src/graphics/tractor-" + absoluteDirection + ".png";
        if (way.equals(FORWARD) || way.equals(BACKWARD)) {
            int i = way.equals(FORWARD) ? 1 : -1;
            if (absoluteDirection.equals(Agent.NORTH) && positionY-i >= 0 && positionY-i<window.cells[0].length){
                if (checkNextStep(positionX,positionY-i)) {
                    positionY-=i;
                }

            } else if (absoluteDirection.equals(Agent.SOUTH) && positionY+i >= 0 && positionY+i<window.cells[0].length){
                if (checkNextStep(positionX,positionY+i)) {
                    positionY+=i;
                }

            } else if (absoluteDirection.equals(Agent.WEST) && positionX-i >= 0 && positionX-i<window.cells.length) {
                if (checkNextStep(positionX-i,positionY)) {
                    positionX-=i;
                }

            } else if (absoluteDirection.equals(Agent.EAST) && positionX-i >= 0 && positionX-i<window.cells.length) {
                if (checkNextStep(positionX+i,positionY)) {
                    positionX+=i;
                }
            }
        }
        repaintGraphic();

    }

    private String LocalToAbsolute() {
        return new String[]{NORTH, EAST, SOUTH, WEST}[rotation];
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

    public static void repaintGraphic() {
        Window.window.repaint();
    }

    public boolean checkNextStep(int x,int y) {
        return window.cells[x][y].isCrossable();
    }

    public static String getIcon() {
        return icon;
    }

    public boolean equals(Agent agent){
        return (this.getX()==agent.getX() && this.getY()==agent.getY() && this.getRotation()==agent.getRotation());
    }
}
