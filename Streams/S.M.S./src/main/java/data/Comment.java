package data;

import java.time.LocalDate;

public record Comment(int id, String content, LocalDate creationDate) {
}
