package github.issue.selenidestyle;

import com.codeborne.selenide.Configuration;
import github.issue.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTests extends TestBase {

    @Test
    public void testIssueName() {
//        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
