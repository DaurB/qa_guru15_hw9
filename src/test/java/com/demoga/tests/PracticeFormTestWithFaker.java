package com.demoga.tests;

import com.codeborne.selenide.Configuration;
import com.demoga.pages.PracticeFormPage;
import com.demoga.utils.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PracticeFormTestWithFaker extends TestData {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void practiceFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        practiceFormPage.checkResultModalVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "1.png")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}
