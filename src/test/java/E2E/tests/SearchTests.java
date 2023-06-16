package E2E.tests;

import E2E.helpers.CourseHelper;
import E2E.helpers.HeaderHelpers;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

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
        studentGrowthMarketingCourseDetails.tyknutTut();
        studentGrowthMarketingCourseDetails.viewAboutThisCourse();

    }

    @Test
    public void searchForTeacherInTheCourseGrowthMarketing() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Growth Marketing");
        studentGrowthMarketingCourseDetails.tyknutTut();
        studentGrowthMarketingCourseDetails.viewAboutThisCourse();
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
}
