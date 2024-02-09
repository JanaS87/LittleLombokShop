package org.jana;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private int studentId;
    private String name;
    private String address;
   @With
   private int grade;

}
