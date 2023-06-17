package E2E.tests;

import E2E.helpers.CourseHelper;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class UploadCourseMaterialTest extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
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
}
