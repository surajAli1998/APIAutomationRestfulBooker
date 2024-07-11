package com.apiautomation.tests.crud;

import com.apiautomation.actions.AssertAction;
import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.BookingResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class TestCreateBooking extends BaseTest {
    @Test(groups = {"smokeTest"})
    public void createBooking(){
        setConfig();
        requestSpecification.basePath(APIEndpoints.getCreateUpdateGetBooking());
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createBookingPayloadAsString())
                .post();
        validatableResponse = response.then().log().all();
        BookingResponse bookingResponse = payloadManager.bookingResponseDeserialize(response.asString());
        assertThat(bookingResponse.getBookingid()).isNotZero();
//        String stringResponse = bookingResponse.getBookingData().toString();
        jsonPath = JsonPath.from(response.asString());
        String actualFirstName = jsonPath.getString("booking.firstname");
        assertThat(actualFirstName).isEqualTo("Suraj");
        assertAction.verifyResponseBody(bookingResponse.getBookingData().getFirstname(),"Suraj","Firstname did not match");
        assertAction.verifyInvalidStatusCode(response);
    }
}
