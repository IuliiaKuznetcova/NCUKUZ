package E2E.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePageHelpers {

    private SelenideElement professorSpotlightTittle = $x("(//span[normalize-space()='Professor spotlight'])[1]");
    private SelenideElement professorDirectoryButton = $x("(//span[normalize-space()='Professors'])[1]");
    private SelenideElement checkOutOurCoursesTitle = $x("/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[1]/p[1]");
    private SelenideElement noCodeUniversityAtAGlanceTitle = $x("/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/h2[1]");

    @Step("Display title professor Spotlight отображение заголовка")
    public void displayTitleProfessorSpotlight() {
        // checkOutOurCoursesTitle.shouldHave(Condition.text("Professor spotlight"));
        professorSpotlightTittle.should(be(visible)).shouldHave(Condition.text("Professor spotlight"));
    }

    @Step("Display title professor Spotlight отображение заголовка")
    public void displayCheckOutOurCoursesTitle() {

        checkOutOurCoursesTitle.should(be(visible)).shouldHave(Condition.text("Check out our courses"));
    }

    @Step("Display title professor Spotlight отображение заголовка")
    public void displaynoCodeUniversityAtAGlanceTitle() {
        noCodeUniversityAtAGlanceTitle.should(be(visible)).shouldHave(Condition.text("NoCode University at a glance"));
    }
}
