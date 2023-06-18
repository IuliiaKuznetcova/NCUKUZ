package E2E.tests;

import E2E.helpers.CourseHelper;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

public class AddCourseTest extends BaseTest {
    CourseHelper courseHelper = new CourseHelper();
    private String emailMalik = PropertiesLoader.loadProperties("emailMalik");
    private String passwordMalik = PropertiesLoader.loadProperties("passwordMalik");

    @Issue("NCU-108")
    @Test
    public void addCourseTest() {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        addCoursePage.addCourseButtonClick();
        addCoursePage.displayAddANewCourseForm();
        addCoursePage.enterCourseName("MedMed");
        addCoursePage.selectFaculty();
        addCoursePage.enterCourseDescription("Med Med");
        addCoursePage.coverPhoto();
        addCoursePage.selectCourseStartDate("15-08-2023");
        addCoursePage.selectCourseEndDate("28-08-2023");
        addCoursePage.clickAddBatton();
        //addCoursePage.checkAddCourse();
        // TODO проверка что кнопка зеленая
    }

    @Issue("NCU-108")
    @Test
    public void addCourseTestWithCheckingTheRoleOfTheTeacher() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        addCoursePage.addCourseButtonClick();
        addCoursePage.displayAddANewCourseForm();
        addCoursePage.enterCourseName("RasRas");
        addCoursePage.selectFaculty();
        addCoursePage.enterCourseDescription("rasras");
        addCoursePage.coverPhoto();
        addCoursePage.selectCourseStartDate("15-08-2023");
        addCoursePage.selectCourseEndDate("28-08-2023");
        addCoursePage.clickAddBatton();
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Med");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();
    }

    @Issue("NCU-108")
    @Test
    public void addCourseTestWithCheckingTheRoleOfTheStudent() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        addCoursePage.addCourseButtonClick();
        addCoursePage.displayAddANewCourseForm();
        addCoursePage.enterCourseName("MedMed");
        addCoursePage.selectFaculty();
        addCoursePage.enterCourseDescription("Med Med");
        addCoursePage.coverPhoto();
        addCoursePage.selectCourseStartDate("15-08-2023");
        addCoursePage.selectCourseEndDate("28-08-2023");
        addCoursePage.clickAddBatton();
        headerHelpers.signOut();
        guestHomePage.clickSignInButton();
        signInPage.loginMalik(emailMalik, passwordMalik);
        studentHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Med");
        studentCourseDetails.tyknutTut();
        studentCourseDetails.viewAboutThisCourse();
    }

    @Issue("NCU-108")
    @Test
    public void addAndEditCourseTestWithChecking() throws InterruptedException {
        guestHomePage.clickSignInButton();
        signInPage.loginRoxanne();
        Selenide.sleep(5000);
        addCoursePage.addCourseButtonClick();
        addCoursePage.displayAddANewCourseForm();
        addCoursePage.enterCourseName("MedMed");
        addCoursePage.selectFaculty();
        addCoursePage.enterCourseDescription("Med Med");
        addCoursePage.coverPhoto();
        addCoursePage.selectCourseStartDate("15-08-2023");
        addCoursePage.selectCourseEndDate("28-08-2023");
        addCoursePage.clickAddBatton();
        teacherHomePage.goToCoursesPage();
        courseHelper.searchCourseWithCheck("Med");
        studentCourseDetails.tyknutTut();
        editCourse.editCourseButtonClick();
        editCourse.displayEditRecordForm();
        editCourse.editCourseName("Medicine");
        editCourse.clickSaveBatton();
    }
}

