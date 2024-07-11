package com.apiautomation.tests.crud;

import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.TokenResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCreateAuthToken extends BaseTest {
    @Test(groups = {"smoke"})
    public void createToken(){
        setConfig();
        requestSpecification.basePath(APIEndpoints.getAUTH());
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createAuthTokenAsString())
                .post();

        validatableResponse = response.then().log().all();
        TokenResponse tokenResponse = payloadManager.tokenResponseDeserialize(response.asString());
        assertThat(tokenResponse.getToken()).isNotNull();
        assertAction.verifyInvalidStatusCode(response);
    }
}
