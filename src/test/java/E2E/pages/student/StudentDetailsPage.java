package E2E.pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class StudentDetailsPage {
    private SelenideElement studentFullName = $x("(//div[@class='MuiBox-root css-blhqza'])[1]");
    private SelenideElement professorFullName = $x("(//div[@class='MuiBox-root css-blhqza'])[1]");
    private SelenideElement backToDirectoryButton = $x("(//a[contains(@type,'button')][normalize-space()='Back to directory'])[2]");

    public void displayStudenFullNameExactData(String searchedStudentName) {
        studentFullName.shouldHave(Condition.text(searchedStudentName));
    }

    public void displayProfessorFullNameExactData(String searchedStudentName) {
        professorFullName.shouldHave(Condition.text(searchedStudentName));
    }

    public void displayStudenFullNameRandomData(String searchInput) {
        studentFullName.shouldHave(Condition.text(searchInput));
    }

    public void backToStudentDirectory() {
        backToDirectoryButton.shouldBe(visible, Duration.ofSeconds(10));
        backToDirectoryButton.click();
    }
}
