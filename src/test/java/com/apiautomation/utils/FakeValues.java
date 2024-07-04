package com.apiautomation.utils;

import com.github.javafaker.Faker;

public class FakeValues {
    Faker faker;
    public String getFirstName(){
        faker = new Faker();
        return faker.name().firstName();
    }
    public String getLastName(){
        faker = new Faker();
        return faker.name().lastName();
    }
}
