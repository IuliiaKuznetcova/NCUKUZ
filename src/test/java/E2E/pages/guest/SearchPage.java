package E2E.pages.guest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    private SelenideElement computerScienceTitle = $x("//*[@id=\"courses-grid-non-logged-in\"]/section/div/div[2]/div[2]/div/div/div/div/div/div[1]");
    //private SelenideElement goToComputerScienceButton = $(By.className("(//a[contains(@type,'button')][normalize-space()='GO TO ->'])[1]"));
    private SelenideElement goToComputerScienceButton = $x("//body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]");
    private SelenideElement computerSciencePage = $(byText("Computer Science"));
    private SelenideElement coursesButton = $x("//*[@id=\"home-header-non-logged-in\"]/header/div/div/div/a[2]/span");



    @Step("Go to Courses Page  Переход к странице Courses")
    public void goToCoursesPage(String courseName) {
        computerScienceTitle.shouldHave(Condition.text(courseName));
        goToComputerScienceButton.click();
        computerSciencePage.should(exist);
    }

    @Step("Click courses Button")
    public void clickCoursesButton() {
        coursesButton.click();
        coursesButton.shouldBe(visible, Duration.ofSeconds(10));
    }


}


