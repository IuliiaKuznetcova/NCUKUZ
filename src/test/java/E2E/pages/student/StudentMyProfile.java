package E2E.pages.student;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class StudentMyProfile {

    private SelenideElement selectYourRole = $x("//div[@class='filter-option-inner-inner']");
    private SelenideElement selectRoleTeacher = $x("(//span[normalize-space()='teacher'])[1]");
    private SelenideElement selectRoleStudent = $x("//span[normalize-space()='student']");
    private SelenideElement updateProfileBatton = $x("//a[@id='sw-update-profile-btn']");

    @Step("Edit the role of Student to Teacher")
    public void editTheRoleOfStudentToTeacher() {
        selectYourRole.click();
        Selenide.sleep(3000);
        selectRoleTeacher.click();
        Selenide.sleep(3000);
        updateProfileBatton.click();
        Selenide.sleep(5000);
    }

    @Step("Edit the role of Teacher to Student")
    public void editTheRoleOfTeacherToStudent() {
        selectYourRole.click();
        Selenide.sleep(3000);
        selectRoleTeacher.click();
        Selenide.sleep(3000);
        updateProfileBatton.click();
        Selenide.sleep(5000);
    }
}
