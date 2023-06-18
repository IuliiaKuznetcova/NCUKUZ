package E2E.tests.regression;

import E2E.tests.BaseTest;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

public class GuestSearchTheCourseTest extends BaseTest {

    @Issue("NCU-28")
    @Test
    public void goToCoursesPageComputerScience() {
        headerHelpers.coursesButtonClick();
        //searchPage.goToCoursesPage("Computer Science");
        //searchPage.goToCoursesPage();
        homePageHelpers.goToCoursesPage();
    }


    // TODO
    //  code functionality check
    //  computerSciencePage = $(byText("I agree to the")); in SearchPage


}


