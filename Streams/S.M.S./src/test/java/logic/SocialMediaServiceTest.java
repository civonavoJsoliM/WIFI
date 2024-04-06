package logic;

import data.Post;
import data.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SocialMediaServiceTest {

    @ParameterizedTest
    @MethodSource("initialParameters")
    void getPostFromCertainUsr(List<User> users, User certainUser, List<Post> expected) {
        SocialMediaService socialMediaService = new SocialMediaService();
        List<Post> posts = socialMediaService.getPostFromCertainUsr(users, certainUser);
        assertEquals(expected, posts);
    }

    static Stream<Arguments> initialParameters() {
        return Stream.of(
                Arguments.of(List.of(new User("iampoce", "123", "milos@intellij.com",
                                        List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                                new Post(2, "World", LocalDate.now(), List.of()),
                                                new Post(3, "!", LocalDate.now(), List.of()))),
                                new User("iamstefana", "987", "stefana@intellij.com",
                                        List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                                new Post(2, "Globus", LocalDate.now(), List.of()))),
                                new User("iammarina", "2468", "marina@intellij.com",
                                        List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                                new Post(2, "Zemljo", LocalDate.now(), List.of())))),
                        new User("iamstefana", "987", "stefana@intellij.com",
                                List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                        new Post(2, "Globus", LocalDate.now(), List.of()))),
                        List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                new Post(2, "Globus", LocalDate.now(), List.of()))),
                Arguments.of(List.of(), new User("iampoce", "123", "milos@intellij.com",
                        List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                new Post(2, "World", LocalDate.now(), List.of()),
                                new Post(3, "!", LocalDate.now(), List.of()))), List.of()),
                Arguments.of(List.of(new User("iampoce", "123", "milos@intellij.com",
                                        List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                                new Post(2, "World", LocalDate.now(), List.of()),
                                                new Post(3, "!", LocalDate.now(), List.of()))),
                                new User("iamstefana", "987", "stefana@intellij.com",
                                        List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                                new Post(2, "Globus", LocalDate.now(), List.of()))),
                                new User("iammarina", "2468", "marina@intellij.com",
                                        List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                                new Post(2, "Zemljo", LocalDate.now(), List.of())))),
                        new User("Pera", "987", "stefana@intellij.com",
                                List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                        new Post(2, "Globus", LocalDate.now(), List.of()))),
                        List.of()),
                Arguments.of(List.of(new User("iampoce", "123", "milos@intellij.com",
                                        List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                                new Post(2, "World", LocalDate.now(), List.of()),
                                                new Post(3, "!", LocalDate.now(), List.of()))),
                                new User("iamstefana", "987", "stefana@intellij.com",
                                        List.of()),
                                new User("iammarina", "2468", "marina@intellij.com",
                                        List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                                new Post(2, "Zemljo", LocalDate.now(), List.of())))),
                        new User("iamstefana", "987", "stefana@intellij.com",
                                List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                        new Post(2, "Globus", LocalDate.now(), List.of()))),
                        List.of())
        );

    }

    @ParameterizedTest
    @MethodSource("initialUsers")
    void userWithMostPosts(List<User> users, List<User> expected) {
        SocialMediaService socialMediaService = new SocialMediaService();
        List<User> userWithMostPosts = socialMediaService.userWithMostPosts(users);
        assertEquals(expected, userWithMostPosts);
    }

    static Stream<Arguments> initialUsers() {
        return Stream.of(
                Arguments.of(List.of(new User("iampoce", "123", "milos@intellij.com",
                                List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                        new Post(2, "World", LocalDate.now(), List.of()),
                                        new Post(3, "!", LocalDate.now(), List.of()))),
                        new User("iamstefana", "987", "stefana@intellij.com",
                                List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                        new Post(2, "Globus", LocalDate.now(), List.of()))),
                        new User("iammarina", "2468", "marina@intellij.com",
                                List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                        new Post(2, "Zemljo", LocalDate.now(), List.of())))),
                        List.of(new User("iampoce", "123", "milos@intellij.com",
                                List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                        new Post(2, "World", LocalDate.now(), List.of()),
                                        new Post(3, "!", LocalDate.now(), List.of()))))),
          Arguments.of(List.of(new User("iampoce", "123", "milos@intellij.com",
                          List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                  new Post(2, "World", LocalDate.now(), List.of()))),
                  new User("iamstefana", "987", "stefana@intellij.com",
                          List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                  new Post(2, "Globus", LocalDate.now(), List.of()))),
                  new User("iammarina", "2468", "marina@intellij.com",
                          List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                  new Post(2, "Zemljo", LocalDate.now(), List.of())))),
                  List.of(new User("iampoce", "123", "milos@intellij.com",
                                  List.of(new Post(1, "Hallo", LocalDate.now(), List.of()),
                                          new Post(2, "World", LocalDate.now(), List.of()))),
                          new User("iamstefana", "987", "stefana@intellij.com",
                                  List.of(new Post(1, "Hola", LocalDate.now(), List.of()),
                                          new Post(2, "Globus", LocalDate.now(), List.of()))),
                          new User("iammarina", "2468", "marina@intellij.com",
                                  List.of(new Post(1, "Cao", LocalDate.now(), List.of()),
                                          new Post(2, "Zemljo", LocalDate.now(), List.of()))))),
                Arguments.of(List.of(), List.of())
        );
    }
   /*  @o@ParameterizedTest
    void postWithMostComments() {
    } */
}