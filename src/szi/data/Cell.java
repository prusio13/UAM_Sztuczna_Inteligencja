package szi.data;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public interface Cell {
    void cross();
    Color getColor();
    double getCrossingCost();
    double getIncome();
    boolean isCrossable();
    void nextDay();
    String getName();

}
