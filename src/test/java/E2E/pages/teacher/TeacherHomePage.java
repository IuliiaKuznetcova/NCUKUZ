package E2E.pages.teacher;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class TeacherHomePage {

    private SelenideElement addAcourseButton = $x("(//span[normalize-space()='Add a course'])[1]");

    @Step("Не отображается кнопка Sign In")
    public void existAddAСourseButton() {
        addAcourseButton.shouldBe(Condition.visible);
    }

}
