package com.apiautomation.tests.crud;

import com.apiautomation.actions.AssertAction;
import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.BookingResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class TestCreateBooking extends BaseTest {
    @Test(groups = {"smokeTest"})
    public void createBooking(){
        requestSpecification.basePath(APIEndpoints.getCreateUpdateGetBooking());
        requestSpecification.body(payloadManager.createBookingPayloadAsString());
        response = RestAssured.given(requestSpecification).when().post();
        validatableResponse = response.then().log().all();
        BookingResponse bookingResponse = payloadManager.bookingResponseDeserialize(response.asString());
        assertThat(bookingResponse.getBookingid()).isNotZero();
//        assertThat(bookingResponse.getBookingData().getFirstname()).isEqualTo("Suraj");
//        assertAction.verifyResponseBody(bookingResponse.getBookingData().getFirstname(),"Suraj","Firstname did not match");
        assertAction.verifyInvalidStatusCode(response);
    }
}
