package szi.data;

import szi.Agent;
import szi.Window;

import java.util.ArrayList;
import java.util.List;

public class AStar {

    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;

    private static int currentPositionX;
    private static int currentPositionY;
    private static int startPositionX;
    private static int startPositionY;
    private static int endPositionX;
    private static int endPositionY;
    private static int direction;
    private static int rotation;

    private static Window window;
    private static Agent agent;

    public static List<String> stepsList;
    public static String nextStep;
    public static boolean isRunning = false;

    public AStar(Window window, Agent agent) {
        this.window = window;
        this.agent = agent;
    }

    public static void runAStar(int startX, int startY, int rotation, int endX, int endY) {
        stepsList = new ArrayList<String>();
        setStartPositions(startX, startY, rotation);
        setEndPositions(endX, endY);
        int wasX = startPositionX;
        int wasY = startPositionY;
        while (true) {
            if (startPositionX == endPositionX && startPositionY == endPositionY) {
                return;
            }
            currentPositionX = startPositionX;
            currentPositionY = startPositionY;

            checkDirection(wasX, wasY);
            getDestinationString(direction);
            stepsList.add(nextStep);

            wasX = currentPositionX;
            wasY = currentPositionY;
            setStartPositions(startPositionX, startPositionY, rotation);
        }

    }

    private double checkCost(int posX, int posY) {
        return window.cells[posX][posY].getCrossingCost();
    }

    private static void setStartPositions(int startPosX, int startPosY, int startRotation) {
        startPositionX = startPosX;
        startPositionY = startPosY;
        rotation = startRotation % 4;
    }

    private static void setEndPositions(int endPosX, int endPosY) {
        endPositionX = endPosX;
        endPositionY = endPosY;
    }

    private static void getDestinationString(int type) {
        switch(type) {
            case LEFT:
                nextStep = Agent.LEFT;
                startPositionX = startPositionX - 1;
                break;
            case RIGHT:
                nextStep = Agent.RIGHT;
                startPositionX = startPositionX + 1;
                break;
            case UP:
                nextStep = Agent.FORWARD;
                startPositionY = startPositionY - 1;
                break;
            case DOWN:
                nextStep = Agent.BACKWARD;
                startPositionY = startPositionY + 1;
                break;
        }
    }

    private static void checkDirection(int wasX, int wasY) {
        if (startPositionX > endPositionX) { //lewo
            direction = lowestValue(LEFT,
                    window.cells[currentPositionX][currentPositionY + 1].getCrossingCost() + distance(currentPositionX, currentPositionY + 1),
                    window.cells[currentPositionX - 1][currentPositionY].getCrossingCost() + distance(currentPositionX - 1, currentPositionY),
                    window.cells[currentPositionX][currentPositionY - 1].getCrossingCost() + distance(currentPositionX, currentPositionY - 1)
            );
        } else if (startPositionX < endPositionX) { //prawo
            direction = lowestValue(RIGHT,
                    window.cells[currentPositionX][currentPositionY - 1].getCrossingCost() + distance(currentPositionX, currentPositionY - 1),
                    window.cells[currentPositionX + 1][currentPositionY].getCrossingCost() + distance(currentPositionX + 1, currentPositionY),
                    window.cells[currentPositionX][currentPositionY + 1].getCrossingCost() + distance(currentPositionX, currentPositionY + 1)
            );
        } else if (startPositionY > endPositionY) { //gora
            direction = lowestValue(UP,
                    window.cells[currentPositionX - 1][currentPositionY].getCrossingCost() + distance(currentPositionX - 1, currentPositionY),
                    window.cells[currentPositionX][currentPositionY - 1].getCrossingCost() + distance(currentPositionX, currentPositionY - 1),
                    window.cells[currentPositionX + 1][currentPositionY].getCrossingCost() + distance(currentPositionX + 1, currentPositionY)
            );
        } else if (startPositionY < endPositionY) { //dol
            direction = lowestValue(DOWN,
                    window.cells[currentPositionX + 1][currentPositionY].getCrossingCost() + distance(currentPositionX + 1, currentPositionY),
                    window.cells[currentPositionX][currentPositionY + 1].getCrossingCost() + distance(currentPositionX, currentPositionY + 1),
                    window.cells[currentPositionX - 1][currentPositionY].getCrossingCost() + distance(currentPositionX - 1, currentPositionY)
            );
        }
    }

    /*
      Zgodnie z ruchem wskazówke zegara np. dla kierunki w lewo : first=dól, secound=lewo, thirth=góra
    */
    private static int lowestValue(int direction, double first, double secound, double thirth) {
        if (first <= secound && first <= thirth) {
            if (direction == 1) {
                return 4;
            }
            return direction - 1;
        } else if (secound <= first && secound <= thirth) {
            return direction;
        } else {
            if (direction == 4) {
                return 1;
            }
            return direction + 1;
        }
    }

    public static void runningChange() {
        isRunning = !isRunning;
    }

    private static int distance(int posX, int posY) {
        int X;
        int Y;
        if (endPositionX > posX){
            X = endPositionX - posX;
        } else {
            X = posX - endPositionX;
        }
        if (endPositionY > posY){
            Y = endPositionY - posY;
        } else {
            Y = posY - endPositionY;
        }
        return X + Y;
    }

}
