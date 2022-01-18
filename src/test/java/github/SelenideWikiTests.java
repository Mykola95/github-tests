package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void shouldBeExampleOfCodeForJunit() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("/");
//        $$(".h1-mktg").first().shouldHave(text("Where the world builds software"));
        $(".h1-mktg").shouldHave(text("Where the world builds software"));

        $("[name=q]").setValue("Selenide").pressEnter();
//        $$(".f4").get(1).shouldHave(text("selenide/selenide"));
        $(".f4", 1).shouldHave(text("selenide/selenide"));

        $(".f4", 1).click();
        $("h1").shouldHave(text("selenide / selenide"));

        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Welcome to the selenide wiki!"));

        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
