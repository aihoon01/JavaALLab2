package org.exercises.designpatterns.TemplatePattern.Exercise2;

public class DataValidation {
    public static void main(String[] args) {
        // Create an email validator and validate an email address
        DataValidator emailValidator = new EmailValidator();
        String email = "example@domain.com";
        System.out.println("Validating email: " + email);
        boolean isEmailValid = emailValidator.validate(email);
        System.out.println("Email valid: " + isEmailValid + "\n");

        // Create a phone number validator and validate a phone number
        DataValidator phoneValidator = new PhoneNumberValidator();
        String phoneNumber = "+1234567890";
        System.out.println("Validating phone number: " + phoneNumber);
        boolean isPhoneValid = phoneValidator.validate(phoneNumber);
        System.out.println("Phone number valid: " + isPhoneValid);
    }
}
