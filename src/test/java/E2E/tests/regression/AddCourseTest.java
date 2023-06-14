package E2E.tests.regression;

import E2E.tests.BaseTest;
import org.testng.annotations.Test;


public class AddCourseTest extends BaseTest {

    @Test
    public void addCourse() {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        addCoursePage.addCourseButtonClick();
        addCoursePage.displayAddANewCourseForm();
        addCoursePage.enterCourseName("Med");
        addCoursePage.selectFacultyMedicine();
        addCoursePage.enterCourseDescription("Med Med");
        addCoursePage.coverPhoto();
        addCoursePage.select1JuniStartDate();
        addCoursePage.select30JuniEndtDate();
        addCoursePage.clickAddBatton();
    }

    // TODO не фунгует
}

