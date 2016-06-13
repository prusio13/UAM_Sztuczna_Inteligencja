package szi.decision;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DecisionEvaluator {

    private static final String PLANT_BACK_DECISION_MAKER_FILE_PATH = "wrocDoBazy.arff";

    private static final String PLANT_ALLOWED_DECISION_MAKER_FILE_PATH = "allowedDecisionMaker.arff";

    private Classifier plantBackDecisionClassifier;

    private Instances plantBackDecisionInstance;

    private Classifier plantAllowedDecisionClassifier;

    private Instances plantAllowedDecisionInstance;


    public DecisionEvaluator() {
        DataSource plantBackDecisionDataSource = null;
        DataSource plantAllowedDecisionDataSource = null;
        try {
            plantBackDecisionDataSource = new DataSource(PLANT_BACK_DECISION_MAKER_FILE_PATH);
            plantAllowedDecisionDataSource = new DataSource(PLANT_ALLOWED_DECISION_MAKER_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            plantBackDecisionInstance = plantBackDecisionDataSource.getDataSet();
            plantAllowedDecisionInstance = plantAllowedDecisionDataSource.getDataSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        plantAllowedDecisionInstance.setClassIndex(2);
        plantAllowedDecisionClassifier = new J48();

        plantBackDecisionInstance.setClassIndex(3);
        plantBackDecisionClassifier = new J48();
        try {
            plantBackDecisionClassifier.buildClassifier(plantBackDecisionInstance);
            plantAllowedDecisionClassifier.buildClassifier(plantAllowedDecisionInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlantAllowed classifyAllowedDecision(double damageValue, double plantVitality) {
        Instance currentInstance = new DenseInstance(3);

        currentInstance.setValue(0, damageValue);
        currentInstance.setValue(1, plantVitality);
        currentInstance.setMissing(2);
        currentInstance.setDataset(plantAllowedDecisionInstance);
        double toReturn = -1;
        try {
            toReturn = plantAllowedDecisionClassifier.classifyInstance(currentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PlantAllowed.values()[(int) toReturn];
    }

    public TractorAction classifyBackDecision(int currentCountBeetroot, int currentCountCorn, int currentCountTabaco) {
        Instance currentInstance = new DenseInstance(4);

        currentInstance.setValue(0, currentCountBeetroot);
        currentInstance.setValue(1, currentCountCorn);
        currentInstance.setValue(2, currentCountTabaco);
        currentInstance.setMissing(3);
        currentInstance.setDataset(plantBackDecisionInstance);
        double toReturn = -1;
        try {
            toReturn = plantBackDecisionClassifier.classifyInstance(currentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TractorAction.values()[(int) toReturn];
    }

}