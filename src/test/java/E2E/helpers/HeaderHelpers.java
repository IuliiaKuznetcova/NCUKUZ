package E2E.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderHelpers {

    private SelenideElement coursesButton = $x("(//span[normalize-space()='Courses'])[1]");
    private SelenideElement professorsButton = $x("(//span[normalize-space()='Professors'])[1]");
    private SelenideElement studentDirectoryButton = $x("(//span[normalize-space()='Student Directory'])[1]");
    private SelenideElement avatarButton = $x("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7'])[1]");
    private SelenideElement signOutButton = $x("(//a[contains(@role,'menuitem')])[2]");
    private SelenideElement myProfileButton = $x("(//a[contains(@role,'menuitem')])[1]");
    private SelenideElement coursesLIstButton = $x("(//div[contains(@class,'css-1as4i22 MuiPopperUnstyled-root')])[1]");
    private SelenideElement nocodeButton = $x("(//img[@class='sw-width-5xs'])[1]");
    private SelenideElement aboutUnsButton = $x("//span[normalize-space()='About Us']");

    @Step("Click the button 'Courses'")
    public void coursesButtonClick() {
        coursesButton.shouldBe(visible, Duration.ofSeconds(10));
        coursesButton.click();
    }

    @Step("Click the button 'Courses List'")
    public void coursesListButtonClick() {
        coursesLIstButton.shouldBe(visible, Duration.ofSeconds(10));
        coursesLIstButton.click();
    }

    @Step("Click the button 'Professors'")
    public void professorsButtonClick() {
        professorsButton.shouldBe(visible, Duration.ofSeconds(10));
        professorsButton.click();
    }

    @Step("Click the button 'Student Directory'")
    public void studentDirectoryButtonClick() {
        displayStudentDirectoryButton();
        studentDirectoryButton.click();
    }

    @Step("Display the button 'Student Directory' отображение кнопки 'Student Directory'")
    public void displayStudentDirectoryButton() {
        studentDirectoryButton.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Display the button 'Avatar' отображение кнопки 'Avatar'")
    public void displayAvatarButton() {
        avatarButton.shouldBe(Condition.visible);
    }

    @Step("Click the button 'Avatar'")
    public void avatarButtonClick() {
        avatarButton.shouldBe(visible, Duration.ofSeconds(10));
        avatarButton.click();
    }

    @Step("Click the button 'Sign Out'")
    public void signOutButtonClick() {
        signOutButton.shouldBe(visible, Duration.ofSeconds(10));
        signOutButton.click();
    }

    @Step("User logout")
    public void signOut() {
        avatarButtonClick();
        signOutButtonClick();
    }

    @Step("Click the button 'NOCODE'")
    public void nocodeButtonClick() {
        nocodeButton.shouldBe(visible, Duration.ofSeconds(10));
        nocodeButton.click();
    }

    @Step("Click the button 'My Profile'")
    public void myProfileButtonClick() {
        myProfileButton.shouldBe(visible, Duration.ofSeconds(10));
        myProfileButton.click();
    }

    @Step("Click the button 'About Uns'")
    public void aboutUnsButtonClick() {
        aboutUnsButton.shouldBe(visible, Duration.ofSeconds(10));
        aboutUnsButton.click();
    }
}
