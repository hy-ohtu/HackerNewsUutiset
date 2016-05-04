package com.mycompany.hackernewsuutiset;

import com.mycompany.hackernewsuutiset.Uutinen;
import org.junit.Test;
import org.junit.Assert;

public class UutinenTest {

    @Test
    public void testToString() {
        Uutinen uutinen = new Uutinen();
        Assert.assertEquals(uutinen.toString(), "null by null, url: null");
    }
}