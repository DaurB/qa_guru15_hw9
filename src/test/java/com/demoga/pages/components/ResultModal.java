package com.demoga.pages.companents;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    private final static String TITLE_TEXT = "Thanks for submitting the form";


    public ResultModal isVisible() {
        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultModal checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
