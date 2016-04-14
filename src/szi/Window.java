package szi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener{
    
    Agent agent = new Agent(50, 50);
    Map mapa = new Map();
    
    public Window() {
        super("Agent na Mapie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1200, 600);
        setResizable(false);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1200, 600);
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

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 24; j++) {
                if (Map.Mapa[i][j] == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j*50, i*50, 50, 50);
                }
                if (Map.Mapa[i][j] == 2) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j*50, i*50, 50, 50);
                }
                if (Map.Mapa[i][j] == 3) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(j*50, i*50, 50, 50);
                }
            }
        }
        g.setColor(Color.RED);
        g.fillRect(agent.getX(), agent.getY(), agent.getHeight(), agent.getHeight());
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case 37:
                agent.moveAgent(Agent.LEFT, 5);
                break;
            case 38:
                agent.moveAgent(Agent.UP, 5);
                break;
            case 39:
                agent.moveAgent(Agent.RIGHT, 5);
                break;
            case 40:
                agent.moveAgent(Agent.DOWN, 5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
