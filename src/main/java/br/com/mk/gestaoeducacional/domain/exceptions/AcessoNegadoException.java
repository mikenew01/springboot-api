package br.com.mk.gestaoeducacional.domain.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcessoNegadoException extends RuntimeException {
    private List<String> messages;

    public AcessoNegadoException() {
        this.messages = new ArrayList<>();
    }

    public AcessoNegadoException(List<String> messages) {
        this.messages = messages;
    }

    public AcessoNegadoException(String message) {
        this.messages = Collections.singletonList(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public boolean isThrowable() {
        return this.messages != null && this.messages.size() > 0;
    }

    public void setMessages(List<String> mensagens) {
        this.messages = mensagens;
    }
}
