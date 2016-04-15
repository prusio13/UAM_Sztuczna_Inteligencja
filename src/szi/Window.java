package szi;

import szi.data.Cell;
import szi.data.CellMap;
import szi.data.State;
import szi.data.cells.Field;
import szi.data.cells.Mud;
import szi.data.cells.Road;
import szi.data.cells.Water;
import szi.data.plants.Beetroot;
import szi.data.plants.Corn;
import szi.data.plants.Tabaco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener{
    
    Agent agent = new Agent(2, 2);
    CellMap map;
    private int sizeX;
    private int sizeY;
    public Window() {
        super("Agent na Mapie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        State state = new State(0.5,0.5,0.5,0.5,0.5,false);
        Cell[][] cells = new Cell[][]{
                                        new Cell[]{new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Road()},
                                        new Cell[]{new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Road()},
                                        new Cell[]{new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Road()},
                                        new Cell[]{new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Field(state,new Tabaco()),new Road()},
                                        new Cell[]{new Road(),new Road(),new Road(),new Road(),new Road()},
                                        new Cell[]{new Water(),new Water(),new Water(),new Water(),new Road()},
                                        new Cell[]{new Field(state,new Beetroot()),new Field(state,new Beetroot()),new Field(state,new Corn()),new Mud(),new Road()},
                                        new Cell[]{new Field(state,new Beetroot()),new Field(state,new Beetroot()),new Field(state,new Corn()),new Mud(),new Road()},
                                        new Cell[]{new Field(state,new Beetroot()),new Field(state,new Beetroot()),new Field(state,new Corn()),new Mud(),new Road()},
                                        new Cell[]{new Field(state,new Beetroot()),new Field(state,new Beetroot()),new Field(state,new Corn()),new Mud(),new Road()}
                                    };
        sizeX = cells.length*50;
        sizeY = cells[0].length*50;
        setSize(sizeX, sizeY);
        map = new CellMap(cells);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, sizeX, sizeY);
        /*
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 400, 300);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 350, 400, 300);
        g.setColor(Color.YELLOW);
        g.fillRect(800, 0, 400, 300);
        g.setColor(Color.YELLOW);
        g.fillRect(800, 350, 400, 300);
        //g.setColor(Color.YELLOW);
        //g.fillRect(800, 0, 400, 300);*/
        Cell[][] cells = map.getMap();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                g.setColor(cells[i][j].getColor());
                g.fillRect(i*50, j*50, 50, 50);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(agent.getX()*50, agent.getY()*50, agent.getHeight(), agent.getHeight());
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case 37:
                agent.moveAgent(Agent.LEFT);
                break;
            case 38:
                agent.moveAgent(Agent.UP);
                break;
            case 39:
                agent.moveAgent(Agent.RIGHT);
                break;
            case 40:
                agent.moveAgent(Agent.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
