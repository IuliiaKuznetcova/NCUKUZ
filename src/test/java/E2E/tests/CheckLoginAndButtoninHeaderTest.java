package E2E.tests;

import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class CheckLoginAndButtoninHeaderTest extends BaseTest{
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Test
    public void malickLoginAndClickTest()  {
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

    @Test
    public void roxanneLoginAndClickTest()  {
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

  /*  @Test
    public void login(){
        guestHomePage.clickSignInButton();
        signInPage.loginAction("gfd", "dfg");
        guestHomePage.notExistSignInButton();
    }*/

    @Test
    public void guestClick () {
        headerHelpers.coursesButtonClick();
        homePageHelpers.displayCheckOutOurCoursesTitle();
        headerHelpers.professorsButtonClick();
        homePageHelpers.displayTitleProfessorSpotlight();
        headerHelpers.aboutUnsButtonClick();
        homePageHelpers.displaynoCodeUniversityAtAGlanceTitle();
    }
}


