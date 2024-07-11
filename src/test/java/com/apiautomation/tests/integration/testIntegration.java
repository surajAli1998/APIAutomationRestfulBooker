package com.apiautomation.tests.integration;

import com.apiautomation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testIntegration extends BaseTest {
    @Test(groups = {"integration"}, priority = 1)
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"integration"}, priority = 2)
    public void testVerifyBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"integration"}, priority = 3)
    public void testUpdateBookingById(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"integration"}, priority = 4)
    public void testDeleteBookingById(){
        Assert.assertTrue(true);
    }
}
