package com.demoga.pages.companents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateComponent {

    public StateComponent setState(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public StateComponent setCity(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

}
