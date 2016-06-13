package szi;

import szi.data.*;
import szi.data.cells.Field;
import szi.decision.DecisionEvaluator;
import szi.decision.PlantAllowed;
import szi.decision.TractorAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Window extends JFrame implements KeyListener {

    //public static Agent agent = new Agent(3, 11);
    public static Agent agent = new Agent(5, 8);

    static Timer timer = new Timer();

    static Window window = new Window();

    static Time time = new Time();

    public CellMap map;

    public Cell[][] cells;

    private int sizeX;

    private int sizeY;

    private AStar aStar;

    private DecisionEvaluator decisionEvaluator = new DecisionEvaluator();


    public Window() {
        super("Jestę Traktorę");
        agent.addWindow(this);
        Time.addWindow(this);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        cells = Map.create();
        sizeX = cells.length * 40;
        sizeY = cells[0].length * 40;
        setSize(sizeX + 100, sizeY);
        map = new CellMap(cells);
        aStar = new AStar(this, agent);
        AStar.runningChange();
        AStar.runAStar(agent.getX(), agent.getY(), agent.rotation, 20, 6);
        Time.setStepsList(AStar.stepsList);
    }

    public static void main(String[] args) {
        timer.scheduleAtFixedRate(agent, 10, 10);
        time.run();

    }

    @Override
    public void paint(Graphics g) {
        try {
            Cell[][] cells = map.getMap();
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[0].length; j++) {
                    if (cells[i][j].getName() == "MUD") {
                        Image mud = new ImageIcon(System.getProperty("user.dir") + "/src/graphics/mud.png").getImage();
                        g.drawImage(mud, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "ROAD") {
                        Image road = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/road.png").getImage();
                        g.drawImage(road, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "TABACO") {
                        Image tabaco = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/tabaco.png").getImage();
                        g.drawImage(tabaco, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "CORN") {
                        Image corn = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/corn.png").getImage();
                        g.drawImage(corn, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "BEETROOT") {
                        Image beetroot = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/beetroot.png").getImage();
                        g.drawImage(beetroot, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "ROCK") {
                        Image rock = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/rock.png").getImage();
                        g.drawImage(rock, i * 40, j * 40, null);
                    } else {
                        Image tabaco = new ImageIcon(
                                System.getProperty("user.dir") + "/src/graphics/tabaco.png").getImage();
                        g.drawImage(tabaco, i * 40, j * 40, null);
                    }
                }
            }

            Image water = new ImageIcon(System.getProperty("user.dir") + "/src/graphics/water.png").getImage();
            g.drawImage(water, 8 * 40, 5 * 40, null);

            Image house = new ImageIcon(System.getProperty("user.dir") + "/src/graphics/house.png").getImage();
            g.drawImage(house, 0, 0, null);

            Image hour = new ImageIcon(Time.getIcon()).getImage();
            g.drawImage(hour, 24 * 40 + 5, 1 * 40, null);

            Image weather = new ImageIcon(Weather.getIcon()).getImage();
            g.drawImage(weather, 24 * 40 + 5, 4 * 40, null);

            Image tractor = new ImageIcon(Agent.getIcon()).getImage();
            g.drawImage(tractor, agent.getX() * 40, agent.getY() * 40, null);
        } catch (Exception e) {

        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case 37:
                agent.moveAgent(Agent.LEFT);
                break;
            case 38:
                agent.moveAgent(Agent.FORWARD);
                break;
            case 39:
                agent.moveAgent(Agent.RIGHT);
                break;
            case 40:
                agent.moveAgent(Agent.BACKWARD);
                break;
            case 32:
                chop(agent.positionX, agent.positionY);
                System.out.println(cells[agent.positionX][agent.positionY].toString());
                System.out.println(cells[agent.positionX][agent.positionY].getName());
                break;
            /*case 32:
                System.out.println("CZAS: " + Time.getMonth() + " dzień " + Time.getDay() + ". godzina " + Time.getHour() + ":00    " + Time.dayOrNight());
                Agent.repaintGraphic();
                break;*/
        }
    }

    private void nextDayPlants() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.getName() == "TABACO") {
                    cell.nextDay();
                } else if (cell.getName() == "CORN") {
                    cell.nextDay();
                } else if (cell.getName() == "BEETROOT") {
                    cell.nextDay();
                }
            }
        }
    }

    private void chop(int i, int j) {
        nextDayPlants();
        if (cells[i][j].getName() == "TABACO") {
            int ii = agent.choppedYields.get("TABACO");
            agent.choppedYields.put("TABACO", ++ii);
        } else if (cells[i][j].getName() == "CORN") {
            int ii = agent.choppedYields.get("CORN");
            agent.choppedYields.put("CORN", ++ii);
        } else if (cells[i][j].getName() == "BEETROOT") {
            int ii = agent.choppedYields.get("BEETROOT");
            agent.choppedYields.put("BEETROOT", ++ii);
        }

        Field field = (Field) cells[i][j];

        System.out.println("Damage" + field.getPlant().getDamageValue() + "\n Vitality:" +
                field.getPlantVitality());
        PlantAllowed plantAllowed = decisionEvaluator.classifyAllowedDecision(field.getPlant().getDamageValue(),
                field.getPlantVitality());


        switch (plantAllowed) {
            case DAMAGE_ALERT:
                System.out.println("Za bardzo uszkodzona, żeby zebrać");
                break;
            case VITALITY_ALERT:
                System.out.println("Za mała wiatlność, żeby zebrać");
                break;
            case OK:
                checkTractorAction();
                break;

        }


    }

    private void checkTractorAction() {
        TractorAction tractorAction = decisionEvaluator.classifyBackDecision(
                agent.choppedYields.get("BEETROOT"),
                agent.choppedYields.get("CORN"),
                agent.choppedYields.get("TABACO"));


        switch (tractorAction) {
            case BACK:
                System.out.println("Wracam oddać plony");
                AStar.initialize(agent.getX(), agent.getY(), agent.getRotation());
                agent.clearPlants();
                break;
            case CONTINUE:
                System.out.println("Można kontynuować zbieranie");
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
