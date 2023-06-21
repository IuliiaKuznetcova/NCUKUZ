package E2E.tests;

import API.tests.ApiBase;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class SignInAndSignOutTest extends BaseTest {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    Faker faker = new Faker();
    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    ApiBase apiBase = new ApiBase();
    String endpoint = "/users/";

    @Issue("NCU-92")
    @Test
    public void registrationOfANewStudentTest() {
        String endpoint = "/users/";
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        Selenide.sleep(5000);
        guestHomePage.notExistSignInButton();
        Selenide.sleep(5000);
        headerHelpers.displayAvatarButton();
        apiBase.deleteRequest(endpoint + email, 200);
    }

    @Issue("NCU-92")
    @Test
    public void registrationOfANewStudentWithCheckTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        Selenide.sleep(5000);
        guestHomePage.notExistSignInButton();
        Selenide.sleep(5000);
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginAction(email, "654321");
        apiBase.deleteRequest(endpoint + email, 200);
    }

    @Issue("NCU-92")
    @Test
    public void registrationOfANewStudentWithSearchTest() {
        guestHomePage.clickSignUpButton();
        signUpPage.registrationOfANewStudent(fullName, email, "654321");
        Selenide.sleep(5000);
        guestHomePage.notExistSignInButton();
        Selenide.sleep(5000);
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginAction(email, "654321");
        headerHelpers.avatarButtonClick();
        headerHelpers.signOutButtonClick();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.studentDirectoryButtonClick();
        studentDirectoryPage.fillFieldSearchOnStudentDirectory(fullName);
        //studetnDirectoryPage.searchResultStudentDisplayExactData(fullName);
        studentDirectoryPage.viewProfileButtonClick();
        apiBase.deleteRequest(endpoint + email, 200);
    }

    @Issue("NCU-92")
    @Test
    public void malickLoginTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        guestHomePage.notExistSignInButton();
        headerHelpers.displayAvatarButton();
        homePageHelpers.displayTitleProfessorSpotlight();
    }

    @Issue("NCU-92")
    @Test
    public void malickLoginTestsearch() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        guestHomePage.notExistSignInButton();
        studentDirectoryPage.fillFieldSearchOnStudentDirectory("Marie Curie");
        //studetnDirectoryPage.searchResultStudentDisplayExactData();
        studentDirectoryPage.viewProfileButtonClick();
        headerHelpers.displayAvatarButton();
    }

    @Issue("NCU-114")
    @Test
    public void roxanneLoginTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        headerHelpers.displayAvatarButton();
        teacherHomePage.existAddAСourseButton();
        homePageHelpers.displayTitleProfessorSpotlight();
    }

    @Issue("NCU-152")
    @Test
    public void malickSignAndSignOutTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.signOut();
    }
}
