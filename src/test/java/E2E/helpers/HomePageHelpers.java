package E2E.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePageHelpers {

    private SelenideElement professorSpotlightTittle = $x("(//span[normalize-space()='Professor spotlight'])[1]");
    private SelenideElement checkOutOurCoursesTitle = $x("/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[1]/p[1]");
    private SelenideElement noCodeUniversityAtAGlanceTitle = $x("/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/h2[1]");
    private SelenideElement computerScienceTitle = $x("//*[@id='courses-grid-non-logged-in']/section/div/div[2]/div[2]/div/div/div/div/div/div[1]");
    private SelenideElement goToComputerScienceButton = $x("//body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]");
    private SelenideElement computerSciencePage = $(byText("Computer Science"));

    @Step("Display the title 'Professor Spotlight'")
    public void displayTitleProfessorSpotlight() {
        // checkOutOurCoursesTitle.shouldHave(Condition.text("Professor spotlight"));
        professorSpotlightTittle.should(be(visible)).shouldHave(Condition.text("Professor spotlight"));
    }

    @Step("Display the title 'Check out our courses'")
    public void displayCheckOutOurCoursesTitle() {
        checkOutOurCoursesTitle.should(be(visible)).shouldHave(Condition.text("Check out our courses"));
    }

    @Step("Display the title 'NoCode University at a glance'")
    public void displaynoCodeUniversityAtAGlanceTitle() {
        noCodeUniversityAtAGlanceTitle.should(be(visible)).shouldHave(Condition.text("NoCode University at a glance"));
    }

    @Step("Go to 'Courses Page'")
    //public void goToCoursesPage(String courseName) {
    public void goToCoursesPage() {
        //computerScienceTitle.shouldHave(Condition.text(courseName));
        goToComputerScienceButton.click();
        computerSciencePage.should(exist);
    }
}
