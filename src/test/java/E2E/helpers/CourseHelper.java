package E2E.helpers;

import E2E.tests.BaseTest;
import io.qameta.allure.Step;

public class CourseHelper extends BaseTest {
    @Step("Search course with check Поиск курса с проверкой")
    public void searchCourseWithCheck(String courseName)  {
        studentCourseList.fillFieldSearch(courseName);
        studentCourseList.searchResultDisplayExactData(courseName);
        studentCourseList.goToCourseFromSearchResult(courseName);
        studentCourseDetails.displayTitleCourse(courseName);
        //studentGrowthMarketingCourseDetails.displayTitleCourse(String.valueOf(text(courseName)));
    }

    @Step("Search course Поиск курса")
    public void searchCourse(String courseName) {
        studentCourseList.fillFieldSearch(courseName);
        studentCourseList.searchResultDisplayExactData(courseName);
        scrollPageToElement2023NoCode();
    }

    @Step("Search Student Поиск студента")
    public void searchStudent(String searchedStudentName) {
        studentDirectoryPage.fillFieldSearchOnStudentDirectory(searchedStudentName);
        studentDirectoryPage.searchResultStudentDisplayExactData(searchedStudentName);
    }

    @Step("Search Student with check Поиск студента с проверкой")
    public void searchStudentWithCheck(String searchedStudentName) {
        studentDirectoryPage.fillFieldSearchOnStudentDirectory(searchedStudentName);
        studentDirectoryPage.searchResultStudentDisplayExactData(searchedStudentName);
        studentDirectoryPage.viewProfileButtonClick();
        studentDetailsPage.displayStudenFullNameExactData(searchedStudentName);
    }

    @Step("Search Professor  with check Поиск профессора с проверкой")
    public void searchProfessorWithCheck(String searchedProfessorName) throws InterruptedException {
        studentDirectoryPage.fillFieldSearchOnProfessorDirectory(searchedProfessorName);
        studentDirectoryPage.searchResultProfessorDisplayExactData(searchedProfessorName);
        studentDirectoryPage.viewProfileButtonClick();
        studentDetailsPage.displayProfessorFullNameExactData(searchedProfessorName);
    }
}
