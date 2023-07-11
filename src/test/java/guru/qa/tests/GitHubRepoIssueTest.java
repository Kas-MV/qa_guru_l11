package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.page_steps.GithubMainPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubRepoIssueTest {

    GithubMainPage githubMainPage = new GithubMainPage();

    public static final String PROJECT_NAME = "qa-guru/qa_guru_14_10";
    public static final String ISSUE_NAME = "Issue for Autotest";


    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("Kas-MV")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void testIssueNameSelenideWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(PROJECT_NAME).pressEnter();
        $(linkText(PROJECT_NAME)).click();
        $("#issues-tab").click();
        $(byText(ISSUE_NAME)).should(Condition.exist);
    }

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("Kas-MV")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void testIssueNameLambdaSyntax() {
        step("1. Открыть главную страницу GitHub", () -> githubMainPage.openPage());
        step("2. Клик в строку поиска", () -> githubMainPage.clickInTheSearchBar());
        step("3. Ввод значения для поиска", () -> githubMainPage.enteringValueInSearchBar(PROJECT_NAME));
        step("4. Клик на подходящий результат", () -> githubMainPage.selectProject(PROJECT_NAME));
        step("5. Клик на Issues", () -> githubMainPage.issueTabClick());
        step("6. Сравнение название Issue", () -> githubMainPage.issueNameCheck(ISSUE_NAME));
    }

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("Kas-MV")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists")
    void testAnnotatedStep() {
        githubMainPage.openPage();
        githubMainPage.clickInTheSearchBar();
        githubMainPage.enteringValueInSearchBar(PROJECT_NAME);
        githubMainPage.selectProject(PROJECT_NAME);
        githubMainPage.issueTabClick();
        githubMainPage.issueNameCheck(ISSUE_NAME);
    }
}
