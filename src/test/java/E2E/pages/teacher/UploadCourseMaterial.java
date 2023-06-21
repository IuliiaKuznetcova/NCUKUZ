package E2E.pages.teacher;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class UploadCourseMaterial {

    private SelenideElement uploadCourseMaterialTitel = $x("(//h3[normalize-space()='Upload course material'])[1]");
    private SelenideElement documentNameField = $x("//*[@id=\"upload-course-material-form-DocumentName--1971305433\"]");
    private SelenideElement uploadDocumentField = $x("//*[@id=\"upload-course-material-form-Document-1880928548\"]");
    private SelenideElement uploadCourseMaterialButton = $x("(//button[normalize-space()='Upload'])[1]");

    @Step("Display the title 'Upload course material'")
    public void displayuploadCourseMaterialTitel() {
        uploadCourseMaterialTitel.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Enter Document name")
    public void enterDocumentName(String courseName) {
        documentNameField.shouldBe(visible, Duration.ofSeconds(10)).setValue(courseName);
    }

    @Step("Upload Document")
    public void uploadDocument(String filePath) {
        //String filePath = "E:/Autotesting/NCUKUZ/src/test/resources/123.png";
        uploadDocumentField.sendKeys(filePath);
    }

    @Step("Click the button 'Save'")
    public void clickUploadBatton() {
        uploadCourseMaterialButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(5000);
    }
}

