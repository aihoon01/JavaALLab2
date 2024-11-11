package org.exercises.designpatterns.TemplatePattern.Exercise2;
import java.util.regex.Pattern;

public abstract class DataValidator {

    // Template method
    public final boolean validate(String data) {
        if (!isValidFormat(data)) {
            System.out.println("Invalid format.");
            return false;
        }
        if (!isValidContent(data)) {
            System.out.println("Invalid content.");
            return false;
        }
        return true; // Data is valid
    }

    // Step to check if the format is valid; subclasses must implement
    protected abstract boolean isValidFormat(String data);

    // Step to check if the content is valid; subclasses can implement this
    protected abstract boolean isValidContent(String data);
}

class PhoneNumberValidator extends DataValidator {

    // Regex for validating a US phone number
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?1?\\d{10}$");

    @Override
    protected boolean isValidFormat(String data) {
        return PHONE_PATTERN.matcher(data).matches();
    }

    @Override
    protected boolean isValidContent(String data) {
        // Additional content validation (if needed)
        return true; // Placeholder for further checks
    }
}


class EmailValidator extends DataValidator {

    // Regex for validating an email address
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    protected boolean isValidFormat(String data) {
        return EMAIL_PATTERN.matcher(data).matches();
    }

    @Override
    protected boolean isValidContent(String data) {
        // Additional content validation (if needed)
        return true; // Placeholder for further checks (e.g., domain validation)
    }
}


