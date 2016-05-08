package szi;

import szi.data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Window extends JFrame implements KeyListener {

    //public static Agent agent = new Agent(3, 11);
    public static Agent agent = new Agent(5, 8);
    public CellMap map;
    public Cell[][] cells;
    static Timer timer = new Timer();
    private int sizeX;
    private int sizeY;
    static Window window = new Window();
    static Time time = new Time();
    private AStar aStar;


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
        AStar.runAStar(agent.getX(), agent.getY(), agent.rotation, 20, 13);
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
                        Image mud = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\mud.png").getImage();
                        g.drawImage(mud, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "ROAD") {
                        Image road = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\road.png").getImage();
                        g.drawImage(road, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "TABACO") {
                        Image tabaco = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\tabaco.png").getImage();
                        g.drawImage(tabaco, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "CORN") {
                        Image corn = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\corn.png").getImage();
                        g.drawImage(corn, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "BEETROOT") {
                        Image beetroot = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\beetroot.png").getImage();
                        g.drawImage(beetroot, i * 40, j * 40, null);
                    } else if (cells[i][j].getName() == "ROCK") {
                        Image rock = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\rock.png").getImage();
                        g.drawImage(rock, i * 40, j * 40, null);
                    }
                }
            }

            Image water = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\water.png").getImage();
            g.drawImage(water, 8 * 40, 5 * 40, null);

            Image house = new ImageIcon(System.getProperty("user.dir") + "\\src\\graphics\\house.png").getImage();
            g.drawImage(house, 0, 0, null);

            Image hour = new ImageIcon(Time.getIcon()).getImage();
            g.drawImage(hour, 24 * 40 + 5, 1 * 40, null);

            Image weather = new ImageIcon(Weather.getIcon()).getImage();
            g.drawImage(weather, 24 * 40 + 5, 4 * 40, null);

            Image tractor = new ImageIcon(Agent.getIcon()).getImage();
            g.drawImage(tractor, agent.getX() * 40, agent.getY() * 40, null);
        } catch (Exception e) {
            System.out.println("Natrafiłem na problem: " + e.toString());
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
                System.out.println("CZAS: " + Time.getMonth() + " dzień " + Time.getDay() + ". godzina " + Time.getHour() + ":00    " + Time.dayOrNight());
                Agent.repaintGraphic();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
