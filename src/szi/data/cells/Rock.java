package szi.data.cells;

import szi.data.Cell;

import javax.swing.*;
import java.awt.*;

public class Rock implements Cell {

    private String icon = "C:\\Users\\Guest\\Pictures\\szi\\rock.png";

    @Override
    public void cross() {}


    public ImageIcon getIcon() {
        ImageIcon icon = new ImageIcon(this.icon);
        return icon;
    }
    @Override
    public Color getColor() {
        return new Color(142, 162, 181);
    }

    @Override
    public double getCrossingCost() {
        return 1000;
    }

    @Override
    public double getIncome() {
        return 0;
    }

    @Override
    public boolean isCrossable() {
        return false;
    }

    @Override
    public void nextDay() {
    }

    @Override
    public String getName() {
        return "ROCK";
    }
}
