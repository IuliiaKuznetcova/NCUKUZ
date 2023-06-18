package API.tests;

import API.dto.ValidUserCredentials;
import E2E.helpers.HeaderHelpers;
import E2E.pages.guest.GuestHomePage;
import E2E.pages.signIn.SignInPage;
import E2E.pages.student.StudentDirectoryPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CreateUserTestApiBase extends ApiBase {
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");
    final static String BASE_URI = "https://jere237.softr.app";

    @Issue("NCU-145")
    @Test
    public void successfulCreateUserWithExactData() {
        ValidUserCredentials requestBody = ValidUserCredentials.builder()
                .full_name(fullName)
                .email(email)
                .password("777555")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
    }

    @Issue("NCU-157")
    @Test
    public void successfulCreateUser() {
        ValidUserCredentials requestBody = ValidUserCredentials.builder()
                .full_name("Ja Kuz")
                .email("ja82@yahoo.com")
                .password("777555")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
    }

    @Issue("NCU-")
    // TODO создать тесткейс
    @Test
    public void successfulCreateUserApiAndUiWithLoginCheck() {

        SignInPage signInPage = new SignInPage();
        HeaderHelpers headerHelpers = new HeaderHelpers();
        GuestHomePage guestHomePage = new GuestHomePage();
        StudentDirectoryPage studetnDirectoryPage = new StudentDirectoryPage();

        ValidUserCredentials requestBody = ValidUserCredentials.builder()
                .full_name(fullName)
                .email(email)
                .password("777555")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
        Selenide.open(BASE_URI);
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        headerHelpers.studentDirectoryButtonClick();
        studetnDirectoryPage.fillFieldSearchOnStudentDirectory(fullName);
        headerHelpers.signOut();
    }

    @AfterMethod
    public void afterTest() {
        deleteRequest(endpoint + email, 200);
        closeWebDriver();
    }
}
