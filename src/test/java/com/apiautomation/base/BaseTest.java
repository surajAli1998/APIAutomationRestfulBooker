package com.apiautomation.base;

import com.apiautomation.actions.AssertAction;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.modules.PayloadManager;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public AssertAction assertAction;
    public JsonPath jsonPath;
    public Gson gson;
    @BeforeTest
    public void setConfig(){
        payloadManager = new PayloadManager();
        assertAction = new AssertAction();
        requestSpecification = new RequestSpecBuilder().setBaseUri(APIEndpoints.getBaseUrl())
                .setContentType(ContentType.JSON).build().log().all();

    }
}
