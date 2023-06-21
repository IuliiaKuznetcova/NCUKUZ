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

public class AddCoursePage {
    private SelenideElement addCourseButton = $x("(//span[normalize-space()='Add course'])[1]");

    //private SelenideElement addCourseButton = $x("(//span[@class='MuiBox-root css-jf8tht'])[1]");
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
    private SelenideElement courseDescriptionField = $x("(//textarea[@id='course-documents-form-Description-1634506682'])[1]");
    private SelenideElement coverPhotoField = $x("(//input[@id='course-documents-form-CoverPhoto-1704715303'])[1]");
    private SelenideElement courseStartDate = $x("(//input[@id='course-documents-form-Startdate-831849774'])[1]");
    // private SelenideElement juni1StartDate = $x("(//button[contains(@class,'rdrDay rdrDayStartOfMonth')])[1]");
    private SelenideElement courseEndDate = $x("(//input[@id='course-documents-form-Enddate-1271684309'])[1]");
    private SelenideElement monthBox = $x("(//div[@class='rdrMonth'])[1]");
    // private SelenideElement juni30EndDate = $x("(//span[contains(@class,'rdrDayStartPreview rdrDayEndPreview')])[1]");
    private SelenideElement addBatton = $x("(//button[normalize-space()='Add'])[1]");

    @Step("Display 'Add new Course' Form")
    public void displayAddANewCourseForm() {
        addANewCourseForm.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Enter Course name")
    public void enterCourseName(String courseName) {
        courseNameField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseName);
    }

    @Step("Select specific Faculty")
    public void selectFaculty() {
        clickSelectFaculty();
        selectFacultyMedicine();
    }

    @Step("Enter Course description")
    public void enterCourseDescription(String courseDescription) {
        courseDescriptionField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseDescription);
    }

    @Step("Cover photo")
    public void coverPhoto() {
        String filePath = "E:/Autotesting/NCUKUZ/src/test/resources/ras.jfif";
        coverPhotoField.sendKeys(filePath);
    }

    @Step("Select Start Date of the Course")
    public void selectCourseStartDate(String startData) {
        clickCourseStartDate();
        selectDate(startData);
    }

    @Step("Select Start Date of the Course ")
    public void selectCourseEndDate(String endData) {
        clickCourseEndDate();
        selectDate(endData);
    }

    @Step("Click the button 'Add Course'")
    public void addCourseButtonClick() {
        addCourseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Select Faculty")
    public void clickSelectFaculty() {
        selectFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    // TODO выбор любого факультета
    @Step("select Faculty Medicine")
    public void selectFacultyMedicine() {
        //selectFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();
        medicineFaculty.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Click the button 'Add'")
    public void clickAddBatton() {
        addBatton.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(7000);
    }

    @Step("Checking if the button is green")
    public void checkAddCourse() {
        // addBatton.shouldHave(cssValue("background-color", "green"));
        String colorOfBatton = addBatton.getCssValue("background-color:#2c2921");
        addBatton.click();
        addBatton.shouldNotHave(Condition.attribute("background-color:#2c2921", colorOfBatton));
    }

    @Step("Click the field 'Course Start Date'")
    public void clickCourseStartDate() {
        courseStartDate.click();
    }

    @Step("Click the field 'Course End Date'")
    public void clickCourseEndDate() {
        courseEndDate.click();
    }

    @Step("Select date")
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
}



