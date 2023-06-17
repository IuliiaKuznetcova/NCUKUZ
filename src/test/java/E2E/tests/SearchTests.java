package E2E.tests;

import E2E.helpers.CourseHelper;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.FileNotFoundException;

public class SearchTests extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    // TeacherDirectoryPage teacherDirectoryPage = new TeacherDirectoryPage();

    @Test
    public void searchInformationAboutThisCourseGrowthMarketing() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        studentCourseList.displayOurCoursesTitle("Our courses");
        //courseHelper.searchCourseWithCheck("Growth Marketing");
        courseHelper.searchCourseWithCheck("Ras");
        // TODO Найти курс с любым названием courseHelper.searchCourseWithCheck("QA");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();

    }

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

       @Test
    public void searchForAnExistingProfessor() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        Thread.sleep(1000);
        headerHelpers.professorButtonClick();
        Thread.sleep(1000);
        homePageHelpers.displayTitleProfessorSpotlight();
        courseHelper.searchProfessorWithCheck("Marie Curie");
        headerHelpers.studentDirectoryButtonClick();
        headerHelpers.signOut();
    }

    @Test
    public void download () throws InterruptedException, FileNotFoundException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentCourseDetails.tyknutTut();
        //studentGrowthMarketingCourseDetails.viewAboutThisCourse();
        studentCourseDetails.downloadDocument();
        // TODO сделать проверку на содержание раздела с преподавателями
    }
}
