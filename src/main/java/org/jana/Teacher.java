package org.jana;

import lombok.Builder;

@Builder
public record Teacher(int teacherId, String name, String subject) {
}
