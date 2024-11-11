package org.exercises.designpatterns.FacadePattern.Exercise2;

public class EmailFacade {
    private EmailComposer composer;
    private EmailSender sender;
    private EmailManager manager;

    public EmailFacade() {
        this.composer = new EmailComposer();
        this.sender = new EmailSender();
        this.manager = new EmailManager();
    }

    // Method to send an email
    public void sendEmail(String recipient, String subject, String body) {
        Email email = composer.composeEmail(recipient, subject, body);
        sender.sendEmail(email);
    }

    // Method to save an email as a draft
    public void saveEmailDraft(String recipient, String subject, String body) {
        Email email = composer.composeEmail(recipient, subject, body);
        manager.saveDraft(email);
    }

    // Method to schedule an email to be sent later
    public void scheduleEmail(String recipient, String subject, String body, String sendTime) {
        Email email = composer.composeEmail(recipient, subject, body);
        manager.scheduleEmail(email, sendTime);
    }
}
 class Main {
     public static void main(String[] args) {
         EmailFacade emailFacade = new EmailFacade();

         // Send an email directly
         emailFacade.sendEmail("john@example.com", "Hello!", "This is a test email.");

         // Save an email as a draft
         emailFacade.saveEmailDraft("jane@example.com", "Meeting Reminder", "Don't forget about the meeting tomorrow.");

         // Schedule an email to be sent at a later time
         emailFacade.scheduleEmail("doe@example.com", "Scheduled Message", "This email will be sent later.", "2023-11-10 10:00 AM");
     }
 }


