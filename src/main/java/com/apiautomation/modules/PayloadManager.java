package com.apiautomation.modules;

import com.apiautomation.pojos.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
public class PayloadManager {

    Gson gson;
    public String createBookingPayloadAsString(){

        BookingData bookingData = new BookingData();
        bookingData.setFirstname("Suraj");
        bookingData.setLastname("Ali");
        bookingData.setTotalPrice(1235);
        bookingData.setDepositpaid(true);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-01-12");
        bookingDates.setCheckout("2023-06-12");
        bookingData.setBookingDates(bookingDates);
        bookingData.setAdditionalneeds("Biryani");

        gson = new Gson();
        return gson.toJson(bookingData);
    }

    public String fullUpdateBookingPayloadAsAstring(){
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-01-12");
        bookingDates.setCheckout("2023-06-12");

        BookingData bookingData = new BookingData();
        bookingData.setFirstname("Nafisha");
        bookingData.setLastname("Ali");
        bookingData.setTotalPrice(5543);
        bookingData.setDepositpaid(true);
        bookingData.setBookingDates(bookingDates);
        bookingData.setAdditionalneeds("Chocolate");

        gson = new Gson();
        return gson.toJson(bookingData);
    }

    public BookingResponse bookingResponseDeserialize(String bookingResponseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(bookingResponseString,BookingResponse.class);
        return bookingResponse;
    }

    public String createAuthTokenAsString(){
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("admin");
        authRequest.setPassword("password123");

        gson = new Gson();
        return gson.toJson(authRequest);
    }

    public TokenResponse tokenResponseDeserialize(String tokenResponseString){
        gson = new Gson();
        TokenResponse tokenResponse = gson.fromJson(tokenResponseString,TokenResponse.class);
        return tokenResponse;
    }

    public BookingId allBookingIdsDeserialize(String allBookingIds){
        gson = new Gson();
        BookingId bookingId = gson.fromJson(allBookingIds,BookingId.class);
        return bookingId;
    }

    public BookingData BookingDataDeserialize(String singleBookingData){
        gson = new Gson();
        return gson.fromJson(singleBookingData,BookingData.class);
    }

}
