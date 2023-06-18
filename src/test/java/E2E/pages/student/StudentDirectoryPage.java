package E2E.pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class StudentDirectoryPage {
    private SelenideElement welcomeTextOnStudentPage = $x("//h1[normalize-space()='Welcome to our']");
    private SelenideElement fieldSearchOnStudentDirectory = $x("//*[@id=\":r0:\"]");
    //private SelenideElement searchResultOnStudentDirectoryFullName = $x("(//div[@class='list-item-wrapper MuiBox-root css-mza73d'])[1]");
    private SelenideElement searchResultOnStudentDirectoryFullName = $x("//*[@id=\"student-directory\"]/section/div/div[2]/div/div/div/div/div/div[1]/div[1]");
    private SelenideElement searchResultOnProfessorDirectoryFullName = $x("//*[@id=\"teacher-spotlight-logged-in\"]/section/div/div[2]/div/div/div/div/div/div[1]/div[1]");
    private SelenideElement searchResultOnStudentDirectoryEmail = $x("(//p[@class='sw-font-size-m sw-text-color-0146b1 sw-font-family-default sw-font-weight-normal sw-text-align-left sw-letter-spacing-normal sw-padding-top-6xs sw-padding-bottom-6xs sw-padding-left-none sw-padding-right-none '])[1]");
    private SelenideElement scroll = $x(" //*[@id=\"home-footer\"]/section/div/div[3]/div[1]/small");
    private SelenideElement viewProfileButton = $x("(//a[normalize-space()='View profile'])[1]");
    private SelenideElement fieldSearchOnTeacherDirectory = $x("//*[@id=\":r0:\"]");

    @Step("Display Welcome Text on the Student Page  Отображение текста приветствия на странице студента")
    public void displayWelcomeTextOnStudentPage() throws InterruptedException {
        welcomeTextOnStudentPage.shouldBe(visible, Duration.ofSeconds(10));
        Thread.sleep(1000);
    }

    @Step("Fill field search on the page 'Student Directory' Заполнение поля поиска на странице 'Student Directory'")
    public void fillFieldSearchOnStudentDirectory(String studentFullName) {
        fieldSearchOnStudentDirectory.click();
        fieldSearchOnStudentDirectory.shouldBe(visible, Duration.ofSeconds(20));
        fieldSearchOnStudentDirectory.setValue(studentFullName);
        fieldSearchOnStudentDirectory.shouldBe(visible, Duration.ofSeconds(20));
        scroll.scrollIntoView(false);
    }

    @Step("Fill field search on the page 'Professor Directory' Заполнение поля поиска на странице 'Professor Directory'")
    public void fillFieldSearchOnProfessorDirectory(String desiredValue) throws InterruptedException {
        fieldSearchOnTeacherDirectory.click();
        Thread.sleep(1000);
        fieldSearchOnTeacherDirectory.shouldBe(visible, Duration.ofSeconds(10));
        fieldSearchOnTeacherDirectory.setValue(desiredValue);
        Thread.sleep(1000);
        fieldSearchOnTeacherDirectory.shouldBe(visible, Duration.ofSeconds(10));
        scroll.scrollIntoView(false);
    }

    @Step("Display search Result Student with ExactData Отображение поиска студента с конкретными данными")
    public void searchResultStudentDisplayExactData(String searchedStudentName) {
        searchResultOnStudentDirectoryFullName.shouldHave(Condition.text(searchedStudentName));
    }

    @Step("Display search Result Professor with ExactData Отображение поиска профессора с конкретными данными")
    public void searchResultProfessorDisplayExactData(String searchedProfessorName) {
        searchResultOnProfessorDirectoryFullName.shouldHave(Condition.text(searchedProfessorName));
    }

    @Step("Display search Result with ExactData Отображение поиска с рандомными данными")
    public void searchResultDisplayRandomData(String searchInput) {
        searchResultOnStudentDirectoryFullName.shouldHave(Condition.text(searchInput));
    }

    @Step("Click the button 'View Profile' ")
    public void viewProfileButtonClick() {
        viewProfileButton.click();
    }

}

