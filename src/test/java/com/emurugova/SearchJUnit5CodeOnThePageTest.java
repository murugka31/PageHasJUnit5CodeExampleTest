package com.emurugova;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchJUnit5CodeOnThePageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2100x1080";
    }

    @Test
    void searchAvailabilityOfCodeExample(){
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").parent().click();
        $("#wiki-body").parent().shouldHave(text("Soft assertions"));
        $(".markdown-body").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
