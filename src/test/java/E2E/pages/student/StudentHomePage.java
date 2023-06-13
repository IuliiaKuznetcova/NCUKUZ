package E2E.pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentHomePage {



    private ElementsCollection buttonInHeader = $$("//*[@id=\"home_header4\"]/header/div/div/div[1]");
    // TODO сделать проверку на видимость количества элементов в хедере

    private SelenideElement coursesButton = $x("//*[@id=\"home_header4\"]/header/div/div/div[1]/a[2]/span");
    private SelenideElement professorSpotlightTittle = $x("(//span[normalize-space()='Professor spotlight'])[1]");
    private SelenideElement studentAvatar = $x("//*[@id=\"home_header4\"]/header/div/div/div[2]/button/div/img");
    private SelenideElement signOutStudentButton = $x("(//a[@role='menuitem'])[2]");
    private SelenideElement professorDirectoryButton = $x("(//span[normalize-space()='Professors'])[1]");
    private SelenideElement coursesLIstButton = $x("//*[@id=\"home_header4\"]/header/div/div/div[1]/div/div/div/a");

      @Step("Display title professor Spotlight отображение заголовка")
    public void displayTitleProfessorSpotlight() {
        professorSpotlightTittle.shouldHave(Condition.text("Professor spotlight"));
    }


    @Step("Go to Courses Page  Переход к странице Courses")
    public void goToCoursesPage() throws InterruptedException {
        coursesButton.click();
        coursesButton.shouldBe(visible, Duration.ofSeconds(10));
        Thread.sleep(1000);
        coursesLIstButton.click();
        Thread.sleep(1000);
        // coursesLIstButton.shouldBe(visible, Duration.ofSeconds(10));
    }


}
