package app.zendoo.zendoo;

import org.junit.Assert;
import org.junit.Test;

public class AsdTest {
    private Asd asd = new Asd();

    @Test
    public void testAsd() throws Exception {
        int result = asd.asd(0, 0);
        Assert.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme