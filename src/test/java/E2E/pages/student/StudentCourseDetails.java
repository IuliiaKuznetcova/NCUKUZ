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
    private SelenideElement firstCourse = $$(By.className("MuiGrid-container")).get(1).$$(By.className("MuiGrid-item")).get(0).find("a");
    private SelenideElement courseMaterialTitle = $x("(//h2[normalize-space()='Course material'])[1]");
    private SelenideElement downloadLink = $x("(//div[contains(text(),'Growth Marketing Course Document.pdf')])[1]");


    @Step("Information display about the teachers of the courses ")
    public void dysplayngInformationAboutCourseTeacher() {
        courseInformationWidget.get(1).shouldHave(text("Heading3"));
    }

    @Step("Information display about the teachers of the courses ")
    public void printInformationAboutCourseTeacher() {
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

    @Step("Title Course display")
    public void displayTitleCourse(String courseName) {
        courseTitle.shouldHave(text(courseName));
        courseTitle.shouldBe(visible, Duration.ofSeconds(10));
        Selenide.sleep(1000);
    }

    @Step("The button 'Upload' in the Course Material section")
    public void existsUploadCourseMaterialButton(String searchInput) {
        uploadCourseMaterialButton.shouldHave(text(searchInput));
    }

    @Step("No button 'Upload' in the Course Material section")
    public void notExistsUploadCourseMaterialButton(String value) {
        uploadCourseMaterialButton.shouldNotBe(Condition.visible);
    }

    @Step("View the course description")
    public void viewAboutThisCourse() {
        aboutThisCourse.should(exist);
    }

    @Step("Click the Title from the search result")
    public void tyknutTut() {
        firstCourse.click();
        Selenide.sleep(1000);
    }

    @Step("DDownload the document from the link")
    // TODO When retaking the test after a while, the test fails because the link was not found.
    //  If you follow the link in a manual mode, the following message appears 'This URL has expired'
    //  ДTo successfully pass the test, you need to get a new link

    public void downloadDocument() throws FileNotFoundException {
        //SelenideElement  downloadDocument = Selenide.$("a[href='https://v5.airtableusercontent.com/v1/18/18/1687046400000/8-lu83W2yV-wZsn1D2wz5w/IJcnFqy97LD82i8ghBWFqExgvj86iZD2CGD3_qYyBQXjFQfgZb-AC72qyxpVPOKka21Og3jtu2p4hywzg7ei_1rzWtVlG_6nQeTPOCaIqZM/IHgbt0lNJbJ8x5wo8Kl6JINKcs2CC13PtdgruBT_8gE']");
        //SelenideElement  downloadDocument = Selenide.$("a[href='https://v5.airtableusercontent.com/v1/18/18/1687104000000/gRPxrT3XXHIofVD63wALUw/rI4Bxb6bgpV1X0sjwbZqPmPAmg95LqPte4vbUqZDWsTR_v0lb7NsBR0ZGGWTasg1epJ1XSvOpC0_iQkpyFbCzG-B9NhPE9rWcF4x5EzXGXgj8B5wRONwwqpybDBxnhgB/t3vNfpb7zOWLHbeBH7pBYPXay5hr-ZWRk8WMSo3-kI0']");
        //SelenideElement downloadDocument = Selenide.$("a[href='https://v5.airtableusercontent.com/v1/18/18/1687104000000/Vtin4dk_FdY0zETKBRsDIA/c79i21d83A-NPaHxQnhiI8c9j-NQFo9UuipcSu_3ljyjCIqErkGfGr_V9CTdhgmf4rTs9brr9pSOOnPJCrNBCyRq1bsFCDFx5JyWW1ye2vI/BmG09gqiNk1VwAlSc586w-_doQu82Vd8LPd5XuB5NpY']");
        SelenideElement downloadDocument = Selenide.$("a[href='https://v5.airtableusercontent.com/v1/18/18/1687377600000/Z0JIlWAYorcGe1_dNCbMmQ/elM8UTmrjTjwTOhOImINe-b9CUXEAcVzxRm0o3_3kfBpOED04xFkfVOhT03IwfaphCAZSlnWngbwoy5nCZpQ0py7KW36Lju9A1DIGUh7oYQeXeKrOdsAH_JZexk1KpEW/E5lXOioGWa_PgUmao8gPWdyil4H5D7X6jKqdKtXGU00']");

        File downloadedFile = downloadDocument.download();
        if (downloadedFile.exists()) {
            System.out.println("File uploaded successfully");
        } else {
            System.out.println("Uploaded file not found");
        }
    }

}


