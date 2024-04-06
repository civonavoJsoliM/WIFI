package data;

import java.time.LocalDate;
import java.util.List;

public record Post(int id, String content, LocalDate creationDate, List<Comment> comments) {
}
