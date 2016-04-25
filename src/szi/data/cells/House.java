package szi.data.cells;

import szi.data.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class House implements Cell {

    private String icon = "C:\\Users\\Guest\\Pictures\\szi\\water.png";

    @Override
    public void cross() {}


    public ImageIcon getIcon() {
        ImageIcon icon = new ImageIcon(this.icon);
        return icon;
    }
    @Override
    public Color getColor() {
        return new Color(181, 0, 5);
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
        return "HAUSE";
    }
}
