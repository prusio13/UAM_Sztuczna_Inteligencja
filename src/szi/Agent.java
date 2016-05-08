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
        icon = System.getProperty("user.dir") + "\\src\\graphics\\tractor-" + NORTH + ".png";
        this.positionX = positionX;
        this.positionY = positionY;
        rotation = 0;
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
        icon = System.getProperty("user.dir") + "\\src\\graphics\\tractor-" + absoluteDirection + ".png";
        if (way.equals(FORWARD) || way.equals(BACKWARD)) {
            int i = way.equals(FORWARD) ? 1 : -1;
            if (absoluteDirection.equals(NORTH) && positionY > 1) {
                if (checkNextStep(NORTH)) {
                    positionY--;
                }

            } else if (absoluteDirection.equals(SOUTH) && positionY < 13) {
                if (checkNextStep(SOUTH)) {
                    positionY++;
                }

            } else if (absoluteDirection.equals(WEST) && positionX > 0) {
                if (checkNextStep(WEST)) {
                    positionX--;
                }

            } else if (absoluteDirection.equals(EAST) && positionX < 23) {
                if (checkNextStep(EAST)) {
                    positionX++;
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

    public boolean checkNextStep(String direction) {
        if (direction.equals(NORTH)) {
            if (window.cells[positionX][positionY - 1].isCrossable()) {
                return true;
            }

        } else if (direction.equals(SOUTH)) {
            if (window.cells[positionX][positionY + 1].isCrossable()) {
                return true;
            }

        } else if (direction.equals(WEST)) {
            if (window.cells[positionX - 1][positionY].isCrossable()) {
                return true;
            }

        } else if (direction.equals(EAST)) {
            if (window.cells[positionX + 1][positionY].isCrossable()) {
                return true;
            }
        }
        return false;
    }

    public static String getIcon() {
        return icon;
    }
}
