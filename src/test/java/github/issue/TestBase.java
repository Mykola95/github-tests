package github.issue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import github.issue.webstepsstyle.steps.WebSteps;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.nio.charset.StandardCharsets;

public class TestBase {
    public WebSteps steps = new WebSteps();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    public void saveSourse() {
        steps.attachPageSource();
    }
}
