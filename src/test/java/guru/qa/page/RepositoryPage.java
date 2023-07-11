package guru.qa.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {
    SelenideElement issueTab = $("#issues-tab");

    public void issueTabClick() {
        issueTab.click();
    }

    public void issueNameCheck(String issueName) {
        $(byText(issueName)).should(Condition.exist);
    }

}
