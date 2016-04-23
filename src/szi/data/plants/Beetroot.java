package szi.data.plants;

import szi.data.LinearProperty;
import szi.data.Plant;
import szi.data.QuadraticProperty;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Beetroot extends Plant {
    public Beetroot() {
        this.humidityProperty =new QuadraticProperty(0.4, 0.9, 0.2);
        this.temperatureProperty =  new QuadraticProperty(0.2,0.7,0.7);
        this.soilQualityProperty =  new QuadraticProperty(0.4, 2., 0.5);
        this.pestAcceptableProperty =  new LinearProperty(0.6, -0.4);
        this.damageValue =  0.2;
        this.value =  20.;
        this.growthTime =  20;
        this.price = 5.;
        this.color = new Color(202, 8,0);
        this.name = "BEETROOT";
    }
}
