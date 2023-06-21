package E2E.tests;

import E2E.helpers.CourseHelper;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.FileNotFoundException;

public class EditCourseTest extends BaseTest {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    CourseHelper courseHelper = new CourseHelper();

    @Issue("NCU-123")
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
        // TODO Фотография не прикрепляется
        //editCourse.editCourseStartDate("06-05-2023");
        // TODO не могу понять, как изменить дату. Очистка не помогла
        editCourse.clickSaveBatton();
    }

    @Issue("NCU-122")
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

    @Test
    public void download() throws FileNotFoundException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseDetails.tyknutTut();
        //studentGrowthMarketingCourseDetails.viewAboutThisCourse();
        studentCourseDetails.downloadDocument();
    }
}
