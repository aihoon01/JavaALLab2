package org.exercises.designpatterns.BuilderPattern;

// User.java
public class User {
    // Required fields
    private final String firstName;
    private final String lastName;

    // Optional fields
    private final String email;
    private final String phoneNumber;

    // Private constructor to be accessed only through the builder
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    // Getters for the fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // Builder class
    public static class UserBuilder {
        // Required fields
        private final String firstName;
        private final String lastName;

        // Optional fields initialized to null by default
        private String email;
        private String phoneNumber;

        // Constructor for required fields
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Setter for the optional email field
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        // Setter for the optional phone number field
        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        // Build method to create the User instance
        public User build() {
            return new User(this);
        }
    }
}
