package github.issue;

import com.codeborne.selenide.Configuration;
import github.issue.webstepsstyle.steps.WebSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public WebSteps steps = new WebSteps();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    public void saveSource() {
        steps.attachPageSource();
    }
}
