package E2E.pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class StudentCourseDetails {


   //private SelenideElement growthMarketingTitleCourse = $x("//h3[normalize-space()='Growth Marketing']");
   private SelenideElement courseTitle = $x("//*[@id=\"course-list\"]/section/div/div/div[2]/div/div/div[1]/div/div/div");
    private SelenideElement uploadCourseMaterialButton = $x("(//button[normalize-space()='Upload'])[1]");
    private SelenideElement neueDescription = $x("(//div[contains(@class,'list-field-element MuiBox-root css-1qw4ra5')])[4]");
     private SelenideElement aboutThisCourse = $(byText("About this course"));
    private ElementsCollection courseInformationWidget = $$(By.className("MuiGrid-container")).get(1).$$(By.className("MuiGrid-item"));
    //private SelenideElement tyknut = $x("(//a)[8]");
    private SelenideElement firstCourse = $$(By.className("MuiGrid-container")).get(1).$$(By.className("MuiGrid-item")).get(0).find("a");

    private SelenideElement courseMaterialTitle = $x("(//h2[normalize-space()='Course material'])[1]");
    private SelenideElement downloadLink = $x("(//div[contains(text(),'Growth Marketing Course Document.pdf')])[1]");


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
    public void displayTitleCourse(String courseName)  {
        courseTitle.shouldHave(text(courseName));
        courseTitle.shouldBe(visible, Duration.ofSeconds(10));
        Selenide.sleep(1000);
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
    public void tyknutTut()  {
        firstCourse.click();
        Selenide.sleep(1000);
    }

    @Step("Cкачать документ по ссылке")
public void downloadDocument1()  {
       // courseTitle.shouldHave(text(documentName)).shouldBe(visible, Duration.ofSeconds(10));
      /*  File downloadedFile = downloadLink.download();
        if (downloadedFile.exists()) {
            System.out.println("Файл успешно загружен");
        } else {
            System.out.println("Загруженный файл не найден");
        }*/
    }
public void downloadDocument () throws FileNotFoundException {
    SelenideElement  downloadDocument = Selenide.$("a[href='https://v5.airtableusercontent.com/v1/18/18/1687046400000/8-lu83W2yV-wZsn1D2wz5w/IJcnFqy97LD82i8ghBWFqExgvj86iZD2CGD3_qYyBQXjFQfgZb-AC72qyxpVPOKka21Og3jtu2p4hywzg7ei_1rzWtVlG_6nQeTPOCaIqZM/IHgbt0lNJbJ8x5wo8Kl6JINKcs2CC13PtdgruBT_8gE']");
    File downloadedFile = downloadDocument.download();
    if (downloadedFile.exists()) {
        System.out.println("Файл успешно загружен");
    } else {
        System.out.println("Загруженный файл не найден");
    }
}
    }


