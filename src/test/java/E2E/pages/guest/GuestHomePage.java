package E2E.pages.guest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GuestHomePage {
private SelenideElement signInButton = $x("//span[normalize-space()='Sign in']");
private SelenideElement signUpButton = $x("//span[normalize-space()='Sign up']");

  //  private SelenideElement signInButton = $x("//*[@id=\"home-header-non-logged-in\"]/header/div/div/div/div/a[1]");

    @Step("Click the button Sign In on the HomePage Нажатие кнопки Sign In на главной странице")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Click the button Sign Up on the HomePage Нажатие кнопки Sign Up на главной странице")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Не отображается кнопка Sign In")
    public void notExistSignInButton() {
        //professorSpotlightTittle.shouldHave(Condition.text("Professor spotlight"));
        signInButton.shouldNotBe(Condition.visible);
    }

    @Step("Oтображается кнопка Sign In")
    public void ExistSignInButton() {
        //professorSpotlightTittle.shouldHave(Condition.text("Professor spotlight"));
        signInButton.shouldBe(Condition.visible);
    }

    @Step("Не отображается кнопка Sign Up")
    public void notExistSignUpButton() {
        //professorSpotlightTittle.shouldHave(Condition.text("Professor spotlight"));
        signUpButton.shouldNotBe(Condition.visible);
    }

    @Step("Oтображается кнопка Sign In")
    public void ExistSignUpButton() {
        //professorSpotlightTittle.shouldHave(Condition.text("Professor spotlight"));
        signUpButton.shouldBe(Condition.visible);
    }
}


