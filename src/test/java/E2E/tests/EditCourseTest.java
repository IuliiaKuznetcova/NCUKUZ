package E2E.tests;

import E2E.helpers.CourseHelper;
import org.testng.annotations.Test;

public class EditCourseTest extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();

    @Test
    public void editCourseTest() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        teacherHomePage.goToCoursesPage();
        /*courseHelper.searchCourseWithCheck("Med");
        editCourse.editCourseButtonClick();
        editCourse.displayEditRecordForm();
        editCourse.editCourseName("Medicine");
        editCourse.clickSaveBatton();*/


    }
}
