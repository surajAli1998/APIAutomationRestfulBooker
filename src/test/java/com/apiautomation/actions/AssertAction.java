package com.apiautomation.actions;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertAction {
    public void verifyResponseBody(String actual, String expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(Integer actual, Integer expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(Boolean actual, Boolean expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(Double actual, Double expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyInvalidStatusCode(Response response){
        Assert.assertTrue(String.valueOf(response.statusCode()).startsWith("500"), "The status code is: " + response.statusCode());
    }
}
