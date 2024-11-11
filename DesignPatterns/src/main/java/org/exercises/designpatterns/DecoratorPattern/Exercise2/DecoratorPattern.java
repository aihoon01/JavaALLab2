package org.exercises.designpatterns.DecoratorPattern.Exercise2;

public class DecoratorPattern {

    public static void main(String[] args) {
        // Original message
        Message message = new TextMessage("Hello, World!");

        // Apply encryption decorator
        Message encryptedMessage = new EncryptionDecorator(message);
        System.out.println("Encrypted Message: " + encryptedMessage.getContent());

        // Apply compression decorator
        Message compressedMessage = new CompressionDecorator(message);
        System.out.println("Compressed Message: " + compressedMessage.getContent());

        // Apply both encryption and compression
        Message compressedAndEncryptedMessage = new CompressionDecorator(new EncryptionDecorator(message));
        System.out.println("Compressed & Encrypted Message: " + compressedAndEncryptedMessage.getContent());
    }
}

class EncryptionDecorator extends MessageDecorator {
    public EncryptionDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return encrypt(super.getContent());
    }

    private String encrypt(String content) {
        // Simple Caesar Cipher for demonstration (shift by 3)
        StringBuilder encrypted = new StringBuilder();
        for (char c : content.toCharArray()) {
            encrypted.append((char) (c + 3)); // shift each character by 3
        }
        return encrypted.toString();
    }
}

class CompressionDecorator extends MessageDecorator {
    public CompressionDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return compress(super.getContent());
    }

    private String compress(String content) {
        // Simple compression: Remove vowels from the content
        return content.replaceAll("[aeiouAEIOU]", "");
    }
}





