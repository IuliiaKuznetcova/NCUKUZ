package E2E.tests;

import E2E.helpers.CourseHelper;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class EditCourseTest extends BaseTest {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    CourseHelper courseHelper = new CourseHelper();

    @Test
    public void editCourseTest() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        Selenide.sleep(3000);
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("QA test");
        studentCourseDetails.tyknutTut();
        editCourse.editCourseButtonClick();
       editCourse.displayEditRecordForm();
       editCourse.editCourseName("Doooon't QA test");
        //editCourse.coverPhoto();
        //editCourse.editCourseStartDate("06-05-2023");
        // TODO не могу понять, как изменить дату. Очистка не помогла
       editCourse.clickSaveBatton();
    }

    @Test
    public void editCourseTestWithCheckingTheRoleOfTheStudent() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        Selenide.sleep(3000);
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("QA");
        studentCourseDetails.tyknutTut();
        editCourse.editCourseButtonClick();
        editCourse.displayEditRecordForm();
        editCourse.editCourseName("Doooon't QA");
        editCourse.clickSaveBatton();
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Med");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();
    }

}
