package com.apiautomation.tests.retryLogic;

import com.apiautomation.base.BaseTest;
import com.apiautomation.endpoints.APIEndpoints;
import com.apiautomation.pojos.BookingData;
import com.apiautomation.pojos.BookingResponse;
import com.apiautomation.utils.PropertyReader;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testIntegrationRetry extends BaseTest {

    @Test(groups = {"integration"}, priority = 1)
    public void testCreateBooking(ITestContext iTestContext){
        iTestContext.setAttribute("token",getToken());
        requestSpecification.basePath(APIEndpoints.getCreateUpdateGetBooking());
        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createBookingPayloadAsString())
                .post();
        validatableResponse = response.then().log().all();
        BookingResponse bookingResponse = payloadManager.bookingResponseDeserialize(response.asString());
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());
        assertThat(bookingResponse.getBookingid()).isNotZero();
        assertAction.verifyInvalidStatusCode(response);
    }

    @Test(groups = {"integration"}, priority = 2)
    public void testVerifyBookingDetails(ITestContext iTestContext){
        String bookingId = iTestContext.getAttribute("bookingid").toString();
        String basePath = APIEndpoints.getCreateUpdateGetBooking()+"/"+bookingId;
        requestSpecification.basePath(basePath);
        response = RestAssured.given(requestSpecification).when()
                .get();
        validatableResponse = response.then().log().all();
        BookingData bookingData = payloadManager.BookingDataDeserialize(response.asString());
        assertAction.verifyInvalidStatusCode(response);
        System.out.println(bookingData.getFirstname());
        System.out.println(bookingData.getBookingDates().getCheckin());
    }

    @Test(groups = {"integration"}, priority = 3)
    public void testUpdateBookingById(ITestContext iTestContext){
        String token = iTestContext.getAttribute("token").toString();
        String bookingId = iTestContext.getAttribute("bookingid").toString();
        String basePath = APIEndpoints.getCreateUpdateGetBooking()+"/"+bookingId;
        requestSpecification.basePath(basePath);
        response = RestAssured.given(requestSpecification).cookie("token",token).when()
                .body(payloadManager.fullUpdateBookingPayloadAsAstring())
                .put();
        validatableResponse = response.then().log().all();
        BookingData bookingData = payloadManager.BookingDataDeserialize(response.asString());
        assertAction.verifyInvalidStatusCode(response);
        assertAction.verifyResponseBody(bookingData.getFirstname(), PropertyReader.getProperty("updatedBookingData.firstName"), "First name not matched");
        System.out.println(bookingData.getFirstname());
    }

    @Test(groups = {"integration"}, priority = 4)
    public void testDeleteBookingById(ITestContext iTestContext){
        String token = iTestContext.getAttribute("token").toString();
        String bookingId = iTestContext.getAttribute("bookingid").toString();
        String basePath = APIEndpoints.getCreateUpdateGetBooking()+"/"+bookingId;
        requestSpecification.basePath(basePath);
        response = RestAssured.given(requestSpecification).auth()
                .preemptive().basic("admin","password123")
                .cookie("token",token).when()
                .delete();
        validatableResponse = response.then().log().all();
        assertAction.verifyInvalidStatusCode(response);
    }

}