package com.apiautomation.base;

import com.apiautomation.actions.AssertAction;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.modules.PayloadManager;
import com.apiautomation.pojos.TokenResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

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

    public String getToken(){
        setConfig();
        requestSpecification.basePath(APIEndpoints.getAUTH());
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createAuthTokenAsString())
                .post();

        validatableResponse = response.then().log().all();
        TokenResponse tokenResponse = payloadManager.tokenResponseDeserialize(response.asString());
        return tokenResponse.getToken();
    }
}
