package E2E.pages.student;

import E2E.tests.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentCourseList  {

    private SelenideElement ourCourseTitle = $x("//*[@id=\"course-list-heading\"]/section/div/div/div/h1");
    //private SelenideElement growthMarketingCourseButton = $x("//*[@id=\"course-list\"]/section/div/div/div[2]/div/div/div[1]/div/div/div[8]/div/div[1]/a");
    private SelenideElement growthMarketingCourseButton = $x("(//div[contains(@class,'list-action-wrapper')])");
    private SelenideElement discoverMoreButton = $x("(//button[normalize-space()='Discover more'])[1]");

    private SelenideElement fieldSearchOnCourseList = $x("//*[@id=\":r0:\"]");


    private SelenideElement searchResultOnCourseList = $x("//*[@id=\"course-list\"]/section/div/div/div[2]");
    //private SelenideElement growthMarketingCourseSearchResult = $x("//*[@id=\"course-list\"]/section/div/div/div[2]/div/div/div/div/div/div/div/div[1]/a");
    //private SelenideElement growthMarketingCourseSearchResult = $x("//*[@id=\"course-list\"]/section/div/div/div[2]/div/div/div/div/div/div");
    private ElementsCollection courseBlockOnCourseListWidget = $$(By.className("vertical-list-item"));

    public void discoverMoreButtonClick(){
        discoverMoreButton.click();
    }

    public void checkFirstWidgetTitle() {
        courseBlockOnCourseListWidget.get(1).$(By.className("MuiChip-root")).shouldHave(text("Marie"));
    }

    public void checkFirstWidgetTitle1() {
        String titleCours = courseBlockOnCourseListWidget.get(1).$(By.className("additional-elements-wrapper")).$(By.className("css-1vykty2")).getText();
        System.out.println(titleCours);
    }

    public void checkAllWidgetTitle(String[] titleName) {
        Map<Integer, String> expectedNames = new HashMap<>();
        for (int i = 0; i < titleName.length; i++) {
            expectedNames.put(i, titleName[i]);
        }
        for (Map.Entry<Integer, String> entry : expectedNames.entrySet()) {
            int widgetIndex = entry.getKey();
            String expectedName = entry.getValue();
            //courseBlockonCourseListWidget.get(widgetIndex).$(By.className("MuiChip-root")).shouldHave(text(expectedName));
            courseBlockOnCourseListWidget.get(widgetIndex).
                    $(By.className("additional-elements-wrapper")).
                    $(By.className("css-1vykty2")).shouldHave(text(expectedName));
        }
    }

    @Step("Display our courses title Отображение названия Our courses")
    public void displayOurCoursesTitle(String title) {
        ourCourseTitle.shouldBe(Condition.text(title));
    }

    @Step("Go to Growth Marketing course  Переход к курсу Growth Marketing")
    public void goToGrowthMarketingCourse() {
        growthMarketingCourseButton.shouldBe(visible, Duration.ofSeconds(10));
       // growthMarketingCourseButton.shouldHave(text(expectedText));
       growthMarketingCourseButton.click();
    }

    @Step("Fill field search on course list Page Заполнение поля поиска на странице Course list")
    public void fillFieldSearchOnCourseList(String desiredValue) {
        fieldSearchOnCourseList.click();
        fieldSearchOnCourseList.shouldBe(visible, Duration.ofSeconds(10));
        fieldSearchOnCourseList.setValue(desiredValue);
        fieldSearchOnCourseList.shouldBe(visible, Duration.ofSeconds(10));
        // scroll.scrollIntoView(false);
    }

    @Step("Fill field search Заполнение поля поиска")
    public void fillFieldSearch(String courseName) {
        fieldSearchOnCourseList.click();
        fieldSearchOnCourseList.shouldBe(visible, Duration.ofSeconds(10));
        fieldSearchOnCourseList.setValue(courseName);
        fieldSearchOnCourseList.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Search result on course list page  Результат поиска на странице Сourse list")
    public void searchResultDisplayExactData(String courseName) {
        searchResultOnCourseList.shouldHave(Condition.text(courseName));
        //searchResultOnCourseList.shouldHave(exactText(courseName));
        // TODO для поиска по конкретному слову нужно найти локатор коллекции
    }

    @Step("Go to a course from a search result  Переход к курсу из результата поиска")
    public void goToCourseFromSearchResult(String courseName) {
        searchResultOnCourseList.shouldBe(visible, Duration.ofSeconds(10));
        searchResultOnCourseList.shouldHave(Condition.text(courseName));

    }


}
