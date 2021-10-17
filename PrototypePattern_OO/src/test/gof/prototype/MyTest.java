package gof.prototype;

import org.junit.Assert;
import org.junit.Test;

public class MyTest {

    @Test
    public void deepCloneTest() {
        Car audi = new Car("A6", 1.9, 130);
        Car copy = audi.deepClone();

        audi.gotoXY(20,30);
        audi.tune();

        Assert.assertTrue(audi.location != copy.location);
        Assert.assertTrue(audi.engine.getPower() != copy.engine.getPower());
    }

    @Test
    public void shallowCloneTest() {
        Car audi = new Car("A6", 1.9, 130);
        Car copy = audi.shallowClone();

        audi.gotoXY(20,30);
        audi.tune();

        Assert.assertEquals(audi.engine.getPower(), copy.engine.getPower());
        Assert.assertEquals(audi.location, copy.location);
    }

}
