package szi.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fingal on 02.04.2016.
 */
public class QuadraticPropertyTest {
    @Test
    public void getValueTest(){
        QuadraticProperty a = new QuadraticProperty(0,2,10.);
        Assert.assertEquals(10.,a.getValue(1),0.00001);
        Assert.assertEquals(0.,a.getValue(2),0.00001);
        Assert.assertEquals(0.,a.getValue(0),0.00001);
        Assert.assertEquals(-30.,a.getValue(3),0.00001);
    }
}