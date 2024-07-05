package com.apiautomation.modules;

import com.apiautomation.pojos.BookingData;
import com.apiautomation.pojos.BookingDates;
import com.apiautomation.pojos.BookingResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class PayloadManager {

    Gson gson;
    public String createBookingPayloadAsString(){
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-01-12");
        bookingDates.setCheckout("2023-06-12");

        BookingData bookingData = new BookingData();
        bookingData.setFirstname("Suraj");
        bookingData.setLastname("Ali");
        bookingData.setTotalPrice(1235);
        bookingData.setDepositpaid(true);
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

    public BookingResponse bookingResponseDeserialize(String response){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(response,BookingResponse.class);
        return bookingResponse;
    }
}
