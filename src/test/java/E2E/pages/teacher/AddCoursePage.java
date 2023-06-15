package E2E.pages.teacher;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class AddCoursePage {

    private SelenideElement addCourseButton = $x("(//span[normalize-space()='Add course'])[1]");
    private SelenideElement addANewCourseForm = $x("(//div[@class='MuiGrid-root MuiGrid-container css-t7lb4m'])[1]");
    private SelenideElement courseNameField = $x("(//input[@id='course-documents-form-CourseName--1078269106'])[1]");
    private SelenideElement selectFaculty = $x("(//div[@id='course-documents-form-Faculty-1389247778'])[1]");
    //private SelenideElement medicineFaculty = $x("(//div[@id='course-documents-form-Faculty-1389247778'])[1]");
    private SelenideElement medicineFaculty = $x("(//li[normalize-space()='Medicine'])[1]");
    private SelenideElement businessSchoolFaculty = $x("(//li[normalize-space()='Business School'])[1]");
    private SelenideElement engineeringFaculty = $x("(//li[normalize-space()='Engineering'])[1]");
    private SelenideElement sciencesFaculty = $x("(//li[normalize-space()='Sciences'])[1]");
    private SelenideElement lawFaculty = $x("(//li[normalize-space()='Law'])[1]");
    private SelenideElement artsFaculty = $x("(//li[normalize-space()='Arts, Design & Architecture'])[1]");
    private SelenideElement courseDescriptionField  = $x("(//textarea[@id='course-documents-form-Description-1634506682'])[1]");
    private SelenideElement coverPhoto = $x("(//input[@id='course-documents-form-CoverPhoto-1704715303'])[1]");
    private SelenideElement courseStartDate = $x("(//input[@id='course-documents-form-Startdate-831849774'])[1]");
   // private SelenideElement juni1StartDate = $x("(//button[contains(@class,'rdrDay rdrDayStartOfMonth')])[1]");
    private SelenideElement courseEndDate = $x("(//input[@id='course-documents-form-Enddate-1271684309'])[1]");
    private SelenideElement monthBox = $x("(//div[@class='rdrMonth'])[1]");
   // private SelenideElement juni30EndDate = $x("(//span[contains(@class,'rdrDayStartPreview rdrDayEndPreview')])[1]");
    private SelenideElement addBatton= $x("(//button[normalize-space()='Add'])[1]");

    @Step("Click the button Add Course Нажать кнопку ДОбавить курс")
    public void selectCourseStartDate() {
        courseStartDate.click();
        String dateToSelect = "10"; // Пример даты, которую нужно выбрать
        String dateSelector = monthBox + dateToSelect + "']";
        $(byCssSelector(dateSelector)).click();
    }

/*    public static void SetDatepicker(String datepickerSelector, String dateToSelect) {
        // найти элемент поля выбора даты
        SelenideElement datepicker = $(byCssSelector(datepickerSelector));

        // ввести дату
        datepicker.setValue(dateToSelect);}

    @Step("Click the button Add Course Нажать кнопку ДОбавить курс")
    public void selectCourseStartDate() {
        courseStartDate.click();
        switchTo().frame(monthBox);
        SetDatepicker("#datepicker", "10");
    }*/




    @Step("Click the button Add Course Нажать кнопку ДОбавить курс")
    public void addCourseButtonClick() {
        addCourseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }


    @Step("Display Add new Course Form  Отображение формы регистрации")
    public void displayAddANewCourseForm() {
        addANewCourseForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Enter Course name Введение названия курса")
    public void enterCourseName(String courseName) {
        courseNameField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseName);
    }
    // TODO выбор любого факультета

    @Step("select Faculty Medicine Выбрать факультета медицины")
    public void selectFaculty() {
        selectFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();

    }
    @Step("select Faculty Medicine Выбрать факультета медицины")
    public void selectFacultyMedicine() {
        //selectFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();
        medicineFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Enter Course description Введение описания курса")
    public void enterCourseDescription(String courseDescription) {
        courseDescriptionField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseDescription);
    }

    @Step("Cover photo Прикрепить фото")
    public void coverPhoto() {
        String filePath = "E:/Autotesting/NCUKUZ/src/test/resources/opi.png";
        coverPhoto.sendKeys(filePath);
    }

 /*    @Step("Select Course start date Выбор даты начала курса")
    public void selectCourseStartDate() {
        courseStartDate.click();
    }*/

    //$(byCssSelector(datePickerSelector)).setValue(dateValue);
   /* @Step("Select 1 Juni Start DateCourse start date выбор начала курса 1 июня")
    public void select1JuniStartDate() {
        juni1StartDate.click();
    }

    @Step("Select 30 Juni DateCourse End date Выбор окончания курса 30 июня")
    public void select30JuniEndtDate() {
        juni30EndDate.click();
    }*/

    @Step("Click the button Add Нажать кнопку Добавить")
    public void clickAddBatton() {
        addBatton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}

