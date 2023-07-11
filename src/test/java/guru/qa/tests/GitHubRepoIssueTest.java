package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.page.GitHubHomePage;
import guru.qa.page.RepositoryPage;
import guru.qa.page.SearchingResultPage;
import guru.qa.page.web_steps.WebSteps;
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

    public static final String PROJECT_NAME = "qa-guru/qa_guru_14_10";
    public static final String ISSUE_NAME = "Issue for Autotest";

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("Kas-MV")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists Selenide With Listener")
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
    @DisplayName("Issue in repository issue-tab exists lambda syntax")
    void testIssueNameLambdaSyntax() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GitHubHomePage homePage = new GitHubHomePage();
        SearchingResultPage searchingResultPage = new SearchingResultPage();
        RepositoryPage repositoryPage = new RepositoryPage();
        step("1. Открыть главную страницу GitHub", homePage::openPage);
        step("2. Клик в строку поиска", homePage::clickInTheSearchBar);
        step("3. Ввод значения для поиска", () -> homePage.enteringValueInSearchBar(PROJECT_NAME));
        step("4. Клик на подходящий результат", () -> searchingResultPage.selectProject(PROJECT_NAME));
        step("5. Клик на Issues", repositoryPage::issueTabClick);
        step("6. Сравнение название Issue", () -> repositoryPage.issueNameCheck(ISSUE_NAME));
    }

    @Test
    @Feature("Repository issue tab")
    @Story("Assure that specific issue exists")
    @Owner("Kas-MV")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github.com", url = "https://github.com")
    @DisplayName("Issue in repository issue-tab exists annotation step")
    void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps
                .openPage()
                .clickInTheSearchBar()
                .enteringValueInSearchBar(PROJECT_NAME)
                .selectProject(PROJECT_NAME)
                .issueTabClick()
                .issueNameCheck(ISSUE_NAME);
    }
}
