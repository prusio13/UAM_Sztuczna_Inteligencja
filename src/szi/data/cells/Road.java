package szi.data.cells;

import szi.data.Cell;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Road implements Cell {

    @Override
    public void cross() {}

    @Override
    public Color getColor() {
        return new Color(50,50,50);
    }

    @Override
    public double getCrossingCost() {
        return 10;
    }

    @Override
    public double getIncome() {
        return 0;
    }

    @Override
    public boolean isCrossable() {
        return true;
    }

    @Override
    public void nextDay() {

    }
}
