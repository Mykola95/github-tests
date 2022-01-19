package github.allure.webstepsstyle;

import github.allure.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static github.testdata.TestDada.repository;
import static github.testdata.TestDada.tab;

public class IssueTests extends TestBase {
    @Test
    @Owner("danylo")
    @Feature("Issues")
    @Story("Some Text")
    @DisplayName("Some Text")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com")
    public void testIssueName() {
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.openRepositoryPage(repository);
        steps.shouldSeeTabWithName(tab,repository);
    }
}
