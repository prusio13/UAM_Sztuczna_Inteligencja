package szi.data;

/**
 * Created by Fingal on 02.04.2016.
 */
public class State {

    private double humidityState;
    private double temperatureState;
    private double soilQualityState;
    private double pestState;
    private double damageResistanceState;
    private boolean isDamage;
    public State(){}
    public State(double humidityState, double temperatureState, double pestAcceptableState, double soilQualityState, double damageResistanceState,boolean isDamage){
        this.humidityState = humidityState;
        this.temperatureState = temperatureState;
        this.pestState = pestAcceptableState;
        this.soilQualityState = soilQualityState;
        this.damageResistanceState = damageResistanceState;
    }
    public double getDamage(){
        if (isDamage) return 1;
        else return 0;
    }
    public double getHumidityState() {
        return humidityState;
    }

    public double getPestState() {
        return pestState;
    }

    public double getSoilQualityState() {
        return soilQualityState;
    }

    public double getTemperatureState() {
        return temperatureState;
    }
    public void setHumidityState(double humidityState) {
        this.humidityState = humidityState;
    }

    public void setTemperatureState(double temperatureState) {
        this.temperatureState = temperatureState;
    }

    public void setSoilQualityState(double soilQualityState) {
        this.soilQualityState = soilQualityState;
    }

    public void setPestState(double pestState) {
        this.pestState = pestState;
    }

    public void setDamageResistanceState(double damageResistanceState) {
        this.damageResistanceState = damageResistanceState;
    }

    public void setDamage(boolean damage) {
        isDamage = damage;
    }
}
