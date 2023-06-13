package E2E.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class SignInAndSignOutTest extends BaseTest {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    Faker faker = new Faker();
  String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();


   /* @Test
    public void registrationOfANewStudentTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent("Medo Chan", "medochan@chan.com", "222222");
        guestHomePage.notExistSignInButton();
        headerHelpers.displayAvatarButtonn();
    }*/

    @Test
    public void registrationOfANewStudentTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        guestHomePage.notExistSignInButton();
        headerHelpers.displayAvatarButtonn();
    }

    @Test
    public void registrationOfANewStudentWithCheckTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        guestHomePage.notExistSignInButton();
        headerHelpers.avatarButtonClick();
        headerHelpers.signOutButtonClick();
        guestHomePage.clickSignInButton();
        signInPage.loginAction(email, "654321");
    }

    @Test
    public void registrationOfANewStudentWithSearchTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        //guestHomePage.notExistSignInButton();
        headerHelpers.avatarButtonClick();
        headerHelpers.signOutButtonClick();
        guestHomePage.clickSignInButton();
        signInPage.loginAction(email, "654321");
        headerHelpers.avatarButtonClick();
        headerHelpers.signOutButtonClick();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studetnDirectoryPage.fillFieldSearchOnStudentDirectory(fullName);
        //studetnDirectoryPage.searchResultStudentDisplayExactData(fullName);
        studetnDirectoryPage.viewProfileButtonClick();
    }

    @Test
    public void malickLoginTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        guestHomePage.notExistSignInButton();
        headerHelpers.displayAvatarButtonn();
        homePageHelpers.displayTitleProfessorSpotlight();
    }

    @Test
    public void roxanneLoginTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        headerHelpers.displayAvatarButtonn();
        teacherHomePage.existAddAcourseButton();
        homePageHelpers.displayTitleProfessorSpotlight();
    }

    @Test
    public void malickSignOutTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.signOut();
    }
}
