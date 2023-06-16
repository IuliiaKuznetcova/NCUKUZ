package E2E.pages.teacher;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EditCourse {
    private SelenideElement editCourseButton = $x("(//div[@id='modal-trigger'])[1]");
    private SelenideElement editRecordForm = $x("(//div[@role='dialog'])[1]");
    private SelenideElement courseNameField = $x("(//input[@name='Course Name'])[1]");
    private SelenideElement courseDescriptionField = $x("(//div[@class='ProseMirror toastui-editor-contents'])[1]");
    private SelenideElement teacherField = $x("(//div[@class='selectize-input items not-full has-options has-items'])[1]");
    private SelenideElement documentNameField = $x("(//div[@class='selectize-input items not-full has-options has-items'])[2]");
    private SelenideElement coverPhotoField = $x(" (//input[@id='fld48q8Qjx5hyMNDc-input'])[1]");
    private SelenideElement deletePhotoBatton = $x(" (//span[@class='delete'])[1]");
    private SelenideElement cancelBatton = $x("(//button[@aria-label='Close this dialog window'][normalize-space()='Cancel'])[1]");
    private SelenideElement saveBatton = $x("(//button[@aria-label='Close this dialog window'][normalize-space()='Cancel'])[1]");
    private SelenideElement courseStartDate = $x("(//input[@name='Start date'])[1]");
    private SelenideElement courseEndDate = $x("(//input[@name='Start date'])[1]");

    @Step("Click the button edit Course Нажать кнопку Edit Course")
    public void editCourseButtonClick() {
        editCourseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Display edit Record Form  Отображение формы Edit Record")
    public void displayEditRecordForm() {
        editRecordForm.shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Edit Course name Изменение названия курса")
    public void editCourseName(String courseName) {
        courseNameField.shouldBe(visible, Duration.ofSeconds(10)).setValue("\u0003").setValue(courseName);
    }

    @Step("Edit Course description Изменение описания курса")
    public void editCourseDescription(String courseDescription) {
        courseDescriptionField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseDescription);
    }

    @Step("Cover photo Прикрепить фото")
    public void coverPhoto() {
        String filePath = "E:/Autotesting/NCUKUZ/src/test/resources/opi.png";
        coverPhotoField.sendKeys(filePath);
    }

    @Step("Edit Course Start Date Выбрать дату начала курса")
    public void editCourseStartDate(String startData) {
        clickCourseStartDate();
        selectDate(startData);
    }

    @Step("Edit Course End Date Выбрать дату окончания курса")
    public void editCourseEndDate(String endData) {
        clickCourseEndDate();
        selectDate(endData);
    }


    @Step("Click the button Cancel Нажать кнопку Отменить")
    public void clickCancelBatton() {
        cancelBatton.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(5000);
    }

    @Step("Click the button Save Нажать кнопку Сохранить")
    public void clickSaveBatton() {
        saveBatton.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(5000);
    }

      public void selectDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        String dayOfMonth = String.valueOf(localDate.getDayOfMonth());

        while (true) {
            SelenideElement displayedDate = $("ul.month-year-header li:nth-child(2)");
            String[] displayedDateParts = displayedDate.text().split(" ");
            int displayedYear = Integer.parseInt(displayedDateParts[1]);
            String displayedMonth = displayedDateParts[0];
            String monthName = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
            if (displayedYear < localDate.getYear() || (displayedYear == localDate.getYear() && !displayedMonth.equals(monthName))) {
                $("ul.month-year-header li:nth-child(3) svg:first-child").click(); // Click the right arrow
            } else {
                break;
            }
        }

        $$("button.rdrDay span.rdrDayNumber span").filter(Condition.text(dayOfMonth)).get(0).click();
    }

    @Step("Click the field Add Course Нажать поле Выбрать дату начала курса")
    public void clickCourseStartDate() {
        courseStartDate.click();
    }

    @Step("Click the field Add Course Нажать поле Выбрать дату окончания курса")
    public void clickCourseEndDate() {
        courseEndDate.click();
    }


}
