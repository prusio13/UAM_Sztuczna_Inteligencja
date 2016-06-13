package szi.data;

import szi.Agent;
import szi.Window;

import java.util.*;

import static java.lang.Math.*;

public class AStar {

    //private static final int RIGHT = 1;
    //private static final int DOWN = 2;
    //private static final int LEFT = 3;
    //private static final int UP = 4;

    public static List<String> stepsList;

    public static Queue<String> stepsList2 = new LinkedList<>();

    public static String nextStep;

    public static boolean isRunning = false;

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

    public AStar(Window window, Agent agent) {
        this.window = window;
        this.agent = agent;
    }

    public static void runAStar2() {
        if (!stepsList2.isEmpty()) {

            String step = stepsList2.poll();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(step);
            switch (step) {
                case "left":
                    agent.moveAgent(Agent.LEFT);
                    break;
                case "right":
                    agent.moveAgent(Agent.RIGHT);
                    break;
                case "forward":
                    agent.moveAgent(Agent.FORWARD);
                    break;
            }
            if (stepsList2.size() == 1) {
                System.out.println("oddano plony");
            }

            window.repaint();
        }
    }

    public static void runAStar(int startX, int startY, int rotation, int endX, int endY) {
        stepsList = getStepsList(startX, startY, rotation, endX, endY);
        for (String step : stepsList
                ) {
            System.out.println(step);
        }
        System.out.println("ready");
        isRunning = true;
        /*stepsList = new ArrayList<String>();
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
        }*/

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

    /*
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
    */
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
        //isRunning = !isRunning;
    }

    private static int distance(int posX, int posY) {
        int X;
        int Y;
        if (endPositionX > posX) {
            X = endPositionX - posX;
        } else {
            X = posX - endPositionX;
        }
        if (endPositionY > posY) {
            Y = endPositionY - posY;
        } else {
            Y = posY - endPositionY;
        }
        return X + Y;
    }

    private static double h1(Position position, int goalX, int goalY) {
        int roadCost = 0;
        for (int i = min(position.x, goalX); i < max(position.x, goalX); i++) {
            if (window.cells[i][position.y].isCrossable()) roadCost += window.cells[i][position.y].getCrossingCost();
            //else roadCost+=1;
        }
        for (int j = min(position.y, goalY); j < max(position.y, goalY); j++) {
            if (window.cells[goalX][j].isCrossable()) roadCost += window.cells[goalX][j].getCrossingCost();
            //else roadCost+=1;
        }
        return roadCost;
    }

    private static double h2(Position position, int goalX, int goalY) {
        int roadCost = 0;
        for (int j = min(position.y, goalY); j < max(position.y, goalY); j++) {
            if (window.cells[position.x][j].isCrossable()) roadCost += window.cells[position.x][j].getCrossingCost();
            //else roadCost+=1;
        }
        for (int i = min(position.x, goalX); i < max(position.x, goalX); i++) {
            if (window.cells[i][goalY].isCrossable()) roadCost += window.cells[i][goalY].getCrossingCost();
            //else roadCost+=1;
        }
        return roadCost;
    }

    private static double heuristicCost(Position position, int goalX, int goalY) {
        double roadCost = 0;
        roadCost = abs(position.x - goalX) + abs(position.y - goalY);
        //roadCost=min(h1(position,goalX,goalY),h2(position,goalX,goalY));
        double rotationCost = 1;
        if (position.x != goalX && (position.rotation == 2 || position.rotation == 0)) {
            rotationCost = 0;
        }
        if (position.y != goalY && (position.rotation == 1 || position.rotation == 3)) {
            rotationCost = 0;
        }
        return roadCost + rotationCost;
    }

    private static Position newPosition(Position oldPosition, String direction) {
        Position newPosition = new Position(oldPosition.x, oldPosition.y, oldPosition.rotation, 1);
        //newAgent.addWindow(window);
        newPosition.moveAgent(direction);
        //Position newPosition = new Position(newAgent.getX(),newAgent.getY(),newAgent.getRotation(),1);
        if (direction == Agent.LEFT || direction == Agent.RIGHT)
            newPosition.gValue = 0.5 * window.cells[newPosition.x][newPosition.y].getCrossingCost();
        newPosition.moves = new ArrayList<>(oldPosition.moves);
        if (direction == Agent.BACKWARD)
            newPosition.gValue = 2 * window.cells[newPosition.x][newPosition.y].getCrossingCost();
        if (direction == Agent.FORWARD)
            newPosition.gValue = window.cells[newPosition.x][newPosition.y].getCrossingCost();
        newPosition.moves.add(direction);
        return newPosition;
    }

