package org.exercises.designpatterns.BuilderPattern;

public class Exercise1 {
    public static void main(String[] args) {
        // Create a User with all fields
        User user1 = new User.UserBuilder("John", "Doe")
                .email("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .build();

        // Create a User with only required fields
        User user2 = new User.UserBuilder("Jane", "Smith")
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}
