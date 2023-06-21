package E2E.tests.regression;

import E2E.helpers.CourseHelper;
import E2E.tests.BaseTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class StudentAsTeacherCourseEditTest extends BaseTest {

    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Issue("NCU-163")
    @Test
    public void courseEditByStudentUnderTheRoleOfTeacher () throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginUser(emailMalik, passwordMalik);
        headerHelpers.goToMyProfile();
        studentMyProfile.editTheRoleOfStudentToTeacher();
        guestHomePage.notExistSignInButton();
        //studentMyProfile.editTheRoleOfTeacherToStudent();
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Check");
        studentCourseDetails.tyknutTut();
        editCourse.editCourseButtonClick();
        Selenide.sleep(3000);
        editCourse.displayEditRecordForm();
        editCourse.editCourseName("Check passed'");
        editCourse.clickSaveBatton();
        Selenide.sleep(3000);
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginUser(emailMalik, passwordMalik);
        headerHelpers.goToMyProfile();
        studentMyProfile.editTheRoleOfTeacherToStudent();
        Selenide.sleep(3000);
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginUser(emailMalik, passwordMalik);
        Selenide.sleep(3000);
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Check passed'");
    }
}
