package E2E.pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class StudentGrowthMarketingCourseDetails {

    private SelenideElement growthMarketingTitleCourse = $x("//h3[normalize-space()='Growth Marketing']");
    private SelenideElement uploadCourseMaterialButton = $x("(//button[normalize-space()='Upload'])[1]");
    private SelenideElement aboutThisCourse = $(byText("About this course"));
    private ElementsCollection courseInformationWidget = $$(By.className("MuiGrid-container")).get(1)
            .$$(By.className("MuiGrid-item"));
    private SelenideElement tyknut = $x("(//a)[8]");

    @Step("Dysplay course information  Отображение информации об учителях курса")
    public void dysplayngInformationAboutCourseTiecher() {
        courseInformationWidget.get(1).shouldHave(text("Heading3"));
    }

    @Step("Dysplay (print) course information  Отображение информации об учителях курса")
    public void printInformationAboutCourseTiecher() {
        List<String> professors = new ArrayList<>();

        for (SelenideElement element : courseInformationWidget.get(0).$$(By.className("sw-font-size-xl"))) {
            professors.add(element.getText());
        }

        System.out.println(professors);
        for (int i = 0; i < professors.size(); i++) {
            String listProfessors = professors.get(i);
            System.out.println(listProfessors);
        }
    }

    @Step("Display Title Course Отображение названия курса")
    public void displayTitleCourse(String courseName) throws InterruptedException {
        growthMarketingTitleCourse.shouldHave(text(courseName));
        growthMarketingTitleCourse.shouldBe(visible, Duration.ofSeconds(10));
        Thread.sleep(1000);
    }

    @Step("Exists Upload Course Material Button  Присутствует кнопка Upload в разделе материалов курса")
    public void existsUploadCourseMaterialButton(String searchInput) {
        uploadCourseMaterialButton.shouldHave(text(searchInput));
    }

    @Step("Not Exists Upload Course Material Button  Отсутствует кнопка Upload в разделе материалов курса")
    public void notExistsUploadCourseMaterialButton(String value) {
        uploadCourseMaterialButton.shouldNotBe(Condition.visible);
    }

    @Step("View course description  Посмотреть описание курса")
    public void viewAboutThisCourse() {
        aboutThisCourse.should(exist);
    }

    @Step("Кликнуть на курс из результата поиска")
    public void tyknutTut() throws InterruptedException {
        tyknut.click();
        Thread.sleep(1000);
    }
}

