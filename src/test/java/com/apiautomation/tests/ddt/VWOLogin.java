package com.apiautomation.tests.ddt;

import com.apiautomation.pojos.VWOLoginRequest;
import com.apiautomation.utils.ExcelUtils;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class VWOLogin {

    public static String baseURL = "https://app.vwo.com";
    public static String basePath = "/login";

    @Test(dataProvider = "getData",dataProviderClass = ExcelUtils.class)
    public void testLogin(String username, String password){
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);

        //setting up the request payload
        VWOLoginRequest vwoLoginRequest = new VWOLoginRequest();
        vwoLoginRequest.setUsername(username);
        vwoLoginRequest.setPassword(password);
        vwoLoginRequest.setRemember(false);
        vwoLoginRequest.setRecaptchaResponseField("");
        Gson gson = new Gson();
        String requestPayload = gson.toJson(vwoLoginRequest);

        //setting up the request specification
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURL)
                .setBasePath(basePath).setContentType(ContentType.JSON).build().log().all();
        Response response = RestAssured.given(requestSpecification).when()
                .body(requestPayload).post();
        ValidatableResponse validatableResponse = response.then().log().all();
        System.out.println(response.asString());
        validatableResponse.statusCode(401);
    }
}
