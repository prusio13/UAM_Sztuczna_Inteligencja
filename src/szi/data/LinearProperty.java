package szi.data;

/**
 * Created by Fingal on 02.04.2016.
 */
public class LinearProperty implements Property{
    private double zero;
    private double slope;
    public LinearProperty(double zero,double slope){
        this.zero=zero;
        this.slope=slope;
    }
    @Override
    public double getValue(double parm) {
        return parm*(slope-zero);
    }

    @Override
    public double getBest() {
        if (getValue(0)>getValue(1)) return 0;
        else return 1;
    }
}
