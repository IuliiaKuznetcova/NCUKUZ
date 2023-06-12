package E2E.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderHelpers {

    private SelenideElement coursesButton = $x("(//span[normalize-space()='Courses'])[1]");
    private SelenideElement professorButton = $x("(//span[normalize-space()='Professors'])[1]");
    private SelenideElement studentDirectoryButton = $x("(//span[normalize-space()='Student Directory'])[1]");
    private SelenideElement avatarButton = $x("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7'])[1]");
    private SelenideElement signOutButton = $x("(//a[contains(@role,'menuitem')])[2]");
    private SelenideElement myProfileButton = $x("(//a[contains(@role,'menuitem')])[1]");
    private SelenideElement coursesLIstButton = $x("(//div[contains(@class,'css-1as4i22 MuiPopperUnstyled-root')])[1]");
    private SelenideElement nocodeButton = $x("(//img[@class='sw-width-5xs'])[1]");
    private SelenideElement aboutUnsButton = $x("//span[normalize-space()='About Us']");


    public void coursesButtonClick() {
        coursesButton.shouldBe(visible, Duration.ofSeconds(10));
        coursesButton.click();
 }

    public void coursesLIstButtonClick() {
        coursesLIstButton.shouldBe(visible, Duration.ofSeconds(10));
        coursesLIstButton.click();
    }

    public void professorButtonClick() {
        professorButton.shouldBe(visible, Duration.ofSeconds(10));
        professorButton.click();
    }

    public void studentDirectoryButtonClick() {
        studentDirectoryButton.shouldBe(visible, Duration.ofSeconds(10));
        studentDirectoryButton.click();
    }

    public void signOutButtonClick() {
        signOutButton.shouldBe(visible, Duration.ofSeconds(10));
        signOutButton.click();
    }

    public void avatarButtonClick() {
        avatarButton.shouldBe(visible, Duration.ofSeconds(10));
        avatarButton.click();
    }

    public void displayAvatarButtonn() {
        avatarButton.shouldBe(Condition.visible);
    }

    public void nocodeButtonClick() {
        nocodeButton.shouldBe(visible, Duration.ofSeconds(10));
        nocodeButton.click();
    }

    public void myProfileButtonClick() {
        myProfileButton.shouldBe(visible, Duration.ofSeconds(10));
        myProfileButton.click();
    }

    public void aboutUnsButtonClick() {
        aboutUnsButton.shouldBe(visible, Duration.ofSeconds(10));
        aboutUnsButton.click();
    }

    public void signOut() {
      avatarButtonClick();
      signOutButtonClick();
    }
}
