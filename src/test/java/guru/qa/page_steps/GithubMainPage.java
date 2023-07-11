package guru.qa.page_steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GithubMainPage {
    public static String githubPageLink = "https://github.com";
    SelenideElement collapsedSearchBar = $(".header-search-button");
    SelenideElement expandedSearchBar = $("#query-builder-test");
    SelenideElement issueTab = $("#issues-tab");

    @Step("Открываем главную страницу GitHub")
    public void openPage() {
        open(githubPageLink);
    }

    @Step("Кликаем в строку поиска")
    public void clickInTheSearchBar() {
        collapsedSearchBar.click();
    }

    @Step("Вставляем значение в строку поиска. Нажимаем Enter")
    public void enteringValueInSearchBar(String value) {
        expandedSearchBar
                .setValue(value)
                .pressEnter();
    }

    @Step("Кликаем по вкладке с Issues")
    public void issueTabClick() {
        issueTab.click();
    }

    @Step("Проверяем название Issue")
    public void issueNameCheck(String issueName) {
        $(byText(issueName)).should(Condition.exist);
    }

    @Step("Кликаем на подходящий результат")
    public void selectProject(String projectName) {
        $(linkText(projectName)).click();
    }
}
