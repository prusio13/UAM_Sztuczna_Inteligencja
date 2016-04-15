package szi.data.cells;

import szi.data.Cell;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Water implements Cell {

    @Override
    public void cross() {}

    @Override
    public Color getColor() {
        return new Color(0, 13, 181);
    }

    @Override
    public double getCrossingCost() {
        return -1;
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
}
