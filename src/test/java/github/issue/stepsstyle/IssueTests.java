package github.issue.stepsstyle;

import github.issue.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static github.testdata.TestDada.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueTests extends TestBase {

    @Test
    public void testIssueName() {
        Allure.label("owner", "danylo");
        Allure.feature("Issues");
        Allure.story("Some Text");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com");

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + repository, () -> {
            $(linkText(repository)).click();
        });

        step("Проверяем названия Issue в репозитории" + repository, () -> {
            $("#issues-tab").shouldHave(text(tab));
        });
    }
}
