package com.demoga.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.github.javafaker.Faker;
import java.util.Random;

public class TestData {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


    static Faker faker = new Faker();
    static Random random = new Random();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1975, 2008)),
            subject = getRandomSubject(),
            hobbies = getRandomHobby(),
            picture = "img/1.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int randomIndex = random.nextInt(month.length);
        return month[randomIndex];
    }

    public static String getRandomSubject() {
        String[] subject = {"Maths", "Chemistry", "Computer Science",
                "Commerce", "Economics"};
        int randomIndex = random.nextInt(subject.length);
        return subject[randomIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomIndex = random.nextInt(hobbies.length);
        return hobbies[randomIndex];
    }


}
