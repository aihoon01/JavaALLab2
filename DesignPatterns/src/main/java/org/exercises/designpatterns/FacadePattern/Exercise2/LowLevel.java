package org.exercises.designpatterns.FacadePattern.Exercise2;


class EmailComposer {
    public Email composeEmail(String recipient, String subject, String body) {
        System.out.println("Composing email to " + recipient);
        return new Email(recipient, subject, body);
    }
}

class EmailSender {
    public void sendEmail(Email email) {
        System.out.println("Sending email to " + email.getRecipient());
        // Simulate sending email
        System.out.println("Email sent successfully!");
    }
}

class EmailManager {
    public void saveDraft(Email email) {
        System.out.println("Saving draft for email to " + email.getRecipient());
        // Simulate saving the email as a draft
        System.out.println("Draft saved successfully.");
    }

    public void scheduleEmail(Email email, String sendTime) {
        System.out.println("Scheduling email to " + email.getRecipient() + " at " + sendTime);
        // Simulate scheduling email
        System.out.println("Email scheduled successfully.");
    }
}





public class LowLevel {
}
