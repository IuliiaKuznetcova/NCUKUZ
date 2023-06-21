package E2E.helpers;

import E2E.tests.BaseTest;
import io.qameta.allure.Step;

public class CourseHelper extends BaseTest {
    @Step("Course search with a check-up")
    public void searchCourseWithCheck(String courseName)  {
        studentCourseList.fillFieldSearch(courseName);
        studentCourseList.searchResultDisplayExactData(courseName);
        studentCourseList.goToCourseFromSearchResult(courseName);
        studentCourseDetails.displayTitleCourse(courseName);
        //studentGrowthMarketingCourseDetails.displayTitleCourse(String.valueOf(text(courseName)));
    }

    @Step("Course search ")
    public void searchCourse(String courseName) {
        studentCourseList.fillFieldSearch(courseName);
        studentCourseList.searchResultDisplayExactData(courseName);
        scrollPageToElement2023NoCode();
    }

    @Step("Student Search ")
    public void searchStudent(String searchedStudentName) {
        studentDirectoryPage.fillFieldSearchOnStudentDirectory(searchedStudentName);
        studentDirectoryPage.searchResultStudentDisplayExactData(searchedStudentName);
    }

    @Step("Student Search with a check-up ")
    public void searchStudentWithCheck(String searchedStudentName) {
        studentDirectoryPage.fillFieldSearchOnStudentDirectory(searchedStudentName);
        studentDirectoryPage.searchResultStudentDisplayExactData(searchedStudentName);
        studentDirectoryPage.viewProfileButtonClick();
        studentDetailsPage.displayStudenFullNameExactData(searchedStudentName);
    }

    @Step("Professor Search  with a check-up ")
    public void searchProfessorWithCheck(String searchedProfessorName) throws InterruptedException {
        studentDirectoryPage.fillFieldSearchOnProfessorDirectory(searchedProfessorName);
        studentDirectoryPage.searchResultProfessorDisplayExactData(searchedProfessorName);
        studentDirectoryPage.viewProfileButtonClick();
        studentDetailsPage.displayProfessorFullNameExactData(searchedProfessorName);
    }
}
