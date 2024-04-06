package data;

import java.util.List;

public record User(String username, String password, String e_mail, List<Post> posts) {
}
