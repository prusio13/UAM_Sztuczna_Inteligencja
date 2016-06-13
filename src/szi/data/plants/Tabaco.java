package szi.data.plants;

import szi.data.LinearProperty;
import szi.data.Plant;
import szi.data.QuadraticProperty;

import java.awt.*;

/**
 * Created by Fingal on 02.04.2016.
 */
public class Tabaco extends Plant {

    public Tabaco() {
        this.humidityProperty = new QuadraticProperty(0.4, 0.6, 0.8);
        this.temperatureProperty = new QuadraticProperty(0.7, 1., 2.0);
        this.soilQualityProperty = new QuadraticProperty(0.6, 2., 0.7);
        this.pestAcceptableProperty = new LinearProperty(0.7, -0.3);
        this.damageValue = 0.7;
        this.value = 100.;
        this.growthTime = 60;
        this.price = 10.;
        this.color = new Color(187, 79, 68);
        this.name = "TABACO";
    }
}
