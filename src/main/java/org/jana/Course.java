package org.jana;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

// @Data
@Value
@AllArgsConstructor
@Builder
public class Course { // schlägt vor, die Class als Record zu definieren
    int courseId;
    String name;
    String teacher;
    List<Student> students;
}
