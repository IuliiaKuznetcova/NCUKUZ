package E2E.pages.SignUp;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage {

    private SelenideElement signUpForm = $x("(//div[@id='signup'])[1]");
    private SelenideElement emailField = $(byAttribute("placeholder", "Email"));
    private SelenideElement fullNameField = $(byAttribute("placeholder", "Full Name"));
    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));
    private SelenideElement showPasswordEyeButton = $x("//i[@class='fa fa-eye-slash show-password']");
    private SelenideElement selectYourRole = $x("(//div[@class='text-center sw-dropdown'])[1]");
    private SelenideElement roleTeacher = $x("(//a[@role='option'])[1]");
    private SelenideElement roleStudent = $x("(//a[@role='option'])[2]");
    private SelenideElement iAgreeToСheckbox = $x("(//span[@class='checkmark position-relative sw-checkbox'])[1]");
    private SelenideElement signUpButtonInRegistrForm = $x("(//a[@id='sw-sign-up-submit-btn'])[1]");
    private SelenideElement signInButtonInRegistrForm = $x("((//a[normalize-space()='Sign In'])[1]");

    @Step("registration of a new student регистрация нового студента")
    public void registrationOfANewStudent(String fullNameValue, String emailValue, String passwordValue) {
        signUpForm.shouldBe(visible, Duration.ofSeconds(10));
        selectRoleStudent();
        enterFullName(fullNameValue);
        enterEmail(emailValue);
        enterPassword(passwordValue);
        iAgreeToСheckbox.click();
        signUpButtonInRegistrForm.click();
    }

    @Step("select Role Student Выбрать роль студента")
    public void selectRoleStudent() {
        selectYourRole.shouldBe(visible, Duration.ofSeconds(10)).click();
        roleStudent.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Enter Password Введение пароля")
    public void enterPassword(String passwordValue) {
        passwordField.shouldBe(visible, Duration.ofSeconds(10)).setValue(passwordValue);
    }

    @Step("Enter FullName Введение полного имени")
    public void enterFullName(String emailValue) {
        fullNameField.shouldBe(visible, Duration.ofSeconds(10)).setValue(emailValue);
    }

    @Step("Enter Email Введение эмейла")
    public void enterEmail(String emailValue) {
        emailField.shouldBe(visible, Duration.ofSeconds(10)).setValue(emailValue);
    }

    @Step("Display Registration Form  Отображение формы регистрации")
    public void DisplaySignUpForm() {
        signUpForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Click Dropdown Select Your Role Нажать на выпадающее меню 'Select Your Role'")
    public void clickSelectYourRoleDropdown() {
        selectYourRole.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Select Role Teacher Выбрать роль учителя")
    public void selectRoleTeacher() {
        selectYourRole.shouldBe(visible, Duration.ofSeconds(10)).click();
        roleTeacher.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Click on the Button 'Show Password' Кликнуть на иконку 'Show Password'")
    public void showPasswordEye() {
        showPasswordEyeButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Сheck 'I Agree To' Поставить галочку в поле 'I Agree To'")
    public void clickIAgreeToСheckbox() {
        iAgreeToСheckbox.shouldBe(visible, Duration.ofSeconds(10)).setSelected(true);
    }

    @Step("Click the button Sign Up in the Registry Form Нажатие кнопки Sign Up в форме регистрации")
    public void clickSignUpButtonInRegistrForm() {
        signUpButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Click the button 'Sign In' in the Registry Form Нажатие кнопки Sign In в форме регистрации")
    public void clickSignInButtonInRegistrForm() {
        signInButtonInRegistrForm.shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}