    private static List<String> getStepsList(int posX, int posY, int rotation, int goalX, int goalY) {
        Set<Position> closedSet = new HashSet<>();
        //Set<Position> openSet = new HashSet<>();
        PriorityQueue<Position> openSet = new PriorityQueue<Position>(50, new Comparator<Position>() {

            @Override
            public int compare(Position o1, Position o2) {
                if ((o1.gValue + heuristicCost(o1, goalX, goalY)) < (o2.gValue + heuristicCost(o2, goalX, goalY))) {
                    return -1;
                }
                if ((o1.gValue + heuristicCost(o1, goalX, goalY)) > (o2.gValue + heuristicCost(o2, goalX, goalY))) {
                    return 1;
                }
                return 0;
            }
        });
        //HashMap<Position,Integer> gValues = new HashMap<>();
        openSet.add(new Position(posX, posY, rotation, 0));
        while (!openSet.isEmpty()) {
            /*for (Object i:openSet.toArray()
                    ) {
                Position i2=(Position)i;
                System.out.println("new");
                System.out.println(i2.gValue);
                System.out.println(i2.gValue+heuristicCost(i2,goalX,goalY));
            }*/
            Position currPosition = openSet.poll();
            //System.out.println("curr"+currPosition.gValue+(heuristicCost(currPosition,goalX,goalY)+currPosition.gValue));
            if (currPosition.x == goalX && currPosition.y == goalY) return currPosition.moves;
            closedSet.add(currPosition);
            for (Position p : new Position[]{newPosition(currPosition, Agent.FORWARD),
                    newPosition(currPosition, Agent.BACKWARD),
                    newPosition(currPosition, Agent.LEFT),
                    newPosition(currPosition, Agent.RIGHT)}) {
                if (closedSet.contains(p) || p.equals(currPosition)) {
                    continue;
                }
                p.gValue = currPosition.gValue + p.gValue;
                openSet.add(p);
            }
        }
        //openSet.add();
        return null;
    }

    public static void initialize(int x, int y, int rotation) {
        stepsList2 = new LinkedList<>(getStepsList(x, y, rotation, 3, 3));
    }

    private double checkCost(int posX, int posY) {
        return window.cells[posX][posY].getCrossingCost();
    }

    private static class Position {

        public int x;

        public int y;

        public int rotation;

        public double gValue;

        public List<String> moves;

        public Position(int x, int y, int rotation, double gValue) {
            this.x = x;
            this.y = y;
            this.rotation = rotation;
            this.gValue = gValue;
            this.moves = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            Position other = (Position) obj;
            return (x == other.x && y == other.y && rotation == other.rotation);
        }

        @Override
        public int hashCode() {
            return x + y + rotation;
        }

        public void moveAgent(String way) {
            if (way.equals(Agent.LEFT)) {
                rotation = (rotation - 1 + 4) % 4;
            }
            if (way.equals(Agent.RIGHT)) {
                rotation = (rotation + 1) % 4;
            }
            String absoluteDirection = LocalToAbsolute();
            if (way.equals(Agent.FORWARD) || way.equals(Agent.BACKWARD)) {
                int i = way.equals(Agent.FORWARD) ? 1 : -1;
                if (absoluteDirection.equals(Agent.NORTH) && y - i >= 0 && y - i < window.cells[0].length) {
                    if (checkNextStep(x, y - i)) {
                        y -= i;
                    }

                } else if (absoluteDirection.equals(Agent.SOUTH) && y + i >= 0 && y + i < window.cells[0].length) {
                    if (checkNextStep(x, y + i)) {
                        y += i;
                    }

                } else if (absoluteDirection.equals(Agent.WEST) && x - i >= 0 && x - i < window.cells.length) {
                    if (checkNextStep(x - i, y)) {
                        x -= i;
                    }

                } else if (absoluteDirection.equals(Agent.EAST) && x + i >= 0 && x + i < window.cells.length) {
                    if (checkNextStep(x + i, y)) {
                        x += i;
                    }
                }
            }
        }

        public boolean checkNextStep(int x, int y) {
            return window.cells[x][y].isCrossable();
        }

        private String LocalToAbsolute() {
            return new String[]{Agent.NORTH, Agent.EAST, Agent.SOUTH, Agent.WEST}[rotation];
        }
    }
}
