package szi.data;

/**
 * Created by Fingal on 01.04.2016.
 */
public class QuadraticProperty implements Property{
    private double min;
    private double max;
    private double peak;
    public QuadraticProperty(double min, double max, double peak){
        this.min=min;
        this.max=max;
        this.peak=peak;
    }
    public double getValue(double param){
        return -(4*peak)/((min-max)*(min-max))*(param - min)*(param-max);
    }

    @Override
    public double getBest() {
        if (peak>0) return (min+max)/2;
        else{
            if (getValue(0)>getValue(1)) return 0;
            else return 1;
        }
    }
}
