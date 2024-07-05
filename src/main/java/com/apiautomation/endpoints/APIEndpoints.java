package com.apiautomation.endpoints;

public class APIEndpoints {
    private static String BASE_URL = "https://restful-booker.herokuapp.com";
    private static String AUTH = "/auth";
    private static String CREATE_UPDATE_GET_BOOKING = "/booking";
    private static String SERVER_HEALTH = "/ping";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getAUTH() {
        return AUTH;
    }

    public static String getCreateUpdateGetBooking() {
        return CREATE_UPDATE_GET_BOOKING;
    }

    public static String getServerHealth() {
        return SERVER_HEALTH;
    }
}
