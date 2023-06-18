package E2E.tests;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class CheckLoginAndButtoninHeaderTest extends BaseTest {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Issue("NCU-92")
    @Test
    public void malickLoginAndClickTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        guestHomePage.notExistSignInButton();
        headerHelpers.studentDirectoryButtonClick();
        headerHelpers.coursesButtonClick();
        headerHelpers.coursesListButtonClick();
        headerHelpers.professorsButtonClick();
        headerHelpers.signOut();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.avatarButtonClick();
        headerHelpers.myProfileButtonClick();
        headerHelpers.nocodeButtonClick();
    }

    @Issue("NCU-114")
    @Test
    public void roxanneLoginAndClickTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        guestHomePage.notExistSignInButton();
        headerHelpers.studentDirectoryButtonClick();
        headerHelpers.coursesButtonClick();
        headerHelpers.coursesListButtonClick();
        headerHelpers.professorsButtonClick();
        headerHelpers.signOut();
        signInPage.loginRoxanne();
        headerHelpers.avatarButtonClick();
        headerHelpers.myProfileButtonClick();
        headerHelpers.nocodeButtonClick();
    }

    @Test
    public void guestClick() {
        headerHelpers.coursesButtonClick();
        homePageHelpers.displayCheckOutOurCoursesTitle();
        headerHelpers.professorsButtonClick();
        homePageHelpers.displayTitleProfessorSpotlight();
        headerHelpers.aboutUsButtonClick();
        homePageHelpers.displaynoCodeUniversityAtAGlanceTitle();
    }
}


