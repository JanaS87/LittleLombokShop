package org.jana;

import java.util.ArrayList;
import java.util.List;

public record University(int universityId, String name, List<Course> courses) {
    public University addCourse(Course course) {
        List<Course> courseList = new ArrayList<>(courses);
        courseList.add(course);

        return new University(universityId, name, courseList);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
