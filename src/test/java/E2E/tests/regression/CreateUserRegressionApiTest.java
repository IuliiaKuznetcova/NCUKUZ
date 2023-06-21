package E2E.tests.regression;

import API.dto.ValidUserCredentials;
import API.tests.ApiBase;
import E2E.helpers.HeaderHelpers;
import E2E.pages.guest.GuestHomePage;
import E2E.pages.signIn.SignInPage;
import E2E.pages.student.StudentDirectoryPage;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class CreateUserRegressionApiTest extends ApiBase {
    String endpoint = "/users/";
    Faker faker = new Faker();
    public String fullName = faker.name().fullName();
    public String email = faker.internet().emailAddress();


    final static String BASE_URI = "https://jere237.softr.app";
    //final static String BASE_URI = "https://erich416.softr.app/";

    @Test
    public void successfulCreateUserApiAndUi() {
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
        signInPage.loginAction(email, "777555");
        headerHelpers.displayStudentDirectoryButton();
        deleteRequest(endpoint+email ,200);
    }
    //TODO написать тест-кейс

}

