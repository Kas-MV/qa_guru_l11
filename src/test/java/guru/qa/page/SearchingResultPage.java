package guru.qa.page;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class SearchingResultPage {

    public void selectProject(String projectName) {
        $(linkText(projectName)).click();
    }
}
