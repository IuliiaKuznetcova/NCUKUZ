package E2E.tests;

import E2E.helpers.CourseHelper;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.FileNotFoundException;

public class UploadCourseMaterialTest extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Issue("NCU-112")
    @Test
    public void editCourseTest() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        Selenide.sleep(3000);
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("QA test");
        studentCourseDetails.tyknutTut();
        uploadCourseMaterial.displayuploadCourseMaterialTitel();
        uploadCourseMaterial.enterDocumentName("Document");
        uploadCourseMaterial.uploadDocument("E:/Autotesting/NCUKUZ/src/test/resources/123.png");
        uploadCourseMaterial.clickUploadBatton();
    }

    @Issue("NCU-122")
    @Test
    public void editCourseWithCheckTest() throws InterruptedException, FileNotFoundException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseDetails.tyknutTut();
        scroll.click();
        //studentCourseDetails.viewAboutThisCourse();
        studentCourseDetails.downloadDocument();
        // TODO сделать проверку на содержание раздела с преподавателями
    }
}
