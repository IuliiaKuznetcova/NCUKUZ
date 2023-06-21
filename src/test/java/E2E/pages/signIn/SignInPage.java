package E2E.pages.signIn;

import E2E.pages.guest.GuestHomePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    private SelenideElement emailField = $(byAttribute("placeholder", "Email"));
    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));
    private SelenideElement signInButtonInRegistrForm = $x("//*[@id=\"sw-sign-in-submit-btn\"]");
    private SelenideElement registrationForm = $x("//*[@id=\"signin\"]");


    @Step("Display Registration Form")
    public void displayRegistrationForm() {
        registrationForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Enter Email")
    public void enterEmail(String emailValue) {
        emailField
                .shouldBe(visible, Duration.ofSeconds(10))
                .setValue(emailValue);
    }

    @Step("Enter Password")
    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }

    @Step("Click the button 'Sign In' in the Registry Form")
    public void clickSignInButtonInRegistrForm() {
        signInButtonInRegistrForm
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    @Step("Login action with entering an email, password and clicking „Sign In” Button")
    public void loginAction(String emailValue, String passwordValue) {
        registrationForm.shouldBe(visible, Duration.ofSeconds(10));
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue(emailValue);
        passwordField.setValue(passwordValue);
        signInButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10));
        signInButtonInRegistrForm.click();
    }

    @Step("Login User")
    public void loginUser(String emailValue, String passwordValue) {
        registrationForm.shouldBe(visible, Duration.ofSeconds(10));
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue(emailValue);
        passwordField.setValue(passwordValue);
        signInButtonInRegistrForm.click();
        signInButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Login student Malik")
    public void loginMalik(String emailValue, String passwordValue) {
        registrationForm.shouldBe(visible, Duration.ofSeconds(10));
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue(emailValue);
        passwordField.setValue(passwordValue);
        signInButtonInRegistrForm.click();
        signInButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Login teacher Roxanna")
    public void loginRoxanne() {
        registrationForm.shouldBe(visible, Duration.ofSeconds(10));
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue("roxanne@example.com");
        passwordField.setValue("123456");
        signInButtonInRegistrForm.click();
        signInButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10));
    }
}
