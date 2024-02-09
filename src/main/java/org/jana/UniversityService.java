package org.jana;

import java.util.ArrayList;
import java.util.List;

public class UniversityService {

    // Write a function to calculate the average grade of a Course (Pass the Course as a parameter).
    public double calculateAverageGrade(Course course) {
        List<Student> students = course.getStudents();

        if (students.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getGrade() >= 0) {
                sum += student.getGrade();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return sum / count; // calculate the average grade
    }

    // Write a function to calculate the average grade of the entire University (Pass a University object as a parameter).

    public double calculateAverageGrade(University university) {
        List<Course> courses = university.getCourses();

        if (courses.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;
        for (Course course : courses) {
            double averageGrade = calculateAverageGrade(course);
            if (averageGrade > 0) {
                sum += averageGrade;
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return sum / count; // calculate the average grade
    }

    public List<Student> getStudentsWithNiceGrade(University university) {
        List<Course> courses = university.getCourses();
        List<Student> studentsWithNiceGrade = new ArrayList<>();

        for (Course course : courses) {
            List<Student> students = course.getStudents();
            for (Student student : students) {
                if (student.getGrade() <= 2) {
                    studentsWithNiceGrade.add(student);
                }
            }
        }

        return studentsWithNiceGrade;
    }
}
