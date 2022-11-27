package com.demoga.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoga.pages.companents.CalendarComponent;
import com.demoga.pages.companents.ResultModal;
import com.demoga.pages.companents.StateComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultModal resultModal = new ResultModal();
    private StateComponent stateComponent = new StateComponent();

    // Elements
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    // Actions
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        $("#state").click();
        stateComponent.setState(value);
        return this;
    }

    public PracticeFormPage setCity(String value) {
        $("#city").click();
        stateComponent.setCity(value);
        return this;
    }

    public PracticeFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    //Results
    public PracticeFormPage checkResultModalVisible() {
        resultModal.isVisible();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultModal.checkResult(key, value);
        return this;
    }

}








