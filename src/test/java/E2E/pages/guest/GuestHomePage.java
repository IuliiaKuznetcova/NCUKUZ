package E2E.pages.guest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class GuestHomePage {
    private SelenideElement signInButton = $x("//span[normalize-space()='Sign in']");
    private SelenideElement signUpButton = $x("//span[normalize-space()='Sign up']");

    //  private SelenideElement signInButton = $x("//*[@id=\"home-header-non-logged-in\"]/header/div/div/div/div/a[1]");

    @Step("Click the button 'Sign In' on the HomePage Нажатие кнопки 'Sign In' на главной странице")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Click the button 'Sign Up' on the HomePage Нажатие кнопки 'Sign Up' на главной странице")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Button 'Sign in' not display  Не отображается кнопка 'Sign In'")
    public void notExistSignInButton() {
        signInButton.shouldNotBe(Condition.visible);
    }

    @Step("Button 'Sign in' display Oтображается кнопка Sign In")
    public void ExistSignInButton() {
        signInButton.shouldBe(Condition.visible);
    }

    @Step("Button 'Sign Up' not display  Не отображается кнопка Sign Up")
    public void notExistSignUpButton() {
        signUpButton.shouldNotBe(Condition.visible);
    }

    @Step("Button 'Sign Up' display Oтображается кнопка Sign Up")
    public void ExistSignUpButton() {
        signUpButton.shouldBe(Condition.visible);
    }
}


