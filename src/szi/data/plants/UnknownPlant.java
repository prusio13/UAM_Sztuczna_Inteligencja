package szi.data.plants;

import szi.PlantClassifier;
import szi.data.Plant;

import java.util.Random;

/**
 * Created by andrzej on 30.05.16.
 */
public class UnknownPlant extends Plant{
    private float height;
    private float size;
    private String color;
    private String crop;
    private PlantClassifier classifier;
    private static Random generator = new Random();

    public UnknownPlant(){
        this(generator.nextFloat()*100,generator.nextFloat()*10,PlantClassifier.getColors()[generator.nextInt(PlantClassifier.getColors().length-1)],PlantClassifier.getCrops()[generator.nextInt(PlantClassifier.getCrops().length-1)]);
    }

    public UnknownPlant(float height, float size, String color, String crop) {
        this.height = height;
        this.size = size;
        this.color = color;
        this.crop = crop;
        try {
            this.classifier = new PlantClassifier();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getValue() {
        try {
            return classifier.getCost(height, size, color, crop);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getName(){
        try {
            return classifier.recognizePlant(height, size, color, crop);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString(){
        return (Double.toString(height)+", "+Double.toString(size)+", "+color+", "+crop+Double.toString(getValue()));
    }
}
