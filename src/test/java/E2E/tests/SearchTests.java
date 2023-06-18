package E2E.tests;

import E2E.helpers.CourseHelper;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.FileNotFoundException;

public class SearchTests extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Test
    public void searchInformationAboutThisCourseGrowthMarketing() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        studentCourseList.displayOurCoursesTitle("Our courses");
        courseHelper.searchCourseWithCheck("Rasras");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();
    }

    @Issue("NCU-98")
    @Test
    public void searchForTeacherInTheCourseGrowthMarketing() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();
        // TODO сделать проверку на содержание раздела с преподавателями
    }

    @Issue("NCU-102")
    @Test
    public void searchForAnExistingStudent() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.studentDirectoryButtonClick();
        studentDirectoryPage.displayWelcomeTextOnStudentPage();
        courseHelper.searchStudentWithCheck("Michael Thomas");
        headerHelpers.studentDirectoryButtonClick();
        headerHelpers.signOut();
    }

    @Issue("Jira-cloud NCU-5")
    @Test
    public void searchForAnExistingProfessor() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        Thread.sleep(1000);
        headerHelpers.professorsButtonClick();
        Thread.sleep(1000);
        homePageHelpers.displayTitleProfessorSpotlight();
        courseHelper.searchProfessorWithCheck("Marie Curie");
        headerHelpers.studentDirectoryButtonClick();
        headerHelpers.signOut();
    }

    @Test
    public void download() throws InterruptedException, FileNotFoundException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseDetails.tyknutTut();
        //studentGrowthMarketingCourseDetails.viewAboutThisCourse();
        studentCourseDetails.downloadDocument();
    }
}
