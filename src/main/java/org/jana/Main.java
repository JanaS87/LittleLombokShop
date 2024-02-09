package org.jana;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Aufgaben 1 - 6");
        Student student = new Student(1, "Manni", "Munich", 1);
        Student student2 = new Student(2, "Herbert", "Hamburg", 2);
        Student student3 = new Student(3, "Susi", "Stuttgart", 4);
        Student student4 = new Student(4, "Klaus", "Köln", 3);

        System.out.println(" ");

        Teacher teacher = new Teacher(1, "Herr Müller", "Mathematik");
        Teacher teacher2 = new Teacher(2, "Frau Schmidt", "Deutsch");
        Teacher teacher3 = new Teacher(3, "Herr Meier", "Englisch");

        System.out.println(" ");

       Course course = new Course(1, "Mathematik", teacher.name(), List.of(student));
         Course course2 = new Course(2, "Deutsch", teacher2.name(), List.of(student2));
        Course course3 = new Course(3, "Englisch", teacher3.name(), List.of(student3));

        System.out.println("Course: " + course.getName() + " Teacher: " + course.getTeacher() + " Student: " + course.getStudents());

        System.out.println(teacher2.teacherId());
        System.out.println(course2);
        System.out.println(student3);

        System.out.println(student4);
        student4.setGrade(10);
        System.out.println(student4);

        System.out.println(" ");

        System.out.println("Aufgabe 7- Builder");
        // Lombok Builder
        Student student5 = Student.builder().studentId(5).name("Karl").address("Kassel").grade(2).build();
        System.out.println(student5);

        Teacher teacher4 = Teacher.builder().teacherId(4).name("Herr Schmidt").subject("Physik").build();
        System.out.println(teacher4);

        Course course4 = Course.builder().courseId(4).name("Physik").teacher(teacher4.name()).students(List.of(student)).build();
        System.out.println(course4);

        System.out.println(" ");

        System.out.println("Aufgabe 8 - With");
        // lombok With
        System.out.println(student5);
        Student student6 = student5.withGrade(6);
        System.out.println(student6);

        System.out.println(" ");

        // Bonus 1
        System.out.println("Bonus 1");
        Course course5 = Course.builder().courseId(5).name("Geschichte").teacher(teacher2.name()).students(List.of(student2)).build();
        System.out.println(course5);
        System.out.println(course5.getName()); // setName etc. ist nicht auswählbar

        System.out.println(" ");

        // Bonus 2
        System.out.println("Bonus 2");

        List<Student> students = new ArrayList<>();

        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Course newCourse = Course.builder().courseId(8).name("Sport").teacher("Herr Schmidt").students(students).build();

        System.out.println(newCourse);

        UniversityService universityService = new UniversityService();

        System.out.println(universityService.calculateAverageGrade(newCourse));

        System.out.println(" ");

        // Bonus 3
        System.out.println("Bonus 3");

        University university = new University(1, "Hochschule München", List.of(course, course2, course3, course4, course5, newCourse));

        System.out.println(university);

        double averageGrade = universityService.calculateAverageGrade(university);
        BigDecimal averageBig = new BigDecimal(averageGrade);
        BigDecimal averageBigRounded = averageBig.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Average Grade of the entire University: " + averageBigRounded);

        System.out.println(" ");

        // Bonus 4
        System.out.println("Bonus 4");
        System.out.println(universityService.getStudentsWithNiceGrade(university));




    }
}