package E2E.pages.teacher;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class TeacherHomePage {

    //private SelenideElement addAcourseButton = $x("(//span[normalize-space()='Add a course'])[1]");
    private SelenideElement addAcourseButton = $x("//*[@id=\"home-header-logged-in-teachers\"]/header/div/div/div[1]/div/a");
    private SelenideElement coursesButton = $x("(//span[normalize-space()='Courses'])[1]");
    private SelenideElement coursesLIstButton = $x("(//a[@role='menuitem'])[1]");

    @Step("'Add A Сourse' Button exists")
    public void existAddAСourseButton() {
        addAcourseButton.shouldBe(Condition.visible);
    }

    @Step("Go to Courses Page")
    public void goToCoursesPage() throws InterruptedException {
        coursesButton.click();
        Thread.sleep(1000);
        coursesButton.shouldBe(visible, Duration.ofSeconds(10));
        Thread.sleep(1000);
        coursesLIstButton.click();
        Thread.sleep(1000);
        // coursesLIstButton.shouldBe(visible, Duration.ofSeconds(10));
    }

}
