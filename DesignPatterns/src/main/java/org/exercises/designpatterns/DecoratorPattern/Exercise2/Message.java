package org.exercises.designpatterns.DecoratorPattern.Exercise2;

public interface Message {
    String getContent();
}


class TextMessage implements Message {
    private String content;

    public TextMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

abstract class MessageDecorator implements Message {
    protected Message message;

    public MessageDecorator(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    }
}
