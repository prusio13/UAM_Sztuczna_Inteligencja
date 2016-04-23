package szi.data.plants;

import szi.data.LinearProperty;
import szi.data.Plant;
import szi.data.QuadraticProperty;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Corn extends Plant {
    public Corn() {
        this.humidityProperty =new QuadraticProperty(0.1, 0.8, 0.5);
        this.temperatureProperty =  new QuadraticProperty(0.1,0.7,0.5);
        this.soilQualityProperty =  new QuadraticProperty(0.1, 2., 0.7);
        this.pestAcceptableProperty =  new LinearProperty(0.7, -0.3);
        this.damageValue =  0.7;
        this.value =  10.;
        this.growthTime =  20;
        this.price = 2.;
        this.color = new Color(161, 161, 59);
        this.name = "CORN";
    }
}
