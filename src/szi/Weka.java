package szi;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by andrzej on 23.05.16.
 */
public class Weka {

    public static void saveClassifier() throws Exception {
        Classifier cls = new J48();
        Instances instances = new Instances(
                new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resorces/plony.arff")));
        instances.setClassIndex(instances.numAttributes() - 1);
        cls.buildClassifier(instances);
        SerializationHelper.write(System.getProperty("user.dir") + "/resorces/plony", cls);
    }

    public static void testClassifier() throws Exception {
        Instances trainInstances = new Instances(
                new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resorces/plony.arff")));
        trainInstances.setClassIndex(trainInstances.numAttributes() - 1);
        Instances testInstances = new Instances(
                new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resorces/plony test.arff")));
        testInstances.setClassIndex(testInstances.numAttributes() - 1);
        Evaluation eval = new Evaluation(trainInstances);
        Classifier cls = (Classifier) SerializationHelper.read(System.getProperty("user.dir") + "/resorces/plony");
        eval.evaluateModel(cls, testInstances);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));

    }

    public static void main(String[] args) throws Exception {
        saveClassifier();
        testClassifier();
        //Classifier cls = (Classifier) SerializationHelper.read(System.getProperty("user.dir")+"/resorces/plony");
        /*Classifier cls = new J48();
        Instances instances =  new Instances(new BufferedReader(new FileReader(System.getProperty("user.dir")+"/resorces/plony.arff")));
        instances.setClassIndex(instances.numAttributes()-1);
        cls.buildClassifier(instances);
        Evaluation eval = new Evaluation(instances);
        Instance iExample = new DenseInstance(5);
        iExample.setValue(0,30.10);
        iExample.setValue(1,5.1);
        iExample.setDataset(instances);
        iExample.setValue(2,"czerwony");
        iExample.setValue(3,"bulwy");
        System.out.println(cls.classifyInstance(iExample));*/
        //UnknownPlant plant=new UnknownPlant();
        //System.out.println(plant.getValue());
        //PlantClassifier classifier = new PlantClassifier();
        //System.out.println(classifier.recognizePlant(30.10f,5.1f,"czerwony","bulwy"));
    }
}
