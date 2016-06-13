package szi.data.cells;

import szi.data.Cell;
import szi.data.Weather;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Mud implements Cell {

    @Override
    public void cross() {
    }

    @Override
    public Color getColor() {
        if (Weather.getType() == Weather.SUN) {
            return new Color(50, 50, 50);
        } else {
            return new Color(34, 21, 5);
        }
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
        if (Weather.getType() == Weather.SUN) {
            return true;
        }
        //return false;
        return true;
    }

    @Override
    public void nextDay() {

    }

    @Override
    public String getName() {
        if (Weather.getType() == Weather.SUN) {
            return "ROAD";
        } else {
            return "MUD";
        }
    }
}
