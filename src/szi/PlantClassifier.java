package szi;

import weka.classifiers.Classifier;
import weka.core.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by andrzej on 30.05.16.
 */
public class PlantClassifier {

    private static final String[] names = new String[]{"buraki", "ziemniaki", "gruszki", "wisnie", "truskawki", "maliny", "jagody", "pszenica"};

    private static final String[] colors = new String[]{"zielony", "zolty", "czerwony", "brazowy", "czarny"};

    private static final String[] crops = new String[]{"owoce", "bulwy", "nasiona"};

    private static final HashMap<String, Integer> costs = fillCosts();

    private Instances source;

    private Classifier classifier;

    public PlantClassifier(String filepath) throws Exception {
        source = instancesFromFile();
        classifier = (Classifier) SerializationHelper.read(filepath);
    }

    public PlantClassifier() throws Exception {
        this(System.getProperty("user.dir") + "/resorces/plony");
    }

    private static Instances instancesFromFile() throws IOException {
        Instances instances = new Instances(
                new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resorces/plony.arff")));
        instances.setClassIndex(instances.numAttributes() - 1);
        return instances;

    }

    private static Instances createDataSource() {
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("plant_height"));
        attributes.add(new Attribute("crop_size"));
        ArrayList<String> values = new ArrayList<>();
        values.add("zielony");
        values.add("zolty");
        values.add("czerwony");
        values.add("brazowy");
        values.add("czarny");
        attributes.add(new Attribute("color", values));
        values = new ArrayList<>();
        values.add("owoce");
        values.add("bulwy");
        values.add("nasiona");
        attributes.add(new Attribute("crop", values));
        values.add("buraki");
        values.add("ziemniaki");
        values.add("gruszki");
        values.add("wisnie");
        values.add("truskawki");
        values.add("maliny");
        values.add("jagody");
        values.add("pszenica");
        Attribute attribute = new Attribute("name", values);
        attributes.add(new Attribute("name", values));
        Instances dataSet = new Instances("vegetables", attributes, 20);
        dataSet.setClassIndex(dataSet.numAttributes() - 1);
        return dataSet;
    }

    private static HashMap<String, Integer> fillCosts() {
        HashMap<String, Integer> result = new HashMap<>();

        result.put("buraki", 10);
        result.put("ziemniaki", 20);
        result.put("gruszki", 1000);
        result.put("wisnie", 1000);
        result.put("truskawki", 40);
        result.put("maliny", 20);
        result.put("jagody", 50);
        result.put("pszenica", 10);
        return result;
    }

    public static String[] getColors() {
        return colors;
    }

    public static String[] getCrops() {
        return crops;
    }

    public static String[] getNames() {
        return names;
    }

    private Instance createInstance(float height, float size, String color, String crop) {
        Instance instance = new DenseInstance(5);
        instance.setDataset(source);
        instance.setValue(0, height);
        instance.setValue(1, size);
        instance.setValue(2, color);
        instance.setValue(3, crop);
        return instance;
    }

    public String recognizePlant(float height, float size, String color, String crop) throws Exception {
        return names[(int) classifier.classifyInstance(createInstance(height, size, color, crop))];
    }

    public int getCost(float height, float size, String color, String crop) throws Exception {
        return costs.get(recognizePlant(height, size, color, crop));
    }
}
