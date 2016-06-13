package szi.data.cells;

import szi.data.Cell;
import szi.data.Plant;
import szi.data.State;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Field implements Cell {

    Plant plant;

    double plantVitality;

    int daysPassed;

    State state;

    public Field(State state) {
        this.state = state;
        plant = null;
    }

    public Field(State state, Plant plant) {
        this.state = state;
        this.plant = plant;
        plantVitality = 0.3;
        daysPassed = 0;
    }

    public boolean isPlanted() {
        return (plant != null);
    }

    private void removePlant() {
        if (plantVitality <= 0) {
            plantVitality = 0.;
            plant = null;
            daysPassed = 0;
        }
    }

    public void nextDay() {
        if (plant != null) {
            plantVitality = Math.min(1, plantVitality + Math.max(1 - plantVitality, 0.5) * plant.getEffect(state));
            daysPassed++;
//            removePlant();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void plant(Plant plant) {
        this.plant = plant;
        daysPassed = 0;
        plantVitality = 0.1;
    }

    @Override
    public void cross() {
        plantVitality = Math.max(0., plantVitality - plant.getDamageValue());
        removePlant();
    }

    @Override
    public Color getColor() {
        if (isPlanted()) return plant.getColor();
        else return new Color(106, 87, 63);
    }

    @Override
    public double getCrossingCost() {
        return plant.getValue() * 100;
        //return plant.getValue()*plant.getDamageValue();
    }

    public double getPlantVitality() {
        return plantVitality;
    }

    @Override
    public double getIncome() {
        if (plant.getGrowthTime() >= daysPassed) {
            return plant.getValue() * plantVitality + 10;
        } else {

            return 0;
        }
    }

    @Override
    public boolean isCrossable() {
        return true;
    }

    public Plant getPlant() {
        return plant;
    }

    public double crop() {
        double income = getIncome();
        plant = null;
        daysPassed = 0;
        return income;
    }

    @Override
    public String getName() {
        if (isPlanted()) return plant.getName();
        else return "FIELD";
    }

    @Override
    public String toString() {
        if (isPlanted()) return plant.toString();
        else return "";
    }
}
