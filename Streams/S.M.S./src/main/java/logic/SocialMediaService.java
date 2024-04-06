package logic;

import data.Post;
import data.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SocialMediaService {
    public List<Post> getPostFromCertainUsr(List<User> users, User certainUser) {
        return users.stream()
                .filter(user -> user.equals(certainUser))
                .flatMap(user -> user.posts().stream())
                .collect(Collectors.toList());
    }

    public List<User> userWithMostPosts(List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(user -> user, user -> user.posts().size()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .stream().collect(Collectors.toList());
    }
    
    public List<Post> postWithMostComments(List<User> users) {
        return users.stream()
                .flatMap(user -> user.posts().stream())
                .max(Comparator.comparingInt(post -> post.comments().size()))
                .stream().collect(Collectors.toList());
    }

}
