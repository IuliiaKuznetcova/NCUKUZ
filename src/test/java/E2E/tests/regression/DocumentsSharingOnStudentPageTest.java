package E2E.tests.regression;

import E2E.helpers.CourseHelper;
import E2E.tests.BaseTest;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class DocumentsSharingOnStudentPageTest extends BaseTest {

    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");


/*    @Issue("Jira-cloud NCU-12")
    @Test
    public void visibilityOfDocumentsSharingOnStudentPageTest1() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.studentDirectoryButtonClick();
        studentDirectoryPage.displayWelcomeTextOnStudentPage();
        studentHomePage.goToCoursesPage();
        studentCourseList.displayOurCoursesTitle("Our courses");
        // studentCourseList.fillFieldSearch("Growth Marketing");
        studentCourseList.discoverMoreButtonClick();
        studentCourseList.goToGrowthMarketingCourse();
        scrollPageToElement2023NoCode();
        studentCourseDetails.notExistsUploadCourseMaterialButton("Upload");
    }*/

    @Issue("Jira-cloud NCU-13")
    @Test
    public void visibilityOfDocumentsSharingOnStudentPageTest2() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.studentDirectoryButtonClick();
        studentDirectoryPage.displayWelcomeTextOnStudentPage();
        studentHomePage.goToCoursesPage();
        studentCourseList.displayOurCoursesTitle("Our courses");
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseList.goToGrowthMarketingCourse();
        scrollPageToElement2023NoCode();
        studentCourseDetails.notExistsUploadCourseMaterialButton("Upload");
    }
}

