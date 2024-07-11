package com.apiautomation.tests.crud;

import com.apiautomation.actions.AssertAction;
import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.BookingData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestGetBookingForABookingId extends BaseTest {
    @Test(groups = {"smoke"})
    public void getBookingForABookingId(){
        setConfig();
        requestSpecification.basePath(APIEndpoints.getCreateUpdateGetBooking()+"/2345");
        response = RestAssured.given(requestSpecification).when().log().all().get();
        validatableResponse = response.then().log().all();
        BookingData bookingData = payloadManager.BookingDataDeserialize(response.asString());
        assertAction.verifyInvalidStatusCode(response);
        assertAction.verifyResponseBody(bookingData.getAdditionalneeds(),"Dinner","Additional need: Dinner");
        assertThat(bookingData.getFirstname()).isEqualTo("Suraj");
        jsonPath = JsonPath.from(response.asString());
        assertThat(jsonPath.getString("firstname")).isEqualTo("Suraj");
        assertThat(jsonPath.getString("bookingdates.checkin")).isNotNull();
        System.out.println(jsonPath.getString("bookingdates.checkin"));
    }
}
