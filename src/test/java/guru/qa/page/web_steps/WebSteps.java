package guru.qa.page.web_steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    public static String githubPageLink = "https://github.com";
    SelenideElement collapsedSearchBar = $(".header-search-button");
    SelenideElement expandedSearchBar = $("#query-builder-test");
    SelenideElement issueTab = $("#issues-tab");

    @Step("Открываем главную страницу GitHub")
    public WebSteps openPage() {
        open(githubPageLink);
        return this;
    }

    @Step("Кликаем в строку поиска")
    public WebSteps clickInTheSearchBar() {
        collapsedSearchBar.click();
        return this;
    }

    @Step("Вставляем значение в строку поиска. Нажимаем Enter")
    public WebSteps enteringValueInSearchBar(String value) {
        expandedSearchBar
                .setValue(value)
                .pressEnter();
        return this;
    }

    @Step("Кликаем на подходящий результат")
    public WebSteps selectProject(String projectName) {
        $(linkText(projectName)).click();
        return this;
    }

    @Step("Кликаем по вкладке с Issues")
    public WebSteps issueTabClick() {
        issueTab.click();
        return this;
    }

    @Step("Проверяем название Issue")
    public void issueNameCheck(String issueName) {
        $(byText(issueName)).should(Condition.exist);
    }
}
