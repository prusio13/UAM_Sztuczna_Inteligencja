package szi.data;

import java.awt.*;

/**
 * Created by Fingal on 01.04.2016.
 */
public class Plant {
    protected Property humidityProperty;
    protected Property temperatureProperty;
    protected Property soilQualityProperty;
    protected Property pestAcceptableProperty;
    protected double damageValue;
    protected double value;
    protected int growthTime;
    protected double price;
    protected Color color;
    protected String name;

    public Plant(){}

    public double getEffect(State state) {
        return humidityProperty.getValue(state.getHumidityState()) *
                pestAcceptableProperty.getValue(state.getPestState()) *
                soilQualityProperty.getValue(state.getSoilQualityState()) *
                temperatureProperty.getValue(state.getTemperatureState());
    }

    public double getValue() {
        return value;
    }

    public double getDamageValue() {
        return damageValue;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}