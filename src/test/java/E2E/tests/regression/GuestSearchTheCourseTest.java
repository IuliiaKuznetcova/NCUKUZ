package E2E.tests.regression;

import E2E.tests.BaseTest;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

public class GuestSearchTheCourseTest extends BaseTest {

    @Issue("Jira-cloud NCU-28")
    @Test
    public void goToCoursesPageComputerScience() {
        headerHelpers.coursesButtonClick();
        //homePageHelpers.goToCoursesPage("Computer Science");
        homePageHelpers.goToCoursesPage();
    }
}


