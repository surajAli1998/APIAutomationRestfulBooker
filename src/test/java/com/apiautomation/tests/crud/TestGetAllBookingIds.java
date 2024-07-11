package com.apiautomation.tests.crud;

import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.BookingId;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestGetAllBookingIds extends BaseTest {
    @Test(groups = {"smoke"})
    public void getAllBookingId(){
        ArrayList<BookingId> list = new ArrayList<>();
        setConfig();
        requestSpecification.basePath(APIEndpoints.getCreateUpdateGetBooking());
        response = RestAssured.given(requestSpecification).when().log().all().get();
        validatableResponse = response.then().log().all();
        assertAction.verifyInvalidStatusCode(response);
        System.out.println(payloadManager.allBookingIdsDeserialize(response.asString()).getBookingid());
    }
}
