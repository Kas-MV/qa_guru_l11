package guru.qa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubHomePage {
    public static String githubPageLink = "https://github.com";
    SelenideElement collapsedSearchBar = $(".header-search-button");
    SelenideElement expandedSearchBar = $("#query-builder-test");

    public void openPage() {
        open(githubPageLink);
    }

    public void clickInTheSearchBar() {
        collapsedSearchBar.click();
    }

    public void enteringValueInSearchBar(String value) {
        expandedSearchBar
                .setValue(value)
                .pressEnter();
    }
}
