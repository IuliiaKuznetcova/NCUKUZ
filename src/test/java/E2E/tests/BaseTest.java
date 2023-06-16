package E2E.tests;

import E2E.helpers.HeaderHelpers;
import E2E.helpers.HomePageHelpers;
import E2E.pages.SignUp.SignUpPage;
import E2E.pages.guest.GuestHomePage;
import E2E.pages.guest.SearchPage;
import E2E.pages.signIn.SignInPage;
import E2E.pages.student.*;
import E2E.pages.teacher.AddCoursePage;
import E2E.pages.teacher.EditCourse;
import E2E.pages.teacher.TeacherHomePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {


    //final static String BASE_URI = "https://jere237.softr.app/";
    final String BASE_URI = PropertiesLoader.loadProperties("url");
    final SelenideElement scroll = $x(" //*[@id=\"home-footer\"]/section/div/div[3]/div[1]/small");

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = new ChromeOptions().addArguments("-remote-allow-origins=*");
        /*EdgeOptions options = new EdgeOptions();
        Configuration.browserCapabilities = options;*/
        // TODO проверка в Edge
        open(BASE_URI);
    }



    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    @Step("Scroll page to element 2023NoCode Проскролить страницу до элемента 2023NoCode")
    public void scrollPageToElement2023NoCode() {
        scroll.scrollIntoView(false);
    }

    protected EditCourse editCourse = new EditCourse();
     protected SearchPage searchPage = new SearchPage();
    protected SignInPage signInPage = new SignInPage();
    protected SignUpPage signUpPage = new SignUpPage();
    protected HeaderHelpers headerHelpers = new HeaderHelpers();
    protected AddCoursePage addCoursePage = new AddCoursePage();
    protected StudentDetailsPage studentDetailsPage = new StudentDetailsPage();
    protected StudentHomePage studentHomePage = new StudentHomePage();
    protected TeacherHomePage teacherHomePage = new TeacherHomePage();
    protected StudetnDirectoryPage studentDirectoryPage = new StudetnDirectoryPage();
    protected HomePageHelpers homePageHelpers = new HomePageHelpers();
    protected GuestHomePage guestHomePage = new GuestHomePage();
    protected StudentCourseList studentCourseList = new StudentCourseList();
    protected StudentCourseDetails studentGrowthMarketingCourseDetails = new StudentCourseDetails();

}
